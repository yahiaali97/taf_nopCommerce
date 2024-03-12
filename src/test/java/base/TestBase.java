package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com");
    }

    @AfterClass(enabled = false)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}