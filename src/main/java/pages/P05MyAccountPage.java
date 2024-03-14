package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05MyAccountPage extends PageBase {
    public P05MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public By myAccountLink = By.linkText("My account");
    public By changePWLink = By.xpath("//a[@href=\"/customer/changepassword\"]");
    By oldPW = By.id("OldPassword");
    By newPW = By.id("NewPassword");
    By confirmNewPW = By.id("ConfirmNewPassword");
    By changePWBtn = By.xpath("//button[@class='button-1 change-password-button']");
    By confirmLbl = By.xpath("//span[@class='close']");

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
