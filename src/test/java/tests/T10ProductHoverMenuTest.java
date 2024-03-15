package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.P01HomePage;

import static org.testng.Assert.assertTrue;

public class T10ProductHoverMenuTest extends TestBase {
    P01HomePage homeObject;

    @Test
    public void userCanChooseProductUsingHoverMenu() {
        homeObject = new P01HomePage(driver);

        homeObject.selectNotebooksMenu();

        assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}
