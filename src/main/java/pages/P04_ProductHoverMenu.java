package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class P04_ProductHoverMenu extends PageBase {
    public P04_ProductHoverMenu(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    private final By computerMenu = By.linkText("Computers");
    private final By notebooksMenu = By.linkText("Notebooks");

    public void selectNotebooksByHoverMenu() {
        action.moveToElement(driver.findElement(computerMenu)).perform();
        action.click(driver.findElement(notebooksMenu)).perform();
    }
}
