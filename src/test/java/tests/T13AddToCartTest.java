package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P06SearchPage;
import pages.P12ShoppingCartPage;

import static org.testng.Assert.assertTrue;

public class T13AddToCartTest extends TestBase {
    P06SearchPage searchObject;
    P12ShoppingCartPage shoppingCartObject;

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

    @Test(priority = 3)
    public void UserCanAddProductToShoppingCart() {
        shoppingCartObject = new P12ShoppingCartPage(driver);

        shoppingCartObject.addToCart();
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
        shoppingCartObject.UpdateProductQuantityInCart("5");

        assertTrue(driver.findElement(shoppingCartObject.totalLbl).getText().contains("9,000"));
    }

    @Test(priority = 4)
    public void UserCanRemoveProductToShoppingCart() {
        shoppingCartObject = new P12ShoppingCartPage(driver);

        shoppingCartObject.RemoveProductFromCart();

        assertTrue(driver.findElement(shoppingCartObject.emptyCartCheckout).getText()
                .equals("Your Shopping Cart is empty!"));
    }
}