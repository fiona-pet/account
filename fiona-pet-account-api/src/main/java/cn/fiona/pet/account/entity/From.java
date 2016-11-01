package cn.fiona.pet.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author baiqw
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel("客户端信息")
public class From implements Serializable {
    /**
     * 标示
     */
    @ApiModelProperty("标示")
    private String agentId;
    /**
     *  名称
     */
    @ApiModelProperty("名称")
    private String agentName;
    /**
     * 类型
     */
    @ApiModelProperty("类型:pc,ios,android")
    private String agentType;
    /**
     * 系统版本
     */
    @ApiModelProperty("系统版本:window10,ios 9, android 4.3")
    private String osVersion;
    /**
     * 位置信息
     */
    @ApiModelProperty("位置信息:坐标 x,y,z")
    private String location;
    /**
     * 客户端版本
     */
    @ApiModelProperty("客户端版本信息:v1.0")
    private String clientVersion;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    @Override
    public String toString() {
        return "From{" +
                "agentId='" + agentId + '\'' +
                ", agentName='" + agentName + '\'' +
                ", agentType='" + agentType + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", location='" + location + '\'' +
                ", clientVersion='" + clientVersion + '\'' +
                '}';
    }
}
