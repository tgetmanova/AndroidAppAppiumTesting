package com.github.spb.tget.pages.keyevents;

import org.openqa.selenium.ScreenOrientation;

public interface KeyEvent {

    void pressBack();

    void pressBackSeveralTimes(int howManyTimes);

    ScreenOrientation getDeviceScreenOrientation();

    void pressHome();

    void collapseKeyboard();
}
