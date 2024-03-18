package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.P01_Registration;
import pages.P02_Login;
import pages.P03_ProductSearch;
import pages.P11_AddProductReview;

import static org.testng.Assert.assertTrue;

public class T11_AddProductReview extends TestBase {
    P01_Registration registerObject;
    P02_Login loginObject;
    P03_ProductSearch searchObject;
    P11_AddProductReview reviewObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    String reviewTitle = "Recommend the product";
    String reviewTxtBox = "This product helped me so much";

    @Test(priority = 1, alwaysRun = true)
    public void UserRegister() {
        registerObject = new P01_Registration(driver);
        registerObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void UserLogin() {
        loginObject = new P02_Login(driver);
        loginObject.openLoginPage();
        loginObject.userLogin(email, password);
        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 3)
    public void SearchWithAutoSuggest() {
        searchObject = new P03_ProductSearch(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 4)
    public void AddReview() {
        reviewObject = new pages.P11_AddProductReview(driver);
        reviewObject.openReviewPage();
        reviewObject.fillReviewForm(reviewTitle, reviewTxtBox);
        assertTrue(driver.findElement(reviewObject.submissionResultMsg).getText()
                .contains("Product review is successfully added"));
    }
}