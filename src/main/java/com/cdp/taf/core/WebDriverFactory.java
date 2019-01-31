package com.cdp.taf.core;

import com.cdp.taf.PropertiesResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    }

    private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();


    public static void setDriver(WebDriver driver){
        if(DRIVER_POOL.get() != null){
            DRIVER_POOL.set(driver);
        }
    }


}
