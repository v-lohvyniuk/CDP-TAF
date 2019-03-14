package com.cdp.taf.ui.decorator;

import com.cdp.taf.core.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DecoratedElement {

    private static final int DEFAULT_TIMEOUT = Properties.forDriver.webdriverWait().intValue();

    protected WebElement element;
    private WebDriver driver;

    public DecoratedElement(WebElement element, WebDriver driver) {
        this.element = element;
        this.driver = driver;
    }

    public boolean isVisibleIn(int timeInSec) {
        turnOffImpicitlyWait();
        WebDriverWait wait = new WebDriverWait(driver, timeInSec);
        try {
            wait.until(dr -> element.isDisplayed() && element.isEnabled());
            return element.isDisplayed() && element.isEnabled();
        } catch (WebDriverException e) {
            e.printStackTrace();
            return false;
        } finally {
            turnOnImpicitlyWait();
        }
    }

    public boolean isVisibleShortly() {
        return isVisibleIn(Properties.forDriver.getShortWait());
    }

    protected boolean preValidateExists() {
        try {
            element.getCssValue("class"); // to check if proxy throws NoSuchElementException
            return true;
        } catch (WebDriverException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void turnOffImpicitlyWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    private void turnOnImpicitlyWait() {
        driver.manage().timeouts()
                .implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    }
}