package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class P02RegistrationPage extends PageBase {

    public P02RegistrationPage(WebDriver driver) {
        super(driver);
    }

    By genderSelect = By.id("gender-male");
    By fnBox = By.id("FirstName");
    By lnBox = By.id("LastName");
    By emailBox = By.id("Email");
    By pwBox = By.id("Password");
    By confirmPWBox = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");
    public By resultMsg = By.cssSelector("div.result");
    public By logoutLink = By.xpath("//a[@class='ico-logout']");

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
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .ignoring(ElementNotInteractableException.class);
        wait.until(
                d -> {
                    clickButton(driver.findElement(logoutLink));
                    return true;
                });
    }
}