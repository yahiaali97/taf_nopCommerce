package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.P01_Registration;
import pages.P02_Login;
import pages.P07_ChangePassword;

import static org.testng.Assert.assertTrue;

public class T07_ChangePassword extends TestBase {
    HomePage homeObject;
    P01_Registration registerObject;
    P02_Login loginObject;
    P07_ChangePassword myAccountObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().firstName();
    String email = fakeData.internet().emailAddress();
    String oldPassword = fakeData.number().digits(8).toString();
    String newPassword = fakeData.number().digits(8).toString();

    @Test(priority = 1)
    public void UserRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        registerObject = new P01_Registration(driver);
        homeObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, oldPassword);
        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void RegisteredUserCanLogin() {
        loginObject = new P02_Login(driver);
        homeObject.openLoginPage();
        loginObject.userLogin(email, oldPassword);
        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 3)
    public void RegisteredUserCanChangePassword() {
        myAccountObject = new P07_ChangePassword(driver);
        myAccountObject.OpenMyAccountPage();
        myAccountObject.openChangePWPage();
        myAccountObject.ChangePassword(oldPassword, newPassword);
        assertTrue(driver.findElement(myAccountObject.changePWLink).isDisplayed());
    }

    @Test(priority = 4)
    public void UserCanLogout() throws InterruptedException {
        registerObject.usrLogout();
        assertTrue(driver.findElement(homeObject.loginLink).isDisplayed());
    }
}