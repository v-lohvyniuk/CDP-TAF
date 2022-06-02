package com.cdp.taf.core.config;

import com.cdp.taf.core.Properties;
import com.cdp.taf.ui.driver.DriverFactory;
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

import java.net.URL;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.cdp.taf")
public class UIConfig extends BaseConfig {

    static {
        String driverType = Properties.driver.getDriverType();

        if (!driverType.equals("android")) {
            WebDriverManager.getInstance(Properties.driver.getDriverType()).setup();
        }
    }

    @Bean
    @Scope("thread")
    public WebDriver webDriver() {
        return DriverFactory.getDriver();
    }
}
