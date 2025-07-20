//package com.practice.utils;
//
//import com.practice.utils.ConfigReader;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
//
//public class BaseTest {
//    protected WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        ConfigReader.loadProperties();
//        String browser = ConfigReader.get("browser");
//
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else {
//            throw new RuntimeException("Browser not supported: " + browser);
//        }
//
//        driver.manage().window().maximize();
//        driver.get(ConfigReader.get("base.url"));
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
