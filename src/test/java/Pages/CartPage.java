package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    By cartProductName= By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public Boolean checkAddedProduct(String productName){
       webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cartProductName));
        return driver.findElement(cartProductName).getText().toLowerCase().contains(productName);
    }
}
