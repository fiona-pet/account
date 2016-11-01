package cn.fiona.pet.account.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dubbo.x.entity.IdEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 系统菜单
 *
 * @author bqw
 */
@Entity
@Table(name = "t_menu")
public class Menu extends IdEntity {
    /**
     * 角色信息
     */
    private Set<Role> roles = new LinkedHashSet<Role>();
    /**
     * 子组
     */
    private Set<Menu> menus = new LinkedHashSet<Menu>();
    /**
     * 父组
     */
    private Menu parentMenu;
    /**
     * 名称
     */
    private String name;
    /**
     * code
     */
    private String code;
    /**
     * 链接地址
     */
    private String uri;
    /**
     * 对应图标样式名称
     */
    private String iconClass;
    /**
     * 描述
     */
    private String describe;
    /**
     * 状态
     */
    private String status;
    /**
     * 叶子节点
     */
    private Boolean leaf;

    /**
     * 排序
     */
    private Integer order;

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



    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "menuSet", fetch = FetchType.LAZY)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "parentMenu")
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "code")
    @NotFound(action = NotFoundAction.IGNORE)
    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    @Column(name = "describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "uri")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Column(name = "icon_class")
    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", iconClass='" + iconClass + '\'' +
                '}';
    }
}
