package com.github.spb.tget.managers;

import com.github.spb.tget.pages.keyevents.KeyEvent;
import com.github.spb.tget.utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ScreenOrientation;

public class DeviceManager {

    private KeyEvent keyEvent;

    public DeviceManager(AppiumDriver driver) {
        keyEvent = AppiumDriverFactory.getKeyEventByDriverType(driver);
    }

    public ScreenOrientation getScreenOrientation() {
        return keyEvent.getDeviceScreenOrientation();
    }
}
