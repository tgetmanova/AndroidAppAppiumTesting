package com.github.spb.tget.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Page {

    protected AndroidDriver driver;

    public Page(AndroidDriver driver) {
        this.driver = driver;
        initElements(new AppiumFieldDecorator(driver), this);
    }
}
