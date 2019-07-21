package com.cdp.taf.ui.bo;

import com.cdp.taf.data.models.User;
import com.cdp.taf.ui.po.impl.HomePage;
import com.cdp.taf.ui.po.impl.LoginPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class LoginRegisterBO {

    @Lazy
    @Autowired
    private LoginPage loginPage;

    @Lazy
    @Autowired
    private HomePage homePage;

    @Autowired
    private static Faker faker;

    private static final Logger LOG = Logger.getLogger(LoginRegisterBO.class);

    @Step
    public void login(String email, String password) {
        LOG.info(format("Performing login for user {%s} , {%s}",email, password));
        loginPage.navigate();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
    }

    @Step
    public boolean isUserLoggedIn(){
        return homePage.getProfilePicLabel().isVisibleShortly();
    }

    @Step
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

    @Step
    public boolean isEmailConfirmationMessageDisplayed(){
        return loginPage.getSecureAssuranceLabel().isVisibleShortly();
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
