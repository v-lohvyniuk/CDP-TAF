package com.cdp.taf.po;

import com.cdp.taf.core.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends WebPage {

    @FindBy(xpath = "//input[@type='text']")
    private WebElement homeInput;

    @FindBy(xpath ="//input[@type='submit']")
    private WebElement submitButton;


    public WebElement getHomeInput() {
        return homeInput;
    }

    
    public WebElement getSubmitButton() {
        return submitButton;
    }

    @Override
    public GmailHomePage navigate(){
        driver.navigate().to("https://www.google.com/");
        return this;
    }
}
