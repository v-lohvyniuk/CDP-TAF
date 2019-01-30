package com.cdp.taf.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;

@Component
public abstract class WebPage {

    @Autowired
    public WebDriver driver;

    @PostConstruct
    public void initPage(){
        PageFactory.initElements(driver, this);
    }

    public WebPage navigate(){
        throw new NotImplementedException();
    }
}
