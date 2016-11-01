package cn.fiona.pet.account.service;

import cn.fiona.pet.account.entity.Menu;
import cn.fiona.pet.account.entity.Role;
import cn.fiona.pet.account.entity.User;
import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.repository.MenuDao;
import cn.fiona.pet.account.repository.UserDao;
import cn.fiona.pet.account.vo.MenuVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author baiqw
 */
@Transactional
public class MenuServiceImpl implements MenuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Set<Menu> findByToken(String token) throws ApiException {
        Set<Menu> menus = new HashSet<Menu>();

        User user = userDao.findOne(token);
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

        menuSet.addAll(findByParentMenuCode(MENU_ROOT));

        List<MenuVO> menus = new ArrayList<MenuVO>();

        findChild(menuSet, menus, new HashSet<Menu>(), MENU_ROOT);

        menus = orderAndRemoveNoSub(menus);

        LOGGER.debug("menus:{}", menus);

        return menus;
    }

    private List<MenuVO> orderAndRemoveNoSub(List<MenuVO> menus) {
        List<MenuVO> list = new ArrayList<MenuVO>();

        for (MenuVO menuVO : menus) {
            if (CollectionUtils.isEmpty(menuVO.getSubMenu())) {
                continue;
            }

            list.add(menuVO);
        }

        menus.clear();

        Collections.sort(list, new Comparator<MenuVO>() {
            @Override
            public int compare(MenuVO o1, MenuVO o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });
        LOGGER.debug("order list:{}", list);
        return list;
    }

    private void findChild(Set<Menu> menuSet, List<MenuVO> menuVOList, Set<Menu> hasFind, String code) {
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
