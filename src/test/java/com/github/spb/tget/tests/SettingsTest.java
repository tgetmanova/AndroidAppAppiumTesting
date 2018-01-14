package com.github.spb.tget.tests;

import com.github.spb.tget.data.Currency;
import com.github.spb.tget.managers.CurrencyManager;
import com.github.spb.tget.managers.MenuManager;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.annotations.Test;

@Feature("Settings menu of Buy List")
@Story("Can manage settings for Buy List")
public class SettingsTest extends BaseTest {

    private MenuManager menuManager;
    private CurrencyManager currencyManager;

    public SettingsTest() {
        menuManager = new MenuManager(getDriver());
        currencyManager = new CurrencyManager(getDriver());
    }

    @Test
    public void canChangeCurrencyFromSettings(){
        menuManager.openSettingsFromBuyListPage();
        Currency currentCurrency = currencyManager.getCurrentCurrency();
    }
}
