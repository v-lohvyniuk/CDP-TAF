package com.cdp.taf;

import com.cdp.taf.core.SpringConfig;
import com.cdp.taf.core.WebDriverFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
@ContextConfiguration(loader= AnnotationConfigContextLoader.class, classes = { SpringConfig.class })
public abstract class UiTestBase extends AbstractTestNGSpringContextTests {

    @AfterMethod
    public void tearDown(){
//        WebDriverFactory.getDriver().close();
//        WebDriverFactory.getDriver().quit();
//        WebDriverFactory.setDriver(null);
    }

}
