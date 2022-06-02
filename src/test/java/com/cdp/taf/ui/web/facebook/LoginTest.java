package com.cdp.taf.ui.web.facebook;

import com.cdp.taf.listeners.AllureScreenshotListener;
import com.cdp.taf.testbase.UiTestBase;
import com.cdp.taf.ui.bo.LoginRegisterBO;
import com.cdp.taf.data.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.cdp.taf.ui.bo.LoginRegisterBO.getSampleUser;
import static org.testng.Assert.assertFalse;

@Listeners({AllureScreenshotListener.class})
public class LoginTest extends UiTestBase {

    @Autowired
    private LoginRegisterBO loginRegisterBO;

    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }

    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase2() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase3() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase4() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase5() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase6() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase7() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase8() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase9() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase10() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase11() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase12() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase13() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase14() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase15() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }
    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase16() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "Sdueghuidfhgih");
        // THEN
        assertFalse(loginRegisterBO.isUserLoggedIn());
    }

    @Test(description = "User is able to see registration email confirmation message")
    public void registration_Confirmation_Positive_TestCase() {
        // Given
        User user = getSampleUser();
        // WHEN
        loginRegisterBO.register(user);
        // THEN
        //TODO: Add model generation to avoid security check
        assertFalse(loginRegisterBO.isEmailConfirmationMessageDisplayed());
        //AND
        loginRegisterBO.failingStep();

    }
}
