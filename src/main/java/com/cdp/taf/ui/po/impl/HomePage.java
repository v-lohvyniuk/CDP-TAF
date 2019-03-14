package com.cdp.taf.ui.po.impl;

import com.cdp.taf.ui.decorator.DecoratedElement;
import com.cdp.taf.ui.po.WebPage;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("thread")
public class HomePage extends WebPage {

    @FindBy(xpath = "//*[contains(@id, 'profile_pic_header')]")
    private DecoratedElement profilePicLabel;

    public DecoratedElement getProfilePicLabel() {
        return profilePicLabel;
    }
}
