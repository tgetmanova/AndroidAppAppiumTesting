package com.github.spb.tget.tests;

import com.github.spb.tget.managers.ListDetailsManager;
import com.github.spb.tget.managers.ListManager;

import org.testng.annotations.Test;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;

public class ListTest extends BaseTest {

    private ListManager listManager;
    private ListDetailsManager listDetailsManager;

    public ListTest() {
        listManager = new ListManager(getDriver());
        listDetailsManager = new ListDetailsManager(getDriver());
    }

    @Test
    public void addingNewListShouldOpenListDetailsPage() {
        String listTitle = randomAlphanumeric(15);
        listManager.createNewList(listTitle);
        listDetailsManager.verifyListDetailsPageOpened(listTitle);
        listDetailsManager.verifyTotalAmount("Total: 0");
    }
}
