package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    protected WebDriver driver;
    public JavascriptExecutor js;
    public Select select;
    public Actions actions;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void setTextElement(WebElement textElement, String value) {
        textElement.sendKeys(value);
    }
}