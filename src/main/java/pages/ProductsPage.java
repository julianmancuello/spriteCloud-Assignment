package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;
    @FindBy(className = "btn_small")
    List<WebElement> addToCartButton;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productName;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> addToCartRandomProducts(int quantityOfProducts) {
        if (quantityOfProducts > productName.size()) {
            throw new IllegalArgumentException("The quantity of products cannot be greater than the maximum available");
        }
        List<String> selectedProductNames = new ArrayList<>();
        for (int i = 0; i < quantityOfProducts; i++) {
            click(addToCartButton.get(i));
            selectedProductNames.add(getText(productName.get(i)));
        }
        return selectedProductNames;
    }

    public void clickCart() {
        click(cartButton);
    }
}