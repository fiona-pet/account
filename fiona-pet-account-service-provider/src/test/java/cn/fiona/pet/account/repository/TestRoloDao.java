package cn.fiona.pet.account.repository;

import cn.fiona.pet.account.entity.Menu;
import cn.fiona.pet.account.entity.Role;
import cn.fiona.pet.account.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.Set;

/**
 * Created by tom on 16/6/21.
 */
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class TestRoloDao extends SpringTransactionalTestCase {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private MenuDao menuDao;


    @Test
    public void findByName(){
        Role role = roleDao.findByName("admin");
        Assert.assertNotNull(role);

        Set<Menu> menus = role.getMenuSet();

        Assert.assertNotNull(menus);

        Assert.assertEquals(menus.size(),4);

        Menu menu = menuDao.findByCode("FM0301");

        Assert.assertNotNull(menu);

        Assert.assertTrue(menu.getRoles().contains(role));
    }

}
