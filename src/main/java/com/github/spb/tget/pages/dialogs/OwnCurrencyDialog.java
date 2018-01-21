package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

public class OwnCurrencyDialog extends PageElements {

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement ownCurrencyInputTextField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private MobileElement okButton;

    public OwnCurrencyDialog(AppiumDriver driver) {
        super(driver);
    }

    @Step("Submitting text to 'Own currency' text field")
    public void enterTextIntoOwnCurrencyInputField(String ownCurrencyText) {
        ownCurrencyInputTextField.setValue(ownCurrencyText);
    }

    @Step("Clicking 'OK' button to submit custom currency")
    public void clickOkButton() {
        okButton.click();
    }
}
