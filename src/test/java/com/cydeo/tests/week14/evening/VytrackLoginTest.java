package com.cydeo.tests.week14.evening;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackLoginTest {

    public static void main(String[] args) throws InterruptedException {
        //1- Setup the "browser driver"
        WebDriver driver = new ChromeDriver();

        Thread.sleep(3000);

        driver.manage().window().maximize();

        Thread.sleep(3000);

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

        // 3- Click Login label
        driver.findElement(By.linkText("LOGIN")).click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        driver.findElement(By.id("prependedInput")).sendKeys("User1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);

        Thread.sleep(3000);


        // 5- Verify the title is "Dashboard"
        if(driver.getTitle().equals("Dashboard")){
            System.out.println("Title verification is passed!");
        }else{
            System.out.println("Title verification is failed!");
        }

        driver.quit();
    }
}
