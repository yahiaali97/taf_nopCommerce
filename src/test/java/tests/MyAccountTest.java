package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class MyAccountTest extends TestBase {

    HomePage homeObject;
    RegistrationPage registerObject;
    LoginPage loginObject;
    MyAccountPage myAccountPageObject;
    String fName = "Robert";
    String lName = "John";
    String email = "test74@example.com";
    String oldPassword = "123456";
    String newPassword = "123456789";

    @Test(priority = 1)
    public void UserRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        registerObject = new RegistrationPage(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration(fName, lName, email, oldPassword);

        assertTrue(driver.findElement(registerObject.resultMsg).getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void RegisteredUserCanLogin() {
        loginObject = new LoginPage(driver);

        homeObject.openLoginPage();
        loginObject.userLogin(email, oldPassword);

        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 3)
    public void RegisteredUserCanChangePassword() {
        myAccountPageObject = new MyAccountPage(driver);

        myAccountPageObject.OpenMyAccountPage();
        myAccountPageObject.openChangePWPage();
        myAccountPageObject.ChangePassword(oldPassword, newPassword);

        assertTrue(driver.findElement(myAccountPageObject.changePWLink).isDisplayed());
    }

    @Test(priority = 4)
    public void UserCanLogout() {
        registerObject.usrLogout();
    }
}