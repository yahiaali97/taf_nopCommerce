package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.P01_Registration;

import static org.testng.Assert.assertTrue;

public class T01_Registration extends TestBase {

    P01_Registration registerObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().firstName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8);

    @Test
    public void userRegistration() {
        registerObject = new P01_Registration(driver);
        registerObject.openRegisterPage();
        registerObject.userRegistration(firstname, lastname, email, password);
        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }
}