package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class ProductsLogoPage extends BasePage{

    public @FindBy(xpath = "//span[text()='Add to cart']")
    List<WebElement> add_to_card;

    public @FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
    List<WebElement> fadedShortShortSleeve;


    public ProductsLogoPage() throws IOException {
        super();
    }


}
