package com.cydeo.tests.week16;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HardVsSoftAssertion extends TestBase {
    @Test
    public void webTablePractice_Hard_Assertion() {
        // 2. Go to https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");

        // 3. Print table data as a single String, not so common, but useful sometimes
        //WebElement tblElement=driver.findElement(By.xpath("//table[@id='table1']"));
        WebElement tbl_1_Element = driver.findElement(By.id("table1"));

        // 4. verify tconway@earthlink.net is anywhere in the table

        //Assert.assertTrue(tbl_1_Element.getText().contains("tconway@earthlink.net..."));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(tbl_1_Element.getText().contains("tconway@earthlink.net..."));
        // 5. print all column names in single line
        WebElement theadElement = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.print("theadElement.getText() = " + theadElement.getText());

        // 6. print each column name in separate lines using a loop and findElements method
        List<WebElement> allColumNames = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        for (WebElement eachColName : allColumNames) {
            System.out.println("eachColName = " + eachColName.getText());
        }
        // 7. verify Tim due money is $50.00
        WebElement timDueElem = driver.findElement(By.xpath("//table[@id='table1']//tr/td[.='tconway@earthlink.net']/following-sibling::td[1]"));
        System.out.println("timDueElem.getText() = " + timDueElem.getText());
       // Assert.assertEquals(timDueElem.getText(), "50.00");
        softAssert.assertEquals(timDueElem.getText(), "50.00");
        softAssert.assertAll(); // if u comment this line, then it is ignores all the asserion.
    }

    @Test
    public void webTablePractice_Soft_Assertion() {
        // 2. Go to https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");

        // 3. Print table data as a single String, not so common, but useful sometimes
        //WebElement tblElement=driver.findElement(By.xpath("//table[@id='table1']"));
        WebElement tbl_1_Element = driver.findElement(By.id("table1"));

        // 4. verify tconway@earthlink.net is anywhere in the table

        Assert.assertTrue(tbl_1_Element.getText().contains("tconway@earthlink.net..."));
        // 5. print all column names in single line
        WebElement theadElement = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.print("theadElement.getText() = " + theadElement.getText());

        // 6. print each column name in separate lines using a loop and findElements method
        List<WebElement> allColumNames = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        for (WebElement eachColName : allColumNames) {
            System.out.println("eachColName = " + eachColName.getText());
        }
        // 7. verify Tim due money is $50.00
        WebElement timDueElem = driver.findElement(By.xpath("//table[@id='table1']//tr/td[.='tconway@earthlink.net']/following-sibling::td[1]"));
        System.out.println("timDueElem.getText() = " + timDueElem.getText());
        Assert.assertEquals(timDueElem.getText(), "50.00");
    }
}
