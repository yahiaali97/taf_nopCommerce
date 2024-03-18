package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P11_AddProductReview extends PageBase {

    public P11_AddProductReview(WebDriver driver) {
        super(driver);
    }

    private final By addReviewLink = By.linkText("Add your review");
    private final By reviewTitle = By.id("AddProductReview_Title");
    private final By reviewText = By.id("AddProductReview_ReviewText");
    private final By reviewRate = By.id("addproductrating_4");
    private final By submitReviewBtn = By.cssSelector("button.button-1.write-product-review-button");
    public By submissionResultMsg = By.cssSelector("div.result");

    public void openReviewPage() {
        clickButton(driver.findElement(addReviewLink));
    }

    public void fillReviewForm(String revTitle, String revText) {
        setTextElement(driver.findElement(reviewTitle), revTitle);
        setTextElement(driver.findElement(reviewText), revText);
        clickButton(driver.findElement(reviewRate));
        clickButton(driver.findElement(submitReviewBtn));
    }
}