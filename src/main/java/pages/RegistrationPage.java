package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends PageBase {
    By GenderRdoBtn = By.id("gender-male");
    By FirstName = By.id("FirstName");
    By LastName = By.id("LastName");
    By Email = By.id("Email");
    By Password = By.id("Password");
    By ConfirmPass = By.id("ConfirmPassword");
    By RegisterSubmit = By.id("register-button");
    public By LogoutLink = By.xpath("//a[@class='ico-logout']");
    By myAccountLink = By.linkText("My account");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void RegisterNewUser(String firstName,
                                String lastName,
                                String emailAddress,
                                String pass) {
        clickButton(driver.findElement(GenderRdoBtn));
        setTextElement(driver.findElement(FirstName), firstName);
        setTextElement(driver.findElement(LastName), lastName);
        setTextElement(driver.findElement(Email), emailAddress);
        setTextElement(driver.findElement(Password), pass);
        setTextElement(driver.findElement(ConfirmPass), pass);
        clickButton(driver.findElement(RegisterSubmit));
    }

    public void usrLogout() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(d -> ExpectedConditions.elementToBeClickable(driver.findElement(LogoutLink)));
    }

    public void OpenMyAccountPage() {
        clickButton(driver.findElement(myAccountLink));
    }
}