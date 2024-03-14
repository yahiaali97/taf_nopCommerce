package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04ContactUsPage extends PageBase {
    By name = By.id("FullName");
    By email = By.id("Email");
    By inquiry = By.id("Enquiry");
    By submitBtn = By.xpath("//button[@type=\"submit\"]");
    public By submitMsg = By.cssSelector("div.result");

    public P04ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactUsForm(String setName, String setEmail, String setInquiry) {
        setTextElement(driver.findElement(name), setName);
        setTextElement(driver.findElement(email), setEmail);
        setTextElement(driver.findElement(inquiry), setInquiry);
        clickButton(driver.findElement(submitBtn));
    }
}
