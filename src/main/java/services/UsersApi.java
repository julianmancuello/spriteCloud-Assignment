package services;

import io.restassured.response.Response;
import models.requests.Credentials;
import models.requests.UserInformation;
import models.responses.ErrorMessage;
import models.responses.InformationModified;
import models.responses.Token;
import models.responses.UserList;

import static common.Endpoints.*;
import static io.restassured.RestAssured.given;

public class UsersApi extends BaseApi {

    public UsersApi() {
        super();
    }

    public Response getUserList(int page) {
        return given()
                .spec(getRequestSpec())
                .param("page", page)
                .when()
                .get(USERS_ENDPOINT);
    }

    public UserList getUserListSuccessfully(int page) {
        return getUserList(page)
                .then().statusCode(200)
                .extract().body().as(UserList.class);
    }

    public Response modifyUserInformation(String name, String job, int id) {
        return given()
                .spec(getRequestSpec())
                .pathParam("ID", id)
                .body(new UserInformation(name, job))
                .when()
                .put(USER_ENDPOINT);
    }

    public InformationModified modifyUserInformationSuccessfully(String name, String job, int id) {
        return modifyUserInformation(name, job, id)
                .then().statusCode(200)
                .extract().body().as(InformationModified.class);
    }
}
