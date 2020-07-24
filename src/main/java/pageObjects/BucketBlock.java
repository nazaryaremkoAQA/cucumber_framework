package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class BucketBlock extends BasePage{

    public @FindBy(xpath = "//span[contains(text(),'Proceed')]")
    WebElement proceed;

    public BucketBlock() throws IOException {
        super();
    }
}
