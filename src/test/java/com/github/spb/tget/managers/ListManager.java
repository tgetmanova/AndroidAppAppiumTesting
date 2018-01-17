package com.github.spb.tget.managers;

import com.github.spb.tget.pages.AddFromMyListPage;
import com.github.spb.tget.pages.BuyListPage;
import com.github.spb.tget.pages.keyevents.KeyEvent;
import com.github.spb.tget.utils.AppiumDriverFactory;

import io.appium.java_client.AppiumDriver;

import java.util.List;

public class ListManager {

    private BuyListPage buyListPage;
    private KeyEvent keyEvent;
    private AddFromMyListPage addFromMyListPage;

    public ListManager(AppiumDriver driver) {
        buyListPage = new BuyListPage(driver);
        keyEvent = AppiumDriverFactory.getKeyEventByDriverType(driver);
        addFromMyListPage = new AddFromMyListPage(driver);
    }

    public void createBuyList(String name) {
        buyListPage.enterTextToNewListTitleField(name)
                .pressAddNewListButton();
    }

    public void backFromMyListToBuyListDetails() {
        keyEvent.pressBackSeveralTimes(2);
    }

    public void selectMyListItems(List<String> itemsName) {
        itemsName.forEach(addFromMyListPage::clickMyListItemByName);
        addFromMyListPage.clickOkButton();
    }
}
