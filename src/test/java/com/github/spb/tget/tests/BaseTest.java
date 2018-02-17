package com.github.spb.tget.tests;

import com.github.spb.tget.utils.AppiumDriverFactory;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    protected AppiumDriver driver;

    @BeforeMethod
    public void initializeTest() {
        driver = AppiumDriverFactory.getDriver();
    }

    @AfterMethod
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeSuite
    public void startAppiumServer() {
        if (AppiumDriverFactory.getIsAppiumToBeLaunched()) {
            AppiumDriverFactory.getAppiumService().start();
        }
    }

    @AfterSuite
    public void stopAppiumServer() {
        AppiumDriverFactory.getAppiumService().stop();
    }
}
