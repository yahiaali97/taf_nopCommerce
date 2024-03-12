package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    WebElement registerLink = driver.findElement(By.linkText("Register"));
    WebElement loginLink = driver.findElement(By.linkText("Log in"));

    public void OpenRegisterPage() {
        PageBase.clickButton(registerLink);
    }

    public void OpenLoginPage() {
        clickButton(loginLink);
    }
}