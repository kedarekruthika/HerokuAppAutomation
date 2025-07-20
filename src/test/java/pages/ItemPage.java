package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Set;

public class ItemPage {

    WebDriver driver;
    WebDriverWait wait;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickFirstItemAndAddToCartWithWindowSwitch() {
        String mainWindow = driver.getWindowHandle();

        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='s-item__link'])[3]")));
        firstItem.click();

        
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                driver.manage().window().maximize();
                break;
            }
        }

        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("atcBtn_btn_1")));
        addToCartBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[contains(text(),'added to cart') or contains(text(),'Added to cart')]")));

        WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@aria-label='Close overlay']")));
        closePopup.click();
        
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
        	    By.xpath("//span[contains(@aria-label,'Your shopping cart contains')]")));

        Actions actions = new Actions(driver);
        actions.moveToElement(cartIcon).pause(Duration.ofMillis(300)).perform();


    }

    public int getCartCount() {
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(@aria-label,'Your shopping cart contains')]")));
        

        
        String cartLabel = cartIcon.getAttribute("aria-label");
        System.out.println("Cart label text: " + cartLabel);

        int itemCount = Integer.parseInt(cartLabel.replaceAll("\\D+", ""));
        return itemCount;
    }
}
