package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    private final By registerLink = By.xpath("//div[@class='header-links']//a[@class='ico-register']");
    public By loginLink = By.cssSelector("a.ico-login");
    private final By contactUsLink = By.xpath("//a[@href='/contactus']");

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
