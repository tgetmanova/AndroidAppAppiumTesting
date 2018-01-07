package com.github.spb.tget.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ListDetailsPage extends Page {

    private String listDetailsHeaderXPathTemplate = "//android.widget.TextView[@text='%s']";

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Total: 0 £')]")
    private MobileElement totalAmountLabel;

    public ListDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAt(String listTitle) {
        List<MobileElement> elements = driver.findElementsByXPath(String.format(listDetailsHeaderXPathTemplate, listTitle));
        return elements.size() == 1;
    }

    public String getTotalAmountText() {
        return totalAmountLabel.getText();
    }
}
