package com.cdp.taf;

import com.cdp.taf.core.ApiConfig;
import io.restassured.mapper.TypeRef;
import io.restassured.response.ValidatableResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.List;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {ApiConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class APITestBase extends AbstractTestNGSpringContextTests {

    public <T> T responseAs(ValidatableResponse response, Class<T> clazz) {
        return response.extract().response().getBody().as(clazz);
    }

    public <T> List<T> responseAsList(ValidatableResponse response) {
        return response.extract().response().getBody().as(new TypeRef<List<T>>() {
        });
    }

}