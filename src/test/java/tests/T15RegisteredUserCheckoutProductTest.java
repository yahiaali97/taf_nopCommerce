package tests;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class T15RegisteredUserCheckoutProductTest extends TestBase {

    P01HomePage homeObject;
    P02RegistrationPage registerObject;
    P03LoginPage loginObject;
    P06SearchPage searchObject;
    P13CheckoutPage checkoutObject;
    P14OrderDetailsPage orderDetailsObject;
    P12ShoppingCartPage shoppingCartObject;
    String fName = "Robert";
    String lName = "John";
    String email = "test126@example.com";
    String password = "123456";
    String billingFirstName = "";
    String billingLastName = "";
    String billingEmail = "";
    String billingCountry = "Egypt";
    String billingCity = "Giza";
    String billingAddress1 = "Giza";
    String billingPostalCode = "12568";
    String billingPhoneNumber = "0100000000";

    @Test(priority = 1, alwaysRun = true)
    public void UserRegister() {
        homeObject = new P01HomePage(driver);
        registerObject = new P02RegistrationPage(driver);

        homeObject.openRegisterPage();
        registerObject.userRegistration(fName, lName, email, password);
    }

    @Test(priority = 2)
    public void UserLogin() {
        loginObject = new P03LoginPage(driver);

        homeObject.openLoginPage();
        loginObject.userLogin(email, password);

        assertTrue(driver.findElement(registerObject.logoutLink).isDisplayed());
    }

    @Test(priority = 3)
    public void SearchForProduct() {
        searchObject = new P06SearchPage(driver);

        searchObject.ProductSearchUsingAutoSuggest("mac");

        assertTrue(driver.findElement(searchObject.assertAutoSuggestSearch).getText()
                .contains("Apple MacBook Pro"));
    }

    @Test(priority = 4)
    public void AddProductToShoppingCart() {
        shoppingCartObject = new P12ShoppingCartPage(driver);

        shoppingCartObject.addToCart();
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
    }

    @Test(priority = 5)
    public void checkoutAsRegisteredUser() throws InterruptedException {
        checkoutObject = new P13CheckoutPage(driver);
        orderDetailsObject = new P14OrderDetailsPage(driver);

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(checkoutObject.agreeCheckbox).isDisplayed());
        checkoutObject.openCheckoutPage();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(checkoutObject.continueBtn).isDisplayed());
        checkoutObject.fillBillingForm(billingFirstName,
                billingLastName,
                billingEmail,
                billingCountry,
                billingCity,
                billingAddress1,
                billingPostalCode,
                billingPhoneNumber);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(orderDetailsObject.orderDetailsLink).isDisplayed());
        orderDetailsObject.switchToOrderDetails();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(orderDetailsObject.pdfInvoiceLink).isDisplayed());
        orderDetailsObject.DownloadPDFInvoice();
    }
}