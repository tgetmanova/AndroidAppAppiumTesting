package com.github.spb.tget.managers;

import com.github.spb.tget.pages.EditCategoriesPage;
import com.github.spb.tget.pages.SettingsPage;
import com.github.spb.tget.pages.dialogs.EnterNamePopup;
import com.github.spb.tget.pages.keyevents.KeyEvent;
import com.github.spb.tget.utils.AppiumDriverFactory;

import io.appium.java_client.AppiumDriver;

public class CategoriesManager {

    private EnterNamePopup enterNamePopup;
    private EditCategoriesPage editCategoriesPage;
    private KeyEvent keyEvent;
    private SettingsPage settingsPage;

    public CategoriesManager(AppiumDriver driver) {
        editCategoriesPage = new EditCategoriesPage(driver);
        enterNamePopup = new EnterNamePopup(driver);
        settingsPage = new SettingsPage(driver);
        keyEvent = AppiumDriverFactory.getKeyEventByDriverType(driver);
    }

    public void addNewItemCategory(String categoryName) {
        editCategoriesPage.clickAddNewButton();
        enterNamePopup.enterNameIntoTextField(categoryName)
                .clickOkButton();
    }

    public void backFromEditCategoriesPageToBuyListPage() {
        keyEvent.pressBackSeveralTimes(2);
    }

    public void openEditCategoriesPageFromSettings() {
        settingsPage.openEditCategoriesPopup();
    }

    public int getVisibleCategoriesListToReOrder() {
        return editCategoriesPage.getVisibleCategories().size();

    }

    public String getCategoryNameAtPosition(int position) {
        return editCategoriesPage.getCategoryNameTextAtPosition(position);
    }

    public void shiftCategories(int from, int after) {
        editCategoriesPage.dragAndDropElement(from, after);
    }
}
