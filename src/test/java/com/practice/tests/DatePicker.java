package com.practice.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));

	}

	public static void selectDate(String exDay, String exMonth, String exYear) {
		String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearValue);
		String month = monthYearValue.split(" ")[0].trim();
		String year = monthYearValue.split(" ")[1].trim();

		while (!(month.equals("June") && year.equals("2025"))) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(monthYearValue);
			month = monthYearValue.split(" ")[0].trim();
			year = monthYearValue.split(" ")[1].trim();

		}
		driver.findElement(By.xpath("//a[text()='25']")).click();

	}
}
