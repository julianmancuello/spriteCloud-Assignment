package api.services;

import api.endpoints.Endpoints;
import api.models.requests.Credentials;
import api.models.responses.ErrorMessage;
import api.models.responses.Token;
import io.restassured.response.Response;

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
                .post(Endpoints.LOGIN_ENDPOINT);
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
