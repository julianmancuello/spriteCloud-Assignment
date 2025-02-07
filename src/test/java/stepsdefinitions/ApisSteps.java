package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.responses.UserData;
import org.junit.Assert;
import services.UsersApi;

import static data.TestData.*;

public class ApisSteps {

    private final UsersApi usersApi;

    public ApisSteps() {
        this.usersApi = new UsersApi();
    }

    @Given("retrieve user list of page {}")
    public void retrieveListOfUserOfPage(int page) {
        userList = usersApi.getUserListSuccessfully(page);
    }

    @Then("check user in position {} is Emma Wong")
    public void checkUserInPositionIs(int position) {
        Assert.assertEquals("Current user is not equal to expected user", EMMA_WONG, userList.getData().get(position - 1));
    }
}
