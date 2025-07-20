package com.practice.tests.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MutiSelectOptions {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dropdown");
		driver.manage().window().maximize();
		Select mutipleOptions = new Select(driver.findElement(By.id("dropdown"))); //locate the dropdown
		List<WebElement> allOptions = mutipleOptions.getOptions(); // select all opotions
		for(WebElement option : allOptions) {
			String text = option.getText();
			mutipleOptions.selectByVisibleText(text);
		}
		
		

	}

}
