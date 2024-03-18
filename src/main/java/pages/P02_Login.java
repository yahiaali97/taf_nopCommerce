package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login extends PageBase {

    public P02_Login(WebDriver driver) {
        super(driver);
    }

    public By loginLink = By.cssSelector("a.ico-login");
    private final By loginEmail = By.id("Email");
    private final By loginPW = By.id("Password");
    private final By loginBtn = By.xpath("//button[@class='button-1 login-button']");

    public void openLoginPage() {
        clickButton(driver.findElement(loginLink));
    }

    public void userLogin(String email, String password) {
        setTextElement(driver.findElement(loginEmail), email);
        setTextElement(driver.findElement(loginPW), password);
        clickButton(driver.findElement(loginBtn));
    }
}