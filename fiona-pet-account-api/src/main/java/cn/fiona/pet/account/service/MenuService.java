package cn.fiona.pet.account.service;

import cn.fiona.pet.account.entity.Menu;
import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.vo.MenuVO;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 菜单服务
 * <p>
 * Created by tom on 16/6/27.
 */
public interface MenuService {
    /**
     * 根菜单编码
     */
    public static final String MENU_ROOT = "M00000";

    /**
     * 获取根据token获取菜单数据
     *
     * @param token
     * @return
     */
    Set<Menu> findByToken(String token) throws ApiException;

    /**
     * 根据父级code获取菜单数据
     *
     * @param code
     *
     * @return
     */
    List<Menu> findByParentMenuCode(String code) throws ApiException;

    /**
     * 根据token获取菜单数据
     * @param token
     * @return
     * @throws ApiException
     */
    List<MenuVO> menus(String token) throws ApiException;
}
