//package com.practice.test;
//
//import java.time.Duration;
//import java.util.concurrent.TimeoutException;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.*;
//import org.testng.Assert;
//import pages.HomePage;
//import pages.ItemPage;
//import com.practice.utils.ConfigReader;
//
//public class EbayCartTest {
//
//	WebDriver driver;
//
//	@BeforeMethod
//	public void launchBrowser() {
//		ConfigReader.loadProperties();
//		String browser = ConfigReader.get("browser");
//
//		if (browser.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else {
//			throw new RuntimeException("Browser not supported: " + browser);
//		}
//
//		driver.manage().window().maximize();
//		driver.get(ConfigReader.get("base.url"));
//	}
//
//	@Test
//	public void verifyAddToCartFunctionality() throws TimeoutException {
//	    HomePage home = new HomePage(driver);
//	    home.enterSearchText("book");
//	    home.clickSearchButton();
//
//	    ItemPage item = new ItemPage(driver);
//	    item.clickFirstItem();
//
//	   
//	    String originalWindow = driver.getWindowHandle();
//	    for (String windowHandle : driver.getWindowHandles()) {
//	        if (!windowHandle.equals(originalWindow)) {
//	            driver.switchTo().window(windowHandle);
//	            break;
//	        }
//	    }
//
//	    item.clickAddToCart();
//	    
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
//		    By.xpath("//button[@aria-label='Close overlay']")
//		));
//		closePopup.click();
//
//		String cartCount = item.getCartCountText();
//	    System.out.println("Cart count: " + cartCount);
//	    Assert.assertEquals(cartCount, "1", "Cart count did not match.");
//	}
//}
