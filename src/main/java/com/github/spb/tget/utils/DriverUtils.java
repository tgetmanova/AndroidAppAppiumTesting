package com.github.spb.tget.utils;

import io.appium.java_client.AppiumDriver;

import io.qameta.allure.Attachment;

import org.openqa.selenium.OutputType;

public final class DriverUtils {

    private DriverUtils() {
        throw new IllegalStateException("DriverUtils class is for static utils only and must not be instantiated");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotAsPng(AppiumDriver driver) {
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}
