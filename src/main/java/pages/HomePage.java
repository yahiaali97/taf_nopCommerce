package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    WebElement registerBtn = driver.findElement(By.linkText("Register"));
    WebElement loginBtn = driver.findElement(By.linkText("Log in"));

    public void OpenRegisterPage() {
        PageBase.clickButton(registerBtn);
    }

    public void OpenLoginPage() {
        PageBase.clickButton(loginBtn);
    }
}