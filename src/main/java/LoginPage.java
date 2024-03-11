import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        if (!"nopCommerce demo store. Login".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the LoginPage page");
        }
    }

    By usernameLocator = By.id("Email");
    By passwordLocator = By.id("Password");
    By loginButtonLocator = By.xpath("//button[@class='button-1 login-button']");

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }

    public LoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver);
    }

    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    public HomePage loginValidUser(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}