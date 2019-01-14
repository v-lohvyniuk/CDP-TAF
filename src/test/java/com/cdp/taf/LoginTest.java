package com.cdp.taf;

import com.cdp.taf.po.HomePage;
import com.cdp.taf.po.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends UiTestBase {

    @Test(description = "User can log in to application")
    public void login_Positive_TestCase() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.getEmailInput().sendKeys("volodymyr.lohvyniuk@gmail.com");
        loginPage.getPasswordInput().sendKeys("");
        loginPage.getLoginButton().click();

        assertTrue(new HomePage().getProfilePicLabel().isDisplayed());
    }

    @Test(description = "User is able to see registration email confirmation message")
    public void registration_Confirmation_Positive_TestCase() {
        LoginPage loginPage = new LoginPage().navigate();
        loginPage.getFirstNameInput().sendKeys("Volodymyr");
        loginPage.getLastNameInput().sendKeys("Kotlinskyy");
        String emailSuffix = System.currentTimeMillis() + "";
        loginPage.getEmailOfPhoneInput().sendKeys("emailt783+" + emailSuffix + "@gmail.com");
        loginPage.getEmailOfPhoneConfirmInput().sendKeys("emailt783+" + emailSuffix + "@gmail.com");
        loginPage.getNewPasswordInput().sendKeys("Facebook123QweRtx");
        loginPage.getBirthdayDaySelect().selectByValue("7");
        loginPage.getBirthdayMonthSelect().selectByValue("7");
        loginPage.getBirthdayYearSelect().selectByValue("1997");
        loginPage.getGenderRadioButtonByValue("1").click();
        loginPage.getRegistrationButton().click();
        assertTrue(loginPage.getEmailConfirmationWidget().isDisplayed());
    }
}
