package com.github.spb.tget.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.qameta.allure.Step;

import java.util.List;

public class ListDetailsPage extends PageElements {

    private String listDetailsHeaderXPathTemplate = "//android.widget.TextView[@text='%s']";

    @AndroidFindBy(id = "com.slava.buylist:id/editText1")
    private MobileElement newItemNameTextField;

    @AndroidFindBy(id = "com.slava.buylist:id/editText2")
    private MobileElement newItemPriceTextField;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.slava.buylist:id/value')]")
    private MobileElement newItemPriceUnitLabel;

    @AndroidFindBy(id = "com.slava.buylist:id/editText3")
    private MobileElement newItemCountTextField;

    @AndroidFindBy(id = "com.slava.buylist:id/editText4")
    private MobileElement newItemCommentTextField;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    private MobileElement addItemButton;

    private String newItemCurrencySymbolXPathTemplate
            = "//android.widget.TextView[@resource-id='com.slava.buylist:id/value' and @text='%s']";

    private String itemNameLabelXPathTemplate = "//android.widget.TextView[@text='%s']";
    private String itemPriceLabelXPathTemplate = "//android.widget.TextView[@text = '%s %s']";
    private String itemAmountLabelXPathTemplate = "//android.widget.TextView[@text = '%s %s']";
    private String itemCommentLabelXPathTemplate = "//android.widget.TextView[@text='%s']";

    public ListDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isAt(String listTitle) {
        List elements = driverManager.getDriver().findElementsByXPath(
                String.format(listDetailsHeaderXPathTemplate, listTitle));
        return elements.size() == 1;
    }

    @Step("Checking whether buy list contains item with name = {0}")
    public boolean hasItemWithName(String name) {
        List elements = driverManager.getDriver().findElementsByXPath(
                String.format(itemNameLabelXPathTemplate, name));
        return elements.size() == 1;
    }

    @Step("Checking whether buy list contains item with comment = {0}")
    public boolean hasItemWithComment(String comment) {
        List elements = driverManager.getDriver().findElementsByXPath(
                String.format(itemCommentLabelXPathTemplate, comment));
        return elements.size() == 1;
    }

    @Step("Checking whether buy list contains item with amount = {0} in given units {1}")
    public boolean hasItemWithAmount(String amount, String units) {
        List elements = driverManager.getDriver().findElementsByXPath(
                String.format(itemAmountLabelXPathTemplate, amount, units));
        return elements.size() == 1;
    }

    @Step("Checking whether buy list contains item with price = {0} in {1} currency")
    public boolean hasItemWithPrice(String price, String units) {
        List elements = driverManager.getDriver().findElementsByXPath(
                String.format(itemPriceLabelXPathTemplate, price, units));
        return elements.size() == 1;
    }

    @Step("Submitting item name to text field")
    public ListDetailsPage enterNewItemName(String name) {
        newItemNameTextField.setValue(name);
        return this;
    }

    @Step("Submitting item price to text field")
    public ListDetailsPage enterNewItemPrice(String price) {
        newItemPriceTextField.setValue(price);
        return this;
    }

    @Step("Submitting item amount to text field")
    public ListDetailsPage enterNewItemAmount(String amount) {
        newItemCountTextField.setValue(amount);
        return this;
    }

    @Step("Submitting item comment to text field")
    public ListDetailsPage enterNewItemComment(String comment) {
        newItemCommentTextField.setValue(comment);
        return this;
    }

    @Step("Clicking 'Add item' button")
    public void clickAddItemButton() {
        addItemButton.click();
    }

    @Step("Checking whether expected currency symbol {0} is displayed on List Details page")
    public boolean isExpectedCurrencySymbolDisplayed(String currencySymbol) {
        return driverManager.getDriver().findElementsByXPath(
                String.format(newItemCurrencySymbolXPathTemplate, currencySymbol)).size() == 1;
    }

    public String getPriceUnitText(){
        return newItemPriceUnitLabel.getText();
    }
}
