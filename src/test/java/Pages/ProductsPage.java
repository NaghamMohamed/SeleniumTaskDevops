package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    By product_title=By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By addToCart=By.id("add-to-cart-sauce-labs-backpack");
    By Cart=By.className("shopping_cart_link");
    By remove=By.id("remove-sauce-labs-backpack");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Boolean checkProductTitle(String title){
        return driver.findElement(product_title).getText().toLowerCase().contains(title);
    }
    public void clickCart(){
        driver.findElement(Cart).click();
    }


    public void addToCart() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addToCart));
        driver.findElement(addToCart).click();
    }
    public void setRemove() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(remove));
        driver.findElement(remove);
    }
}
