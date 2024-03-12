package register;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

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
                "XCompany",
                "123456",
                "123456");
    }
}