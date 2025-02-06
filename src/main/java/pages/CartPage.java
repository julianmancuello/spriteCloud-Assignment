package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    List<WebElement> productName;
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEachSelectedProductPresentInCart(List<String> selectedProductNames) {
        if (productName.size() == selectedProductNames.size()) {
            for (int i = 0; i < productName.size(); i++) {
                String extractedText = productName.get(i).getText();
                if (!extractedText.equals(selectedProductNames.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void clickCheckoutButton() {
        click(checkoutButton);
    }
}