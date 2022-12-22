package Tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class productsTest {
    WebDriver driver;
    // WebDriverWait webDriverWait;
    String URL = "https://www.saucedemo.com/";
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeClass

    public void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassWord("secret_sauce");
        loginPage.clickLogin();
    }

    @AfterMethod
    public void logout() {
        driver.get(URL);

    }

    @Test
    public void checkAddedProduct() {
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html","URL not True");
        softAssert.assertTrue(productsPage.checkProductTitle("products"));
        productsPage.addToCart();
        productsPage.clickCart();
        softAssert.assertTrue(cartPage.checkAddedProduct("sauce"));
        softAssert.assertAll();

    }
}
