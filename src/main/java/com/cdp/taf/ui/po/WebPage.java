package com.cdp.taf.ui.po;

import com.cdp.taf.ui.decorator.CustomFieldDecorator;
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
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public WebPage navigate(){
        throw new NotImplementedException();
    }

}
