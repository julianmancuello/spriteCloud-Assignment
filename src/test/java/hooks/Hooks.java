package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import ui.manager.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.setUpWebDriver();
//        RestAssured.filters(
//                new RequestLoggingFilter(),
//                new ResponseLoggingFilter()
//        );
    }

    @After
    public void tearDown() {
        DriverManager.tearDownWebDriver();
    }
}
