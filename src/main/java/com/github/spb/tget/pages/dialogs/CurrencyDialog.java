package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

import java.util.List;

public class CurrencyDialog extends PageElements {

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    List<MobileElement> currencyItems;

    public CurrencyDialog(AppiumDriver driver) {
        super(driver);
    }

    @Step("Checking what currency is currently selected")
    public String getCheckedCurrencyItem() {
        return currencyItems.stream()
                .filter(i -> i.getAttribute("checked").equals("true"))
                .findFirst().get().getText();
    }
}
