package cn.fiona.pet.account.service;

import cn.fiona.pet.account.entity.Organize;
import cn.fiona.pet.account.entity.Role;
import cn.fiona.pet.account.entity.User;
import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.exception.NotFoundException;
import cn.fiona.pet.account.facade.LoginVO;
import cn.fiona.pet.account.repository.RoleDao;
import cn.fiona.pet.account.repository.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.dubbo.x.entity.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baiqw
 */
@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public String login(LoginVO loginVO) throws ApiException {
        User user = userDao.findByLoginNameAndStatus(loginVO.getName(), "OK");

        if (null == loginVO){
            throw new InvalidParameterException("输入数据为空!");
        }

        if (null == user) {
            throw new AuthenticationException(String.format("[%s]用户未找到!", loginVO.getName()));
        }

        String password = loginVO.getPassword();

        if (StringUtils.isBlank(password)){
            throw new InvalidParameterException("密码不能为空!");
        }

        if (!passwordValidation(password, user)){
            throw new InvalidParameterException("密码错误!");
        }

        String token = user.getPersonId();

        return token;
    }

    @Override
    public boolean validateToken(String token) throws ApiException {
        if (StringUtils.isBlank(token)){
            throw new ApiException("token is null!");
        }

        User user = userDao.findByPersonId(token);
        if (null == user){
            user = userDao.findOne(token);
        }

        if (null == user){
            throw new ApiException(String.format("%s not exists!", token));
        }

        return true;
    }

    @Override
    @Transactional
    public User getByToken(String token) throws ApiException {
        User user = userDao.findByPersonId(token);
        if (null == user){
            user = userDao.findOne(token);
        }

        if (null == user) {
            throw new ApiException(String.format("%s not exists!", token));
        }

        User userVO = new User();
        userVO.setId(token);
        userVO.setName(user.getName());
        userVO.setLoginName(user.getLoginName());
        userVO.setOrganize(user.getOrganize());

        return userVO;
    }

    @Override
    public List<User> listByRoleCode(String code) {
        Role role = roleDao.findByCode(code);
        List<User> users = new ArrayList<User>();
        for (User user: role.getUsers()){
            User userVO = new User();
            userVO.setName(user.getName());
            userVO.setId(user.getId());
            userVO.setLoginName(user.getLoginName());
            users.add(userVO);
        }

        return users;
    }

    @Override
    @Transactional
    public User createUser(User user) {

        if (null == user.getOrganize()) {
            Organize organize =  new Organize();
            organize.setId("bj");
            user.setOrganize(organize);
        }

        Set<Role> roleSet = new HashSet<Role>();

        for (Role role: user.getRoles()){
            logger.debug("add role:{}", role.getCode());
            Role r = roleDao.findByCode(role.getCode());
            roleSet.add(r);
        }

        if (roleSet.size() == 0){
            roleSet.add(roleDao.findByCode("doctor"));
        }

        user.setRoles(roleSet);
        user.setStatus("OK");

        encode(user);

        userDao.save(user);

        User userVO = new User();

        userVO.setId(user.getId());
        userVO.setName(user.getName());
        userVO.setPersonId(user.getPersonId());
        userVO.setLoginName(user.getLoginName());

        return userVO;
    }

    @Override
    public boolean hasRole(String role, String token) throws ApiException {
        User user = userDao.findByPersonId(token);
        if (null == user){
            user = userDao.findOne(token);
        }

        if (null == user) {
            throw new ApiException(String.format("%s not exists!", token));
        }

        for (Role r: user.getRoles()){
            if (r.getCode().equalsIgnoreCase(role)){
                return true;
            }
        }

        return false;
    }

    private boolean passwordValidation(String password, User user){

        byte[] salt = Encodes.decodeHex(user.getSalt());

        byte[] hashPassword = Digests.sha1(password.getBytes(), salt, 1024);

        return user.getPassword().equals(Encodes.encodeHex(hashPassword));
    }

    private void encode(User user){

        byte[] salt = Encodes.decodeHex(user.getSalt());

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, 1024);

        user.setPassword(Encodes.encodeHex(hashPassword));
    }


}
