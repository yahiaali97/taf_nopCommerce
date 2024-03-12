package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {
    By changePassword = By.linkText("Change Password");
    By oldPassword = By.id("OldPassword");
    By newPassword = By.id("NewPassword");
    By ConfirmNewPassword = By.id("ConfirmNewPassword");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void OpenChangePasswordPage(String oldPass, String newPass) {
        clickButton(driver.findElement(changePassword));
        setTextElement(driver.findElement(oldPassword), oldPass);
        setTextElement(driver.findElement(newPassword), newPass);
        setTextElement(driver.findElement(ConfirmNewPassword), newPass);
    }
}
