package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.WebDriverManager;
import org.junit.Assert;
import pages.LoginPage;

import static data.TestData.*;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(WebDriverManager.getDriver());
    }

    @Given("the user access to Sauce Demo")
    public void userAccessToSauceDemo() {
        loginPage.navigateTo(AUT_URL);
    }

    @When("the user attempts to log in with {} credentials")
    public void userLogInWithCredentials(String user) {
        String userType;
        switch (user) {
            case "STANDARD_USER" -> userType = STANDARD_USER;
            case "BLOCKED_USER" -> userType = BLOCKED_USER;
            case "NON_EXISTING_USER" -> userType = NON_EXISTING_USER;
            default -> throw new IllegalArgumentException("Invalid user type: " + user);
        }
        loginPage.loginUser(userType, MASTER_PASSWORD);
    }

    @Then("{} error icons and the error message for {} should be displayed")
    public void errorIconsAndErrorMessageShouldBeDisplayed(int numberOfIcons, String error) {
        String errorType;
        switch (error) {
            case "BLOCKED_USER" -> errorType = BLOCKED_USER_ERROR_MSG;
            case "NON_EXISTING_USER" -> errorType = NON_EXISTING_USER_ERROR_MSG;
            default -> throw new IllegalArgumentException("Invalid error message: " + error);
        }

        Assert.assertTrue("Error icons are not displayed", loginPage.isErrorIconCountEqualToExpectedQuantity(numberOfIcons));
        Assert.assertEquals("Error message do not match", errorType, loginPage.getLoginErrorMessage());
    }
}
