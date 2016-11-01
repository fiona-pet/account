package cn.fiona.pet.account.facade;

import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.vo.MenuVO;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 菜单
 *
 * @author baiqw
 */

@Path("menus")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value = "/menus", description = "菜单接口")
public interface MenuRestService {
    /**
     * 菜单接口
     *
     * @param token
     * @return
     */
    @GET
    @Path("/")
    @ApiOperation(value = "用户菜单",
            notes = "用户菜单数据"
    )
    RestResult<List<MenuVO>> menus(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token) throws ApiException;
}
