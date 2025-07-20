package com.practice.tests.dropdown;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class SeleniumDropDownList {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.foodandwine.com/");
        driver.manage().window().maximize();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate the <li> for the "Food" menu
            WebElement foodMenuLi = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[normalize-space()='Food']/parent::li")
            ));

            // Hover over the <li>
           Actions actions = new Actions(driver);
            actions.moveToElement(foodMenuLi).perform();

            // Wait for the submenu to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//a[normalize-space()='Food']/parent::li//ul[contains(@class,'sublist')]")
            ));

            // Get all <a> links inside the "Food" dropdown
            List<WebElement> foodItems = driver.findElements(
                By.xpath("//a[normalize-space()='Food']/parent::li//ul[contains(@class,'sublist')]//a")
            );

            System.out.println("Food Menu Dropdown Items:");
            for (WebElement item : foodItems) {
                System.out.println(item.getText().trim());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
