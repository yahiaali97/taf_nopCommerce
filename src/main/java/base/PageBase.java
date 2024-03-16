package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;
    public JavascriptExecutor js;
    public Select select;
    public Actions action;

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void setTextElement(WebElement textElement, String value) {
        textElement.sendKeys(value);
    }

    protected static void clearText(WebElement clearText) {
        clearText.clear();
    }
}