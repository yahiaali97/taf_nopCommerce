package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P03_ProductSearch;

import static org.testng.Assert.assertTrue;

public class T03_ProductSearch extends TestBase {

    pages.P03_ProductSearch searchObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void userCanSearchForProduct() {
        searchObject = new pages.P03_ProductSearch(driver);
        searchObject.productSearch(productName);
        assertTrue(driver.findElement(searchObject.searchAssert).isDisplayed());
    }

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new P03_ProductSearch(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }
}