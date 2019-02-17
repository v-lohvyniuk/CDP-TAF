package com.cdp.taf;

import com.cdp.taf.core.ApiConfig;
import com.cdp.taf.core.SpringConfig;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = { ApiConfig.class })
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class APITestBase extends AbstractTestNGSpringContextTests {

    public <T> T responseAs(ValidatableResponse response, Class<T> clazz) {
        return response.extract().response().getBody().as(clazz);
    }

}