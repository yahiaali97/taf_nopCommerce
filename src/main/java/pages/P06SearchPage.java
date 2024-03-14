package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P06SearchPage extends PageBase {

    public P06SearchPage(WebDriver driver) {
        super(driver);
    }

    By searchTxtBox = By.id("small-searchterms");
    By searchBtn = By.xpath("//button[@class='button-1 search-box-button']");
    public By searchAssert = By.xpath("//img[@alt=\"Picture of Apple MacBook Pro 13-inch\"]");
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