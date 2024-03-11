package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageBase {
    private final By GenderRdoBtn = By.id("gender-male");
    private final By FirstName = By.id("FirstName");
    private final By LastName = By.id("LastName");
    private final By Email = By.id("Email");
    private final By Company = By.id("Company");
    private final By Password = By.id("Password");
    private final By ConfirmPass = By.id("ConfirmPassword");
    private final By RegisterSubmit = By.id("register-button");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void loginValidUser(String firstName,
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