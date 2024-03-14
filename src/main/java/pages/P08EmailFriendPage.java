package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08EmailFriendPage extends PageBase {

    public P08EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    By emailFriendBtn = By.cssSelector("div.email-a-friend");
    By emailFriendTxt = By.id("FriendEmail");
    By personalMsgTxt = By.id("PersonalMessage");
    By submitSentBtn = By.xpath("//button[@name=\"send-email\"]");
    public By ConfirmationMsg = By.cssSelector("div.result");

    public void sendEmailToFriend(String friendEmail, String personalMsg) {
        clickButton(driver.findElement(emailFriendBtn));
        setTextElement(driver.findElement(emailFriendTxt), friendEmail);
        setTextElement(driver.findElement(personalMsgTxt), personalMsg);
        clickButton(driver.findElement(submitSentBtn));
    }
}