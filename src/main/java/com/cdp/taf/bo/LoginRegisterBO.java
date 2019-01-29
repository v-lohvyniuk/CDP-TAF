package com.cdp.taf.bo;

import com.cdp.taf.po.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LoginRegisterBO {

    @Autowired
    private ApplicationContext applicationContext;

    public LoginPage getLoginPage(){
        return applicationContext.getBean(LoginPage.class);
    }
    private LoginPage loginPage;
}
