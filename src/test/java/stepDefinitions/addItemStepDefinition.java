
package stepDefinitions;

import Utilities.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class addItemStepDefinition extends TestBase{

    static homePage home;
    static womenPage women;
    static fadedShortsPage fadedShorts;
    static cartSummaryPage cartSummary;
    static addressPage address;
    static shippingPage shipping;
    static paymentPage payment;
    static orderSummaryPage orderSummary;
    static orderConfirmationPage orderConfirm;

    @When("user clicks on Women tab")
    public void user_clicks_on_women_tab() {
        home = new homePage(driver);
        home.clickOnWomen();
    }
    @Then("user is navigated to the Women's page")
    public void user_is_navigated_to_the_women_s_page() {
        women = new womenPage(driver);
        women.verifyThatUserIsOnWomenPage();
    }

    @When("the user adds an item and checks out")
    public void the_user_adds_an_item_and_checks_out() throws InterruptedException {

        women.addItem();
        fadedShorts = new fadedShortsPage(driver);
        fadedShorts.verifyThatUserIsOnFadedShortsPage();
        fadedShorts.addItemAndCheckout();
        cartSummary = new cartSummaryPage(driver);
        cartSummary.verifyThatUserIsOnCartSummaryPage();
        cartSummary.summaryCheckout();
        address = new addressPage(driver);
        address.verifyThatUserIsOnAddressPage();
        address.addressCheckout();
        shipping = new shippingPage(driver);
        shipping.verifyThatUserIsOnShippingPage();
        shipping.shippingCheckout();
        payment = new paymentPage(driver);
        payment.verifyThatUserIsOnPaymentPage();
        payment.payByBankWire();
        orderSummary = new orderSummaryPage(driver);
        orderSummary.verifyThatUserIsOnOrderSummaryPage();
        orderSummary.orderSummary();
        orderConfirm = new orderConfirmationPage(driver);
        orderConfirm.verifyThatUserIsOnOrderConfirmationPage();
        orderConfirm.confirmOrder();

    }




}

