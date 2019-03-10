package com.cdp.taf.stepdef;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class DriverStepDef {
    @Lazy
    @Autowired
    private WebDriver driver;

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}