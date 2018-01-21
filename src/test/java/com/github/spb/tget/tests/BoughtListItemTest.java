package com.github.spb.tget.tests;

import com.github.spb.tget.managers.ListDetailsManager;
import com.github.spb.tget.managers.ListManager;
import com.github.spb.tget.managers.MenuManager;
import com.github.spb.tget.managers.SettingsManager;
import com.github.spb.tget.utils.RandomUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoughtListItemTest extends BaseTest {

    private MenuManager menuManager;
    private SettingsManager settingsManager;
    private ListManager listManager;
    private ListDetailsManager listDetailsManager;

    @BeforeMethod
    public void boughtListItemTestInitialize() {
        menuManager = new MenuManager(driver);
        settingsManager = new SettingsManager(driver);
        listManager = new ListManager(driver);
        listDetailsManager = new ListDetailsManager(driver);
    }

    @Test(description = "When 'Move bought items to the bottom' option is selected, " +
            "marking item as bought must cause it to fall to the bottom of the list")
    public void boughtItemShouldBeMovedToTheBottomIfCorrespondingOptionIsSet() {
        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(20));
        menuManager.openSettingsFromBuyListPage();
        settingsManager.setMoveBoughtItemsToTheBottom();
        listDetailsManager.addSeveralItemsToTheList(3);
        String itemNameToMarkAsBought = listDetailsManager.getListItemNameAtTheTopPosition();

        listDetailsManager.markItemAsBoughtAtPosition(0);

        listDetailsManager.verifyItemWithNameAtTheBottomOfList(itemNameToMarkAsBought);
    }

    @Test(description = "When 'Move bought items to the bottom' option is not selected, " +
            "marking item as bought must not cause any movements of the item within the list")
    public void boughtItemShouldNotBeMovedToTheBottomIfCorrespondingOptionIsNotSet() {
        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(20));
        menuManager.openSettingsFromBuyListPage();
        settingsManager.resetMoveBoughtItemsToTheBottom();
        listDetailsManager.addSeveralItemsToTheList(3);
        String itemNameToMarkAsBought = listDetailsManager.getListItemNameAtTheTopPosition();

        listDetailsManager.markItemAsBoughtAtPosition(0);

        listDetailsManager.verifyItemWithNameAtTheTopOfList(itemNameToMarkAsBought);
    }

    @Test(description = "When adding new active list item with name that should be after the bought item due to" +
            " alphabetical sorting, the bought item must still be after all active items including new one")
    public void boughtItemShouldBeKeptAtTheBottomWhenThereIsNewItemThatIsAlphabeticallyAfterTheBoughtItem() {

    }
}
