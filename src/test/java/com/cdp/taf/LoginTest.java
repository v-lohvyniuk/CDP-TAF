package com.cdp.taf;

import com.cdp.taf.po.HomePage;
import com.cdp.taf.po.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends UiTestBase {

    @Test
    public void login_Positive_TestCase() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.getEmailInput().sendKeys("volodymyr.lohvyniuk@gmail.com");
        loginPage.getPasswordInput().sendKeys("solliwarqwertyua");
        loginPage.getLoginButton().click();

        Assert.assertTrue(new HomePage().getProfilePicLabel().isDisplayed());
    }
}
