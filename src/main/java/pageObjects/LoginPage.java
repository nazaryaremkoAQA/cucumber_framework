package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends BasePage{

    public @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    public @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;

    public @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement submit;

    public LoginPage() throws IOException {
        super();
    }


}
