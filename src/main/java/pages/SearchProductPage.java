package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage extends PageBase {
    By searchBar = By.id("small-searchterms");
    By searchBtn = By.xpath("//button[@class='button-1 search-box-button']");
    public By itmSearched = By.xpath("//img[@alt=\"Picture of Apple iCam\"]");

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    public void setSearchBar(String searchBarBox) {
        setTextElement(driver.findElement(searchBar), searchBarBox);
        clickButton(driver.findElement(searchBtn));
    }
}
