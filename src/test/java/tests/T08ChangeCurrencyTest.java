package tests;

import base.TestBase;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import pages.P01HomePage;
import pages.P06SearchPage;
import pages.P07ProductDetailsPage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class T08ChangeCurrencyTest extends TestBase {
    P01HomePage homeObject;
    P06SearchPage searchObject;
    P07ProductDetailsPage detailsObject;

    @Test(priority = 1)
    public void userCanChangeCurrency() {
        homeObject = new P01HomePage(driver);
        homeObject.changeCurrency();
    }

    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest() {
        searchObject = new P06SearchPage(driver);
        detailsObject = new P07ProductDetailsPage(driver);
        searchObject.ProductSearchUsingAutoSuggest("mac");

        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    driver.findElement(detailsObject.productPriceLbl).isDisplayed();
                    return true;
                });

        System.out.println(driver.findElement(detailsObject.productPriceLbl).getText());
        assertTrue(driver.findElement(detailsObject.productPriceLbl).getText()
                .contains("€"));
    }
}