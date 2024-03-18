package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_ProductSearch extends PageBase {

    public P03_ProductSearch(WebDriver driver) {
        super(driver);
    }

    private final By searchTxtBox = By.id("small-searchterms");
    private final By searchBtn = By.xpath("//button[@class='button-1 search-box-button']");
    public By searchAssert = By.xpath("//img[@alt='Picture of Apple MacBook Pro 13-inch']");
    public By assertAutoSuggestSearch = By.cssSelector("strong.current-item");
    public List<WebElement> optionElements = driver.findElements(By.id("ui-id-1"));

    public void productSearch(String searchBarBox) {
        setTextElement(driver.findElement(searchTxtBox), searchBarBox);
        clickButton(driver.findElement(searchBtn));
    }

    public void ProductSearchUsingAutoSuggest(String searchTxt) {
        setTextElement(driver.findElement(searchTxtBox), searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        optionElements.get(0).click();
    }
}