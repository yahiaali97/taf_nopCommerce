package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ContactUsTest extends TestBase {
    HomePage homeObject;
    ContactUsPage contactUsObject;
    String name = "Jaden";
    String email = "jaden@example.com";
    String inquiry = "I can't add items to the cart";


    @Test
    public void OpenContactUsPage() {
        homeObject = new HomePage(driver);
        contactUsObject = new ContactUsPage(driver);
        homeObject.openContactPage();
        contactUsObject.fillContactUsForm(name, email, inquiry);
        assertTrue(driver.findElement(contactUsObject.submitMsg)
                .getText()
                .contains("Your enquiry has been successfully sent"));
    }
}