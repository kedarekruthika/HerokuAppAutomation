package com.practice.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FoodAndMenuMouseHover {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.foodandwine.com");
		List<WebElement> foodLinks = driver.findElements(By.xpath("//a[contains(text(),'Food')]"));
		for(WebElement linkname : foodLinks) {
			linkname.isDisplayed();
		Actions action = new Actions(driver);
		action.moveToElement(linkname).perform();
		break;
		}
		List<WebElement> links = driver
				.findElements(By.xpath("//a[contains(text(),'Food')]/following-sibling::ul/li/a"));
		for (WebElement e : links) {
			String text = e.getText();
			System.out.println(text);
		}

		driver.quit();

	}

}
