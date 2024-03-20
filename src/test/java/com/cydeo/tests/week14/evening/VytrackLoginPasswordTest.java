package com.cydeo.tests.week14.evening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackLoginPasswordTest {

    public static void main(String[] args) {

        //1- Setup the "browser driver"
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

        // 3- Click Login label
        driver.findElement(By.cssSelector("a[href='http://app.vytrack.com']")).click();

        // 4- Verify the password is hidden

        WebElement password = driver.findElement(By.xpath("//input[@name='_password']"));

        String actualHiddenPassword = password.getAttribute("type");
        String expectedHiddenPassword = "password";

        if (actualHiddenPassword.equals(expectedHiddenPassword)){
            System.out.println("Password is hidden!");
        }else{
            System.out.println("Password is not hidden!");
        }

        driver.quit();
    }
}
