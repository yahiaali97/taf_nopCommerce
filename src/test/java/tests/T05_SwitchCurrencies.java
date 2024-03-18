package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P05_SwitchCurrencies;

public class T05_SwitchCurrencies extends TestBase {
    P05_SwitchCurrencies switchCurrenciesObject;

    @Test
    public void userCanChangeCurrency() throws InterruptedException {
        switchCurrenciesObject = new P05_SwitchCurrencies(driver);
        switchCurrenciesObject.getCurrencyList();
        Thread.sleep(500);
    }
}