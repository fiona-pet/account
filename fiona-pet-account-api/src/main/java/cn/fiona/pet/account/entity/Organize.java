package cn.fiona.pet.account.entity;

import org.dubbo.x.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by tom on 16/6/20.
 */
@Entity
@Table(name = "t_organize")
public class Organize extends IdEntity {
    /**
     * 名称
     */
    private String name;

    /**
     * saas 服务 标示 英文
     */
    @NotNull
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
