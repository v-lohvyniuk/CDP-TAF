package com.cdp.taf.core;

import com.cdp.taf.Properties;
import com.cdp.taf.bo.LoginRegisterBO;
import com.cdp.taf.po.HomePage;
import com.cdp.taf.po.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Configuration
public class SpringConfig {


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

    public static void main(String[] args) {
        resolveDriverExecutable();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        final CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(Collections.singletonMap("thread", new SimpleThreadScope()));
        return configurer;
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

    @Bean
    @Scope("thread")
    public LoginPage loginPage() {
        return new LoginPage();
    }

    @Bean
    @Scope("thread")
    public HomePage homePage() {
        return new HomePage();
    }


    private static WebDriver getLocalDriverInstance() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Properties.forDriver.webdriverWait(), TimeUnit.SECONDS);
        return driver;
    }

}
