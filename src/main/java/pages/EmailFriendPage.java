package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailFriendPage extends PageBase {
    By emailFriendBtn = By.cssSelector("div.email-a-friend");
    By emailFriendTxt = By.id("FriendEmail");
    By yourEmailTxt = By.id("YourEmailAddress");
    By personalMsgTxt = By.id("PersonalMessage");
    By submitSentBtn = By.xpath("//button[@name=\"send-email\"]");

    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }


    public void sendEmailToFriend(String friendEmail, String yourEmail, String personalMsg) {
        clickButton(driver.findElement(emailFriendBtn));
        setTextElement(driver.findElement(emailFriendTxt), friendEmail);
        setTextElement(driver.findElement(yourEmailTxt), yourEmail);
        setTextElement(driver.findElement(personalMsgTxt), personalMsg);
        clickButton(driver.findElement(submitSentBtn));
    }
}