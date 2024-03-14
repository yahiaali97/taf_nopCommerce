package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P09AddProductReviewPage extends PageBase {
    
    public P09AddProductReviewPage(WebDriver driver) {
        super(driver);
    }

    By addReviewLink = By.linkText("Add your review");
    By reviewTitle = By.id("AddProductReview_Title");
    By reviewText = By.id("AddProductReview_ReviewText");
    By reviewRate = By.id("addproductrating_4");
    By submitReviewBtn = By.cssSelector("button.button-1.write-product-review-button");
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