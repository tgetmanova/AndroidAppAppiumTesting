package com.github.spb.tget.tests;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.github.spb.tget.utils.ReportUtils.saveScreenshotAsPng;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        saveScreenshotAsPng(((BaseTest) currentClass).driver);
    }
}
