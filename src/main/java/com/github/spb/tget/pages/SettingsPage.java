package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

import org.openqa.selenium.By;

public class SettingsPage extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Sort list']")
    private MobileElement sortListItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Currency']")
    private MobileElement currencyItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Own currency']")
    private MobileElement ownCurrencyItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Orientation']")
    private MobileElement orientationItem;

    private By categoriesItemLocator = MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Categories List\"));");

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(0)")
    private MobileElement displayUnitsCheckbox;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(1)")
    private MobileElement displayCommentsCheckbox;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(2)")
    private MobileElement displayPriceCheckbox;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(" +
            "new UiSelector().className(\"android.widget.CheckBox\").instance(4));")
    private MobileElement moveBoughtItemsToTheBottomCheckbox;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Opening 'Sort List' popup from 'Settings'")
    public void openSortListPopup() {
        sortListItem.click();
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
    @Step("Opening 'Edit Categories' page from 'Settings'")
    public void openEditCategoriesPopup() {
        driverManager.getDriver().findElement(categoriesItemLocator).click();
    }

    @Step("Checking 'Units' item checkbox from 'Settings'")
    public void clickUnitsCheckbox() {
        displayUnitsCheckbox.click();
    }

    public boolean isUnitsItemChecked() {
        return displayUnitsCheckbox.getAttribute("checked").equals("true");
    }

    @Step("Checking 'Comment' item checkbox from 'Settings'")
    public void clickCommentCheckbox() {
        displayCommentsCheckbox.click();
    }

    public boolean isCommentItemChecked() {
        return displayCommentsCheckbox.getAttribute("checked").equals("true");
    }

    @Step("Checking 'Price' item checkbox from 'Settings'")
    public void clickPriceCheckbox() {
        displayPriceCheckbox.click();
    }

    public boolean isPriceItemChecked() {
        return displayPriceCheckbox.getAttribute("checked").equals("true");
    }

    public boolean isMoveBoughtItemsToTheBottomOptionSelected() {
        return moveBoughtItemsToTheBottomCheckbox.getAttribute("checked").equals("true");
    }

    @Step("Selecting 'Move bought to the end of the list' from 'Settings'")
    public void checkMoveBoughtItemsToTheBottom() {
        moveBoughtItemsToTheBottomCheckbox.click();
    }
}
