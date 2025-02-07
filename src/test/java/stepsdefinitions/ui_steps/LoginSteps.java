package stepsdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.manager.DriverManager;
import org.junit.Assert;
import ui.pages.LoginPage;

import static data.TestData.*;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(DriverManager.getDriver());
    }

    @Given("the user access to Sauce Demo")
    public void userAccessToSauceDemo() {
        loginPage.navigateTo(BASE_URL);
    }

    @And("the user logs in with {} credentials")
    @When("the user attempts to log in with {} credentials")
    public void userLogInWithCredentials(UserType user) {
        loginPage.loginUser(user.getValue(), MASTER_PASSWORD);
    }

    @Then("{} error icons and the error message for {} should be displayed")
    public void errorIconsAndErrorMessageShouldBeDisplayed(int numberOfIcons, UserType error) {
        String errorType;
        switch (error) {
            case BLOCKED_USER -> errorType = BLOCKED_USER_ERROR_MSG;
            case NON_EXISTING_USER -> errorType = NON_EXISTING_USER_ERROR_MSG;
            default -> throw new IllegalArgumentException("Invalid error message: " + error);
        }

        Assert.assertTrue("Error icons are not displayed", loginPage.isErrorIconCountEqualToExpectedQuantity(numberOfIcons));
        Assert.assertEquals("Error message do not match", errorType, loginPage.getLoginErrorMessage());
    }
}
