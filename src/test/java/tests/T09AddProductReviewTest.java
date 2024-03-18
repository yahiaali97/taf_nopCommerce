package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class T09AddProductReviewTest extends TestBase {
    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    P03LoginPage loginObject;
    P06SearchPage searchObject;
    P09AddProductReviewPage reviewObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    String reviewTitle = "Recommend the product";
    String reviewTxtBox = "This product helped me so much";

    @Test(priority = 1, alwaysRun = true)
    public void UserRegister() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, password);

        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void UserLogin() {
        loginObject = new P03LoginPage(driver);

        homeObject.openLoginPage();
        loginObject.userLogin(email, password);

        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 3)
    public void SearchWithAutoSuggest() {
        searchObject = new P06SearchPage(driver);

        searchObject.ProductSearchUsingAutoSuggest("mac");

        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 4)
    public void AddReview() {
        reviewObject = new P09AddProductReviewPage(driver);

        reviewObject.openReviewPage();
        reviewObject.fillReviewForm(reviewTitle, reviewTxtBox);

        assertTrue(driver.findElement(reviewObject.submissionResultMsg).getText()
                .contains("Product review is successfully added"));
    }
}