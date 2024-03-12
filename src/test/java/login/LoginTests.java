package login;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {
    HomePage homeObject;
    LoginPage loginObject;
    RegistrationPage registrationPage;

    @Test
    public void userLogin() {
        homeObject = new HomePage(driver);
        homeObject.OpenLoginPage();

        loginObject = new LoginPage(driver);
        loginObject.userLogin("testtest1239@example.com", "123456789");

        WebElement logoutElement = driver.findElement(registrationPage.LogoutLink);
        assertTrue(logoutElement.isDisplayed(), "Logout link is displayed after login");
    }
}