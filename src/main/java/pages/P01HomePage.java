package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class P01HomePage extends PageBase {

    public P01HomePage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    By currencyDDL = By.id("customerCurrency");
    By registerLink = By.linkText("Register");
    public By loginLink = By.cssSelector("a.ico-login");
    By contactUsLink = By.xpath("//a[@href=\"/contactus\"]");
    By computerMenu = By.linkText("Computers");
    By notebooksMenu = By.linkText("Notebooks");

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

    public void changeCurrency() {
        select = new Select(driver.findElement(currencyDDL));
        select.selectByIndex(1);
    }

    public void selectNotebooksMenu() {
        action.moveToElement(driver.findElement(computerMenu)).perform();
        action.click(driver.findElement(notebooksMenu)).perform();
    }
}