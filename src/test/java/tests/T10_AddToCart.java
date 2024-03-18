package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P03_ProductSearch;
import pages.P10_AddToCart;

import static org.testng.Assert.assertTrue;

public class T10_AddToCart extends TestBase {
    P03_ProductSearch searchObject;
    P10_AddToCart shoppingCartObject;

    @Test(priority = 1)
    public void refreshHomePage() {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new P03_ProductSearch(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");
        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 3)
    public void UserCanAddProductToShoppingCart() {
        shoppingCartObject = new P10_AddToCart(driver);
        shoppingCartObject.addToCart();
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
        shoppingCartObject.UpdateProductQuantityInCart("5");
        assertTrue(driver.findElement(shoppingCartObject.totalLbl).getText().contains("9,000"));
    }

    @Test(priority = 4)
    public void UserCanRemoveProductToShoppingCart() {
        shoppingCartObject = new P10_AddToCart(driver);
        shoppingCartObject.RemoveProductFromCart();
        assertTrue(driver.findElement(shoppingCartObject.emptyCartCheckout).getText()
                .equals("Your Shopping Cart is empty!"));
    }
}