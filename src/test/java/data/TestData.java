package data;

import java.util.List;

public class TestData {

    public static final String AUT_URL = "https://www.saucedemo.com/";
    public static final String CHECKOUT_URL = "https://www.saucedemo.com/checkout-complete.html";

    public static final String STANDARD_USER = "standard_user";
    public static final String BLOCKED_USER = "locked_out_user";
    public static final String NON_EXISTING_USER = "non_existing_user";
    public static final String MASTER_PASSWORD = "secret_sauce";

    public static final String BLOCKED_USER_ERROR_MSG = "Epic sadface: Sorry, this user has been locked out.";
    public static final String NON_EXISTING_USER_ERROR_MSG = "Epic sadface: Username and password do not match any user in this service";
    public static final String SUCCESSFUL_HEADER = "Thank you for your order!";

    public static List<String> listOfAddedProducts;
}
