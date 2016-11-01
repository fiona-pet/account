package cn.fiona.pet.account.aop;

import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.exception.AuthorizationException;
import cn.fiona.pet.account.exception.InvalidParameterException;
import cn.fiona.pet.account.service.AccountService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 身份认证 切面
 * Created by tom on 16/6/28.
 */
@Aspect
public class AuthInterceptor {
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);
    @Autowired
    private AccountService accountService;

    @Pointcut("execution(* cn.fiona.pet.account.facade.*.*(..))")
    private void anyMethod(){}//定义一个切入点

    @Before(value = "anyMethod() && args(token,..)", argNames = "token")
    public void doAccessCheck(String token) throws AuthorizationException {
        LOGGER.debug("check token:{}", token);

        try {
            boolean validateToken = accountService.validateToken(token);

            if (!validateToken){
                throw new AuthorizationException("token 验证失败!");
            }
        } catch (ApiException e) {
            LOGGER.warn("Request filter invoked:Token validate fail!");
            throw new AuthorizationException("token 验证失败!");
        }
    }
}
