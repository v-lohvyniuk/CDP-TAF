package com.cdp.taf.ui.decorator.impl;

import com.cdp.taf.ui.decorator.DecoratedElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class Label extends DecoratedElement {

    public Label(WebElement element, WebDriver driver) {
        super(element, driver);
    }

    public boolean containsIgnoreCaseText(String text) {
        return preValidateExists() &&
                containsIgnoreCase(this.element.getText(), text);
    }
}
