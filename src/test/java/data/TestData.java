package data;

import api.models.responses.*;
import lombok.Getter;

import java.util.List;

public class TestData {

    @Getter
    public enum UserType{
        STANDARD_USER("standard_user"),
        BLOCKED_USER("locked_out_user"),
        NON_EXISTING_USER("non_existing_user");

        private final String value;

        UserType(String value) {
            this.value = value;
        }
    }

    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String CHECKOUT_URL = BASE_URL + "checkout-complete.html";

    public static final String MASTER_PASSWORD = "secret_sauce";

    public static final String BLOCKED_USER_ERROR_MSG = "Epic sadface: Sorry, this user has been locked out.";
    public static final String NON_EXISTING_USER_ERROR_MSG = "Epic sadface: Username and password do not match any user in this service";
    public static final String SUCCESSFUL_HEADER = "Thank you for your order!";

    public static List<String> listOfAddedProducts;

    public static UserList userList;
    public static final UserData EMMA_WONG = new UserData(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg");
    public static final String ApiUser = "eve.holt@reqres.in";
    public static final String ApiPassword = "cityslicka";
    public static Token token;
    public static ErrorMessage errorMessage;
    public static InformationModified infoModified;
}
