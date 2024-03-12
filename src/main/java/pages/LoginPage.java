package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    By LoginEmail = By.id("Email");
    By LoginPassword = By.id("Password");
    By LoginButton = By.xpath("//button[@class='button-1 login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void userLogin(String email, String pass) {
        setTextElement(driver.findElement(LoginEmail), email);
        setTextElement(driver.findElement(LoginPassword), pass);
        clickButton(driver.findElement(LoginButton));
    }
}