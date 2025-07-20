package com.practice.tests;


import org.testng.annotations.Test;

import com.practice.utils.pConfigReader;

public class DemoTest {

    @Test
    public void testOpenUrl() {
        // Step 2: Read values from config
    	String url = pConfigReader.get("base.url");
    	String browser = pConfigReader.get("browser");


        // Step 3: Print to check
        System.out.println("URL from config: " + url);
        System.out.println("Browser from config: " + browser);
    }
}
