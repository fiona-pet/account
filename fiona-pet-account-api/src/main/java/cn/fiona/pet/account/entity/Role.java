package cn.fiona.pet.account.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.dubbo.x.entity.IdEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 角色
 *
 * @author bqw
 */
@Entity
@Table(name = "t_role")
public class Role extends IdEntity {
    /**
     * 用户信息
     */
    private Set<User> users = new LinkedHashSet<User>();

    /**
     * 菜单 信息
     */
    private Set<Menu> menuSet;


    /**
     * 名称
     */
    private String name;

    /**
     * 码
     */
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

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_role_menu",
            joinColumns = {@JoinColumn(name = "role_code", referencedColumnName = "code")},
            inverseJoinColumns = {@JoinColumn(name = "menu_code", referencedColumnName = "code")})
    @JsonIgnore
    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }


}
