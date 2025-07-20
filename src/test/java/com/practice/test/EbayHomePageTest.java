//package com.practice.test;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
//import org.testng.Assert;
//import pages.HomePage;
//import com.practice.utils.ConfigReader;
//
//public class EbayHomePageTest {
//
//    WebDriver driver;
//
//    @BeforeMethod
//    public void launchEbayHomePage() {
//       
//        ConfigReader.loadProperties();
//        String browser = ConfigReader.get("browser");
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver(); 
//        } else {
//            throw new RuntimeException("Browser not supported: " + browser);
//        }
//        driver.manage().window().maximize();
//        driver.get(ConfigReader.get("base.url"));
//    }
//
//    @Test
//    public void verifyEbaySearchResultsTitle() {
//        String searchKeyword = "book";
//        HomePage home = new HomePage(driver);
//        home.enterSearchText(searchKeyword);
//        home.clickSearchButton();
//        String actualTitle = driver.getTitle();
//        Assert.assertTrue(actualTitle.toLowerCase().contains(searchKeyword.toLowerCase()),
//                "Search failed - Title does not contain: " + searchKeyword);
//    }
//
//    @AfterMethod
//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
