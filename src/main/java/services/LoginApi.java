package services;

import io.restassured.response.Response;
import models.requests.Credentials;
import models.responses.ErrorMessage;
import models.responses.Token;

import static common.Endpoints.LOGIN_ENDPOINT;
import static io.restassured.RestAssured.given;

public class LoginApi extends BaseApi {

    public LoginApi() {
        super();
    }

    public Response logInUser(String email, String password) {
        return given()
                .spec(getRequestSpec())
                .body(new Credentials(email, password))
                .when()
                .post(LOGIN_ENDPOINT);
    }

    public Token logInUserSuccessfully(String email, String password) {
        return logInUser(email, password)
                .then().statusCode(200)
                .extract().body().as(Token.class);
    }

    public ErrorMessage logInUserWithoutPassword(String email) {
        return logInUser(email, null)
                .then().statusCode(400)
                .extract().body().as(ErrorMessage.class);
    }
}
