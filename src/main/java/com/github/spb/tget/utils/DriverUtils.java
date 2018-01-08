package com.github.spb.tget.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverUtils {

    public static AndroidDriver createAndroidDriver() {
        Properties properties = DataContextUtils.getAppProperties();
        File app = new File(DriverUtils.class.getClassLoader().getResource(
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
}
