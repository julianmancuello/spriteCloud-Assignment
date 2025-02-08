package stepsdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import ui.manager.DriverManager;

public class Hooks {

    private boolean isUiTest;
    private boolean isApiTest;

    @Before
    public void setUp(Scenario scenario) {
        isUiTest = scenario.getSourceTagNames().contains("@ui-test");
        isApiTest = scenario.getSourceTagNames().contains("@api-test");
        if (isUiTest) DriverManager.setUpWebDriver();
        else if (isApiTest) RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        else throw new IllegalArgumentException("The scenario does not contain a valid tag.");
    }

    @After
    public void tearDown() {
        if (isUiTest) DriverManager.tearDownWebDriver();
        else if (isApiTest) RestAssured.reset();
        else throw new IllegalStateException("The scenario does not contain a valid tag.");
    }
}
