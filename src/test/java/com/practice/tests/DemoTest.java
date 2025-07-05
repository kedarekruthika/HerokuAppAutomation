package com.practice.tests;


import org.testng.annotations.Test;

import com.practice.utils.ConfigReader;

public class DemoTest {

    @Test
    public void testOpenUrl() {
        // Step 1: Load config properties
        ConfigReader.loadProperties();

        // Step 2: Read values from config
        String url = ConfigReader.get("base.url");
        String browser = ConfigReader.get("browser");

        // Step 3: Print to check
        System.out.println("URL from config: " + url);
        System.out.println("Browser from config: " + browser);
    }
}
