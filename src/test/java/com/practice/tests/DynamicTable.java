package com.practice.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='taskTable']/tbody/tr"));

		System.out.println("Number of rows " + rows.size());

		for (WebElement r : rows) {
			WebElement name = driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr[" + r + "]//td[1]"));
			if (name.getText().equals("Chrome")) {
				System.out.println(name);
				String cpuLoad = driver
						.findElement(By
								.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]"))
						.getText();
				String value = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				if (cpuLoad.equals(value)) {
					System.out.println("CPU load of Chrome is equal.");
				} else {
					System.out.println("CPU load of Chrome is not equal");
				}
				break;

			}

		}

	}

}
