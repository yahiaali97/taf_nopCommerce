package myaccount;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

public class MyAccountTests extends TestBase {

    HomePage homeObject;
    RegistrationPage registerObject;
    LoginPage loginObject;
    MyAccountPage myAccountPageObject;
    String oldPassword = "123456";
    String newPassword = "123456789";
    String firstName = "Yahya";
    String lastName = "Ali";
    String emailAddress = "testtest1997@example.com";

    @Test(priority = 1)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.OpenRegisterPage();
        registerObject = new RegistrationPage(driver);
        registerObject.RegisterNewUser(firstName,
                lastName,
                emailAddress,
                oldPassword);
    }

    @Test(priority = 2)
    public void RegisteredUserCanLogin() {
        homeObject = new HomePage(driver);
        homeObject.OpenLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(emailAddress, oldPassword);
    }

    @Test(priority = 3)
    public void RegisteredUserCanChangePassword() throws InterruptedException {
        myAccountPageObject = new MyAccountPage(driver);
        RegistrationPage registerObject = new RegistrationPage(driver);
        registerObject.OpenMyAccountPage();
        myAccountPageObject.ChangePassword(oldPassword, newPassword);
    }
    @Test(priority = 4)
    public void UserCanLogout() {
        registerObject.usrLogout();
    }
}