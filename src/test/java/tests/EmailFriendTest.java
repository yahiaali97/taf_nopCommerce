package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.EmailFriendPage;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SearchPage;

import static org.testng.Assert.assertTrue;

public class EmailFriendTest extends TestBase {
    HomePage homeObject;
    RegistrationPage registerObject;
    SearchPage searchObject;
    EmailFriendPage emailFriendObject;

    String fName = "Robert";
    String lName = "John";
    String email = "test77@example.com";
    String yourEmail = "john@example.com";
    String personalMsg = "This product is very good for you";
    String password = "123456";

    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new HomePage(driver);
        registerObject = new RegistrationPage(driver);
        homeObject.openRegisterPage();
        registerObject.userRegistration(fName, lName, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg)
                .getText()
                .contains("Your registration completed"));
    }


    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new SearchPage(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
    }

    @Test(priority = 3)
    public void emailFriend() {
        emailFriendObject = new EmailFriendPage(driver);
        emailFriendObject.sendEmailToFriend(email,yourEmail,personalMsg);
    }
}