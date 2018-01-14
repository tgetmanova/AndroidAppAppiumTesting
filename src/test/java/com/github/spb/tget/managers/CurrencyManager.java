package com.github.spb.tget.managers;

import com.github.spb.tget.data.Currency;
import com.github.spb.tget.pages.SettingsPage;
import com.github.spb.tget.pages.dialogs.CurrencyDialog;
import com.github.spb.tget.pages.keyevents.KeyEvent;
import com.github.spb.tget.utils.AppiumDriverFactory;

import io.appium.java_client.AppiumDriver;

public class CurrencyManager {

    private SettingsPage settingsPage;
    private CurrencyDialog currencyDialog;
    private KeyEvent keyEvent;

    public CurrencyManager(AppiumDriver driver) {
        settingsPage = new SettingsPage(driver);
        currencyDialog = new CurrencyDialog(driver);
        keyEvent = AppiumDriverFactory.getKeyEventByDriverType(driver);
    }

    public Currency getCurrentCurrency() {
        settingsPage.openCurrencySettingsPopup();
        Currency currency = Currency.getCurrencyBySymbol(currencyDialog.getCheckedCurrencyItem());
        keyEvent.pressBackSeveralTimes(2);
        return currency;
    }
}
