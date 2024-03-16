package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P12ShoppingCartPage extends PageBase {
    public P12ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By addToCartBtn = By.id("add-to-cart-button-4");
    By removeItemBtn = By.cssSelector("button.remove-btn");
    By updateCartBtn = By.id("updatecart");
    By quantityTxt = By.cssSelector("input.qty-input");
    public By totalLbl = By.cssSelector("td.subtotal");
    public By emptyCartCheckout = By.cssSelector("div.no-data");

    public void addToCart() {
        clickButton(driver.findElement(addToCartBtn));
    }

    public void UpdateProductQuantityInCart(String quantity) {
        clearText(driver.findElement(quantityTxt));
        setTextElement(driver.findElement(quantityTxt), quantity);
        clickButton(driver.findElement(updateCartBtn));
    }

    public void RemoveProductFromCart() {
        clickButton(driver.findElement(removeItemBtn));
    }
}