package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By UserName=By.xpath("//*[@data-test='username']");
    By PW=By.id("password");
    By submitBtn=By.id("login-button");
    By errorMsg = By.xpath("//*[@data-test='error']");

    public void enterUserName(String userNameIn){
        driver.findElement(UserName).sendKeys(userNameIn);
    }
    public void enterPassWord(String passWordIn){
        driver.findElement(PW).sendKeys(passWordIn);
    }
    public void clickLogin(){
        driver.findElement(submitBtn).click();
    }
    public String ckekErrorMsg(){
        return driver.findElement(errorMsg).getText();
    }
}
