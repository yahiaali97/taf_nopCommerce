package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {
    public By productPriceLbl = By.cssSelector("span.price-value-4");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
}