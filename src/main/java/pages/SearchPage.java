package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase {
    By searchTxtBox = By.id("small-searchterms");
    By searchBtn = By.xpath("//button[@class='button-1 search-box-button']");
    public By productTitle = By.cssSelector("h2.product-title");


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void productSearch(String searchBarBox) {
        setTextElement(driver.findElement(searchTxtBox), searchBarBox);
        clickButton(driver.findElement(searchBtn));
    }
}