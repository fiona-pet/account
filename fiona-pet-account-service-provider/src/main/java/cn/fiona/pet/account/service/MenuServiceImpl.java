package cn.fiona.pet.account.service;

import cn.fiona.pet.account.entity.Menu;
import cn.fiona.pet.account.entity.Role;
import cn.fiona.pet.account.entity.User;
import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.repository.MenuDao;
import cn.fiona.pet.account.repository.UserDao;
import cn.fiona.pet.account.vo.MenuVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author baiqw
 */
@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Set<Menu> findByToken(String token) throws ApiException {
        Set<Menu> menus = new HashSet<Menu>();

        User user = userDao.findByPersonId(token);
        if (null == user){
            user = userDao.findOne(token);
        }

        Set<Role> roleSet = user.getRoles();

        for (Role role : roleSet) {

            menus.addAll(role.getMenuSet());
        }

        return menus;
    }

    @Override
    public List<Menu> findByParentMenuCode(String code) throws ApiException {
        return menuDao.findByParentMenuCodeOrderByOrderAsc(code);
    }

    @Override
    public List<MenuVO> menus(String token) throws ApiException {
        LOGGER.debug("token:{}", token);

        Set<Menu> menuSet = findByToken(token);

        List<Menu> menuList = new ArrayList<Menu>();
        menuList.addAll(menuSet);
        Collections.sort(menuList, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                return o1.getOrder() - o1.getOrder();
            }
        });

        menuList.addAll(findByParentMenuCode(MENU_ROOT));

        List<MenuVO> menus = new ArrayList<MenuVO>();

        findChild(menuList, menus, new HashSet<Menu>(), MENU_ROOT);

        menus = orderAndRemoveNoSub(menus);

        LOGGER.debug("menus:{}", menus);

        return menus;
    }

    private List<MenuVO> orderAndRemoveNoSub(List<MenuVO> menus) {
        List<MenuVO> list = new ArrayList<MenuVO>();

        LOGGER.debug("order list:{}", list);

        for (MenuVO menuVO : menus) {
            if (CollectionUtils.isEmpty(menuVO.getSubMenu())) {
                continue;
            }

            list.add(menuVO);

            Collections.sort(menuVO.getSubMenu(), new Comparator<MenuVO>() {
                @Override
                public int compare(MenuVO o1, MenuVO o2) {
                    return o1.getOrder()-o2.getOrder();
                }
            });
        }

        menus.clear();

        return list;
    }

    private void findChild(List<Menu> menuSet, List<MenuVO> menuVOList, Set<Menu> hasFind, String code) {
        for (Menu menu : menuSet) {

            if (hasFind.contains(menu)) {
                continue;
            }

            Menu parentMenu = menu.getParentMenu();

            if (parentMenu == null || code.equals(parentMenu.getCode())) {
                MenuVO menuVO = new MenuVO(menu);

                menuVOList.add(menuVO);

                hasFind.add(menu);
            }
        }

        for (MenuVO menuVO : menuVOList) {
            findChild(menuSet, menuVO.getSubMenu(), hasFind, menuVO.getCode());
        }
    }
}
