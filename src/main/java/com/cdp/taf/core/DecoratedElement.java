package com.cdp.taf.core;

import org.openqa.selenium.WebElement;

public class DecoratedElement {

    protected WebElement element;

    public DecoratedElement(WebElement element) {
        this.element = element;
    }



}