package login;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {
    HomePage homeObject;
    LoginPage loginObject;

    @Test
    public void userLogin() {
        homeObject = new HomePage(driver);
        homeObject.OpenLoginPage();

        loginObject = new LoginPage(driver);
        loginObject.userLogin("yahyaali@example.com", "123456");
    }

    @Test(dependsOnMethods = {"userLogin"}, enabled = false)
    public void SignIndUserCanLogout() {
        loginObject = new LoginPage(driver);

        WebElement logoutButton = driver.findElement(loginObject.Logout);
        boolean isLogoutButtonDisplayed = logoutButton.isDisplayed();
        System.out.println("Is Log out button displayed? " + isLogoutButtonDisplayed);
        assertTrue(isLogoutButtonDisplayed);

        loginObject.logoutBtn();
    }
}