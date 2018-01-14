package com.github.spb.tget.managers;

import com.github.spb.tget.pages.BuyListPage;

import io.appium.java_client.AppiumDriver;

public class ListManager {

    private BuyListPage buyListPage;

    public ListManager(AppiumDriver driver) {
        buyListPage = new BuyListPage(driver);
    }

    public void createNewListFromBuyListPage(String name) {
        buyListPage.enterTextToNewListTitleField(name)
                .pressAddNewListButton();
    }
}
