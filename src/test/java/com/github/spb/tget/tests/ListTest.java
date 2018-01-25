package com.github.spb.tget.tests;

import com.github.spb.tget.data.Category;
import com.github.spb.tget.data.ListItemInfo;
import com.github.spb.tget.managers.ListDetailsManager;
import com.github.spb.tget.managers.ListManager;
import com.github.spb.tget.managers.MenuManager;
import com.github.spb.tget.utils.RandomUtils;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Collections;

@Listeners(TestListener.class)
@Feature("Main Buy List page")
@Story("Can create list items from Main Buy List page")
public class ListTest extends BaseTest {

    private ListManager listManager;
    private ListDetailsManager listDetailsManager;
    private MenuManager menuManager;

    @BeforeMethod
    public void listTestInitialize() {
        listManager = new ListManager(driver);
        listDetailsManager = new ListDetailsManager(driver);
        menuManager = new MenuManager(driver);
    }

    @Test(description = "After new list creation, should be redirected to list details page")
    public void addingNewListShouldOpenListDetailsPage() {
        String listTitle = RandomUtils.getRandomAlphanumeric(20);
        listManager.createBuyList(listTitle);
        listDetailsManager.verifyListDetailsPageOpened(listTitle);
    }

    @Test(description = "New item's details should be saved correctly in the buy list")
    public void addingItemToNewBuyListShouldSaveItem() {
        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(20));
        ListItemInfo expectedListItem = ListItemInfo.randomListItemInfo();

        listDetailsManager.addNewItemToTheList(expectedListItem);

        listDetailsManager.verifyItemIsDisplayedInTheListWithAllDetails(expectedListItem);
    }

    @Test(description = "New item's details should be saved correctly in the buy list - with category")
    public void canSelectCategoryForNewlyCreatedItemAndSaveIt() {
        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(20));
        ListItemInfo expectedListItem = ListItemInfo.randomListItemInfo();

        listDetailsManager.createItemWithCategory(expectedListItem);

        listDetailsManager.verifyItemIsDisplayedInTheList(expectedListItem.getName());
    }

    @Test(description = "Can save new item in My List")
    public void addingItemToMyListShouldSaveItem() {
        menuManager.openMyListPageFromBuyListPageMenu();
        ListItemInfo listItemInfo = ListItemInfo.randomListItemInfo();

        listDetailsManager.addNewItemToTheList(listItemInfo);

        listDetailsManager.verifyItemIsDisplayedInTheListWithAllDetails(listItemInfo);
    }

    @Test(description = "Can add pre-saved item derived from 'My List' to new Buy List")
    public void canAddItemFromMyListToNewBuyList() {
        menuManager.openMyListPageFromBuyListPageMenu();
        ListItemInfo listItemInfo = ListItemInfo.randomListItemInfo();
        listDetailsManager.addNewItemToTheList(listItemInfo);
        listDetailsManager.verifyItemIsDisplayedInTheListWithAllDetails(listItemInfo);
        listManager.backFromMyListToBuyListDetails();

        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(25));
        menuManager.openAddFromMyListPageFromBuyListPageMenu();
        listManager.selectMyListItems(Collections.singletonList(listItemInfo.getName()));

        listDetailsManager.verifyItemIsDisplayedInTheListWithAllDetails(listItemInfo);
    }
}
