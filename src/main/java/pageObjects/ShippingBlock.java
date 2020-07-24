package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ShippingBlock extends ProceedToCheckout {

    public @FindBy(xpath = "//div[@id='uniform-cgv']")
    WebElement termsOfService;

    public @FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
    WebElement proceed_to_checkout;

    public ShippingBlock() throws IOException {
    }
}
