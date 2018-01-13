package com.github.spb.tget.tests;

import com.github.spb.tget.data.ListItemInfo;
import com.github.spb.tget.managers.CurrencyManager;
import com.github.spb.tget.managers.ListDetailsManager;
import com.github.spb.tget.managers.ListManager;
import com.github.spb.tget.managers.MenuManager;
import com.github.spb.tget.utils.RandomUtils;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Main Buy List page")
@Story("Creating list items from Main Buy List page")
public class ListTest extends BaseTest {

    private ListManager listManager;
    private ListDetailsManager listDetailsManager;
    private CurrencyManager currencyManager;
    private MenuManager menuManager;

    @BeforeMethod
    public void listTestsInitialize() {
        listManager = new ListManager(getDriver());
        listDetailsManager = new ListDetailsManager(getDriver());
        currencyManager = new CurrencyManager(getDriver());
        menuManager = new MenuManager(getDriver());
    }

    @Test(description = "After new list creation, should be redirected to list details page")
    public void addingNewListShouldOpenListDetailsPage() {
        String listTitle = RandomUtils.getRandomAlphanumeric(20);
        listManager.createNewList(listTitle);
        listDetailsManager.verifyListDetailsPageOpened(listTitle);
    }

    @Test(description = "New item's details should be saved correctly in the list")
    public void canAddItemToTheListWithCorrectProperties() {
        listManager.createNewList(RandomUtils.getRandomAlphanumeric(20));

        ListItemInfo expectedListItem = RandomUtils.getRandomListItemInfo();
        listDetailsManager.addNewItemToTheList(expectedListItem);
        listDetailsManager.verifyItemExistsInTheList(expectedListItem);
    }

    @Test
    public void canAddItemToTheListFromMyList() {
    }
}
