package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By registerLink = By.linkText("Register");

    public By loginLink = By.linkText("Log in");

    public void OpenRegisterPage() {
        clickButton(driver.findElement(registerLink));
    }

    public void OpenLoginPage() {
        clickButton(driver.findElement(loginLink));
    }
}