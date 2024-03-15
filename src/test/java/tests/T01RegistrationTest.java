package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P01HomePage;
import pages.P02RegistrationPage;

import static org.testng.Assert.assertTrue;

public class T01RegistrationTest extends TestBase {
    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    String fName = "Robert";
    String lName = "John";
    String email = "test90@example.com";
    String password = "123456";

    @Test
    public void userRegistration() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration(fName, lName, email, password);

        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }
}