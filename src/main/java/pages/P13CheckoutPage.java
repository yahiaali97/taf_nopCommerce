package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P13CheckoutPage extends PageBase {
    public P13CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public By agreeCheckbox = By.id("termsofservice");
    public By checkoutBtn = By.id("checkout");
    By guestCheckoutBtn = By.xpath("//button[@class='button-1 checkout-as-guest-button']");
    By billingFirstName = By.id("BillingNewAddress_FirstName");
    By billingLastName = By.id("BillingNewAddress_LastName");
    By billingEmail = By.id("BillingNewAddress_Email");
    By billingCountry = By.id("BillingNewAddress_CountryId");
    By billingCity = By.id("BillingNewAddress_City");
    By billingAddress1 = By.id("BillingNewAddress_Address1");
    By billingPostalCode = By.id("BillingNewAddress_ZipPostalCode");
    By billingPhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    public By continueBtn = By.xpath("//button[@class='button-1 new-address-next-step-button' and @name='save']");
    By ConfirmShippingCheckoutBtn = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    By ConfirmPaymentMethodBtn = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    By ConfirmPaymentInfoBtn = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    By ConfirmOrderBtn = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");

    public void openCheckoutPage() {
        clickButton(driver.findElement(agreeCheckbox));
        clickButton(driver.findElement(checkoutBtn));
    }

    public void checkoutAsGuest() {
        clickButton(driver.findElement(guestCheckoutBtn));
    }

    public void fillBillingForm(String fName, String lName, String email, String country, String city, String address1, String postalCode, String phoneNumber) {
        setTextElement(driver.findElement(billingFirstName), fName);
        setTextElement(driver.findElement(billingLastName), lName);
        setTextElement(driver.findElement(billingEmail), email);
        setTextElement(driver.findElement(billingCountry), country);
        setTextElement(driver.findElement(billingCity), city);
        setTextElement(driver.findElement(billingAddress1), address1);
        setTextElement(driver.findElement(billingPostalCode), postalCode);
        setTextElement(driver.findElement(billingPhoneNumber), phoneNumber);
        clickButton(driver.findElement(continueBtn));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(ConfirmShippingCheckoutBtn).isDisplayed());
        clickButton(driver.findElement(ConfirmShippingCheckoutBtn));

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(ConfirmPaymentMethodBtn).isDisplayed());
        clickButton(driver.findElement(ConfirmPaymentMethodBtn));

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(ConfirmPaymentInfoBtn).isDisplayed());
        clickButton(driver.findElement(ConfirmPaymentInfoBtn));

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(ConfirmOrderBtn).isDisplayed());
        clickButton(driver.findElement(ConfirmOrderBtn));
    }
}