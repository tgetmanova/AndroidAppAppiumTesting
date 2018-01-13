package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingsPage extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Currency']")
    private MobileElement currencySettingsItem;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    public void openCurrencySettingsPopup() {
        currencySettingsItem.click();
    }
}
