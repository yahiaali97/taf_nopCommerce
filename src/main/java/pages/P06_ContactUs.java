package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ContactUs extends PageBase {

    public P06_ContactUs(WebDriver driver) {
        super(driver);
    }

    private final By name = By.id("FullName");
    private final By email = By.id("Email");
    private final By inquiry = By.id("Enquiry");
    private final By submitBtn = By.xpath("//button[@name='send-email']");
    public By submitMsg = By.cssSelector("div.result");

    public void fillContactUsForm(String setName, String setEmail, String setInquiry) {
        setTextElement(driver.findElement(name), setName);
        setTextElement(driver.findElement(email), setEmail);
        setTextElement(driver.findElement(inquiry), setInquiry);
    }

    public void submitForm() {
        clickButton(driver.findElement(submitBtn));
    }
}