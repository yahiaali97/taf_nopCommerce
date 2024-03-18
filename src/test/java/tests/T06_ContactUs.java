package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P06_ContactUs;

import static org.testng.Assert.assertTrue;

public class T06_ContactUs extends TestBase {
    P06_ContactUs contactUsObject;
    String name = "robert";
    String email = "robert@example.com";
    String inquiry = "I can't add items to the cart";

    @Test
    public void OpenContactUsPage()  {
        contactUsObject = new P06_ContactUs(driver);
        contactUsObject.openContactPage();
        contactUsObject.fillContactUsForm(name, email, inquiry);
        contactUsObject.submitForm();
        assertTrue(driver.findElement(contactUsObject.submitMsg).getText()
                .contains("Your enquiry has been successfully sent"));
    }
}