package com.cdp.taf.ui.android;

import com.cdp.taf.testbase.UiTestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AndroidSampleTest2048 extends UiTestBase {

    @Test
    public void browserTest() throws Exception {
        driver.findElement(By.xpath("//*[@text=\"Start Game\"]")).click();
    }
}
