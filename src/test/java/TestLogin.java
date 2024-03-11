import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestLogin extends TestBase{
    @Test
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.loginValidUser("yahya", "255yahya");
        Thread.sleep(5000);
        //assertThat(homePage.getMessageText(), is("Hello userName"));
    }
}