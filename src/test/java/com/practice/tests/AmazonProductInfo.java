package com.practice.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductInfo {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=Redmi+A4+5G");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebElement productBlock = driver.findElement(
				By.xpath("//div[@data-component-type='s-search-result'][.//span[contains(text(),'Redmi A4 5G')]]"));
		System.out.println(productBlock);
		String productTitle = productBlock.findElement(By.xpath(".//span[contains(text(),'Redmi A4 5G')]")).getText();
		System.out.println(productTitle);
		String productPrice = productBlock.findElement(
			    By.xpath(".//span[contains(@class,'a-price')]//span[@class='a-offscreen']")
				).getText();

		System.out.println("Product Title: " + productTitle);
		System.out.println("Product Price: " + productPrice);

		driver.quit();

	}

}
