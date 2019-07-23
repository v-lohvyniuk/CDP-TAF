package com.cdp.taf.listeners;

import com.cdp.taf.utils.SpringContext;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Component
public class AllureTestListener implements ITestListener {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(((TakesScreenshot) SpringContext.getBean(WebDriver.class))
                .getScreenshotAs(OutputType.BYTES));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
