package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));  
    }

    By searchBox = By.id("gh-ac");
    By searchButton = By.xpath("//button[@type ='submit' and @id ='gh-search-btn']");
    By searchResultsContainer = By.xpath("//ul[contains(@class,'srp-results')]");  

    public void enterSearchText(String text) {
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        box.clear();
        box.sendKeys(text);
    }

    public void clickSearchButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        button.click();
    }

        public void waitForSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsContainer));
    }
}
