package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import manager.WebDriverManager;

public class Hooks {

    @Before
    public void setUp() {
        //WebDriverManager.setUpWebDriver();
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
    }

    @After
    public void tearDown() {
        //WebDriverManager.tearDownWebDriver();
    }
}
