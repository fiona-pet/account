package cn.fiona.pet.account.facade;

import cn.fiona.pet.account.entity.Menu;
import cn.fiona.pet.account.entity.RestResultEnum;
import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.service.AccountService;
import cn.fiona.pet.account.service.MenuService;
import cn.fiona.pet.account.vo.MenuVO;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.HeaderParam;
import java.util.*;

import static cn.fiona.pet.account.service.MenuService.MENU_ROOT;

/**
 * 用户菜单数据
 *
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
public class MenuRestServiceImpl implements MenuRestService {

  private static final Logger LOGGER = LoggerFactory.getLogger(MenuRestServiceImpl.class);

  private MenuService menuService;

    public MenuService getMenuService() {
        return menuService;
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public RestResult<List<MenuVO>> menus(String token) throws ApiException{
        List<MenuVO> menus = menuService.menus(token);
        LOGGER.info("menus:{}", menus);
        return RestResult.OK(menus);
    }


}
