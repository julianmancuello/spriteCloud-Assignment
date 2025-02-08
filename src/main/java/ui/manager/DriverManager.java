package ui.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class DriverManager {

    @Getter
    private static WebDriver driver;

    public static void setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setChromeOptions());
    }

    public static void tearDownWebDriver() {
        driver.quit();
    }

    private static ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        //options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        //options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        return options;
    }
}
