package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

public class SortListPopup extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'By category']")
    private MobileElement byCategoryRadio;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'By alphabet']")
    private MobileElement byAlphabetRadio;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'In a pre-order']")
    private MobileElement inPreOrderRadio;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'In reverse order']")
    private MobileElement inReverseOrderRadio;

    public SortListPopup(AppiumDriver driver) {
        super(driver);
    }

    public boolean isByAlphabetRadioSelected() {
        return byAlphabetRadio.getAttribute("checked").equals("true");
    }

    @Step("Selecting 'By Alphabet' radio for sorting")
    public void checkByAlphabetRadio() {
        byAlphabetRadio.click();
    }
}
