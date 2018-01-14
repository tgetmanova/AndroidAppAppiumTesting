package com.github.spb.tget.managers;

import com.github.spb.tget.data.Currency;
import com.github.spb.tget.data.ListItemInfo;
import com.github.spb.tget.pages.ListDetailsPage;
import com.github.spb.tget.utils.RandomUtils;

import io.appium.java_client.AppiumDriver;

import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;

public class ListDetailsManager {
    private ListDetailsPage listDetailsPage;

    public ListDetailsManager(AppiumDriver driver) {
        listDetailsPage = new ListDetailsPage(driver);
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

    public void verifyItemExistsInTheList(ListItemInfo listItemInfo) {
        SoftAssertions assertion = new SoftAssertions();
        assertion.assertThat(listDetailsPage.hasItemWithName(listItemInfo.getName()))
                .as("After adding new item to the list, cannot find buy list item with name: "
                        + listItemInfo.getName())
                .isTrue();
        assertion.assertThat(listDetailsPage.hasItemWithComment(listItemInfo.getComment()))
                .as("After adding new item to the list, cannot find buy list item with comment: "
                        + listItemInfo.getComment())
                .isTrue();
        assertion.assertThat(listDetailsPage.hasItemWithAmount(String.valueOf(listItemInfo.getAmount()), "pcs."))
                .as("After adding new item to the list, cannot find buy list item with amount: "
                        + listItemInfo.getAmount())
                .isTrue();
        assertion.assertThat(listDetailsPage.hasItemWithPrice(String.valueOf(listItemInfo.getPrice()), "£"))
                .as("After adding new item to the list, cannot find buy list item with price: "
                        + listItemInfo.getPrice())
                .isTrue();

        assertion.assertAll();
    }

    public void verifyCurrencyForItemsIsAsExpected(Currency expectedCurrency) {
        listDetailsPage.enterNewItemName(RandomUtils.getRandomAlphanumeric(15));
        listDetailsPage.isExpectedCurrencySymbolDisplayed(expectedCurrency.getCurrencySymbol());
    }
}