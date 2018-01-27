package com.github.spb.tget.tests;

import com.github.spb.tget.data.Currency;
import com.github.spb.tget.data.ListItemDisplaySettings;
import com.github.spb.tget.data.ListItemInfo;
import com.github.spb.tget.managers.SettingsManager;
import com.github.spb.tget.managers.ListDetailsManager;
import com.github.spb.tget.managers.ListManager;
import com.github.spb.tget.managers.MenuManager;
import com.github.spb.tget.managers.DeviceManager;
import com.github.spb.tget.utils.RandomUtils;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.openqa.selenium.ScreenOrientation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Feature("Settings menu of Buy List")
@Story("Can manage general application settings for Buy List application")
public class ApplicationSettingsTest extends BaseTest {

    private MenuManager menuManager;
    private SettingsManager settingsManager;
    private ListManager listManager;
    private ListDetailsManager listDetailsManager;
    private DeviceManager deviceManager;

    @BeforeMethod
    public void settingsTestInitialize() {
        menuManager = new MenuManager(driver);
        settingsManager = new SettingsManager(driver);
        listManager = new ListManager(driver);
        listDetailsManager = new ListDetailsManager(driver);
        deviceManager = new DeviceManager(driver);
    }

    @Test(description = "After currency is changed, Buy List items should be displayed with updated currency symbol")
    public void currencyCanBeChangedAndAppliedToBuyListItems() {
        menuManager.openSettingsFromMenu();
        Currency targetCurrency = Currency.getRandomCurrencyExcept(settingsManager.getCurrentCurrency());

        menuManager.openSettingsFromMenu();
        settingsManager.setCurrency(targetCurrency);

        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(15));
        listDetailsManager.verifyCurrencyForItemsIsAsExpected(targetCurrency.getCurrencySymbol());
    }

    @Test(description = "When setting some custom currency, " +
            "Buy List items should be displayed with updated currency symbol")
    public void customCurrencyCanBeAppliedToBuyListItems() {
        menuManager.openSettingsFromMenu();
        String customCurrencySymbol = RandomUtils.getRandomAlphanumeric(5);
        settingsManager.setCustomCurrency(customCurrencySymbol);

        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(15));
        listDetailsManager.verifyCurrencyForItemsIsAsExpected(customCurrencySymbol);
    }

    @Test(description = "Can customize list item details view (hide/display)")
    public void changesInListItemDisplaySettingsShouldBeAppliedToListItems() {
        ListItemDisplaySettings expectedDisplaySettings = ListItemDisplaySettings.randomListDisplaySettings();
        menuManager.openSettingsFromMenu();
        settingsManager.changeListItemDisplaySettings(expectedDisplaySettings);
        settingsManager.backFromSettingsToBuyList();

        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(20));
        ListItemInfo listItem = ListItemInfo.randomListItemInfo();
        listDetailsManager.addNewItemToTheList(listItem);
        listDetailsManager.verifyItemIsDisplayedInTheList(listItem.getName());

        listDetailsManager.verifyDisplaySettingsAreAppliedCorrectlyForNewItem(listItem, expectedDisplaySettings);
    }

    @Test(description = "Can change application orientation via Settings")
    public void canChangeApplicationOrientationInSettings() {
        menuManager.openSettingsFromMenu();
        ScreenOrientation initialOrientation = deviceManager.getScreenOrientation();
        settingsManager.changeOrientation();
        settingsManager.verifyApplicationScreenOrientationHasChanged(initialOrientation);
    }
}
