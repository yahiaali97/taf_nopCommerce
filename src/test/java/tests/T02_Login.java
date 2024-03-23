package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.P01_Registration;
import pages.P02_Login;

import static org.testng.Assert.assertTrue;

public class T02_Login extends TestBase {
    HomePage homeObject;
    P01_Registration registerObject;
    P02_Login loginObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();

    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new HomePage(driver);
        homeObject.openRegisterPage();
        registerObject = new P01_Registration(driver);
        registerObject.userRegistration(firstname, lastname, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void userLogin() {
        loginObject = new P02_Login(driver);
        loginObject = new P02_Login(driver);
        homeObject.openLoginPage();
        loginObject.userLogin(email, password);
        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }
}