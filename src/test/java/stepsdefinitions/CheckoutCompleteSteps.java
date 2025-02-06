package stepsdefinitions;

import data.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.WebDriverManager;
import org.junit.Assert;
import pages.CheckoutCompletePage;

import static data.TestData.*;

public class CheckoutCompleteSteps {

    private final CheckoutCompletePage checkoutCompletePage;

    public CheckoutCompleteSteps() {
        this.checkoutCompletePage = new CheckoutCompletePage(WebDriverManager.getDriver());
    }

    @Then("the purchase was completed successfully")
    public void purchaseWasCompletedSuccessfully() {
        Assert.assertEquals("Error: Purchase not completed", CHECKOUT_URL, checkoutCompletePage.getCurrentUrl());
    }

    @And("successful purchase message and green tick displayed")
    public void successfulPurchaseMessageAndGreenTickDisplayed() {
        Assert.assertEquals("Success header is incorrect", SUCCESSFUL_HEADER, checkoutCompletePage.getSuccessfulHeader());
        Assert.assertTrue("The green tick is not displayed after the checkout", checkoutCompletePage.isGreenTickDisplayed());
    }
}
