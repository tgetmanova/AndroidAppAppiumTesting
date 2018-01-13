package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CommonMenu extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Settings']")
    private MobileElement settingsMenuItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'My List']")
    private MobileElement myListMenuItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Remind']")
    private MobileElement remindMenuItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Add from my list']")
    private MobileElement addFromMyListMenuItem;

    public CommonMenu(AppiumDriver driver) {
        super(driver);
    }

    public void selectSettingsOption() {
        settingsMenuItem.click();
    }

    public void selectMyListOption() {
        myListMenuItem.click();
    }

    public void selectRemindOption() {
        remindMenuItem.click();
    }

    public void selectAddFromMyListOption() {
        addFromMyListMenuItem.click();
    }
}
