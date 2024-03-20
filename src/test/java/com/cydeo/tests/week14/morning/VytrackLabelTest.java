package com.cydeo.tests.week14.morning;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VytrackLabelTest {
    /*
  1-open a chrome browser
  2-goto https://vytrack.com/
  3-verify Home, About us, Our Approach, Products and Services, Contact and LOGIN labels are displayed
     */

    public static void main(String[] args) throws InterruptedException {

// 1-open a chrome browser
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        Thread.sleep(3000);

//3-verify Home, About us, Our Approach, Products and Services, Contact and LOGIN labels are displayed
        List<String> expectedLabelTexts= new ArrayList<>(Arrays.asList("Home", "About us", "Our Approach", "Products and Services", "Contact", "LOGIN"));

        //cssSelector syntax: tagName#idValue
        //                    parentElement>childElement
        List<WebElement> actualLabels = driver.findElements(By.cssSelector("ul#top-menu>li>a"));

        List<String> actualLabelTexts= new ArrayList<>();

        for(WebElement each : actualLabels){
            actualLabelTexts.add(each.getText());
        }

        if(actualLabelTexts.equals(expectedLabelTexts)){
            System.out.println("Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed!");
        }else{
            System.out.println("Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are NOT displayed!");
        }

        driver.quit();



    }
}
