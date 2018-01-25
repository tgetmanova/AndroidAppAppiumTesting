package com.github.spb.tget.managers;

import com.github.spb.tget.data.ListItemDisplaySettings;
import com.github.spb.tget.data.ListItemInfo;
import com.github.spb.tget.pages.ListDetailsPage;
import com.github.spb.tget.pages.dialogs.SelectCategoryPopup;
import com.github.spb.tget.utils.RandomUtils;

import io.appium.java_client.AppiumDriver;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import org.testng.Assert;

public class ListDetailsManager {

    private static final String DEFAULT_AMOUNT_UNITS = "pcs.";
    private static final String DEFAULT_CURRENCY_SYMBOL = "£";

    private ListDetailsPage listDetailsPage;
    private SelectCategoryPopup selectCategoryPopup;

    public ListDetailsManager(AppiumDriver driver) {
        listDetailsPage = new ListDetailsPage(driver);
        selectCategoryPopup = new SelectCategoryPopup(driver);
    }

    public void verifyListDetailsPageOpened(String listTitle) {
        Assert.assertTrue(listDetailsPage.isAt(listTitle), "List Details page is supposed to be opened, " +
                "but it is not");
    }

    public void addNewItemToTheList(ListItemInfo listItemInfo) {
        listDetailsPage.enterNewItemName(listItemInfo.getName())
                .enterNewItemPrice(String.valueOf(listItemInfo.getPrice()))
                .enterNewItemAmount(String.valueOf(listItemInfo.getAmount()))
                .enterNewItemComment(listItemInfo.getComment())
                .clickAddItemButton();
    }

    public void verifyItemIsDisplayedInTheList(String itemName) {
        Assert.assertTrue(listDetailsPage.hasItemWithName(itemName),
                "After adding new item to the list, cannot find buy list item with name: " + itemName);
    }

    public void verifyItemIsDisplayedInTheListWithAllDetails(ListItemInfo listItemInfo) {
        SoftAssertions assertion = new SoftAssertions();
        assertion.assertThat(listDetailsPage.hasItemWithName(listItemInfo.getName()))
                .as("After adding new item to the list, cannot find buy list item with name: "
                        + listItemInfo.getName())
                .isTrue();
        assertion.assertThat(listDetailsPage.hasItemWithComment(listItemInfo.getComment()))
                .as("After adding new item to the list, cannot find buy list item with comment: "
                        + listItemInfo.getComment())
                .isTrue();
        assertion.assertThat(listDetailsPage.hasItemWithAmount(
                String.valueOf(listItemInfo.getAmount()), DEFAULT_AMOUNT_UNITS))
                .as("After adding new item to the list, cannot find buy list item with amount: "
                        + listItemInfo.getAmount())
                .isTrue();
        assertion.assertThat(listDetailsPage.hasItemWithPrice(
                String.valueOf(listItemInfo.getPrice()), DEFAULT_CURRENCY_SYMBOL))
                .as("After adding new item to the list, cannot find buy list item with price: "
                        + listItemInfo.getPrice())
                .isTrue();

        assertion.assertAll();
    }

    public void verifyCurrencyForItemsIsAsExpected(String expectedCurrencySymbol) {
        listDetailsPage.enterNewItemName(RandomUtils.getRandomAlphanumeric(15));
        listDetailsPage.isExpectedCurrencySymbolDisplayed(expectedCurrencySymbol);
    }

    public void verifyDisplaySettingsAreAppliedCorrectlyForNewItem(ListItemInfo listItemInfo, ListItemDisplaySettings expectedDisplaySettings) {
        SoftAssertions assertion = new SoftAssertions();
        assertion.assertThat(listDetailsPage.hasItemWithAmount(
                String.valueOf(listItemInfo.getAmount()), DEFAULT_AMOUNT_UNITS))
                .as("Display setting is incorrect for Units. Expected to display Units: " +
                        expectedDisplaySettings.getDisplayUnits())
                .isEqualTo(expectedDisplaySettings.getDisplayUnits());
        assertion.assertThat(listDetailsPage.hasItemWithPrice(
                String.valueOf(listItemInfo.getPrice()), DEFAULT_CURRENCY_SYMBOL))
                .as("Display setting is incorrect for Price. Expected to display Price: " +
                        expectedDisplaySettings.getDisplayPrice())
                .isEqualTo(expectedDisplaySettings.getDisplayPrice());
        assertion.assertThat(listDetailsPage.hasItemWithComment(listItemInfo.getComment()))
                .as("Display setting is incorrect for Comment. Expected to display Comment: " +
                        expectedDisplaySettings.getDisplayComment())
                .isEqualTo(expectedDisplaySettings.getDisplayComment());
        assertion.assertAll();
    }

    public void addSeveralItemsWithNumericPrefixesToTheList(int itemsCount) {
        for (int i = 0; i < itemsCount; i++) {
            addNewItemToTheList(ListItemInfo.randomWithListItemNamePrefix(String.valueOf(i)));
        }
    }

    public String getListItemNameAtTheTopPosition() {
        return listDetailsPage.getItemNameTextByInstanceNumber(0);
    }

    private String getListItemNameAtTheVeryLastPosition(int totalItemsCount) {
        return listDetailsPage.getItemNameTextByInstanceNumber(totalItemsCount - 1);
    }

    public int getNumberOfListItems() {
        return listDetailsPage.getItemNamesTextLabels().size();
    }

    public void markItemAsBoughtAtPosition(int position) {
        listDetailsPage.clickBasketImageIconByInstanceNumber(position);
    }

    public void verifyItemWithNameAtTheBottomOfList(String expectedItemName) {
        String actualItemNameAtTheBottom = getListItemNameAtTheVeryLastPosition(getNumberOfListItems());
        Assertions.assertThat(actualItemNameAtTheBottom)
                .as(String.format("Expected to see item with name %s at the bottom of the list, " +
                        "but there was another: %s", expectedItemName, actualItemNameAtTheBottom))
                .isEqualTo(expectedItemName);
    }

    public void verifyItemWithNameAtTheTopOfList(String expectedItemName) {
        String actualItemNameAtTheTop = getListItemNameAtTheTopPosition();
        Assertions.assertThat(actualItemNameAtTheTop)
                .as(String.format("Expected to see item with name %s at the top of the list, " +
                        "but there was another item: %s", expectedItemName, actualItemNameAtTheTop))
                .isEqualTo(expectedItemName);
    }

    public void createItemWithCategory(ListItemInfo listItemInfo) {
        listDetailsPage.enterNewItemName(listItemInfo.getName())
                .clickCategoryDropDown();
        selectCategoryPopup.clickCategoryItemByNameText(listItemInfo.getCategory().getName());
        listDetailsPage.clickAddItemButton();
    }
}