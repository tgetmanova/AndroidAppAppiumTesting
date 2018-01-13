package com.github.spb.tget.managers;

import com.github.spb.tget.pages.SettingsPage;
import com.github.spb.tget.pages.dialogs.CurrencyDialog;

import io.appium.java_client.AppiumDriver;

public class CurrencyManager {

    private SettingsPage settingsPage;
    private CurrencyDialog currencyDialog;

    public CurrencyManager(AppiumDriver driver) {
        settingsPage = new SettingsPage(driver);
        currencyDialog = new CurrencyDialog(driver);
    }

    public String getCurrentCurrency() {
        settingsPage.openCurrencySettingsPopup();
        return currencyDialog.getCheckedCurrencyItem();
    }
}
