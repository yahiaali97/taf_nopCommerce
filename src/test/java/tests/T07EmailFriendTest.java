package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class T07EmailFriendTest extends TestBase {
    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    P03LoginPage loginObject;
    P06SearchPage searchObject;
    P08EmailFriendPage emailFriendObject;

    String fName = "Robert";
    String lName = "John";
    String email = "test84@example.com";
    String personalMsg = "This product is very good for you";
    String password = "123456";

    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);
        homeObject.openRegisterPage();
        registerObject.userRegistration(fName, lName, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg)
                .getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new P06SearchPage(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
    }

    @Test(priority = 3)
    public void userLogin() {
        loginObject = new P03LoginPage(driver);
        homeObject.openLoginPage();
        loginObject.userLogin(email, password);
        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 4)
    public void emailFriend() {
        emailFriendObject = new P08EmailFriendPage(driver);
        emailFriendObject.sendEmailToFriend(email, personalMsg);
        assertTrue(driver.findElement(emailFriendObject.ConfirmationMsg)
                .getText()
                .contains("Your message has been sent"));
    }
}