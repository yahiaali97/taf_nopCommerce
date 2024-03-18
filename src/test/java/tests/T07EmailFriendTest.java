package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class T07EmailFriendTest extends TestBase {
    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    P03LoginPage loginObject;
    P06SearchPage searchObject;
    P08EmailFriendPage emailFriendObject;

    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String personalMsg = "This product is very good for you";
    String password = fakeData.number().digits(8).toString();

    @Test(priority = 1)
    public void userRegistration() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, password);

        assertTrue(driver.findElement(registerObject.resultMsg)
                .getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void SearchWithAutoSuggest() {
        searchObject = new P06SearchPage(driver);

        searchObject.ProductSearchUsingAutoSuggest("mac");

        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
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

        assertTrue(driver.findElement(emailFriendObject.ConfirmationMsg).getText()
                .contains("Your message has been sent"));
    }
}