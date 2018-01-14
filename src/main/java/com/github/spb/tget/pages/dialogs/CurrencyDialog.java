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

    @Step("Selecting {0} currency in the popup")
    public void selectCurrency(String currencySymbol) {
        MobileElement targetCurrencyItem = currencyItems.stream()
                .filter(i -> i.getText().equals(currencySymbol))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find given currency: " + currencySymbol));
        if (targetCurrencyItem.getAttribute("checked").equals("true")) {
            throw new IllegalStateException(
                    String.format("Currency %s is already selected to be default", currencySymbol));
        }
        targetCurrencyItem.click();
    }
}
