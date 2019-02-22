package com.cdp.taf.core;

import com.cdp.taf.api.services.ClientService;
import com.cdp.taf.api.services.UserService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static io.restassured.RestAssured.given;

@Configuration
@ComponentScan(basePackages = "com.cdp.taf.api")
public class ApiConfig extends BaseConfig {

    @Bean
    @Scope("thread")
    public RequestSpecification requestSpecification() {
        RestAssuredConfig config = RestAssuredConfig.config().objectMapperConfig(
                ObjectMapperConfig.objectMapperConfig().jackson2ObjectMapperFactory((cls, charset) -> objectMapper()));
        RequestSpecification spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON)
                .setConfig(config).build();
        return given().spec(spec);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        objectMapper.registerModule(new JaxbAnnotationModule());
        return objectMapper;
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