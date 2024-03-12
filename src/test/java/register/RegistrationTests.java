package register;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase {
    HomePage homeObject;
    RegistrationPage registerObject;

    @Test
    public void userRegistration() {
        homeObject = new HomePage(driver);
        homeObject.OpenRegisterPage();

        registerObject = new RegistrationPage(driver);
        registerObject.RegisterNewUser("Yahya",
                                        "Ali",
                                        "yahyaali@example.com",
                                        "123456");

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
}