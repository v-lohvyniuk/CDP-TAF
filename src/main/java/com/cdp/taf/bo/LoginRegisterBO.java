package com.cdp.taf.bo;

import com.cdp.taf.models.User;
import com.cdp.taf.po.HomePage;
import com.cdp.taf.po.LoginPage;
import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class LoginRegisterBO {

    @Lazy
    @Autowired
    private LoginPage loginPage;

    @Autowired
    private static Faker faker;

    @Lazy
    @Autowired
    private HomePage homePage;

    private static final Logger LOG = Logger.getLogger(LoginRegisterBO.class);

    public void login(String email, String password) {
        LOG.info(format("Performing login for user {%s} , {%s}",email, password));
        loginPage.navigate();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
    }

    public boolean isUserLoggedIn(){
        return homePage.getProfilePicLabel().isDisplayed();
    }

    public void register(User user) {
        LOG.info("Registering new user, test data : " + user);
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
        return loginPage.isVisible(loginPage.getEmailConfirmationWidget(), 5);
    }

    public static User getSampleUser() {
        Faker faker = new Faker();

        return new User.Builder()
                .setfName(faker.name().firstName())
                .setlName(faker.name().lastName())
                .setEmail("volodymyrtestmail+" + faker.hashCode() + "@gmail.com")
                .setPassword("Facebook123Qwe" +System.currentTimeMillis())
                .setDOBday(7)
                .setDOBmonth(7)
                .setDOByear(1996)
                .setGender(1)
                .build();
    }
}
