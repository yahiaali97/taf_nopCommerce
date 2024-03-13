package tests;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {

    HomePage homeObject;
    RegistrationPage registerObject;
    LoginPage loginObject;
    String fName = "Robert";
    String lName = "John";
    String email = "test51@example.com";
    String password = "123456";


    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new HomePage(driver);
        homeObject.OpenRegisterPage();
        registerObject = new RegistrationPage(driver);
        registerObject.userRegistration(fName, lName, email, password);

        assertTrue(driver.findElement(registerObject.resultMsg).getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void userLogin() {
        homeObject.OpenLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, password);

        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }
}