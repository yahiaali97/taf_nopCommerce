package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P04ContactUsPage;
import pages.P01HomePage;

import static org.testng.Assert.assertTrue;

public class T03ContactUsTest extends TestBase {
    P01HomePage homeObject;
    P04ContactUsPage contactUsObject;
    String name = "Jaden";
    String email = "jaden@example.com";
    String inquiry = "I can't add items to the cart";

    @Test
    public void OpenContactUsPage() {
        homeObject = new P01HomePage(driver);
        contactUsObject = new P04ContactUsPage(driver);
        homeObject.openContactPage();
        contactUsObject.fillContactUsForm(name, email, inquiry);
        assertTrue(driver.findElement(contactUsObject.submitMsg).getText()
                .contains("Your enquiry has been successfully sent"));
    }
}