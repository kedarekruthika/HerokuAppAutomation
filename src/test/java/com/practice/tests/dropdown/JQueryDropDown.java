package com.practice.tests.dropdown;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JQueryDropDown {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.foodandwine.com");

		Thread.sleep(3000); // let page load

		List<WebElement> foodMenuList = driver.findElements(By.xpath("//a[contains(text(),'Food')]"));
		System.out.println("Found " + foodMenuList.size() + " 'Food' links");
		for (int i = 0; i < foodMenuList.size(); i++) {
		    WebElement el = foodMenuList.get(i);
		    System.out.println("Index: " + i);
		    System.out.println("Text: '" + el.getText().trim() + "'");
		    System.out.println("Is displayed: " + el.isDisplayed());
		    System.out.println("Location: " + el.getLocation());
		    System.out.println("Class: " + el.getAttribute("class"));
		    System.out.println("Href: " + el.getAttribute("href"));
		    System.out.println("-------------------------");
		}

		

		WebElement foodLink = null;
		for (WebElement el : foodMenuList) {
			if (el.isDisplayed()) {
				foodLink = el;
				break;
			}
		}

		if (foodLink != null) {
			System.out.println("'Food' link is visible, performing hover...");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(foodLink));

			Actions actions = new Actions(driver);
			actions.moveToElement(foodLink).perform();

			Thread.sleep(1000); // wait for submenu

			List<WebElement> foodLinks = driver
					.findElements(By.xpath("//a[contains(text(),'Food')]/following-sibling::ul/li/a"));

			System.out.println("Number of submenu links: " + foodLinks.size());
			for (WebElement e : foodLinks) {
				System.out.println(e.getText().trim());
			}
		} else {
			System.out.println("Could not find visible 'Food' menu link to hover over.");
		}

		driver.quit();
	}
}