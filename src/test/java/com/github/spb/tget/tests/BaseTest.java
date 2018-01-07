package com.github.spb.tget.tests;

import com.github.spb.tget.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.AfterTest;

public class BaseTest {

    private AndroidDriver driver;

    public BaseTest() {
        driver = DriverUtils.getDriver();
    }

    protected AndroidDriver getDriver() {
        return this.driver;
    }

    @AfterTest
    public void cleanup() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
