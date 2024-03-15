package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P10WishlistPage extends PageBase {

    public P10WishlistPage(WebDriver driver) {
        super(driver);
    }

    public By addToWishlistBtn = By.id("add-to-wishlist-button-4");
    public By wishlistHeader = By.cssSelector("h1");
    public By productCell = By.cssSelector("a.product-name");
    public By productQty = By.cssSelector("input.qty-input");
    By updateWishlistBtn = By.id("updatecart");
    By removeFromCartCheck = By.cssSelector("button.remove-btn");
    public By emptyCartLbl = By.cssSelector("div.no-data");

    public void AddProductToWishlist() {
        clickButton(driver.findElement(addToWishlistBtn));
    }

    public void updateProductQty(String pQty) {
        clearText(driver.findElement(productQty));
        setTextElement(driver.findElement(productQty), pQty);
        clickButton(driver.findElement(updateWishlistBtn));
    }

    public void removeProductFromWishlist() {
        clickButton(driver.findElement(removeFromCartCheck));
    }
}