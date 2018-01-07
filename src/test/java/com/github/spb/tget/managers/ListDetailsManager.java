package com.github.spb.tget.managers;

import com.github.spb.tget.data.ListItemInfo;
import com.github.spb.tget.pages.ListDetailsPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class ListDetailsManager {
    private ListDetailsPage page;

    public ListDetailsManager(AndroidDriver driver) {
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
        Assert.assertTrue(page.hasItemWithName(listItemInfo.getName()));
    }

    public void verifyTotalAmount(String expectedAmount) {
        Assert.assertTrue(page.getTotalAmountText().contains(expectedAmount),
                "Incorrect total amount for list details is retrieved");
    }
}