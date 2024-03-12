package myaccount;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class MyAccountTests extends TestBase {

    HomePage homeObject;
    RegistrationPage registerObject;
    LoginPage loginObject;
    MyAccountPage myAccountPageObject;
    String oldPassword = "123456";
    String newPassword = "123456789";
    String firstName = "Yahya";
    String lastName = "Ali";
    String emailAddress = "sd0154466@example.com";

    @Test(priority = 1)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.OpenRegisterPage();
        registerObject = new RegistrationPage(driver);
        registerObject.RegisterNewUser(firstName,
                lastName,
                emailAddress,
                oldPassword);

        WebElement SuccessMsg = driver.findElement(By.cssSelector("div.result"));
        assertTrue(SuccessMsg.isDisplayed(), "Successfully Registration");
    }

    @Test(priority = 2, dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void RegisteredUserCanLogin() {
        homeObject.OpenLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(emailAddress, oldPassword);

        WebElement logoutElement = driver.findElement(registerObject.LogoutLink);
        assertTrue(logoutElement.isDisplayed(), "Logout link is displayed after login");
    }

    @Test(priority = 3)
    public void RegisteredUserCanChangePassword() {
        myAccountPageObject = new MyAccountPage(driver);
        registerObject.OpenMyAccountPage();
        myAccountPageObject.ChangePassword(oldPassword, newPassword);

        WebElement changePasswordElement = driver.findElement(myAccountPageObject.changePassword);
        assertTrue(changePasswordElement.isDisplayed(), "Change Password link is displayed after login");
    }

    @Test(priority = 4)
    public void UserCanLogout() {
        registerObject.usrLogout();

//        WebElement loginElement = driver.findElement(homeObject.loginLink);
//        assertTrue(loginElement.isDisplayed(), "Login link is displayed after log out");
    }
}