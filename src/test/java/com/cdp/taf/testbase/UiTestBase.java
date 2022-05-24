package com.cdp.taf.testbase;

import com.cdp.taf.core.config.UIConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

import javax.annotation.PostConstruct;

@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = { UIConfig.class })
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class UiTestBase extends AbstractTestNGSpringContextTests {

    @Lazy
    @Autowired
    private WebDriver driver;

    @PostConstruct
    public void postConstruct() {
        WebDriverManager.chromedriver().setup();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
