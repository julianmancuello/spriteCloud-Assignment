package data;

import api.models.responses.*;
import lombok.Getter;

import java.util.List;

public class TestData {

    @Getter
    public enum UserType {
        STANDARD_USER("standard_user"),
        BLOCKED_USER("locked_out_user"),
        NON_EXISTING_USER("non_existing_user");

        private final String value;

        UserType(String value) {
            this.value = value;
        }
    }

    /**
    * Using static variables as test date is not the best practice, but I am using them for simplicity.
    * In a real-world scenario, I would use Context Store variables to manage data between steps
    * and pipeline variables for secrets.
    */

    public static final String MASTER_PASSWORD = "secret_sauce";

    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String CHECKOUT_URL = BASE_URL + "checkout-complete.html";

    public static final String BLOCKED_USER_ERROR_MSG = "Epic sadface: Sorry, this user has been locked out.";
    public static final String NON_EXISTING_USER_ERROR_MSG = "Epic sadface: Username and password do not match any user in this service";
    public static final String SUCCESSFUL_HEADER = "Thank you for your order!";

    public static List<String> listOfAddedProducts;

    public static final UserData EMMA_WONG = new UserData(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg");
    public static final String ApiUser = "eve.holt@reqres.in";
    public static final String ApiPassword = "cityslicka";

    public static UserList userList;
    public static Token token;
    public static ErrorMessage errorMessage;
    public static InformationModified infoModified;
}
