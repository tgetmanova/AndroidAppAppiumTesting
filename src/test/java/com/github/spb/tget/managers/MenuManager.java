package com.github.spb.tget.managers;

import com.github.spb.tget.pages.BuyListPage;
import com.github.spb.tget.pages.CommonMenu;

import io.appium.java_client.AppiumDriver;

public class MenuManager {

    private BuyListPage buyListPage;
    private CommonMenu menu;

    public MenuManager(AppiumDriver driver) {
        menu = new CommonMenu(driver);
        buyListPage = new BuyListPage(driver);
    }

    public void openSettingsFromBuyListPage() {
        buyListPage.clickMenuButton();
        menu.selectSettingsOption();
    }

    public void openMyListPageFromBuyListPageMenu() {
        buyListPage.clickMenuButton();
        menu.selectMyListOption();
    }

    public void openAddFromMyListPageFromBuyListPageMenu() {
        buyListPage.clickMenuButton();
        menu.selectAddFromMyListOption();
    }
}
