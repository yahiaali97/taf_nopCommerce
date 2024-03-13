package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.SearchProductPage;

import static org.testng.Assert.assertTrue;

public class SearchProductTest extends TestBase {

    SearchProductPage searchProductObject;
    String searchBarTxt = "Apple iCam";

    @Test
    public void searchForProduct() {
        searchProductObject = new SearchProductPage(driver);
        searchProductObject.setSearchBar(searchBarTxt);
        assertTrue(driver.findElement(searchProductObject.itmSearched).isDisplayed());
    }
}
