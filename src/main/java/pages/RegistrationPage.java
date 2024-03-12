package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageBase {
    By GenderRdoBtn = By.id("gender-male");
    By FirstName = By.id("FirstName");
    By LastName = By.id("LastName");
    By Email = By.id("Email");
    By Company = By.id("Company");
    By Password = By.id("Password");
    By ConfirmPass = By.id("ConfirmPassword");
    By RegisterSubmit = By.id("register-button");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void RegisterNewUser(String firstName,
                                String lastName,
                                String emailAddress,
                                String companyName,
                                String pass,
                                String confirmPass) {
        clickButton(driver.findElement(GenderRdoBtn));
        setTextElement(driver.findElement(FirstName), firstName);
        setTextElement(driver.findElement(LastName), lastName);
        setTextElement(driver.findElement(Email), emailAddress);
        setTextElement(driver.findElement(Company), companyName);
        setTextElement(driver.findElement(Password), pass);
        setTextElement(driver.findElement(ConfirmPass), confirmPass);
        clickButton(driver.findElement(RegisterSubmit));
    }
}