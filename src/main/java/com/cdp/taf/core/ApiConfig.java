package com.cdp.taf.core;

import com.cdp.taf.api.services.ClientService;
import com.cdp.taf.api.services.UserService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Collections;

import static io.restassured.RestAssured.given;

@Configuration
@ComponentScan(basePackages = "com.cdp.taf.api")
public class ApiConfig {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        final CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(Collections.singletonMap("thread", new SimpleThreadScope()));
        return configurer;
    }

    @Bean
    @Scope("thread")
    public RequestSpecification requestSpecification() {
        RequestSpecification spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON).build();
        return given().spec(spec);
    }

    @Bean
    @Scope("thread")
    public UserService userService() {
        return new UserService(requestSpecification().baseUri("https://jsonplaceholder.typicode.com/users"));
    }

    @Bean
    @Scope("thread")
    public ClientService clientService() {
        return new ClientService(requestSpecification().baseUri("https://gigabyte.eu.auth0.com/api/v2/clients"));
    }
}