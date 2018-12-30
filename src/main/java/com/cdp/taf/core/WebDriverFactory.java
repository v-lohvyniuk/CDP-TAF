package com.cdp.taf.core;

import com.cdp.taf.PropertiesResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (DRIVER_POOL.get() == null) {
            DRIVER_POOL.set(getLocalDriverInstance());
        }
        return DRIVER_POOL.get();
    }

    private static WebDriver getLocalDriverInstance() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(PropertiesResolver.webDriverConfig.webdriverWait(), TimeUnit.SECONDS);
        return driver;
    }
}
