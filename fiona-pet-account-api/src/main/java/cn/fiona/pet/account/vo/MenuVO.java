package cn.fiona.pet.account.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单 视图对象
 *
 * Created by tom on 16/6/28.
 */
@ApiModel("菜单")
public class MenuVO extends UuidVO{
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("编码")
    private String code;
    @ApiModelProperty("叶子节点")
    private boolean leaf;
    @ApiModelProperty("排序")
    private int order;
    @ApiModelProperty("图标样式")
    private String iconClass;
    @ApiModelProperty("地址")
    private String uri;
    @ApiModelProperty("子菜单")
    private List<MenuVO> subMenu = new ArrayList<MenuVO>();

    public MenuVO(Object source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<MenuVO> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MenuVO> subMenu) {
        this.subMenu = subMenu;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
