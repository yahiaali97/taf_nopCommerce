package myaccount;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountTests extends TestBase {

    HomePage homeObject;
    LoginPage loginObject;
    MyAccountPage myAccountPageObject;
    String oldPassword = "123456";
    String newPassword = "123456789";

    @Test
    public void userLogin() {
        homeObject = new HomePage(driver);
        homeObject.OpenLoginPage();

        loginObject = new LoginPage(driver);
        loginObject.userLogin("yahyaali@example.com", "123456");
    }
    @Test
    public void LoggedInUserCanChangePassword(){
        myAccountPageObject = new MyAccountPage(driver);
        myAccountPageObject.OpenChangePasswordPage(oldPassword,newPassword);
    }
}
