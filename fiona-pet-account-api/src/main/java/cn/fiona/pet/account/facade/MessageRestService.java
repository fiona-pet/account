package cn.fiona.pet.account.facade;

import cn.fiona.pet.account.exception.ApiException;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.ws.rs.*;

/**
 * 短信息 服务 rest api
 *
 * @author baiqw
 */

@Path("/messages")
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value="/messages", description = "发送短信接口")
public interface MessageRestService {
    /**
     * 发送短信
     * @param phoneNumber 手机号
     * @return
     */
    @GET
    @Path("send/{phone_number}")
    @ApiOperation(value = "发送短信",
            notes = "发送短信到指定手机.",
            position = 1)
    RestResult send(@ApiParam(value = "手机号", required = true) @PathParam("phone_number") @NotEmpty(message = "电话不能为空") String phoneNumber, @ApiParam(value = "短信内容", required = true) @QueryParam("content")  @NotEmpty(message = "短信内容不能为空") String content);

    /**
     * 发送验证码
     * @param phoneNumber 手机号
     * @return
     */
    @GET
    @Path("send/verification/code/{phone_number}")
    @ApiOperation(value = "发送验证码",
            notes = "生成一个验证码发送到手机端"
    )
    RestResult sendVerificationCode(@ApiParam(value = "手机号", required = true) @PathParam("phone_number")  @NotEmpty String phoneNumber);

    /**
     * 短信验证
     * @param phoneNumber 手机号
     * @param verificationCode 验证码
     * @return
     */
    @GET
    @Path("verification/code/{phone_number}/{verification_code}")
    @ApiOperation(value = "验证码验证",
            notes = "根据手机号及验证码,验证验正码有效性"
    )
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid phone_number"),
            @ApiResponse(code = 404, message = "Verification code not found") })
    RestResult verificationCode(@ApiParam(value = "手机号", required = true) @PathParam("phone_number")  @NotEmpty String phoneNumber,@ApiParam(value = "验证码", required = true) @PathParam("verification_code")  @NotEmpty String verificationCode) throws ApiException;

}
