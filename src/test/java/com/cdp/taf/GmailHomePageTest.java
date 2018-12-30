package com.cdp.taf;

import com.cdp.taf.po.GmailHomePage;
import org.testng.annotations.Test;

public class GmailHomePageTest extends UiTestBase {

    @Test
    public void navigateToSearchPage_Positive_TestCase(){
        GmailHomePage homePage = new GmailHomePage();
        homePage.navigate();
        homePage.getHomeInput().sendKeys("do a barrel roll");
        homePage.getSubmitButton().click();
    }
}
