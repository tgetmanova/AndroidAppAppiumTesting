package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageElements {

    protected AppiumDriver driver;

    public PageElements(AppiumDriver driver) {
        this.driver = driver;
        initElements(new AppiumFieldDecorator(driver), this);
    }
}
