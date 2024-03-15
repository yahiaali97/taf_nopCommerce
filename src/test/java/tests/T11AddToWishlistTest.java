package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P06SearchPage;
import pages.P10WishlistPage;

import static org.testng.Assert.assertTrue;

public class T11AddToWishlistTest extends TestBase {
    P06SearchPage searchObject;
    P10WishlistPage wishlistObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void goToHomeAgainFirst() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    } // Auto Suggest Search doesn't work at first test

    @Test(priority = 2)
    public void UserSearchWithAutoSuggest() {
        searchObject = new P06SearchPage(driver);

        searchObject.ProductSearchUsingAutoSuggest("apple mac");

        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 3)
    public void userCanAddProductToWishlist() {
        wishlistObject = new P10WishlistPage(driver);

        wishlistObject.AddProductToWishlist();

        driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
        assertTrue(driver.findElement(wishlistObject.wishlistHeader).isDisplayed());
        assertTrue(driver.findElement(wishlistObject.productCell).getText()
                .contains(productName));
    }

    @Test(priority = 4)
    public void userCanUpdateQtyOfProductInWishlist() {
        wishlistObject.updateProductQty("5");
        //assertEquals(driver.findElement(wishlistObject.productQty).getText(),"5");
    }

    @Test(priority = 5)
    public void userCanRemoveProductFromWishlist() {
        wishlistObject.removeProductFromWishlist();

        assertTrue(driver.findElement(wishlistObject.emptyCartLbl).getText()
                .contains("The wishlist is empty"));
    }
}