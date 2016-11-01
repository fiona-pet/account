package cn.fiona.pet.account.repository;

import cn.fiona.pet.account.entity.Menu;
import cn.fiona.pet.account.entity.Role;
import cn.fiona.pet.account.entity.User;
import cn.fiona.pet.account.vo.MenuVO;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.*;

import static cn.fiona.pet.account.service.MenuService.MENU_ROOT;

/**
 * Created by tom on 16/6/21.
 */
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class TestMenuDao extends SpringTransactionalTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestMenuDao.class);
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void findByCode() {
        String rootCode = "M00000";

        Menu menu = menuDao.findByCode(rootCode);

        Assert.assertNotNull(menu);

        List<Menu> menus = menuDao.findByParentMenuCodeOrderByOrderAsc(rootCode);


        Assert.assertTrue(menu.getMenus().containsAll(menus));
    }

    @Test
    public void menus() {
        String token = "fc5db3b3-4063-4a12-a511-880ba19e4b58";

        Set<Menu> menuSet = new HashSet<Menu>();

        User user = userDao.findOne(token);

        Set<Role> roleSet = user.getRoles();

        Assert.assertEquals(roleSet.size(), 1);

        for (Role role : roleSet) {
            Assert.assertEquals(role.getCode(),"admin");

            Assert.assertEquals(role.getMenuSet().size(), 4);
            menuSet.addAll(role.getMenuSet());
        }
        Assert.assertEquals(menuSet.size(), 4);

        menuSet.addAll(menuDao.findByParentMenuCodeOrderByOrderAsc(MENU_ROOT));

        Assert.assertNotNull(menuSet);

        Assert.assertEquals(menuSet.size(), 15);

        List<MenuVO> menus = new ArrayList<MenuVO>();

        findChild(menuSet, menus, new HashSet<Menu>(), MENU_ROOT);

        LOGGER.info("{} -> menuSet:{}", token, menuSet);

        LOGGER.info("{} -> menu:{}", token, JSON.toJSON(orderAndRemoveNoSub(menus)));
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

    private List<MenuVO> orderAndRemoveNoSub(List<MenuVO> menus) {
        List<MenuVO> list = new ArrayList<MenuVO>();

        for (MenuVO menuVO: menus){
            if (CollectionUtils.isEmpty(menuVO.getSubMenu())){
                continue;
            }

            list.add(menuVO);
        }

        Collections.sort(list, new Comparator<MenuVO>() {
            @Override
            public int compare(MenuVO o1, MenuVO o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });

        return list;
    }
}
