package com.cdp.taf.po;

import com.cdp.taf.core.WebDriverFactory;
import com.cdp.taf.core.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class LoginPageProvider extends WebPage {

    @Autowired
    private LoginPage loginPage;


}
