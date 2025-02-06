package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(className = "error_icon")
    List<WebElement> errorIcon;
    @FindBy(className = "error-message-container")
    WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public boolean isErrorIconCountEqualToExpectedQuantity(int expectedErrorIcons) {
        return errorIcon.size() == expectedErrorIcons;
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMessage);
    }
}
