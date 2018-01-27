package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

public class CommonMenu extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Settings']")
    private MobileElement settingsMenuItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'My List']")
    private MobileElement myListMenuItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Remind']")
    private MobileElement remindMenuItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Add from my list']")
    private MobileElement addFromMyListMenuItem;

    @AndroidFindBy(id = "com.slava.buylist:id/button1")
    private MobileElement menuButton;

    public CommonMenu(AppiumDriver driver) {
        super(driver);
    }

    @Step("Expanding top menu items")
    public CommonMenu clickMenuButton() {
        menuButton.click();
        return this;
    }

    @Step("Selecting 'Settings' option in Menu")
    public void selectSettingsOption() {
        settingsMenuItem.click();
    }

    @Step("Selecting 'My List' option in Menu")
    public void selectMyListOption() {
        myListMenuItem.click();
    }

    @Step("Selecting 'Remind' option in Menu")
    public void selectRemindOption() {
        remindMenuItem.click();
    }

    @Step("Selecting 'Add from my list' option in Menu")
    public void selectAddFromMyListOption() {
        addFromMyListMenuItem.click();
    }
}
