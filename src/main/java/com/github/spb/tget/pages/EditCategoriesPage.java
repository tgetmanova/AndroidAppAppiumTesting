package com.github.spb.tget.pages;

import com.github.spb.tget.utils.ReportUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

import java.util.List;

public class EditCategoriesPage extends PageElements {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ADD NEW']")
    private MobileElement addNewCategoryButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.slava.buylist:id/title']")
    private List<MobileElement> categoryTextItems;

    private String dragAndDropItemLocatorTemplate = "new UiSelector().className(\"android.widget.ImageView\")" +
            ".resourceId(\"com.slava.buylist:id/dicon\").instance(%d)";

    private String dragAndDropAllItemsLocatorTemplate = "new UiSelector().className(\"android.widget.ImageView\")" +
            ".resourceId(\"com.slava.buylist:id/dicon\")";

    private String categoryItemLocatorTemplate = "new UiSelector().className(\"android.widget.TextView\")" +
            ".resourceId(\"com.slava.buylist:id/title\").instance(%d)";

    public EditCategoriesPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Clicking 'Add new category button'")
    public void clickAddNewButton() {
        addNewCategoryButton.click();
    }

    @Step("Drag and dropping category item from {0} after {1} to change the order")
    public void dragAndDropElement(int fromElementPosition, int afterElementPosition) {
        TouchAction touch = new TouchAction(driverManager.getDriver());
        printVisibleCategoriesNames();

        MobileElement fromElementDD = (MobileElement) driverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(
                String.format(dragAndDropItemLocatorTemplate, fromElementPosition)));

        MobileElement toElementDD = (MobileElement) driverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(
                String.format(dragAndDropItemLocatorTemplate, afterElementPosition)));

        touch.longPress(fromElementDD).moveTo(toElementDD).release().perform();
        printVisibleCategoriesNames();
    }

    @Step("Getting Category name at position")
    public String getCategoryNameTextAtPosition(int position) {
        return driverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(
                String.format(categoryItemLocatorTemplate, position))).getText();
    }

    @Step("Retrieving all visible categories")
    public List<MobileElement> getVisibleCategories() {
        return driverManager.getDriver().findElements(MobileBy.AndroidUIAutomator(
                dragAndDropAllItemsLocatorTemplate));
    }

    private void printVisibleCategoriesNames() {
        StringBuilder stringBuilder = new StringBuilder();
        int visibleItemsCount = getVisibleCategories().size();

        for (int i = 0; i < visibleItemsCount; i++) {
            MobileElement item = (MobileElement) driverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(
                    String.format(categoryItemLocatorTemplate, i)));
            stringBuilder.append(String.format("Category item #%d: %s\n", i, item.getText()));
        }

        ReportUtils.saveText("Categories order at the Edit Categories Page", stringBuilder.toString());
    }
}
