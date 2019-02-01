package com.cdp.taf.bo;

import com.cdp.taf.models.User;
import com.cdp.taf.po.HomePage;
import com.cdp.taf.po.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LoginRegisterBO {

    @Autowired
    private ApplicationContext applicationContext;

    @Lazy
    @Autowired
    private LoginPage loginPage;

    @Lazy
    @Autowired
    private HomePage homePage;

    public void login(String email, String password) {
        loginPage.navigate();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
    }

    public boolean isUserLoggedIn(){
        return homePage.getProfilePicLabel().isDisplayed();
    }

    public void register(User user) {
        loginPage.navigate();
        loginPage.getFirstNameInput().sendKeys(user.getfName());
        loginPage.getLastNameInput().sendKeys(user.getlName());
        loginPage.getEmailOfPhoneInput().sendKeys(user.getEmail());
        loginPage.getEmailOfPhoneConfirmInput().sendKeys(user.getEmail());
        loginPage.getNewPasswordInput().sendKeys(user.getPassword());
        loginPage.getBirthdayDaySelect().selectByValue("" + user.getDOBday());
        loginPage.getBirthdayMonthSelect().selectByValue("" + user.getDOBmonth());
        loginPage.getBirthdayYearSelect().selectByValue("" + user.getDOByear());
        loginPage.getGenderRadioButtonByValue("" + user.getGender()).click();
        loginPage.getRegistrationButton().click();
    }

    public boolean isEmailConfirmationMessageDisplayed(){
        return loginPage.getEmailConfirmationWidget().isDisplayed();
    }

    public static User getSampleUser() {
        return new User.Builder()
                .setfName("Volodymyr" + System.currentTimeMillis())
                .setlName("Kotlinsky" + System.currentTimeMillis())
                .setEmail("emailt78sddsd3+" + System.currentTimeMillis() + "@gmail.com")
                .setPassword("Facebook123Qwe" +System.currentTimeMillis())
                .setDOBday(7)
                .setDOBmonth(7)
                .setDOByear(1996)
                .setGender(1)
                .build();
    }
}
