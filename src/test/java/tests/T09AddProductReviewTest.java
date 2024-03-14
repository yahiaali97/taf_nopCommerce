package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class T09AddProductReviewTest extends TestBase {
    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    P03LoginPage loginObject;
    P06SearchPage searchObject;
    P09AddProductReviewPage reviewObject;
    String fName = "Robert";
    String lName = "John";
    String email = "test90@example.com";
    String password = "123456";
    String reviewTitle = "Recommend the product";
    String reviewTxtBox = "This product helped me so much";

    @Test(priority = 1, alwaysRun = true)
    public void UserRegister() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);
        homeObject.openRegisterPage();
        registerObject.userRegistration(fName, lName, email, password);
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
    }

    @Test(priority = 4)
    public void goToReviewPage() {
        reviewObject = new P09AddProductReviewPage(driver);
        reviewObject.openReviewPage();
        reviewObject.fillReviewForm(reviewTitle, reviewTxtBox);
        assertTrue(driver.findElement(reviewObject.submissionResultMsg).getText()
                .contains("Product review is successfully added"));
    }
}