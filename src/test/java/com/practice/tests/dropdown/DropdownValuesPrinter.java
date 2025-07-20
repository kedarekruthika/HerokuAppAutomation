package com.practice.tests.dropdown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class DropdownValuesPrinter {
    public static void main(String[] args) {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to the food and wine website
            driver.get("https://foodandwine.com"); // Replace with actual URL
            
            // Maximize the browser window
            driver.manage().window().maximize();
            
            // Wait for page to load completely
            Thread.sleep(2000);
            
            // Locate the Food dropdown element
            WebElement foodDropdown = driver.findElement(By.id("food-dropdown")); // Replace with actual locator
            
            // Create Select object for Food dropdown
            Select foodSelect = new Select(foodDropdown);
            
            // Get all options from Food dropdown
            List<WebElement> foodOptions = foodSelect.getOptions();
            
            // Print Food dropdown values
            System.out.println("=== FOOD DROPDOWN VALUES ===");
            for (WebElement option : foodOptions) {
                // Print each option text
                System.out.println(option.getText());
            }
            
            // Locate the Drinks dropdown element
            WebElement drinksDropdown = driver.findElement(By.id("drinks-dropdown")); // Replace with actual locator
            
            // Create Select object for Drinks dropdown
            Select drinksSelect = new Select(drinksDropdown);
            
            // Get all options from Drinks dropdown
            List<WebElement> drinksOptions = drinksSelect.getOptions();
            
            // Print Drinks dropdown values
            System.out.println("\n=== DRINKS DROPDOWN VALUES ===");
            for (WebElement option : drinksOptions) {
                // Print each option text
                System.out.println(option.getText());
            }
            
        } catch (Exception e) {
            // Handle any exceptions that occur
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}