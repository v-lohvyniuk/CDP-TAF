package com.cdp.taf.core;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class BaseConfig {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        final CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(Collections.singletonMap("thread", new SimpleThreadScope()));
        return configurer;
    }
}
