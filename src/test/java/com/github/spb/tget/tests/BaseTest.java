package com.github.spb.tget.tests;

import com.github.spb.tget.utils.AppiumDriverFactory;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeMethod
    public void initializeTest() {
        driver = AppiumDriverFactory.getDriver();
    }

    @AfterMethod
    public void cleanup() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
