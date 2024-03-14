package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.SearchPage;

import static org.testng.Assert.assertTrue;

public class SearchTest extends TestBase {

    SearchPage searchObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test
    public void userCanSearchForProduct() {
        searchObject = new SearchPage(driver);

        searchObject.productSearch(productName);

        assertTrue(driver.findElement(searchObject.productTitle).isDisplayed());
    }
}