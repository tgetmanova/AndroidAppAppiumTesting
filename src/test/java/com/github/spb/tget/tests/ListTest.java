package com.github.spb.tget.tests;

import com.github.spb.tget.data.ListItemInfo;
import com.github.spb.tget.managers.ListDetailsManager;
import com.github.spb.tget.managers.ListManager;

import com.github.spb.tget.utils.RandomUtils;
import org.testng.annotations.Test;

public class ListTest extends BaseTest {

    private ListManager listManager;
    private ListDetailsManager listDetailsManager;

    public ListTest() {
        listManager = new ListManager(getDriver());
        listDetailsManager = new ListDetailsManager(getDriver());
    }

    @Test
    public void addingNewListShouldOpenListDetailsPage() {
        String listTitle = RandomUtils.getRandomAlphanumeric(20);
        listManager.createNewList(listTitle);
        listDetailsManager.verifyListDetailsPageOpened(listTitle);
    }

    @Test
    public void canAddItemToTheListWithCorrectProperties() {
        listManager.createNewList(RandomUtils.getRandomAlphanumeric(20));

        ListItemInfo expectedListItem = RandomUtils.getRandomListItemInfo();
        listDetailsManager.addNewItemToTheList(expectedListItem);
        listDetailsManager.verifyItemExistsInTheList(expectedListItem);
    }
}
