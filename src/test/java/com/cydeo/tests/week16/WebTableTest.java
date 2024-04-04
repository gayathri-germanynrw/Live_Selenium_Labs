package com.cydeo.tests.week16;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {
    @Test
    public void web_table_test() {
        //Step 1- Go to the url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        //Step 2- Click on Date input area
        WebElement datePick_Element = driver.findElement(By.id("datepicker"));
        datePick_Element.click();

        //Step 3- Get all td of tables using findElements method

        List<WebElement> allTableData = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));


        //Step 4- Get the text of all elements
        for (WebElement eachDay : allTableData) {
            if (!eachDay.getText().trim().isEmpty()) {
                System.out.println("eachDay.getText() = " + eachDay.getText());
            }
        }
        //Step 5- Click 12. day of month
        BrowserUtils.selectDay(driver, 12);

        //Step 6- Assert that date of "04/12/2024" has been entered in input area.
        Assert.assertEquals(datePick_Element.getAttribute("value"), "04/12/2024");
    }

}
/*
Step 1- Go to the url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html
Step 2- Click on Date input area
Step 3- Get all td of tables using findElements method
Step 4- Get the text of all elements
Step 5- Click 12. day of month
Step 6- Assert that date of "04/12/2024" has been entered in input area.
 */
