package cn.fiona.pet.account.facade;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 用户注册 输入
 * Created by baiqw on 16/1/21.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SignUpVO implements Serializable{
    /**
     * 电话
     */
    @NotNull
    @Size(min = 11, max = 11)
    private String phone_number;
    /**
     * 密码
     */
    @NotNull
    @Size(min = 6, max = 32)
    private String password;
    /**
     * 名称
     */
    @NotNull
    @Size(min = 2, max = 32)
    private String username;
    /**
     * 验证码
     */
    @NotNull
    private String verification_code;
}
