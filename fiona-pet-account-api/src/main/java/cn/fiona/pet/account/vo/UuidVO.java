package cn.fiona.pet.account.vo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * uuid 视图对象
 *
 * Created by tom on 16/6/28.
 */
public class UuidVO implements Serializable{

    private String uuid;

    public UuidVO() {}

    public UuidVO(Object source) {
        try {
            BeanUtils.copyProperties(this, source);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
