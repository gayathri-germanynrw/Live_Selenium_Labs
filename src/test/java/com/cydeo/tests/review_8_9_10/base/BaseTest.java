package com.cydeo.tests.review_8_9_10.base;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected Actions actions;
    @BeforeMethod
    public void setUp(){
        actions=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99_drag.drop.url"));
    }
    @AfterMethod
    public void teardown(){
        //Driver.closeDriver();
    }

}
