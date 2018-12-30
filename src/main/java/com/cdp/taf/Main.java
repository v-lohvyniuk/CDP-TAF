package com.cdp.taf;

import com.cdp.taf.po.GmailHomePage;

public class Main {

    public static void main(String[] args) {
        GmailHomePage homePage = new GmailHomePage();
        homePage.navigate();
        homePage.getHomeInput().sendKeys("doabarrelroll");
        homePage.getSubmitButton().click();
    }
}
