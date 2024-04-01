package com.cydeo.tests.week16;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Tframe_Practice extends TestBase {
    // 1. Users are already login and on the homepage of CRM app
    @Test
    public void iframe_test(){
        driver.get("https://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver);
        // 2. Users click the MESSAGE tab
        WebElement msgElement=driver.findElement(By.id("feed-add-post-form-tab-message"));
        msgElement.click();

        // one way to switch
        // driver.switchTo().frame(0);
        // using iframe web element
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        // 3. Users write test message ( inside Iframe
        driver.findElement(By.tagName("body")).sendKeys("Hello");
        // if iframe is nested child iframe and you want to go to iframe
        driver.switchTo().parentFrame();
        // if u want to go back main Html
        driver.switchTo().defaultContent();
        // 4. Users click the SEND button
        // In cssSelector id value we use (# )
        driver.findElement(By.cssSelector("#blog-submit-button-save")).click();
        // 5. Verify the message is displayed on the feed
        WebElement feedMsgEle=driver.findElement(By.xpath("//div[contains(@id,'blog_post_body_')]"));
        Assert.assertEquals(feedMsgEle.getText()
                ,"Hello");

    }

}

/*
// 1. Users are already login and on the homepage of CRM app
    // 2. Users click the MESSAGE tab
    // 3. Users write test message
    // 4. Users click the SEND button
    // 5. Verify the message is displayed on the feed
 */
