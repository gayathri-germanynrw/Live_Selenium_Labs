package com.cydeo.tests.review_8_9_10;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Guru99_UploadTest extends TestBase {

    @Test
    public void guru99UploadTest() {
        //// TC: Guru99 Upload Test
        //1. Go to  “https://demo.guru99.com/test/upload”
       driver.get("https://demo.guru99.com/test/upload");


        // one way to switch to Iframe

        driver.switchTo().frame(driver.findElement(By.id("gdpr-consent-notice")));

        // using iframe web element
       // driver.switchTo().frame(0);
        // 3. Users write test message ( inside Iframe
        driver.findElement(By.xpath("//span[text()='Accept All']")).click();
        // if iframe is nested child iframe and you want to go to iframe
        driver.switchTo().parentFrame();

        //2. Upload file into Choose File
        WebElement chooseFileBtn=driver.findElement(By.id("uploadfile_0"));
        chooseFileBtn.sendKeys("C:/Users/gayat/Downloads/some-file.txt");

        //3. Click terms of service check box
                                         //TagName#idvalue
        driver.findElement(By.cssSelector("input#terms"));
        BrowserUtils.sleep(2);
        //4. Click Submit File button
        driver.findElement(By.name("send")).click();
        //button[@name='send']

        //5. Verify expected message appeared.
        // Expected: “1 file
        // has been successfully uploaded.
        BrowserUtils.sleep(2);
        //WebElement msg_Element=driver.findElement(By.cssSelector("h3#res>center"));
        WebElement resultMsg = driver.findElement(By.cssSelector("h3#res>center"));
       String actualMsg = resultMsg.getText();
       String expectedMsg ="1 file\nhas been successfully uploaded.";
        Assert.assertEquals(actualMsg,expectedMsg,"Result message verification failed!");
    }

}

/*
// TC: Guru99 Upload Test
  //1. Go to  “https://demo.guru99.com/test/upload”
  //2. Upload file into Choose File
  //3. Click terms of service check box
  //4. Click Submit File button
  //5. Verify expected message appeared.
  // Expected: “1 file
   // has been successfully uploaded.
 */
