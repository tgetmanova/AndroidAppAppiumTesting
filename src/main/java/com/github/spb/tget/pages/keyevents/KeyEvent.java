package com.github.spb.tget.pages.keyevents;

public interface KeyEvent {
    void pressBack();
    void pressBackSeveralTimes(int howManyTimes);
    void pressHome();
    void collapseKeyboard();
}
