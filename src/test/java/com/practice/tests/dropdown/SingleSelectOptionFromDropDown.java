package com.practice.tests.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleSelectOptionFromDropDown {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dropdown");
		driver.manage().window().maximize();
		Select selectDropdown = new Select(driver.findElement(By.id("dropdown")));
		selectDropdown.selectByVisibleText("Option 1");
		   System.out.println(selectDropdown.getFirstSelectedOption().getText());
		driver.quit();
		

	}

}
