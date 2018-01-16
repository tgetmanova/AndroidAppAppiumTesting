package com.github.spb.tget.tests;

import io.appium.java_client.AppiumDriver;

import io.qameta.allure.Attachment;

import org.openqa.selenium.OutputType;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        saveScreenshotAsPng(((BaseTest) currentClass).driver);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotAsPng(AppiumDriver driver) {
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}
