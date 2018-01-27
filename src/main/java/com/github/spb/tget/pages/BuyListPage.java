package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

public class BuyListPage extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='New list...']")
    private MobileElement newListTitleTextField;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    private MobileElement addNewListButton;

    public BuyListPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Submitting new list title to the text field")
    public BuyListPage enterTextToNewListTitleField(String text) {
        newListTitleTextField.setValue(text);
        return this;
    }

    @Step("Clicking add new list button")
    public void pressAddNewListButton() {
        addNewListButton.click();
    }
}
