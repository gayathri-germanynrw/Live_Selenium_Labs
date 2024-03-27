package com.cydeo.tests.week15.morning;

import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadioButtonTest {
    WebDriver driver;
@BeforeMethod
    public void setupMethod(){
//  1-open a chrome browser
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
    public void radioButtonTest() {
//  2-goto https://practice.cydeo.com/
    driver.get("https://practice.cydeo.com/");
//  3-click Radio Buttons
    //driver.findElement(By.linkText("Radio Buttons")).click();
    BrowserUtils.clickOption(driver,"Radio Buttons");
//  4-verify title contains Radio buttons
//  5-select the favorite color as Red
//  6-verify the Red is selected
//  7-select the favorite sport as Football
//  8-verify the Football is selected
}
}
