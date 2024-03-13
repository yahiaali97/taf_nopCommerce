package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends PageBase {
    By genderSelect = By.id("gender-male");
    By fnBox = By.id("FirstName");
    By lnBox = By.id("LastName");
    By emailBox = By.id("Email");
    By pwBox = By.id("Password");
    By confirmPWBox = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");
    public By logoutLink = By.xpath("//a[@class='ico-logout']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void userRegistration(String firstName, String lastName, String emailAddress, String pass) {
        clickButton(driver.findElement(genderSelect));
        setTextElement(driver.findElement(fnBox), firstName);
        setTextElement(driver.findElement(lnBox), lastName);
        setTextElement(driver.findElement(emailBox), emailAddress);
        setTextElement(driver.findElement(pwBox), pass);
        setTextElement(driver.findElement(confirmPWBox), pass);
        clickButton(driver.findElement(registerBtn));
    }

    public void usrLogout() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(d -> ExpectedConditions.elementToBeClickable(driver.findElement(logoutLink)));
    }
}