package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

public class SettingsPage extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Currency']")
    private MobileElement currencyItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Own currency']")
    private MobileElement ownCurrencyItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Orientation']")
    private MobileElement orientationItem;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(0)")
    private MobileElement units;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(1)")
    private MobileElement comment;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(2)")
    private MobileElement price;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Opening 'Currency selection' popup from 'Settings'")
    public void openCurrencyPopup() {
        currencyItem.click();
    }

    @Step("Opening 'Provide custom currency' popup from 'Settings'")
    public void openOwnCurrencyPopup() {
        ownCurrencyItem.click();
    }

    @Step("Opening 'Orientation selection' popup from 'Settings'")
    public void openOrientationPopup() {
        orientationItem.click();
    }

    @Step("Clicking 'Units' item from 'Settings'")
    public void clickUnits() {
        units.click();
    }

    public boolean isUnitsItemChecked() {
        return units.getAttribute("checked").equals("true");
    }

    @Step("Clicking 'Comment' item from 'Settings'")
    public void clickComment() {
        comment.click();
    }

    public boolean isCommentItemChecked() {
        return units.getAttribute("checked").equals("true");
    }

    @Step("Clicking 'Price' item from 'Settings'")
    public void clickPrice() {
        price.click();
    }

    public boolean isPriceItemChecked() {
        return units.getAttribute("checked").equals("true");
    }
}
