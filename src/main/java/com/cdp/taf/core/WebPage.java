package com.cdp.taf.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.cdp.taf.core.WebDriverFactory.getDriver;

public abstract class WebPage {


    public WebDriver driver;

    public WebPage() {
        this.driver = getDriver();
        PageFactory.initElements(getDriver(), this);
    }

    public WebPage navigate(){
        throw new NotImplementedException();
    }
}
