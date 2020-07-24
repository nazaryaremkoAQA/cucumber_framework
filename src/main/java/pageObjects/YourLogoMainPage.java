package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class YourLogoMainPage extends BasePage{

    public @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signIn;
    public @FindBy(xpath = "//a[text()='Women']")
    WebElement women;

    public @FindBy(xpath = "//a[text()='T-shirts']")
    List<WebElement> tShirt;

    public YourLogoMainPage() throws IOException {
        super();
    }

}
