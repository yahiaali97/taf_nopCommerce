package login;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

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
}