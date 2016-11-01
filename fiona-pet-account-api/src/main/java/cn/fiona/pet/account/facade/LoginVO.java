package cn.fiona.pet.account.facade;

import cn.fiona.pet.account.entity.From;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 用户注册 输入
 * Created by baiqw on 16/1/21.
 */

@ApiModel("登录信息")
public class LoginVO implements Serializable{
    @NotNull
    @Size(min = 1, max = 20)
    @ApiModelProperty(value = "用户名", required = true)
    private String name;
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "客户端信息", required = false)
    private From from;

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account (" +
                "password=" + password +
                ", name='" + name + '\'' +
                ')';
    }
}
