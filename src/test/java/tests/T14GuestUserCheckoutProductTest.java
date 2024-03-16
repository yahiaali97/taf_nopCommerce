package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P06SearchPage;
import pages.P12ShoppingCartPage;
import pages.P13CheckoutPage;

import static org.testng.Assert.assertTrue;

public class T14GuestUserCheckoutProductTest extends TestBase {
    P06SearchPage searchObject;
    P12ShoppingCartPage shoppingCartObject;
    P13CheckoutPage checkoutObject;
    String billingFirstName = "ahmed";
    String billingLastName = "ahmed";
    String billingEmail = "ahmed@example.com";
    String billingCountry = "Egypt";
    String billingCity = "Giza";
    String billingAddress1 = "Giza";
    String billingPostalCode = "12568";
    String billingPhoneNumber = "0100000000";

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
    }

    @Test(priority = 4)
    public void checkoutAsGuest() throws InterruptedException {
        checkoutObject = new P13CheckoutPage(driver);

        checkoutObject.openCheckoutPage();
        checkoutObject.checkoutAsGuest();
        Thread.sleep(500);
        checkoutObject.fillBillingForm(billingFirstName,
                billingLastName,
                billingEmail,
                billingCountry,
                billingCity,
                billingAddress1,
                billingPostalCode,
                billingPhoneNumber);
    }
}