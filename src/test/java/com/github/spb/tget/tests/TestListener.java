package com.github.spb.tget.tests;

import io.appium.java_client.AppiumDriver;

import io.qameta.allure.Attachment;

import org.openqa.selenium.OutputType;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        saveScreenshotAsPng(((BaseTest) currentClass).driver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotAsPng(AppiumDriver driver) {
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}
