package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutConfirmationPage extends BasePage {

    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void clickFinishButton() {
        click(finishButton);
    }
}
