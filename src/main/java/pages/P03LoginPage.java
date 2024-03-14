package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03LoginPage extends PageBase {
    public P03LoginPage(WebDriver driver) {
        super(driver);
    }

    By loginEmail = By.id("Email");
    By loginPW = By.id("Password");
    By loginBtn = By.xpath("//button[@class='button-1 login-button']");

    public void userLogin(String email, String password) {
        setTextElement(driver.findElement(loginEmail), email);
        setTextElement(driver.findElement(loginPW), password);
        clickButton(driver.findElement(loginBtn));
    }
}