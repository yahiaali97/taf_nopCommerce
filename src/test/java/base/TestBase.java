package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utilities.Helper;

public class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com");
    }

    @AfterClass(enabled = false)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshotOnFailure(driver, result.getName());
        }
    }
}