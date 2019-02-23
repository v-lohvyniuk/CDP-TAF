package com.cdp.taf.core;

import com.cdp.taf.Properties;
import com.cdp.taf.bo.LoginRegisterBO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.cdp.taf")
public class UIConfig extends BaseConfig {

    static {
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/linux/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        }
    }

    private static WebDriver getLocalDriverInstance() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Properties.forDriver.webdriverWait(), TimeUnit.SECONDS);
        return driver;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public LoginRegisterBO loginRegisterBO() {
        return new LoginRegisterBO();
    }

    @Bean
    @Scope("thread")
    public WebDriver webDriver() {
        return getLocalDriverInstance();
    }

}
