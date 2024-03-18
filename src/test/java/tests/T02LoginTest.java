package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.P01HomePage;
import pages.P02RegistrationPage;
import pages.P03LoginPage;

import static org.testng.Assert.assertTrue;

public class T02LoginTest extends TestBase {

    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    P03LoginPage loginObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();

    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, password);

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