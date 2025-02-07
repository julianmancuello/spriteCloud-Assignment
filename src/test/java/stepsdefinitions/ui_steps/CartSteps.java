package stepsdefinitions.ui_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ui.manager.DriverManager;
import org.junit.Assert;
import ui.pages.CartPage;

import static data.TestData.listOfAddedProducts;

public class CartSteps {

    private final CartPage cartPage;

    public CartSteps() {
        this.cartPage = new CartPage(DriverManager.getDriver());
    }

    @Then("check the products were added successfully to the cart")
    public void checkProductsWereAddedSuccessfullyToCart() {
        Assert.assertTrue("The products information in the cart do not match the selected products.",
                cartPage.isEachSelectedProductPresentInCart(listOfAddedProducts));
    }

    @Given("the user click on checkout button")
    public void userClickOnCheckoutButton() {
        cartPage.clickCheckoutButton();
    }
}
