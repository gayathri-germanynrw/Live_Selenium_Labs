package com.cydeo.tests.week14.morning;
/*
** TC002 As a user I should be able to see the password hidden as default

 1- Setup the "browser driver"
 2- Go to "https://vytrack.com"
 3- Click Login label
 4- Verify the password is hidden
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VytrackHiddenPasswordTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebElement loginButton;
        WebElement passwordBox;

//1- Setup the "browser driver"
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// 2- Go to "https://vytrack.com"
    driver.get("https://vytrack.com");
    Thread.sleep(3000);

// 3- Click Login label
        //xpath syntax: //tagName[text()='TEXT']
    loginButton=driver.findElement(By.xpath("//a[text()='LOGIN']"));
    loginButton.click();

// 4- Verify the password is hidden
        //xpath syntax:  //tagName[@attribute='value']
    passwordBox=driver.findElement(By.xpath("//input[@id='prependedInput2']"));

    String actualAttributeTypeOfPasswordBox=passwordBox.getAttribute("type");
    String expectedAttributeTypeOfPasswordBox="password";

    if(actualAttributeTypeOfPasswordBox.equals(expectedAttributeTypeOfPasswordBox)){
        System.out.println("Password is hidden!");
    }else{
        System.out.println("Password is NOT hidden!");
    }

    driver.quit();
    }
}
