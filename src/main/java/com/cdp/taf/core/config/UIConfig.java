package com.cdp.taf.core.config;

import com.cdp.taf.core.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.cdp.taf")
public class UIConfig extends BaseConfig {

    static {
        System.setProperty("webdriver.chrome.driver", resolveDriverExecutable());
    }

    private static String resolveDriverExecutable(){
        if(System.getProperty("os.name").toLowerCase().contains("linux")){
            return "src/main/resources/drivers/linux/chromedriver";
        }else {
            return "src/main/resources/drivers/chromedriver.exe";
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
    @Scope("thread")
    public WebDriver webDriver() {
        return getLocalDriverInstance();
    }

}
