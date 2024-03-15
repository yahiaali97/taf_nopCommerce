package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P11ComparePage extends PageBase {

    public P11ComparePage(WebDriver driver) {
        super(driver);
    }

    By addToCompareBtn = By.cssSelector("button.button-2.add-to-compare-list-button\n");
    By compareTable = By.cssSelector("table.compare-products-table");
    public List<WebElement> allRows = driver.findElements(By.tagName("tr"));
    public List<WebElement> allCols = driver.findElements(By.tagName("td"));
    By clearListBtn = By.cssSelector("a.clear-list");
    public By noDataLbl = By.cssSelector("div.no-data");
    public By firstProductName = By.linkText("Apple MacBook Pro 13-inch");
    public By secondProductName = By.linkText("Asus N551JK-XO076H Laptop");

    public void compareProducts() {
        System.out.println("Number of rows: " + allRows.size());
        for (WebElement row : allRows) {
            System.out.println(row.getText() + "\t");
            for (WebElement col : allCols) {
                System.out.println(col.getText() + "\t");
            }
        }
    }

    public void addProductToCompare() {
        clickButton(driver.findElement(addToCompareBtn));
    }

    public void clearCompareTable() {
        clickButton(driver.findElement(clearListBtn));
    }
}