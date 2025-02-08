package stepsdefinitions.api_steps;

import api.services.LoginApi;
import api.services.UsersApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static data.TestData.*;

public class ApisSteps {

    private final UsersApi usersApi;
    private final LoginApi loginApi;

    public ApisSteps() {
        this.usersApi = new UsersApi();
        this.loginApi = new LoginApi();
    }

    @Given("retrieve user list of page {}")
    public void retrieveListOfUserOfPage(int page) {
        userList = usersApi.getUserListSuccessfully(page);
    }

    @Then("check user in position {} is Emma Wong")
    public void checkUserInPositionIs(int position) {
        Assert.assertEquals("Current user is not equal to expected user", EMMA_WONG, userList.getData().get(position - 1));
    }

    @Given("user logs in with credentials")
    public void userLogsInWithCredentials() {
        token = loginApi.logInUserSuccessfully(ApiUser, ApiPassword);
    }

    @Then("token was generated successfully")
    public void tokenWasGeneratedSuccessfully() {
        Assert.assertNotNull("Token was not generated", token);
    }

    @Given("user logs in without password")
    public void userLogsInWithoutPassword() {
        errorMessage = loginApi.logInUserWithoutPassword(ApiUser);
    }

    @Then("{} error message is retrieved")
    public void errorMessageIsRetrieved(String expectedError) {
        Assert.assertEquals(expectedError, errorMessage.getError());
    }

    @Given("modify name to {} and job to {} for user with ID {}")
    public void modifyNameAndJobForUserWithId(String name, String job, int id) {
        infoModified = usersApi.modifyUserInformationSuccessfully(name, job, id);
    }

    @Then("user information was changed to {} and {}")
    public void userInformationWasChanged(String name, String job) {
        Assert.assertEquals("The name was not modified", name, infoModified.getName());
        Assert.assertEquals("Job was not modified", job, infoModified.getJob());
    }
}
