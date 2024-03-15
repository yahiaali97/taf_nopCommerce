package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P01HomePage;
import pages.P06SearchPage;

import static org.testng.Assert.assertTrue;

public class T06SearchWithAutoSuggest extends TestBase {
    P01HomePage homeObject;
    P06SearchPage searchObject;

    @Test
    public void UserSearchWithAutoSuggest() {
        homeObject = new P01HomePage(driver);
        searchObject = new P06SearchPage(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }
}