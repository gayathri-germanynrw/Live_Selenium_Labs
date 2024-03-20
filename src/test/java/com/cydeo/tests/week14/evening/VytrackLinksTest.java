package com.cydeo.tests.week14.evening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VytrackLinksTest {

    public static void main(String[] args) {
        //1-open a chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        //  3-verify Home, About us, Our Approach, Products and Services, Contact and LOGIN labels are displayed

       List<WebElement> allTopLinks = driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));

     //  List<String> expectedAllTopLinks = new ArrayList<>(Arrays.asList("Home", "About us", "Our Approach", "Products and Services", "Contact", "LOGIN"));

        for (WebElement eachLink : allTopLinks) {
            System.out.println("eachLink.isDisplayed() = " + eachLink.isDisplayed());
        }

        driver.quit();
    }
}
