package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P06SearchPage;
import pages.P11ComparePage;

import static org.testng.Assert.assertTrue;

public class T12AddProductToCompareTest_Error extends TestBase {
    P06SearchPage searchObject;
    P11ComparePage compareObject;
    String firstProduct = "Apple MacBook Pro 13-inch";
    String secondProduct = "Asus N551JK-XO076H Laptop";

    @Test(priority = 1)
    public void refreshHomePage() {
        driver.navigate().to(getBaseUrl());
    } // Auto Suggest Search doesn't work at first test

    @Test(priority = 2)
    public void userCanCompareProducts() {
        searchObject = new P06SearchPage(driver);
        compareObject = new P11ComparePage(driver);

        searchObject.ProductSearchUsingAutoSuggest(firstProduct);
        compareObject.addProductToCompare();
        waitForSomeTime();

        searchObject = new P06SearchPage(driver);
        compareObject = new P11ComparePage(driver);

        searchObject.ProductSearchUsingAutoSuggest(secondProduct);
        compareObject.addProductToCompare();
        waitForSomeTime();

        driver.navigate().to(getBaseUrl() + "/compareproducts");

        assertTrue(driver.findElement(compareObject.firstProductName).getText().contains("Apple"));
        assertTrue(driver.findElement(compareObject.secondProductName).getText().contains("Asus"));

        compareObject.compareProducts();
    }

    @Test(priority = 3)
    public void clearList() {
        searchObject = new P06SearchPage(driver);
        compareObject = new P11ComparePage(driver);

        compareObject.clearCompareTable();

        assertTrue(driver.findElement(compareObject.noDataLbl).getText()
                .contains("You have no items to compare"));
    }

    private void waitForSomeTime() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getBaseUrl() {
        return "http://demo.nopcommerce.com";
    }
}