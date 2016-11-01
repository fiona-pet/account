package cn.fiona.pet.account.facade;

import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.exception.NotFoundException;
import cn.fiona.pet.account.service.MessageService;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.PathParam;

/**
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
public class MessageRestServiceImpl implements MessageRestService {

    private static final Logger logger = LoggerFactory.getLogger(MessageRestServiceImpl.class);

    private MessageService messageService;

    public MessageService getMessageService() {
        return messageService;
    }


    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }


    @Override
    public RestResult send(@ApiParam(value = "手机号", required = true) @NotEmpty(message = "电话不能为空") String phoneNumber, @ApiParam(value = "短信内容", required = true) @NotEmpty(message = "短信内容不能为空") String content) {
        logger.debug("phone_number:{}, content:{}", phoneNumber,content);
        return RestResult.OK(messageService.send(phoneNumber, content));
    }

    @Override
    public RestResult sendVerificationCode(@PathParam("phone_number") String phoneNumber) {
        return RestResult.OK(messageService.sendVerificationCode(phoneNumber));
    }

    @Override
    public RestResult verificationCode(@ApiParam(value = "手机号", required = true) @NotEmpty String phoneNumber, @ApiParam(value = "验证码", required = true) @NotEmpty String verificationCode) throws ApiException {
        if (phoneNumber.length() < 11) {
            throw new NotFoundException("无效手机号");
        }else {
        return RestResult.OK(messageService.verificationCode(phoneNumber, verificationCode));
        }
    }

}
