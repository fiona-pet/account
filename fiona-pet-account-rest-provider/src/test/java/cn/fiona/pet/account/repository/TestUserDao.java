package cn.fiona.pet.account.repository;

import cn.fiona.pet.account.entity.Organize;
import cn.fiona.pet.account.entity.Role;
import cn.fiona.pet.account.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by tom on 16/6/21.
 */
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class TestUserDao extends SpringTransactionalTestCase {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void findByLoginName(){
        User user = userDao.findByLoginName("admin");

        Assert.assertNotNull(user);

        Assert.assertNotNull(user.getRoles());

        Assert.assertEquals(user.getRoles().size(),1);
    }

    @Test
    @Rollback(false)
    public void create(){
        User user = new User();
        user.setLoginName("白2");
        user.setName("白2");
        user.setPassword("123");
        user.setId(UUID.randomUUID().toString());
        Organize organize =  new Organize();
        organize.setId("9b06d376-44ff-4153-9b31-c29a19b8da29");
        user.setOrganize(organize);
        Set<Role> roleSet = new HashSet<Role>();
        Role role = roleDao.findByCode("doctor");
        roleSet.add(role);
        user.setRoles(roleSet);

        userDao.save(user);

    }
}
