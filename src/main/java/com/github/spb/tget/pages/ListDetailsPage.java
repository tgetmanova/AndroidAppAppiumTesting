package com.github.spb.tget.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ListDetailsPage extends Page {

    private String listDetailsHeaderXPathTemplate = "//android.widget.TextView[@text='%s']";

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Total: 0 £')]")
    private MobileElement totalAmountLabel;

    @AndroidFindBy(id = "com.slava.buylist:id/editText1")
    private MobileElement newItemNameTextField;

    @AndroidFindBy(id = "com.slava.buylist:id/editText2")
    private MobileElement newItemPriceTextField;

    @AndroidFindBy(id = "com.slava.buylist:id/editText3")
    private MobileElement newItemCountTextField;

    @AndroidFindBy(id = "com.slava.buylist:id/editText4")
    private MobileElement newItemCommentTextField;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    private MobileElement addItemButton;

    private String itemNameLabelXPathTemplate = "//android.widget.TextView[@text='%s']";
    private String itemPriceLabelXPathTemplate = "//android.widget.TextView[@text='%s']";
    private String itemAmountLabelXPathTemplate = "//android.widget.TextView[@text='%s']";
    private String itemCommentLabelXPathTemplate = "//android.widget.TextView[@text='%s']";

    public ListDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAt(String listTitle) {
        List<MobileElement> elements = driver.findElementsByXPath(String.format(listDetailsHeaderXPathTemplate, listTitle));
        return elements.size() == 1;
    }

    public boolean hasItemWithName(String name) {
        List<MobileElement> elements = driver.findElementsByXPath(String.format(itemNameLabelXPathTemplate, name));
        return elements.size() == 1;
    }

    public ListDetailsPage enterNewItemName(String name) {
        newItemNameTextField.setValue(name);
        return this;
    }

    public ListDetailsPage enterNewItemPrice(String price) {
        newItemPriceTextField.setValue(price);
        return this;
    }

    public ListDetailsPage enterNewItemAmount(String amount) {
        newItemCountTextField.setValue(amount);
        return this;
    }

    public ListDetailsPage enterNewItemComment(String comment) {
        newItemCommentTextField.setValue(comment);
        return this;
    }

    public void clickAddItemButton() {
        addItemButton.click();
    }

    public String getTotalAmountText() {
        return totalAmountLabel.getText();
    }
}
