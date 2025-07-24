package com.practice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    public static void loadProperties() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/apiconfig.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("api.timeout"));
    }
}
