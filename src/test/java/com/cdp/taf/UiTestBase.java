package com.cdp.taf;

import com.cdp.taf.core.WebDriverFactory;
import org.testng.annotations.AfterMethod;

public abstract class UiTestBase {

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.getDriver().close();
        WebDriverFactory.getDriver().quit();
        WebDriverFactory.setDriver(null);
    }

}
