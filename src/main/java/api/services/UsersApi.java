package api.services;

import api.models.requests.UserInformation;
import api.models.responses.InformationModified;
import api.models.responses.UserList;
import io.restassured.response.Response;

import static api.endpoints.Endpoints.USERS_ENDPOINT;
import static api.endpoints.Endpoints.USER_ENDPOINT;
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
