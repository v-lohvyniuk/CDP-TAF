package com.cdp.taf.core;

import com.cdp.taf.bo.LoginRegisterBO;
import com.cdp.taf.po.LoginPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Configuration
public class SpringConfig {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        final CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(Collections.singletonMap("thread", new SimpleThreadScope()));
        return configurer;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public LoginRegisterBO loginRegisterBO(){
        return new LoginRegisterBO();
    }

    @Bean
    @Scope("thread")
    public LoginPage loginPage(){
        return new LoginPage();
    }



}
