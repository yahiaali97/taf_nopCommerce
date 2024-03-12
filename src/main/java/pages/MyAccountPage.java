package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {
    By changePassword = By.xpath("//a[@href=\"/customer/changepassword\"]");
    By oldPassword = By.id("OldPassword");
    By newPassword = By.id("NewPassword");
    By confirmNewPassword = By.id("ConfirmNewPassword");
    By submitChangePasswordBtn = By.xpath("//button[@class='button-1 change-password-button']");
    By closeConfirmationMsg = By.xpath("//span[@class='close']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void ChangePassword(String oldPass, String newPass) {
        clickButton(driver.findElement(changePassword));
        setTextElement(driver.findElement(oldPassword), oldPass);
        setTextElement(driver.findElement(newPassword), newPass);
        setTextElement(driver.findElement(confirmNewPassword), newPass);
        clickButton(driver.findElement(submitChangePasswordBtn));
        clickButton(driver.findElement(closeConfirmationMsg));
    }
}
