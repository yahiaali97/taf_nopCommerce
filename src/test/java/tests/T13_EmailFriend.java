package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.P01_Registration;
import pages.P02_Login;
import pages.P03_ProductSearch;
import pages.P13_EmailFriend;

import static org.testng.Assert.assertTrue;

public class T13_EmailFriend extends TestBase {
    P01_Registration registerObject;
    P02_Login loginObject;
    P03_ProductSearch searchObject;
    P13_EmailFriend emailFriendObject;

    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String personalMsg = "This product is very good for you";
    String password = fakeData.number().digits(8).toString();

    @Test(priority = 1)
    public void userRegistration() {
        registerObject = new P01_Registration(driver);
        registerObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg)
                .getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void SearchWithAutoSuggest() {
        searchObject = new P03_ProductSearch(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 3)
    public void userLogin() {
        loginObject = new P02_Login(driver);
        loginObject.openLoginPage();
        loginObject.userLogin(email, password);
        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 4)
    public void emailFriend() {
        emailFriendObject = new P13_EmailFriend(driver);
        emailFriendObject.sendEmailToFriend(email, personalMsg);
        assertTrue(driver.findElement(emailFriendObject.ConfirmationMsg).getText()
                .contains("Your message has been sent"));
    }
}