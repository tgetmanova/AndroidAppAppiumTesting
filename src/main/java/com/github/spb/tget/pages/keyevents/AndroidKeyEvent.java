package com.github.spb.tget.pages.keyevents;

import com.github.spb.tget.pages.PageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import io.qameta.allure.Step;

public class AndroidKeyEvent extends PageElements implements KeyEvent {

    public AndroidKeyEvent(AppiumDriver driver) {
        super(driver);
    }

    @Override
    @Step("Pressing back device button")
    public void pressBack() {
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Override
    public void pressBackSeveralTimes(int howManyTimes) {
        int current = 0;
        while (current++ < howManyTimes) {
            pressBack();
        }
    }

    @Override
    public void pressHome() {

    }

    @Override
    public void collapseKeyboard() {

    }
}
