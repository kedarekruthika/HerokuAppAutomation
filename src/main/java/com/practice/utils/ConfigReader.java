package com.practice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Load properties file
    public static void loadProperties() {
        properties = new Properties();
        try {
        	FileInputStream fis = new FileInputStream(
        		    System.getProperty("user.dir") + "/src/test/resources/config.properties"
        		);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get value for a given key
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
