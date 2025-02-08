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

    @Before
    public void setUp(Scenario scenario) {
        isUiTest = scenario.getSourceTagNames().contains("@ui-test");

        if (isUiTest) DriverManager.setUpWebDriver();
        else RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @After
    public void tearDown() {
        if (isUiTest) DriverManager.tearDownWebDriver();
        else RestAssured.reset();
    }
}
