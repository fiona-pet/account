package cn.fiona.pet.account.facade;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 账号
 *
 * @author baiqw
 */

@Path("accounts")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value="/accounts", description = "账号接口")
public interface AccountRestService {
    /**
     * 注册
     * @param signUp
     * @return
     */
    @POST
    @Path("sign-up")
    @ApiOperation(value = "注册",
            notes = "用户注册"
    )
    RestResult signUp(SignUpVO signUp);

    /**
     * 登录
     * @param signIn
     * @return
     */
    @POST
    @Path("sign-in")
    @ApiOperation(value = "登录",
            notes = "用户登录"
    )
    RestResult signIn(LoginVO signIn);

}
