package com.cdp.taf.stepdef;


import com.cdp.taf.bo.LoginRegisterBO;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class LoginStepDef extends BaseStepDef {
    @Autowired
    private LoginRegisterBO loginRegisterBO;

    @When("^User type email (\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}) and password and click submit$")
    public void typeLoginAndPasswordAndSubmit(String login) {
        loginRegisterBO.login(login, "Qwerty1234");
    }

    @Then("^Then error message is displayed$")
    public void errorMessageIsDisplayed() {
        assertTrue(loginRegisterBO.errorMessageDisplayed());
    }
}