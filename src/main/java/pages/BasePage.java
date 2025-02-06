package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private final int STD_TIMEOUT_SEC = 10;
    private final int POLLING_EVERY_MS = 100;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public FluentWait<WebDriver> fluentWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(STD_TIMEOUT_SEC)).pollingEvery(Duration.ofMillis(POLLING_EVERY_MS));
    }

    public void waitForElementToBeVisible(WebElement webElement) {
        fluentWait().until(driver -> webElement.isDisplayed());
    }

    public void click(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        webElement.click();
    }

    public void type(WebElement webElement, String text) {
        waitForElementToBeVisible(webElement);
        webElement.sendKeys(text);
    }

    public String getText(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        return webElement.getText();
    }

    public boolean isDisplayed(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        return webElement.isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
