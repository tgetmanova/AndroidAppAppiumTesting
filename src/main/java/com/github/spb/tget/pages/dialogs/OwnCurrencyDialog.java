package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OwnCurrencyDialog extends PageElements {

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement ownCurrencyInputTextField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private MobileElement okButton;

    public OwnCurrencyDialog(AppiumDriver driver) {
        super(driver);
    }

    public void enterTextIntoOwnCurrencyInputField(String ownCurrencyText) {
        ownCurrencyInputTextField.setValue(ownCurrencyText);
    }

    public void clickOkButton() {
        okButton.click();
    }
}
