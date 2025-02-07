package stepsdefinitions.ui_steps;

import io.cucumber.java.en.When;
import ui.manager.DriverManager;
import ui.pages.CheckoutConfirmationPage;

public class CheckoutConfirmationSteps {

    private final CheckoutConfirmationPage checkoutConfirmationPage;

    public CheckoutConfirmationSteps() {
        this.checkoutConfirmationPage = new CheckoutConfirmationPage(DriverManager.getDriver());
    }

    @When("the user click on finish button")
    public void userClickOnFinishButton() {
        checkoutConfirmationPage.clickFinishButton();
    }
}
