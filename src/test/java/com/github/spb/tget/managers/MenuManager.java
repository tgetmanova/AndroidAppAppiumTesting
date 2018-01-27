package com.github.spb.tget.managers;

import com.github.spb.tget.pages.CommonMenu;

import io.appium.java_client.AppiumDriver;

public class MenuManager {

    private CommonMenu menu;

    public MenuManager(AppiumDriver driver) {
        menu = new CommonMenu(driver);
    }

    public void openSettingsFromMenu() {
        menu.clickMenuButton().selectSettingsOption();
    }

    public void openMyListPageFromBuyListPageMenu() {
        menu.clickMenuButton().selectMyListOption();
    }

    public void openAddFromMyListPageFromBuyListPageMenu() {
        menu.clickMenuButton().selectAddFromMyListOption();
    }
}
