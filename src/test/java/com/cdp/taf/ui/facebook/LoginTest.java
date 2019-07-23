package com.cdp.taf.ui.facebook;

import com.cdp.taf.listeners.AllureTestListener;
import com.cdp.taf.testbase.UiTestBase;
import com.cdp.taf.ui.bo.LoginRegisterBO;
import com.cdp.taf.data.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.cdp.taf.ui.bo.LoginRegisterBO.getSampleUser;
import static org.testng.Assert.assertFalse;

@Listeners({AllureTestListener.class})
public class LoginTest extends UiTestBase {

    @Autowired
    private LoginRegisterBO loginRegisterBO;

    @Test(description = "User can log in to application")
    public void loginWithoutPwd_Negative_TestCase() {
        // WHEN
        loginRegisterBO.login("volodymyr.lohvyniuk@gmail.com", "");
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
    }
}
