package stepsdefinitions;

import io.cucumber.java.en.Then;
import manager.WebDriverManager;
import org.junit.Assert;
import pages.CartPage;

import static data.TestData.*;

public class CartSteps {

    private final CartPage cartPage;

    public CartSteps() {
        this.cartPage = new CartPage(WebDriverManager.getDriver());
    }

    @Then("check the products were added successfully to the cart")
    public void checkProductsWereAddedSuccessfullyToCart() {
        Assert.assertTrue("The products information in the cart do not match the selected products.", cartPage.isEachSelectedProductPresentInCart(listOfAddedProducts));
    }
}
