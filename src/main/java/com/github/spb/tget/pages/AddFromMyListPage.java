package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;

public class AddFromMyListPage extends PageElements {

    @AndroidFindBy(id = "button2")
    private MobileElement okButton;

    private String myListItemsAvailableForSelectionXPathTemplate = "//android.widget.TextView[@text = '%s']";

    public AddFromMyListPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyListItemByName(String itemName) {
        driverManager.waitForElementPresenceAndClick(
                By.xpath(String.format(myListItemsAvailableForSelectionXPathTemplate, itemName)));
    }

    public void clickOkButton() {
        okButton.click();
    }
}
