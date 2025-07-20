package com.practice.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Main {

    // Method to check if an element (by xpath) is clickable
    public static boolean isElementClickable(WebDriver driver, String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
    
//    WebElement element = wait.until(ExpectedConditions.

    public static void main(String[] args) {
        // Step 0: Start Chrome browser (make sure chromedriver is set in PATH)
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Go to the Amazon page
            driver.get("https://www.amazon.in/");

            // Step 2: Find the "Digital Content and Devices" section and all its links
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Digital Content and Devices')]")
            ));

            // Find all <a> links that are following siblings of the section header
            List<WebElement> links = driver.findElements(
                By.xpath("//div[contains(text(),'Digital Content and Devices')]/following-sibling::a")
            );

            System.out.println("Found " + links.size() + " links under 'Digital Content and Devices'.");

            // Step 3: Loop through each link and check if it's clickable
            for (WebElement link : links) {
                String linkText = link.getText().trim();
                if (linkText.isEmpty()) continue;  // skip if text is empty

                // Build xpath using the link text
                String xpath = "//a[contains(text(),'" + linkText + "')]";

                boolean clickable = isElementClickable(driver, xpath);
                System.out.println("Link: '" + linkText + "' - Clickable? " + clickable);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();  // always close the browser
        }
    }
}
