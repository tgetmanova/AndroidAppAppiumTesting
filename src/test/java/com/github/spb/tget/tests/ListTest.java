package com.github.spb.tget.tests;

import com.github.spb.tget.managers.ListManager;

import org.testng.annotations.Test;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;

public class ListTest extends BaseTest {

    private ListManager listManager;

    public ListTest() {
        this.listManager = new ListManager(getDriver());
    }

    @Test
    public void draftTest() {
        listManager.enterNewListName(randomAlphanumeric(15));
    }
}
