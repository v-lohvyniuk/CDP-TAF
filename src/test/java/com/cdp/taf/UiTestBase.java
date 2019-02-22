package com.cdp.taf;

import com.cdp.taf.core.UIConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = { UIConfig.class })
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class UiTestBase extends AbstractTestNGSpringContextTests {

    @Lazy
    @Autowired
    private WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
