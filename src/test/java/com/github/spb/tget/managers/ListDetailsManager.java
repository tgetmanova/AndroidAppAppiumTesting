package com.github.spb.tget.managers;

import com.github.spb.tget.data.ListItemInfo;
import com.github.spb.tget.pages.ListDetailsPage;

import io.appium.java_client.AppiumDriver;

import org.testng.Assert;

public class ListDetailsManager {
    private ListDetailsPage page;
    private String currentCurrency;
    private String currentAmountUnits;

    public ListDetailsManager(AppiumDriver driver) {
        page = new ListDetailsPage(driver);
    }

    public void verifyListDetailsPageOpened(String listTitle) {
        Assert.assertTrue(page.isAt(listTitle), "List Details page is supposed to be opened, " +
                "but it is not");
    }

    public void addNewItemToTheList(ListItemInfo listItemInfo) {
        page.enterNewItemName(listItemInfo.getName())
                .enterNewItemPrice(String.valueOf(listItemInfo.getPrice()))
                .enterNewItemAmount(String.valueOf(listItemInfo.getAmount()))
                .enterNewItemComment(listItemInfo.getComment())
                .clickAddItemButton();
    }

    public void verifyItemExistsInTheList(ListItemInfo listItemInfo) {
        Assert.assertTrue(page.hasItemWithName(listItemInfo.getName()),
                "After adding new item to the list, cannot find buy list item with name: "
                        + listItemInfo.getName());
        Assert.assertTrue(page.hasItemWithComment(listItemInfo.getComment()),
                "After adding new item to the list, cannot find buy list item with comment: "
                        + listItemInfo.getComment());
        Assert.assertTrue(page.hasItemWithAmount(String.valueOf(listItemInfo.getAmount()), "pcs."),
                "After adding new item to the list, cannot find buy list item with amount: "
                        + listItemInfo.getAmount());
        Assert.assertTrue(page.hasItemWithPrice(String.valueOf(listItemInfo.getPrice()), "£"),
                "After adding new item to the list, cannot find buy list item with price: "
                        + listItemInfo.getPrice());
    }

    public void verifyTotalAmount(String expectedAmount) {
        Assert.assertTrue(page.getTotalAmountText().contains(expectedAmount),
                "Incorrect total amount for list details is retrieved");
    }
}