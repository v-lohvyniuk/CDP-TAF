package com.cdp.taf.core.config;

import com.cdp.taf.core.Properties;
import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.cdp.taf")
public class UIConfig extends BaseConfig {

    static {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver getRemoteDriverInstance() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }



    private static DesiredCapabilities chromeCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions());
        capabilities.setCapability("selenoid:options", ImmutableMap.of(
                "enableVNC", true,
                "enableVideo", true
        ));

        return capabilities;
    }
    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        return options;
    }
    private static WebDriver getLocalDriverInstance() {
        WebDriver driver = new ChromeDriver(chromeOptions());
        driver.manage().timeouts().implicitlyWait(Properties.forDriver.webdriverWait(), TimeUnit.SECONDS);
        return driver;
    }

    @Bean
    @Scope("thread")
    public WebDriver webDriver() {
        if (Properties.forDriver.getUseLocalDriver()) {
            return getLocalDriverInstance();
        } else {
            return getRemoteDriverInstance();
        }
    }

}
