package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.BasePage;
import pageObjects.ContactUsPage;
import pageObjects.YourLogoMainPage;
import utils.DriverFactory;

public class SendMessageSteps extends DriverFactory {

    private YourLogoMainPage yourLogoMainPage = BasePage.init(YourLogoMainPage.class);
    private ContactUsPage contactUsPage = BasePage.init(ContactUsPage.class);

    @Given("^I click on contact us$")
    public void i_click_on_contact_us() {
        yourLogoMainPage.clickOnElementUsingCustomTimeout(yourLogoMainPage.contactUs, driver, 10);
    }

    @And("^I choose \"([^\"]*)\" from subject heading$")
    public void i_choose_from_subject_heading(String name) throws Throwable {
        contactUsPage.selectElementFromDropDown(contactUsPage.subjectHeading, name, driver, 10);
     }

    @And("^I enter email address$")
    public void i_enter_email_address() throws Throwable {
        contactUsPage.sendKeysToWebElement(contactUsPage.email, "ynazar1231@gmail.com");
    }

    @Given("^I enter message \"([^\"]*)\"$")
    public void i_enter_message(String message) throws Throwable {
        contactUsPage.sendKeysToWebElement(contactUsPage.message, message);
    }

    @Given("^I press send button$")
    public void i_press_send_button() throws Throwable {
        contactUsPage.clickOnElementUsingCustomTimeout(contactUsPage.submit,driver, 10);
    }

    @Then("^I see proper message \"([^\"]*)\"$")
    public void i_see_proper_message(String message) throws Throwable {
        Assert.assertEquals("Message status is not correct", message, contactUsPage.messageStatus.getText());
    }

}
