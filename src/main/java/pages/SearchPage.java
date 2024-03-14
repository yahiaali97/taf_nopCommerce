package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends PageBase {
    By searchTxtBox = By.id("small-searchterms");
    By searchBtn = By.xpath("//button[@class='button-1 search-box-button']");
    public By searchAssert = By.cssSelector("h1.product-name");
    public List<WebElement> optionElements = driver.findElements(By.id("ui-id-1"));

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void productSearch(String searchBarBox) {
        setTextElement(driver.findElement(searchTxtBox), searchBarBox);
        clickButton(driver.findElement(searchBtn));
    }

    public void ProductSearchUsingAutoSuggest(String searchTxt) {
        setTextElement(driver.findElement(searchTxtBox), searchTxt);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        optionElements.get(0).click();
    }
}