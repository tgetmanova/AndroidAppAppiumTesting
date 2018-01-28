package com.github.spb.tget.tests;

import com.github.spb.tget.data.CategoryReOrderInfo;
import com.github.spb.tget.managers.CategoriesManager;
import com.github.spb.tget.managers.ListDetailsManager;
import com.github.spb.tget.managers.ListManager;
import com.github.spb.tget.managers.MenuManager;
import com.github.spb.tget.utils.RandomUtils;

import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Listeners(TestListener.class)
@Feature("Settings menu of Buy List")
@Story("Can manage product categories for Buy List")
public class CategoryTest extends BaseTest {

    private ListManager listManager;
    private ListDetailsManager listDetailsManager;
    private CategoriesManager categoriesManager;
    private MenuManager menuManager;

    @BeforeMethod
    public void categoryTestInitialize() {
        listDetailsManager = new ListDetailsManager(driver);
        listManager = new ListManager(driver);
        categoriesManager = new CategoriesManager(driver);
        menuManager = new MenuManager(driver);
    }

    @Test(description = "Can add new custom categories for Buy List items via Settings " +
            "and assign these new categories to items")
    public void canAddCustomCategoriesForListItems() {
        menuManager.openSettingsFromMenu();
        categoriesManager.openEditCategoriesPageFromSettings();

        List<String> categoriesToAdd = RandomUtils.getListOfRandomAlphanumerics(5);
        categoriesToAdd.forEach(category -> categoriesManager.addNewItemCategory(category));
        categoriesManager.backFromEditCategoriesPageToBuyListPage();

        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(15));
        listDetailsManager.verifyCategoriesAreAvailableForItem(categoriesToAdd);
    }

    @Test(description = "Can add new custom category while already adding new item to the list " +
            "(moving to Settings right from List Details page) and assign these new category to items")
    @Issue("When adding new categories right from List Details page while adding new item to the list, " +
            "newly created category is not yet available for selection")
    public void canAddCustomCategoriesForListItemsInPlace() {
        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(15));
        menuManager.openSettingsFromMenu();
        categoriesManager.openEditCategoriesPageFromSettings();

        String customCategory = RandomUtils.getRandomAlphanumeric(15);
        categoriesManager.addNewItemCategory(customCategory);
        categoriesManager.backFromEditCategoriesPageToBuyListPage();

        listDetailsManager.verifyCategoriesAreAvailableForItem(Collections.singletonList(customCategory));
    }

    @Test(description = "Can change order of categories from 'Settings' by drag and drop")
    public void canChangeCategoriesOrder() {
        menuManager.openSettingsFromMenu();
        categoriesManager.openEditCategoriesPageFromSettings();
        CategoryReOrderInfo reOrderInfo = new CategoryReOrderInfo(
                categoriesManager.getVisibleCategoriesListToReOrder());
        String categoryNameToMove = categoriesManager.getCategoryNameAtPosition(reOrderInfo.getFromPosition());

        categoriesManager.shiftCategories(reOrderInfo.getFromPosition(), reOrderInfo.getAfterPosition());
        categoriesManager.backFromEditCategoriesPageToBuyListPage();

        listManager.createBuyList(RandomUtils.getRandomAlphanumeric(15));
        listDetailsManager.verifyOrderOfCategory(categoryNameToMove, reOrderInfo.getExpectedPositionAfterReordering());
    }
}
