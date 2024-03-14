package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07ProductDetailsPage extends PageBase {
    public P07ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public By productPriceLbl = By.cssSelector("span.price-value-4");
}