package com.github.spb.tget.managers;

import com.github.spb.tget.data.Currency;
import com.github.spb.tget.data.ListItemDisplaySettings;
import com.github.spb.tget.pages.SettingsPage;
import com.github.spb.tget.pages.dialogs.CurrencyDialog;
import com.github.spb.tget.pages.dialogs.OrientationDialog;
import com.github.spb.tget.pages.keyevents.KeyEvent;
import com.github.spb.tget.utils.AppiumDriverFactory;

import io.appium.java_client.AppiumDriver;

import org.assertj.core.api.Assertions;

import org.openqa.selenium.ScreenOrientation;

public class SettingsManager {

    private SettingsPage settingsPage;
    private CurrencyDialog currencyDialog;
    private KeyEvent keyEvent;
    private OrientationDialog orientationDialog;

    public SettingsManager(AppiumDriver driver) {
        settingsPage = new SettingsPage(driver);
        currencyDialog = new CurrencyDialog(driver);
        keyEvent = AppiumDriverFactory.getKeyEventByDriverType(driver);
        orientationDialog = new OrientationDialog(driver);
    }

    public Currency getCurrentCurrency() {
        settingsPage.openCurrencyPopup();
        Currency currency = Currency.getCurrencyBySymbol(currencyDialog.getCheckedCurrencyItem());
        keyEvent.pressBackSeveralTimes(2);
        return currency;
    }

    public void setCurrency(Currency currency) {
        settingsPage.openCurrencyPopup();
        currencyDialog.selectCurrency(currency.getCurrencySymbol());
        keyEvent.pressBack();
    }

    public void changeListItemDisplaySettings(ListItemDisplaySettings listItemDisplaySettings) {
        if (listItemDisplaySettings.getDisplayUnits() != settingsPage.isUnitsItemChecked()) {
            settingsPage.clickUnitsCheckbox();
        }
        if (listItemDisplaySettings.getDisplayPrice() != settingsPage.isPriceItemChecked()) {
            settingsPage.clickPriceCheckbox();
        }
        if (listItemDisplaySettings.getDisplayComment() != settingsPage.isCommentItemChecked()) {
            settingsPage.clickCommentCheckbox();
        }
    }

    public void backFromSettingsToBuyList() {
        keyEvent.pressBack();
    }

    public void changeOrientation() {
        settingsPage.openOrientationPopup();
        ScreenOrientation orientation = keyEvent.getDeviceScreenOrientation();
        switch (orientation) {
            case LANDSCAPE:
                orientationDialog.checkVerticalRadioButton();
                keyEvent.pressBack();
                break;
            case PORTRAIT:
                orientationDialog.checkHorizontalRadioButton();
                keyEvent.pressBack();
                break;
            default:
                throw new IllegalStateException("Inconsistent device orientation state: " + orientation.value());
        }
    }

    public void verifyApplicationScreenOrientationHasChanged(ScreenOrientation initialOrientation) {
        ScreenOrientation currentScreenOrientation = keyEvent.getDeviceScreenOrientation();
        Assertions.assertThat(currentScreenOrientation)
                .as(String.format("Expected to change orientation from initial %s, but still having %s",
                        initialOrientation, currentScreenOrientation))
                .isNotEqualTo(initialOrientation);
    }

    public void setMoveBoughtItemsToTheBottom() {
        if (!settingsPage.isMoveBoughtItemsToTheBottomOptionSelected()) {
            settingsPage.checkMoveBoughtItemsToTheBottom();
        }
        keyEvent.pressBack();
    }

    public void resetMoveBoughtItemsToTheBottom() {
        if (settingsPage.isMoveBoughtItemsToTheBottomOptionSelected()) {
            settingsPage.checkMoveBoughtItemsToTheBottom();
        }
        keyEvent.pressBack();
    }
}
