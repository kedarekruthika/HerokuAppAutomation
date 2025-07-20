package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        // Wait for new window and switch
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Click Add to Cart
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("atcBtn_btn_1")));
        addToCartBtn.click();

        // Wait for confirmation overlay
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[contains(text(),'added to cart') or contains(text(),'Added to cart')]")));

        // Close the overlay (popup)
        WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@aria-label='Close overlay']")));
        closePopup.click();

        // Stay on item window — do NOT switch back to mainWindow
    }

    // ✅ Final correct version of getCartCount()
    public int getCartCount() {
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(@aria-label,'Your shopping cart contains')]")));
        
        String cartLabel = cartIcon.getAttribute("aria-label");
        System.out.println("Cart label text: " + cartLabel);

        int itemCount = Integer.parseInt(cartLabel.replaceAll("\\D+", ""));
        return itemCount;
    }
}
