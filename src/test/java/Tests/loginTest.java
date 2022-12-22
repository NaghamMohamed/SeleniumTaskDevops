package Tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class loginTest {

    WebDriver driver;
   // WebDriverWait webDriverWait;
    String URL="https://www.saucedemo.com/";
    LoginPage loginPage;
    ProductsPage productsPage;
    @BeforeClass

       public void setup(){
       driver = new ChromeDriver();
       driver.get(URL);
       loginPage=new LoginPage(driver);
       productsPage=new ProductsPage(driver);
    }
    @AfterMethod
    public void logout(){
        driver.get(URL);
        //driver.quit();
    }
    @Test
    public void loginSuccess(){
        SoftAssert softAssert=new SoftAssert();
        loginPage.enterUserName("standard_user");
        loginPage.enterPassWord("secret_sauce");
        loginPage.clickLogin();
        //login("standard_user","secret_sauce");
        softAssert.assertAll();
    }
    @Test
    public void lockedOutUser(){
        loginPage.enterUserName("locked_out_user");
        loginPage.enterPassWord("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.ckekErrorMsg(),"Epic sadface: Sorry, this user has been locked out.");
       //Sorry, this user has been locked out.
    }
    @Test
    public void userNameValidation(){
        loginPage.enterUserName("");
        loginPage.enterPassWord("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.ckekErrorMsg(),"Epic sadface: Username is required");
    }
    @Test
    public void passWordValidation() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassWord("");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.ckekErrorMsg(),"Epic sadface: Password is required");
    }
    @Test
    public void WrongPassword(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassWord("xx");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.ckekErrorMsg(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void ProductsPage(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassWord("secret_sauce");
        loginPage.clickLogin();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html","URL not True");
        softAssert.assertTrue(productsPage.checkProductTitle("products"));
        softAssert.assertAll();
    }
@Test
    public void CartLink(){
    loginPage.enterUserName("standard_user");
    loginPage.enterPassWord("secret_sauce");
    loginPage.clickLogin();
    productsPage.clickCart();
}
@Test
    public void addTocartCkick(){
    loginPage.enterUserName("standard_user");
    loginPage.enterPassWord("secret_sauce");
    loginPage.clickLogin();
    productsPage.addToCart();
}


}
