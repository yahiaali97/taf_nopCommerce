package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.P01HomePage;
import pages.P02RegistrationPage;
import pages.P03LoginPage;
import pages.P05MyAccountPage;

import static org.testng.Assert.assertTrue;

public class T04MyAccountTest extends TestBase {

    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    P03LoginPage loginObject;
    P05MyAccountPage p05MyAccountPageObject;

    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().firstName();
    String email = fakeData.internet().emailAddress();
    String oldPassword = fakeData.number().digits(8).toString();
    String newPassword = fakeData.number().digits(8).toString();

    @Test(priority = 1)
    public void UserRegisterSuccessfully() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, oldPassword);

        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void RegisteredUserCanLogin() {
        loginObject = new P03LoginPage(driver);

        homeObject.openLoginPage();
        loginObject.userLogin(email, oldPassword);

        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 3)
    public void RegisteredUserCanChangePassword() {
        p05MyAccountPageObject = new P05MyAccountPage(driver);

        p05MyAccountPageObject.OpenMyAccountPage();
        p05MyAccountPageObject.openChangePWPage();
        p05MyAccountPageObject.ChangePassword(oldPassword, newPassword);

        assertTrue(driver.findElement(p05MyAccountPageObject.changePWLink).isDisplayed());
    }

    @Test(priority = 4)
    public void UserCanLogout() {
        registerObject.usrLogout();

        assertTrue(driver.findElement(homeObject.loginLink).isDisplayed());
    }
}