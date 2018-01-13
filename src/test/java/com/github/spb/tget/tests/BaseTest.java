package com.github.spb.tget.tests;

import com.github.spb.tget.utils.DriverUtils;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterMethod;

public class BaseTest {

    private AppiumDriver driver;

    public BaseTest() {
        driver = DriverUtils.createAndroidDriver();
    }

    protected AppiumDriver getDriver() {
        if (driver == null || driver.getSessionId() == null) {
            driver = DriverUtils.createAndroidDriver();
        }
        return driver;
    }

    @AfterMethod
    public void cleanup() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
