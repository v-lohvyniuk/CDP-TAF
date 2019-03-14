package com.cdp.taf.ui.po.impl;

import com.cdp.taf.core.Properties;
import com.cdp.taf.ui.decorator.DecoratedElement;
import com.cdp.taf.ui.decorator.impl.Label;
import com.cdp.taf.ui.po.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("thread")
public class LoginPage extends WebPage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='reg_email__']")
    private WebElement emailOfPhoneInput;

    @FindBy(xpath = "//input[@name='reg_email_confirmation__']")
    private WebElement emailOfPhoneConfirmInput;

    @FindBy(xpath = "//input[@name='reg_passwd__']")
    private WebElement newPasswordInput;

    @FindBy(id = "day")
    private WebElement birthdayDaySelect;

    @FindBy(id = "month")
    private WebElement birthdayMonthSelect;

    @FindBy(id = "year")
    private WebElement birthdayYearSelect;

    @FindBy(name = "sex") // value 1 for M, 2 for F
    private List<WebElement> genderRadioButtons;

    @FindBy(xpath = "//button[@type='submit' and @name = 'websubmit']")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[contains(@class, 'contact_importer_widget')]")
    private DecoratedElement emailConfirmationWidget;

    @FindBy(xpath = "//div[contains(text(), 'We wasdfdfnt to make')]")
    private Label someLabel;

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailOfPhoneInput() {
        return emailOfPhoneInput;
    }

    public WebElement getNewPasswordInput() {
        return newPasswordInput;
    }

    public Select getBirthdayDaySelect() {
        return new Select(birthdayDaySelect);
    }

    public Select getBirthdayMonthSelect() {
        return new Select(birthdayMonthSelect);
    }

    public Select getBirthdayYearSelect() {
        return new Select(birthdayYearSelect);
    }


    public Label getSecureAssuranceLabel() {
        return someLabel;
    }

    public List<WebElement> getGenderRadioButtons() {
        return genderRadioButtons;
    }

    public WebElement getGenderRadioButtonByValue(String value) {
        return genderRadioButtons.stream().filter(x -> x.getAttribute("value").equals(value)).findFirst()
                .orElseThrow(() -> new RuntimeException("No such element with value " + value));
    }

    public WebElement getRegistrationButton() {
        return registrationButton;
    }

    public WebElement getEmailOfPhoneConfirmInput() {
        return emailOfPhoneConfirmInput;
    }

    public DecoratedElement getEmailConfirmationWidget() {
        return emailConfirmationWidget;
    }

    @Override
    public LoginPage navigate() {
        driver.navigate().to(Properties.forEnv.getBaseUrl());
        return this;
    }
}
