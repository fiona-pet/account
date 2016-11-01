package cn.fiona.pet.account.facade;

import cn.fiona.pet.account.entity.User;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 身份授权 服务 rest api
 *
 * @author baiqw
 */

@Path("/auth")
@Api(value="auth", description = "身份授权")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
public interface AuthRestService {
    public static final String HEADER_AUTHORIZATION_KEY = "authorization";
    /**
     * 登录
     *
     * @param loginVO 登录信息
     * @return RestResult 身份认证成功 data 返回用户token
     */
    @POST
    @Path("login")
    @ApiOperation(value = "登录", notes = "用户登录,登录成功返回token信息",response = RestResult.class)
    RestResult<String> login(@ApiParam(value = "登录信息", required = true) LoginVO loginVO);

    @GET
    @Path("")
    @ApiOperation(value = "登录用户信息",
            notes = "登录用户信息"
    )
    RestResult<User> get(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token);

    @GET
    @Path("/users/byRole/{code}")
    @ApiOperation(value = "根据角色编号获取用户列表",
            notes = "根据角色编号获取用户列表"
    )
    RestResult<List<User>> usersByRoleCode(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("角色编号") @PathParam("code") String code);
}
