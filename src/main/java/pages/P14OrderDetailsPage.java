package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P14OrderDetailsPage extends PageBase {
    public P14OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public By orderDetailsLink = By.linkText("Click here for order details.");
    By printInvoiceLink = By.xpath("//a[@class='button-2 print-order-button']");
    public By pdfInvoiceLink = By.xpath("//a[@class='button-2 pdf-invoice-button']");

    public void switchToOrderDetails() {
        clickButton(driver.findElement(orderDetailsLink));
    }

    public void PrintOrderDetails() {
        clickButton(driver.findElement(printInvoiceLink));
    }

    public void DownloadPDFInvoice() {
        clickButton(driver.findElement(pdfInvoiceLink));
    }
}
