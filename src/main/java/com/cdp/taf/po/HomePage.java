package com.cdp.taf.po;

import com.cdp.taf.core.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("thread")
public class HomePage extends WebPage {

    @FindBy(xpath = "//*[contains(@id, 'profile_pic_header')]")
    private WebElement profilePicLabel;

    public WebElement getProfilePicLabel() {
        return profilePicLabel;
    }
}
