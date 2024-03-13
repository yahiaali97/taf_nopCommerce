package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.SearchPage;

import static org.testng.Assert.assertTrue;

public class SearchProductUsingAutoSuggestTest extends TestBase {
    SearchPage searchObject;

    @Test
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new SearchPage(driver);

        searchObject.ProductSearchUsingAutoSuggest("app");

        assertTrue(driver.findElement(searchObject.productTitle).isDisplayed());
    }
}