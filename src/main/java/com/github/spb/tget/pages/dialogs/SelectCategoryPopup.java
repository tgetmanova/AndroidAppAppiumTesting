package com.github.spb.tget.pages.dialogs;

import com.github.spb.tget.pages.PageElements;
import com.github.spb.tget.utils.ReportUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

import java.util.List;

public class SelectCategoryPopup extends PageElements {

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    private List<MobileElement> categoryTextItems;

    private String categoryTextItemTemplate = "new UiSelector().resourceId(\"android:id/text1\").instance(%d)";

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

    @Step("Getting category by position number")
    public String getCategoryNameAtPosition(int position) {
        ReportUtils.saveScreenshotAsPng(driverManager.getDriver());
        return driverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(
                String.format(categoryTextItemTemplate, position))).getText();
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
