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
    String fName = "Yahya";
    String lName = "Ali";
    String email = "test51@example.com";
    String password = "123456";


    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new HomePage(driver);
        homeObject.OpenRegisterPage();
        registerObject = new RegistrationPage(driver);
        registerObject.userRegistration(fName, lName, email, password);

        assertTrue(driver.findElement(registerObject.resultMsg).isDisplayed(), "Successfully Registration");
    }

    @Test(priority = 2)
    public void userLogin() {
        homeObject.OpenLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, password);

        WebElement logoutElement = driver.findElement(registerObject.logoutLink);
        assertTrue(logoutElement.isDisplayed(), "Logout link is displayed after login");
    }
}