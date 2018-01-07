package com.github.spb.tget.managers;

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

    public void verifyTotalAmount(String expectedAmount) {
        Assert.assertTrue(page.getTotalAmountText().contains(expectedAmount),
                "Incorrect total amount for list details is retrieved");
    }
}