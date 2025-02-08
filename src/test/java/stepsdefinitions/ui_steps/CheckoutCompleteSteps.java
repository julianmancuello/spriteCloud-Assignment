package stepsdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import ui.manager.DriverManager;
import ui.pages.CheckoutCompletePage;

import static data.TestData.CHECKOUT_URL;
import static data.TestData.SUCCESSFUL_HEADER;

public class CheckoutCompleteSteps {

    private final CheckoutCompletePage checkoutCompletePage;

    public CheckoutCompleteSteps() {
        this.checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver());
    }

    @Then("the purchase was completed successfully")
    public void purchaseWasCompletedSuccessfully() {
        Assert.assertEquals("Error: Purchase not completed", CHECKOUT_URL, checkoutCompletePage.getCurrentUrl());
    }

    @And("successful purchase message and green check displayed")
    public void successfulPurchaseMessageAndGreenCheckDisplayed() {
        Assert.assertEquals("Success header is incorrect", SUCCESSFUL_HEADER, checkoutCompletePage.getSuccessfulHeader());
        Assert.assertTrue("The green check is not displayed after the checkout", checkoutCompletePage.isGreenCheckDisplayed());
    }
}
