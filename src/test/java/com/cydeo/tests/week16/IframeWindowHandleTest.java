package com.cydeo.tests.week16;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class IframeWindowHandleTest extends TestBase {

    @Test
    public void iframeWindowHandleTest() {

    //Step 1- Go to the url : http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        driver.findElement(By.id("accept-choices")).click();

    //Step 2- Get the current window’s handle and write to the console window. It must be the first window handle.
        String mainWindowHandle=driver.getWindowHandle();
        System.out.println("mainWindowHandle = " + mainWindowHandle);
        BrowserUtils.sleep(5);
        // id, String, web Element
        driver.switchTo().frame("iframeResult");
        //Step 3- Locate the “Visit W3Schools.com!” link and click it.
        driver.findElement(By.linkText("Visit W3Schools.com!")).click();
        //Step 4- Get all window handles and hold them in a list.
        Set<String> allWindowHandles=driver.getWindowHandles();
        //Step 5- Write to total window handle number to the console. It must be 2.

        System.out.println("allWindowHandles.size() = " + allWindowHandles.size());
        //Step 6- Switch to the second window.
        for (String eachWindow : allWindowHandles) {
            driver.switchTo().window(eachWindow);
        }

    //Step 7- Get the current window’s handle and write to the console window. It must be a second window handle.
        String secondWindowHandle=driver.getWindowHandle();
        System.out.println("secondWindowHandle = " + secondWindowHandle);
        //Step 8- Check the upper left side logo in the second window is displayed.
        WebElement logoElem=driver.findElement(By.cssSelector(".fa.fa-logo.ws-hover-text-green"));
        Assert.assertTrue(logoElem.isDisplayed());

    //Step 9- Go back (Switch) to the first window.
        driver.switchTo().window(mainWindowHandle);

    //Step 10- Get the current window’s handle and write to the console window. It must be the first window handle.
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        //Step 11- Check the See Run Button Text. It must contain “Run ❯” text.

        WebElement runBtn=driver.findElement(By.id("runbtn"));
        Assert.assertTrue(runBtn.getText().contains("Run ❯"));
    }
}

