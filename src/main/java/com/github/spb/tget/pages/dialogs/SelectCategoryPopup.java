package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

import java.util.List;

public class SelectCategoryPopup extends PageElements {

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    private List<MobileElement> categoryTextItems;

    public SelectCategoryPopup(AppiumDriver driver) {
        super(driver);
    }

    @Step("Clicking category {0} in selection popup")
    public void clickCategoryItemByNameText(String categoryName) {
        MobileElement targetCategoryItem = tryFindScrollableCategoryItemByNameOrNull(categoryName);
        if (targetCategoryItem == null) {
            throw new IllegalStateException("Cannot find category in selection popup: " + categoryName);
        }
        targetCategoryItem.click();
    }

    @Step("Searching for {0} category in the popup...")
    public boolean isCategoryPresent(String categoryName) {
        MobileElement targetCategoryItem = tryFindScrollableCategoryItemByNameOrNull(categoryName);
        return targetCategoryItem != null;
    }

    private MobileElement tryFindScrollableCategoryItemByNameOrNull(String categoryName) {
        MobileElement targetCategoryItem = categoryTextItems.stream()
                .filter(i -> i.getText().equals(categoryName))
                .findFirst()
                .orElse(null);
        if (targetCategoryItem == null) {
            List<MobileElement> targetCategoryItems = driverManager.getDriver().findElements(MobileBy.AndroidUIAutomator(
                    String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", categoryName)));
            targetCategoryItem = targetCategoryItems.stream().findFirst().orElse(null);
        }
        return targetCategoryItem;
    }
}
