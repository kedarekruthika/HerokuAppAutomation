package com.practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler; 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import pages.HomePage;
import pages.ItemPage;

public class EbayFunctionalTest {

    WebDriver driver;
    HomePage homePage;
    ItemPage itemPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        itemPage = new ItemPage(driver);
    }

    @Test
    public void verifyAddToCartFunctionality() throws IOException {
        driver.get("https://www.ebay.com");

        homePage.enterSearchText("book");
        homePage.clickSearchButton();
        homePage.waitForSearchResults();

        itemPage.clickFirstItemAndAddToCartWithWindowSwitch();

        int cartCount = itemPage.getCartCount();
        System.out.println("Cart count: " + cartCount);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        File cartSectionScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(cartSectionScreenshot, new File("./screenshots/cart_section.png"));
        System.out.println("Cart section screenshot saved.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[@class='gh-cart__icon']")));

        File fullScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(fullScreenshot, new File("./screenshots/full_cart_page.png"));
        System.out.println("Full-page screenshot saved.");
    
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
}
