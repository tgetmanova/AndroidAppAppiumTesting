package com.github.spb.tget.tests;

import com.github.spb.tget.data.Currency;
import com.github.spb.tget.managers.CurrencyManager;
import com.github.spb.tget.managers.ListDetailsManager;
import com.github.spb.tget.managers.ListManager;
import com.github.spb.tget.managers.MenuManager;
import com.github.spb.tget.utils.RandomUtils;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Feature("Settings menu of Buy List")
@Story("Can manage settings for Buy List")
public class SettingsTest extends BaseTest {

    private MenuManager menuManager;
    private CurrencyManager currencyManager;
    private ListManager listManager;
    private ListDetailsManager listDetailsManager;

    @BeforeMethod
    public void settingsTestInitialize() {
        menuManager = new MenuManager(driver);
        currencyManager = new CurrencyManager(driver);
        listManager = new ListManager(driver);
        listDetailsManager = new ListDetailsManager(driver);
    }

    @Test(description = "After currency is changed, Buy List items should be displayed with updated currency symbol")
    public void currencyCanBeChangedAndAppliedToBuyListItems() {
        menuManager.openSettingsFromBuyListPage();
        Currency targetCurrency = Currency.getRandomCurrencyExcept(currencyManager.getCurrentCurrency());

        menuManager.openSettingsFromBuyListPage();
        currencyManager.setCurrency(targetCurrency);

        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(15));
        listDetailsManager.verifyCurrencyForItemsIsAsExpected(targetCurrency);
    }
}
