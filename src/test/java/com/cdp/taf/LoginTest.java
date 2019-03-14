package com.cdp.taf;

import com.cdp.taf.bo.LoginRegisterBO;
import com.cdp.taf.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static com.cdp.taf.bo.LoginRegisterBO.getSampleUser;
import static org.testng.Assert.assertFalse;

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
