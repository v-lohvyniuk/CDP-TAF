package com.cdp.taf;

import com.cdp.taf.bo.LoginRegisterBO;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

import static com.cdp.taf.bo.LoginRegisterBO.getSampleUser;
import static org.testng.Assert.assertTrue;

public class LoginTest extends UiTestBase {

    @Autowired
    private LoginRegisterBO loginRegisterBO;

    @Test(description = "User can log in to application")
    public void login_Positive_TestCase() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "");
        // THEN
        assertTrue(loginRegisterBO.isUserLoggedIn());
    }

    @Test(description = "User is able to see registration email confirmation message")
    public void registration_Confirmation_Positive_TestCase() {
        // WHEN
        loginRegisterBO.register(getSampleUser());
        // THEN
        //TODO: Add model generation to avoid security check
//        assertTrue(loginRegisterBO.isEmailConfirmationMessageDisplayed());
    }

    @Test
    public void navigateToGoogleHomePage(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://translate.google.com/");
        WebElement element = webDriver.findElement(By.xpath("//a[contains(@href, 'ServiceLogin')]"));
        System.out.println(element.getText());
        webDriver.navigate().to("https://www.ukr.net/");
        WebElement videoElement = webDriver.findElement(By.xpath("(//a[contains(@href, 'news/video')])[1]"));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", videoElement);
//        videoElement.click();
    }

}
