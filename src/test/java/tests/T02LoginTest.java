package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P01HomePage;
import pages.P02RegistrationPage;
import pages.P03LoginPage;

import static org.testng.Assert.assertTrue;

public class T02LoginTest extends TestBase {

    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    P03LoginPage loginObject;
    String fName = "Robert";
    String lName = "John";
    String email = "test91@example.com";
    String password = "123456";

    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);
        homeObject.openRegisterPage();
        registerObject.userRegistration(fName, lName, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void userLogin() {
        loginObject = new P03LoginPage(driver);
        homeObject.openLoginPage();
        loginObject.userLogin(email, password);
        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }
}