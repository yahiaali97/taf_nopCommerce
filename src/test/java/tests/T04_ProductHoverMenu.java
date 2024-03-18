package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P04_ProductHoverMenu;

import static org.testng.Assert.assertTrue;

public class T04_ProductHoverMenu extends TestBase {
    P04_ProductHoverMenu hoverMenuObject;

    @Test
    public void userCanChooseProductUsingHoverMenu() {
        hoverMenuObject = new P04_ProductHoverMenu(driver);
        hoverMenuObject.selectNotebooksByHoverMenu();
        assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}