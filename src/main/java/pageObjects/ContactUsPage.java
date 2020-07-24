package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ContactUsPage extends BasePage{

    public @FindBy(xpath = "//div[@id='uniform-id_contact']")
    WebElement subjectHeading;

    public @FindBy(id = "email")
    WebElement email;

    public @FindBy(id = "message")
    WebElement message;

    public @FindBy(xpath = "//button[@type='submit' and @name='submitMessage']")
    WebElement submit;

    public @FindBy(xpath = "//div[@id='center_column']/p")
    WebElement messageStatus;

    public ContactUsPage() throws IOException {
        super();
    }
}
