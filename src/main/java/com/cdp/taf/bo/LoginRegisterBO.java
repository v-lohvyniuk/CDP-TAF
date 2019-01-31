package com.cdp.taf.bo;

import com.cdp.taf.models.User;
import com.cdp.taf.po.HomePage;
import com.cdp.taf.po.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LoginRegisterBO {

    @Autowired
    private ApplicationContext applicationContext;

    private LoginPage getLoginPage() {
        return applicationContext.getBean(LoginPage.class);
    }

    private HomePage getHomePage() {
        return applicationContext.getBean(HomePage.class);
    }


    public void login(String email, String password) {
        getLoginPage().navigate();
        getLoginPage().getEmailInput().sendKeys(email);
        getLoginPage().getPasswordInput().sendKeys(password);
        getLoginPage().getLoginButton().click();
    }

    public boolean isUserLoggedIn(){
        return getHomePage().getProfilePicLabel().isDisplayed();
    }

    public void register(User user) {
        getLoginPage().navigate();
        getLoginPage().getFirstNameInput().sendKeys(user.getfName());
        getLoginPage().getLastNameInput().sendKeys(user.getlName());
        getLoginPage().getEmailOfPhoneInput().sendKeys(user.getEmail());
        getLoginPage().getEmailOfPhoneConfirmInput().sendKeys(user.getEmail());
        getLoginPage().getNewPasswordInput().sendKeys(user.getPassword());
        getLoginPage().getBirthdayDaySelect().selectByValue("" + user.getDOBday());
        getLoginPage().getBirthdayMonthSelect().selectByValue("" + user.getDOBmonth());
        getLoginPage().getBirthdayYearSelect().selectByValue("" + user.getDOByear());
        getLoginPage().getGenderRadioButtonByValue("" + user.getGender()).click();
        getLoginPage().getRegistrationButton().click();
    }

    public boolean isEmailConfirmationMessageDisplayed(){
        return getLoginPage().getEmailConfirmationWidget().isDisplayed();
    }

    public static User getSampleUser() {
        return new User.Builder()
                .setfName("Volodymyddffdfr")
                .setlName("Kotlinskdfdfyy")
                .setEmail("emailt78sddsd3+" + System.currentTimeMillis() + "@gmail.com")
                .setPassword("Facebook123QweRtxsdsd")
                .setDOBday(7)
                .setDOBmonth(7)
                .setDOByear(1996)
                .setGender(1)
                .build();
    }
}
