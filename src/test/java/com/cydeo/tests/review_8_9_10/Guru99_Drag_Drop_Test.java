package com.cydeo.tests.review_8_9_10;

import com.cydeo.tests.review_8_9_10.base.BaseTest;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Guru99_Drag_Drop_Test extends BaseTest {

    @Test
    public void drag_and_drop_test() {
        // TC: Guru99 Drag and Drop Test
        // 1- Open a chrome browser
        // 2- Go to: https://demo.guru99.com/test/drag_drop.html
        // 3- Drag “BANK” and drop into Account area under Debit Side
        // Click "Accept ALL" from iframe _ Popup
        WebElement ifrmae_acceptBtn = Driver.getDriver().findElement(By.id("gdpr-consent-notice"));
        Driver.getDriver().switchTo().frame(ifrmae_acceptBtn);
        Driver.getDriver().findElement(By.xpath("//span[text()='Accept All']")).click();
        Driver.getDriver().switchTo().parentFrame();


        WebElement bank = Driver.getDriver().findElement(By.linkText("BANK"));
        WebElement accountType = Driver.getDriver().findElement(By.id("bank"));
        actions.dragAndDrop(bank, accountType).perform();

        // 4- Drag “5000” and drop into Amount area under Debit Side

        WebElement amt_5k = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement amountArea = Driver.getDriver().findElement(By.id("amt7"));
        actions.dragAndDrop(amt_5k, amountArea).perform();
    }
}
