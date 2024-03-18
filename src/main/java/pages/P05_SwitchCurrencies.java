package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class P05_SwitchCurrencies extends PageBase {
    public P05_SwitchCurrencies(WebDriver driver) {
        super(driver);
    }

    private final By currencyOptions = By.id("customerCurrency");

    public void getCurrencyList() {
        select = new Select(driver.findElement(currencyOptions));
        select.selectByIndex(1);
    }
}
