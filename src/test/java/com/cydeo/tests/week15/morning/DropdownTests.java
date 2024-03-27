package com.cydeo.tests.week15.morning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropdownTests {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //  1-open a chrome browser
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//  2-goto https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");
    }
    @Test
    public void dropdownTest1(){

//  3-click Dropdown
        driver.findElement(By.linkText("Dropdown")).click();
//  4-verify default option Select a State at State Selection dropdown menu
        Select selectState = new Select(driver.findElement(By.id("state")));

        WebElement defaultOption= selectState.getFirstSelectedOption();

        String actualDefaultOption = defaultOption.getText();
        String expectedDefaultOption="Select a State";

        Assert.assertEquals(actualDefaultOption,expectedDefaultOption,"Actual default option is NOT the same");

    }

    @Test
    public void dropdownTest2(){
//  3-click Dropdown
        driver.findElement(By.linkText("Dropdown")).click();
//  4-select Alabama from State Selection dropdown menu
        Select selectState = new Select(driver.findElement(By.id("state")));
        //selectState.selectByIndex(1);
        //selectState.selectByValue("AL");
        selectState.selectByVisibleText("Alabama");

//  5-verify Alabama is selected
//        WebElement selectedOption = selectState.getFirstSelectedOption();
//        String actualSelectedOption = selectedOption.getText();

        String actualSelectedOption = selectState.getFirstSelectedOption().getText();
        String  expectedSelectedOption ="Alabama";

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
