package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

import java.util.List;

public class EditCategoriesPage extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ADD NEW'")
    private MobileElement addNewCategoryButton;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> categoryTextItems;

    public EditCategoriesPage(AppiumDriver<org.openqa.selenium.WebElement> driver) {
        super(driver);
    }

    @Step("Searching category {0} in the list by its name")
    public void tryFindCategoryByName(String categoryName) throws RuntimeException {
        boolean doesCategoryExist = categoryTextItems.stream()
                .anyMatch(i -> i.getText().equals(categoryName));
        if (doesCategoryExist) {
            return;
        }
        ((List<MobileElement>) driverManager.getDriver().findElements(MobileBy.AndroidUIAutomator(
                String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", categoryName))))
                .stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Cannot find category in the list: " + categoryName));
    }
}
