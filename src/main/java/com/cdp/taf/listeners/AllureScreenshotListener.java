package com.cdp.taf.listeners;

import com.cdp.taf.utils.SpringContext;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class AllureScreenshotListener implements ITestListener {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void onTestFailure(ITestResult result) {
        BufferedImage img = new AShot().takeScreenshot(SpringContext.getBean(WebDriver.class)).getImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveScreenshot(baos.toByteArray());
    }

    @Attachment(value = "Full page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
