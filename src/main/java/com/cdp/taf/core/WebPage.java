package com.cdp.taf.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public abstract class WebPage {

    @Autowired
    public WebDriver driver;

    @PostConstruct
    public void initPage(){
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    private static final int CONTITION_WAIT = 15;

    public WebPage navigate(){
        throw new NotImplementedException();
    }

    public boolean isVisible(DecoratedElement element){
        return isVisible(element, CONTITION_WAIT);
    }

    public boolean isVisibleCurrently(DecoratedElement element){
        return isVisible(element, 0);
    }

    public boolean isVisible(DecoratedElement element, int timeInSec){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeInSec);
        try {
            wait.until(driver -> element.element.isDisplayed() && element.element.isEnabled());
            if(element.element.isDisplayed() && element.element.isEnabled()){
                return true;
            }
            return false;
        }catch (WebDriverException e){
            e.printStackTrace();
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }


}
