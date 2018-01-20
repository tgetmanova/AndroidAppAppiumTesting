package com.github.spb.tget.utils;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    private AppiumDriver driver;

    private WebDriverWait wait;

    public DriverManager(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void waitForElementPresenceAndClick(By elementLocator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        driver.findElement(elementLocator).click();
    }
}
