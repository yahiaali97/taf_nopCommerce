package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P06SearchPage;

import static org.testng.Assert.assertTrue;

public class T05SearchTest extends TestBase {

    P06SearchPage searchObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test
    public void userCanSearchForProduct() {
        searchObject = new P06SearchPage(driver);
        searchObject.productSearch(productName);
        assertTrue(driver.findElement(searchObject.searchAssert).isDisplayed());
    }
}