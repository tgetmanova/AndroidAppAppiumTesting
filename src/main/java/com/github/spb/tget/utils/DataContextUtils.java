package com.github.spb.tget.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public final class DataContextUtils {

    private DataContextUtils() {
        throw new IllegalStateException("DataContextUtils class is for static utils only and must not be instantiated");
    }

    public static Properties getAppProperties() {
        Properties appProperties = new Properties();

        InputStream resourceAsStream = DataContextUtils.class.getResourceAsStream("/application.properties");
        try (Reader reader = new InputStreamReader(resourceAsStream)) {
            appProperties.load(reader);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        return appProperties;
    }
}