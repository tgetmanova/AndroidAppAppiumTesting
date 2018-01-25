package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

public class EnterNamePopup extends PageElements {

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement enterNameTextField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK'")
    private MobileElement okButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NO'")
    private MobileElement noButton;

    public EnterNamePopup(AppiumDriver driver) {
        super(driver);
    }

    @Step("Submitting text into name text field")
    public void enterNameIntoTextField(String text) {
        enterNameTextField.setValue(text);
    }

    @Step("Clicking OK button")
    public void clickOkButton() {
        okButton.click();
    }

    @Step("Clicking OK button")
    public void clickNoButton() {
        noButton.click();
    }
}
