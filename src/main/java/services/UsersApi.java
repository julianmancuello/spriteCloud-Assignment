package services;

import io.restassured.response.Response;
import models.responses.UserList;

import static common.Endpoints.USERS_ENDPOINT;
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
}
