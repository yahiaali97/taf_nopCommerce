package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends TestBase {
    HomePage homeObject;
    RegistrationPage registerObject;
    String fName = "Robert";
    String lName = "John";
    String email = "test60@example.com";
    String password = "123456";

    @Test
    public void userRegistration() {
        homeObject = new HomePage(driver);
        homeObject.OpenRegisterPage();
        registerObject = new RegistrationPage(driver);
        registerObject.userRegistration(fName, lName, email, password);

        assertTrue(driver.findElement(registerObject.resultMsg).getText().contains("Your registration completed"));
    }
}