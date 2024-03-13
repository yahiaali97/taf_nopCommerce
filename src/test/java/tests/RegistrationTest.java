package tests;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends TestBase {
    HomePage homeObject;
    RegistrationPage registerObject;

    @Test
    public void userRegistration() {
        homeObject = new HomePage(driver);
        homeObject.OpenRegisterPage();
        registerObject = new RegistrationPage(driver);
        registerObject.userRegistration("Yahya", "Ali", "test60@example.com", "123456");

        assertTrue(driver.findElement(registerObject.resultMsg).isDisplayed(), "Successfully Registration");
    }
}