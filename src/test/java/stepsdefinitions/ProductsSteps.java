package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manager.WebDriverManager;
import pages.ProductsPage;

import static data.TestData.listOfAddedProducts;

public class ProductsSteps {

    private final ProductsPage productsPage;

    public ProductsSteps() {
        this.productsPage = new ProductsPage(WebDriverManager.getDriver());
    }

    @When("the user add first {} products to cart")
    public void userAddRandomProductToCart(int quantityOfProducts) {
        listOfAddedProducts = productsPage.addToCartRandomProducts(quantityOfProducts);
    }

    @And("click on the cart icon")
    public void ClickOnCartIcon() {
        productsPage.clickCart();
    }
}
