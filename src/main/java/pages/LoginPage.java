package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {

    By LoginEmail = By.id("Email");
    By LoginPassword = By.id("Password");
    By LoginButton = By.xpath("//button[@class='button-1 login-button']");
    public By Logout = By.linkText("Log out");
    By myAccountLink = By.linkText("My account");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void userLogin(String email, String pass) {
        setTextElement(driver.findElement(LoginEmail), email);
        setTextElement(driver.findElement(LoginPassword), pass);
        clickButton(driver.findElement(LoginButton));
    }

    public void logoutBtn() {
        clickButton(driver.findElement(Logout));
    }

    public void GoToMyAccountPage() {
        clickButton(driver.findElement(myAccountLink));
    }
}