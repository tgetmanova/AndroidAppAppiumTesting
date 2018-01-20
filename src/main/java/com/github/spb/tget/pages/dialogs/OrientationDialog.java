package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

public class OrientationDialog extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'Horizontal']")
    private MobileElement horizontalRadio;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'Vertical']")
    private MobileElement verticalRadio;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'Auto']")
    private MobileElement autoRadio;

    public OrientationDialog(AppiumDriver driver) {
        super(driver);
    }

    @Step("Checking 'Horizontal' orientation radio button")
    public void checkHorizontalRadioButton() {
        horizontalRadio.click();
    }

    @Step("Checking 'Vertical' orientation radio button")
    public void checkVerticalRadioButton() {
        verticalRadio.click();
    }

    @Step("Checking 'Auto' orientation radio button")
    public void checkAutoRadioButton() {
        autoRadio.click();
    }
}
