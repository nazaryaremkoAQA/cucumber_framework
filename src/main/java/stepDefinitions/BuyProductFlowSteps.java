package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.DriverFactory;

public class BuyProductFlowSteps extends DriverFactory {

    private YourLogoMainPage yourLogoMainPage = BasePage.init(YourLogoMainPage.class);
    private LoginPage loginPage = BasePage.init(LoginPage.class);
    private ProductsLogoPage productsLogoPage = BasePage.init(ProductsLogoPage.class);
    private BucketBlock bucketBlock = BasePage.init(BucketBlock.class);
    private SummaryBlock summaryBlock = BasePage.init(SummaryBlock.class);
    private AddressBlock addressBlock = BasePage.init(AddressBlock.class);
    private ShippingBlock shippingBlock = BasePage.init(ShippingBlock.class);
    private PaymentBlock paymentBlock = BasePage.init(PaymentBlock.class);

    @Given("^I access yourlogo website$")
    public void i_access_yourlogo_website() throws Throwable {
        driver.navigate().to("http://automationpractice.com/");
    }

    @When("^I sign in to the website$")
    public void i_sign_in_to_the_website(DataTable dt) throws Throwable {
        yourLogoMainPage.clickOnElementUsingCustomTimeout(yourLogoMainPage.signIn, driver, 10);
        loginPage.sendKeysToWebElement(loginPage.email, dt.raw().get(0).get(0));
        loginPage.sendKeysToWebElement(loginPage.password, dt.raw().get(0).get(1));
        loginPage.clickOnElementUsingCustomTimeout(loginPage.submit, driver, 10);
    }

    @When("^I click on t-shirt$")
    public void i_click_on_t_shirt() throws Throwable {
        yourLogoMainPage.clickOnElementUsingCustomTimeout(yourLogoMainPage.tShirt.get(1), driver, 10);
    }

    @When("^I click on add to card$")
    public void i_click_on_add_card() throws Throwable {
        productsLogoPage.scrollToElementByWebElementLocator(driver.findElement(By.xpath("//span[@class='available-now']")));
        productsLogoPage.hoverOnWebElement(productsLogoPage.fadedShortShortSleeve.get(0), driver, 10);
        productsLogoPage.clickOnElementUsingCustomTimeout(productsLogoPage.add_to_card.get(0), driver, 10);
    }

    @Given("^I click on proceed to checkout in bucket block$")
    public void i_click_on_proceed_to_checkout_in_bucket_block() throws Throwable {
         bucketBlock.clickOnElementUsingCustomTimeout(bucketBlock.proceed, driver, 10);
     }

    @Given("^I click on proceed to checkout in summary block$")
    public void i_click_on_proceed_to_checkout_in_summary_block()   {
        summaryBlock.clickOnElementUsingCustomTimeout(summaryBlock.proceedToCheckout, driver, 10);
    }

    @Given("^I click on proceed to checkout in address block$")
    public void i_click_on_proceed_to_checkout_in_address_block()   {
        addressBlock.clickOnElementUsingCustomTimeout(addressBlock.proceedToCheckout, driver, 10);
    }

    @Given("^I agree with term of service$")
    public void i_agree_with_term_of_service() throws Throwable {
        shippingBlock.waitElementIsVisible(shippingBlock.termsOfService, 10);
        shippingBlock.termsOfService.click();
    }

    @Given("^I click on proceed to checkout in shipping block$")
    public void i_click_on_proceed_to_checkout_in_shipping_block()   {
        shippingBlock.clickOnElementUsingCustomTimeout(shippingBlock.proceed_to_checkout, driver, 10);
    }

    @Given("^I choose pay by bank wire$")
    public void i_choose_pay_by_bank_wire() throws Throwable {
        paymentBlock.clickOnElementUsingCustomTimeout(paymentBlock.payByBank, driver, 10);
    }

    @Given("^I confirm my order$")
    public void i_confirm_my_order() throws Throwable {
        paymentBlock.clickOnElementUsingCustomTimeout(paymentBlock.confirm, driver, 10);

    }

    @Then("^I check if price is \"([^\"]*)\"$")
    public void i_check_if_price_is(String price) throws Throwable {
        Assert.assertEquals("Price is wrong", price, paymentBlock.price.getText());
     }

}
