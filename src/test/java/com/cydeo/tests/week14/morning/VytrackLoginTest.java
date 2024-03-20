package com.cydeo.tests.week14.morning;

/*
 ** TC001 As a user I should be able to login with valid credentials

 1- Setup the "browser driver"
 2- Go to "https://vytrack.com"
 3- Click Login label
 4- Login to application with username as "User1" and password as "UserUser123"
 5- Verify the title is "Dashboard"
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VytrackLoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebElement loginButton;
        WebElement userNameBox;
        WebElement passwordBox;

//1- Setup the "browser driver"
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//   2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

//   3- Click Login label
        loginButton = driver.findElement(By.linkText("LOGIN"));
        loginButton.click();

//   4- Login to application with username as "User1" and password as "UserUser123"
        userNameBox=driver.findElement(By.id("prependedInput"));
        userNameBox.sendKeys("User1");

        passwordBox=driver.findElement(By.cssSelector("input#prependedInput2"));
        passwordBox.sendKeys("UserUser123"+ Keys.ENTER);

//   5- Verify the title is "Dashboard"
        Thread.sleep(7000);

        String actualTitle=driver.getTitle();
        String expectedTitle="Dashboard";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed!");
        }else {
            System.out.println("Title verification failed!");
        }
        driver.quit();
    }
}
