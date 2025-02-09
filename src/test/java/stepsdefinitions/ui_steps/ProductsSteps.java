package stepsdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import ui.manager.DriverManager;
import ui.pages.ProductsPage;

import static data.TestData.listOfAddedProducts;

public class ProductsSteps {

    private final ProductsPage productsPage;

    public ProductsSteps() {
        this.productsPage = new ProductsPage(DriverManager.getDriver());
    }

    @When("the user add first {} products to cart")
    public void userAddRandomProductToCart(int quantityOfProducts) {
        listOfAddedProducts = productsPage.addToCartRandomProducts(quantityOfProducts);
    }

    @And("click on the cart icon")
    public void clickOnCartIcon() {
        productsPage.clickCart();
    }
}
