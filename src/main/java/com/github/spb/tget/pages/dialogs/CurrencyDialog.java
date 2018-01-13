package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class CurrencyDialog extends PageElements {

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    List<MobileElement> currencyItems;

    public CurrencyDialog(AppiumDriver driver) {
        super(driver);
    }

    public String getCheckedCurrencyItem() {
        return currencyItems.stream()
                .filter(i -> i.getAttribute("checked").equals("true"))
                .findFirst().get().getText();
    }
}
