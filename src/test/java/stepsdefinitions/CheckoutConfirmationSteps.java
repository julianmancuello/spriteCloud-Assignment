package stepsdefinitions;

import io.cucumber.java.en.When;
import manager.WebDriverManager;
import pages.CheckoutConfirmationPage;

public class CheckoutConfirmationSteps {

    private final CheckoutConfirmationPage checkoutConfirmationPage;

    public CheckoutConfirmationSteps() {
        this.checkoutConfirmationPage = new CheckoutConfirmationPage(WebDriverManager.getDriver());
    }

    @When("the user click on finish button")
    public void userClickOnFinishButton() {
        checkoutConfirmationPage.clickFinishButton();
    }
}
