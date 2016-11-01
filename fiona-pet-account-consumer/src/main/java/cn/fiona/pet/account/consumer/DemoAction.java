/*
 * Copyright 1999-2011 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.fiona.pet.account.consumer;

import cn.fiona.pet.account.entity.Account;
import cn.fiona.pet.account.entity.From;
import cn.fiona.pet.account.facade.LoginVO;
import cn.fiona.pet.account.service.AccountService;


/**
 * @author baiqw
 */
public class DemoAction {

    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void start() throws Exception {


        LoginVO loginVO = new LoginVO();
        loginVO.setName("admin");
        loginVO.setPassword("admin");

        From from = new From();
        from.setAgentId("test");
        from.setAgentName("R03025");
        from.setAgentType("MacOS");
        from.setClientVersion("1.0");
        from.setLocation("1,2,3");
        from.setOsVersion("10.10.5");

        loginVO.setFrom(from);


        System.out.println("SUCESS: login user with: " + accountService.login(loginVO));
    }

}
