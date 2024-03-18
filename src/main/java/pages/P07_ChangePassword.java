package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_ChangePassword extends PageBase {

    public P07_ChangePassword(WebDriver driver) {
        super(driver);
    }

    public By myAccountLink = By.linkText("My account");
    public By changePWLink = By.xpath("//a[@href='/customer/changepassword']");
    private final By oldPW = By.id("OldPassword");
    private final By newPW = By.id("NewPassword");
    private final By confirmNewPW = By.id("ConfirmNewPassword");
    private final By changePWBtn = By.xpath("//button[@class='button-1 change-password-button']");
    private final By confirmLbl = By.xpath("//span[@class='close']");

    public void OpenMyAccountPage() {
        clickButton(driver.findElement(myAccountLink));
    }

    public void openChangePWPage() {
        clickButton(driver.findElement(changePWLink));
    }

    public void ChangePassword(String oldPass, String newPass) {
        setTextElement(driver.findElement(oldPW), oldPass);
        setTextElement(driver.findElement(newPW), newPass);
        setTextElement(driver.findElement(confirmNewPW), newPass);
        clickButton(driver.findElement(changePWBtn));
        clickButton(driver.findElement(confirmLbl));
    }
}
