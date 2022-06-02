package com.cdp.taf.ui.driver;

import com.cdp.taf.core.Properties;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getDriver() {
        if (Properties.driver.getUseLocalDriver()) {
            return getLocalDriverInstance();
        } else {
            return getRemoteDriverInstance();
        }
    }

    private static WebDriver getLocalDriverInstance() {
        WebDriver driver = new ChromeDriver(chromeOptions());
        driver.manage().timeouts().implicitlyWait(Properties.driver.webdriverWait(), TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getRemoteDriverInstance() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(Properties.driver.getHubUrl()), getCapabilities(Properties.driver.getDriverType()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static DesiredCapabilities getCapabilities(String driverType) {
        if (driverType.equals("chrome")) {
            return chromeCapabilities();
        }
        if (driverType.equals("firefox")) {
            return firefoxCapabilities();
        }
        if (driverType.equals("android")) {
            return androidCapabilities();
        }

        throw new RuntimeException("No capabilities for type: " + driverType);
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

    private static DesiredCapabilities androidCapabilities() {
        final DesiredCapabilities device = new DesiredCapabilities();
        device.setCapability("deviceName", "android");
        device.setCapability("version", "10.0");
        device.setCapability("app", "https://d30.dwnserver.com/download/5142464f-56a1-4693-bdec-6de6ea9bdc62/2048-2-0-pdalife.ru.apk/"); //APK from https://www.apkmirror.com/apk/androbaby/2048/2048-2-1-release/2048-2-1-android-apk-download/download/
        device.setCapability("appPackage", "com.androbaby.game2048");
        device.setCapability("appActivity", "com.androbaby.game2048.MainActivity");
        device.setCapability("enableVNC", true);
        device.setCapability("enableVideo", true); // Uncomment this to record video
        return device;
    }

    private static DesiredCapabilities firefoxCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions());
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
}
