package com.cdp.taf;

import com.cdp.taf.core.SpringConfig;
import com.cdp.taf.core.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = { SpringConfig.class })
public abstract class UiTestBase extends AbstractTestNGSpringContextTests {


    @Autowired
    private ApplicationContext context;
    @AfterMethod
    public void tearDown(){
        WebDriver driver = context.getBean(WebDriver.class);
        driver.close();
        driver.quit();
    }

}
