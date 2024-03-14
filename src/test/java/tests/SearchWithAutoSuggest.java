package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchWithAutoSuggest extends TestBase {
    HomePage homeObject;
    SearchPage searchObject;

    @Test
    public void UserSearchWithAutoSuggest() {
        homeObject = new HomePage(driver);
        searchObject = new SearchPage(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
    }
}