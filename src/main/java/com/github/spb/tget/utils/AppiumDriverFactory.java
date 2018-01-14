package com.github.spb.tget.utils;

import com.github.spb.tget.pages.keyevents.AndroidKeyEvent;
import com.github.spb.tget.pages.keyevents.KeyEvent;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AppiumDriverFactory {

    public static AppiumDriver getDriver() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                AppiumDriverFactory.class.getClassLoader().getResource("test-execution-context.xml").getPath());

        return (AppiumDriver) applicationContext.getBean("driver");
    }

    public static AppiumDriver getDriverByType(String driverType) {
        switch (driverType) {
            case "Android":
                return getAndroidDriver();
            default:
                throw new IllegalArgumentException("Invalid Appium Driver type: " + driverType);
        }
    }

    private static AndroidDriver getAndroidDriver() {
        Properties properties = DataContextUtils.getAppProperties();
        File app = new File(AppiumDriverFactory.class.getClassLoader().getResource(
                properties.getProperty("appRelativeLocationUnderResources")).getPath(),
                properties.getProperty("appName"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName",
                properties.getProperty("device"));
        capabilities.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME,
                properties.getProperty("platform"));
        capabilities.setCapability("app", app.getAbsolutePath());

        URL url;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException exception) {
            throw new RuntimeException(exception);
        }

        return new AndroidDriver(url, capabilities);
    }

    public static KeyEvent getKeyEventByDriverType(AppiumDriver driver) {
        if (driver instanceof AndroidDriver) {
            return new AndroidKeyEvent(driver);
        }
        throw new IllegalArgumentException("Invalid Appium Driver type");
    }
}
