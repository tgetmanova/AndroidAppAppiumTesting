package com.github.spb.tget.managers;

import com.github.spb.tget.pages.BuyListPage;

import io.appium.java_client.AppiumDriver;

public class ListManager {

    private BuyListPage page;

    public ListManager(AppiumDriver driver) {
        page = new BuyListPage(driver);
    }

    public void createNewList(String name) {
        page.enterTextToNewListTitleField(name)
                .pressAddNewListButton();
    }
}
