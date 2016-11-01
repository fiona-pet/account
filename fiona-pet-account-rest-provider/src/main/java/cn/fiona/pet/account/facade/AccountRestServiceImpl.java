package cn.fiona.pet.account.facade;

import cn.fiona.pet.account.entity.Account;
import cn.fiona.pet.account.exception.ApiException;
import cn.fiona.pet.account.service.AccountService;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
public class AccountRestServiceImpl implements AccountRestService {

  private static final Logger logger = LoggerFactory.getLogger(AccountRestServiceImpl.class);

  private AccountService accountService;

  public AccountService getAccountService() {
      return accountService;
  }

  public void setAccountService(AccountService accountService) {
      this.accountService = accountService;
  }

    @Override
    public RestResult signUp(SignUpVO signUp) {
        return null;
    }

    @Override
    public RestResult signIn(LoginVO signIn) {
        return null;
    }
}
