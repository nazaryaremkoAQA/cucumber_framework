package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class YourLogoMainPage extends BasePage{

    public @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signIn;
    public @FindBy(xpath = "//a[text()='Women']")
    WebElement women;

    public @FindBy(id = "contact-link")
    WebElement contactUs;

    public @FindBy(id = "contact-link")
    List<WebElement> tShirt;

    public YourLogoMainPage() throws IOException {
        super();
    }

}
