package com.github.spb.tget.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BuyListPage extends Page {

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='New list...']")
    private MobileElement addNewListTextField;

    public BuyListPage(AndroidDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        addNewListTextField.setValue(text);
    }
}
