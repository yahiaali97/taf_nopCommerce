package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P06SearchPage;

import static org.testng.Assert.assertTrue;

public class T06SearchWithAutoSuggestTest extends TestBase {
    P06SearchPage searchObject;

    @Test(priority = 1)
    public void refreshHomePage() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    } // Auto Suggest Search doesn't work at first test

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new P06SearchPage(driver);

        searchObject.ProductSearchUsingAutoSuggest("mac");

        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }
}