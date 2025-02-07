package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "pony_express")
    WebElement greenCheck;
    @FindBy(className = "complete-header")
    WebElement successfulHeader;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isGreenCheckDisplayed() {
        return isDisplayed(greenCheck);
    }

    public String getSuccessfulHeader() {
        return getText(successfulHeader);
    }
}
