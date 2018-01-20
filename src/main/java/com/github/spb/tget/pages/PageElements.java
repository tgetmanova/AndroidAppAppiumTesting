package com.github.spb.tget.pages;

import com.github.spb.tget.utils.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageElements {

    protected DriverManager driverManager;

    public PageElements(AppiumDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(new AppiumFieldDecorator(driver), this);
    }
}
