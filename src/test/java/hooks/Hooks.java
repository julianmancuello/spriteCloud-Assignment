package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import manager.WebDriverManager;

public class Hooks {

    @Before
    public void setUp() {
        WebDriverManager.setUpWebDriver();
    }

    @After
    public void tearDown() {
        WebDriverManager.tearDownWebDriver();
    }
}
