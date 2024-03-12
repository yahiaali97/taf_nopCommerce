package myaccount;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    String emailAddress = "testttt@example.com";

    @Test(priority = 1)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.OpenRegisterPage();
        registerObject = new RegistrationPage(driver);
        registerObject.RegisterNewUser(firstName,
                lastName,
                emailAddress,
                oldPassword);

        try {
            registerObject = new RegistrationPage(driver);
            WebElement errorMsgUserExistence = driver.findElement(By.cssSelector("div.message-error.validation-summary-errors"));
            boolean isErrorMsgUserExistenceDisplayed = errorMsgUserExistence.isDisplayed();
            System.out.println("Is Error Message User Existence Displayed? " + isErrorMsgUserExistenceDisplayed);
            assertTrue(isErrorMsgUserExistenceDisplayed, "Error Message User Existence is displayed after registration");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    @Test(priority = 2, dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void RegisteredUserCanLogin() {
        homeObject = new HomePage(driver);
        homeObject.OpenLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(emailAddress, oldPassword);

        registerObject = new RegistrationPage(driver);
        WebElement logoutElement = driver.findElement(registerObject.LogoutLink);
        boolean isLogoutDisplayed = logoutElement.isDisplayed();
        System.out.println("Is Log out Button is Displayed? " + isLogoutDisplayed);
        assertTrue(isLogoutDisplayed, "Logout link is displayed after login");
    }

    @Test(priority = 3)
    public void RegisteredUserCanChangePassword() {
        myAccountPageObject = new MyAccountPage(driver);
        RegistrationPage registerObject = new RegistrationPage(driver);
        registerObject.OpenMyAccountPage();
        myAccountPageObject.ChangePassword(oldPassword, newPassword);

        try {
            myAccountPageObject = new MyAccountPage(driver);
            WebElement changePasswordElement = driver.findElement(myAccountPageObject.changePassword);
            boolean isChangePasswordButtonDisplayed = changePasswordElement.isDisplayed();
            System.out.println("Is Change Password Button is Displayed? " + isChangePasswordButtonDisplayed);
            assertTrue(isChangePasswordButtonDisplayed, "Change Password link is displayed after login");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }

    @Test(priority = 4)
    public void UserCanLogout() {
        registerObject.usrLogout();

        try {
            homeObject = new HomePage(driver);
            WebElement loginElement = driver.findElement(homeObject.loginLink);
            boolean isLoginDisplayed = loginElement.isDisplayed();
            System.out.println("Is Log out Button is Displayed? " + isLoginDisplayed);
            assertTrue(isLoginDisplayed, "Logout link is displayed after login");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}