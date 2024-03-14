package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    By registerLink = By.linkText("Register");

    public By loginLink = By.linkText("Log in");
    By contactUsLink = By.xpath("//a[@href=\"/contactus\"]");

    public HomePage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public void openRegisterPage() {
        clickButton(driver.findElement(registerLink));
    }

    public void openLoginPage() {
        clickButton(driver.findElement(loginLink));
    }

    public void openContactPage() {
        js.executeScript("scrollTo(0, document.body.scrollHeight)");
        clickButton(driver.findElement(contactUsLink));
    }
}