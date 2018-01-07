package com.github.spb.tget.managers;

import com.github.spb.tget.pages.BuyListPage;

import io.appium.java_client.android.AndroidDriver;

public class ListManager {

    private BuyListPage page;

    public ListManager(AndroidDriver driver) {
        page = new BuyListPage(driver);
    }

    public void enterNewListName(String name) {
        page.enterText(name);
    }
}
