package com.automation.frigidaire.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.Random;
import java.util.function.Supplier;
import java.util.List;

public class WebElementUtil {

    // Private constructor to prevent instantiation of this utility class
    private WebElementUtil() {
        throw new IllegalStateException("Utility class");
    }

    // Retry mechanism for flaky interactions
    private static void retryOnFailure(Runnable action, int maxRetries, long delayMillis) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                action.run();
                return;
            } catch (Exception e) {
                attempts++;
                if (attempts >= maxRetries) {
                    throw e;
                }
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Retry interrupted", ie);
                }
            }
        }
    }

    /**
     * Waits for an element to be visible and then clicks it.
     * Retries up to 3 times if interaction fails.
     * @param locator The By locator of the element.
     */
    public static void clickElement(By locator) {
        retryOnFailure(() -> waitForElementToBeClickable(locator).click(), 3, 1000);
    }

    /**
     * Waits for an element to be visible, clears it, and sends the provided text.
     * Retries up to 3 times if interaction fails.
     * @param locator The By locator of the element.
     * @param text The text to type into the element.
     */
    public static void sendKeys(By locator, String text) {
        retryOnFailure(() -> {
            WebElement element = waitForElementToBeVisible(locator);
            element.clear();
            element.sendKeys(text);
        }, 3, 1000);
    }

    /**
     * Waits for an element to be visible and returns its text.
     * Retries up to 3 times if interaction fails.
     * @param locator The By locator of the element.
     * @return The text of the element.
     */
    public static String getText(By locator) {
        final String[] text = new String[1];
        retryOnFailure(() -> text[0] = waitForElementToBeVisible(locator).getText(), 3, 1000);
        return text[0];
    }

    /**
     * Checks if an element is displayed on the page.
     * @param locator The By locator of the element.
     * @return true if the element is displayed, false otherwise.
     */
    public static boolean isDisplayed(By locator) {
        try {
            return waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Waits for an element to be visible for a maximum of 10 seconds.
     * @param locator The By locator of the element.
     * @return The WebElement once it is visible.
     */
    public static WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable for a maximum of 10 seconds.
     * @param locator The By locator of the element.
     * @return The WebElement once it is clickable.
     */
    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Navigates the browser to the specified URL.
     * @param url The URL to navigate to.
     */
    public static void navigateTo(String url) {
        DriverManager.getDriver().get(url);
    }

    /**
     * Gets the title of the current page.
     * @return The title of the page.
     */
    public static String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    /**
     * Gets the current URL of the page.
     * @return The current URL.
     */
    public static String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }
    
    /**
     * Switches the Driver focus to Frame
     * @param frameId you want to switch the focus to
     */
    public static void switchToFrame(String frameId) {
    	DriverManager.getDriver().switchTo().frame(frameId);
    }
    
    /**
     * Switches the Driver focus to Back to the Default
     */
    public static void switchToDefaultContent() {
    	DriverManager.getDriver().switchTo().defaultContent();
    }
    
    /**
     * Generates the random number
     * @param range - length of the int we want to generate
     * @return the random number in int
     */
    public static int getRandomNumber(int range) {
    	return new Random().nextInt(range);
    }
    
    /**
     * Switch to Frame and perform the Action and then Switches back to Default Content
     * @param frameNameOrId - to swithch to the frame, action- Action we want to perform Ex: getText(), isDisplayed()
     * @return it return the output value of action (Ex: boolean, String, int)
     */
    public static <T> T performInFrame(String frameNameOrId, Supplier<T> action) {
        try {
            switchToFrame(frameNameOrId);
            return action.get();
        } finally {
            switchToDefaultContent();

    /**
     * Scrolls the element into view using JavaScript and waits until it is clickable.
     * @param locator The By locator of the element to scroll into view.
     */

    public static void scrollIntoView(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "const element = arguments[0];" +
                        "const rect = element.getBoundingClientRect();" +
                        "const absoluteElementTop = rect.top + window.pageYOffset;" +
                        "const offset = 100;" + // adjust offset as per sticky header height
                        "window.scrollTo({top: absoluteElementTop - offset, behavior: 'instant'});",
                element
        );

        waitForElementToBeClickable(locator);
    }


    public static void scrollIntoView(By locator, int stickyHeaderHeight) {
        WebElement element = waitForElementToBeVisible(locator);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "const element = arguments[0];" +
                        "const rect = element.getBoundingClientRect();" +
                        "const absoluteElementTop = rect.top + window.pageYOffset;" +
                        "const offset = " + stickyHeaderHeight + ";" + // adjust offset as per sticky header height
                        "window.scrollTo({top: absoluteElementTop - offset, behavior: 'instant'});",
                element
        );

        waitForElementToBeClickable(locator);
    }

    /**
     * Finds all elements matching the given locator using the current WebDriver.
     * @param locator The By locator to search for.
     * @return List of WebElements matching the locator.
     */
    public static List<WebElement> findElements(By locator) {
        if (DriverManager.getDriver() == null) {
            throw new IllegalStateException("WebDriver is not initialized. Ensure DriverManager.getDriver() is called before using findElements.");
        }
        List<WebElement> elements = DriverManager.getDriver().findElements(locator);
        if (elements.isEmpty()) {
            System.err.println("No elements found for locator: " + locator);
        }
        return elements;
    }

    public static String getExactText(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        return (String) js.executeScript("return arguments[0].textContent;", element);
    }

    /**
     * Waits for a specific attribute of an element to contain a given value.
     * @param locator The By locator of the element.
     * @param attribute The attribute to check (e.g., "class", "value", "style").
     * @param value The value that the attribute should contain.
     * @param timeoutInSeconds The maximum time to wait in seconds.
     */
    public static void waitForAttributeToContain(By locator, String attribute, String value, int timeoutInSeconds) {
        if (timeoutInSeconds <= 0) {
            throw new IllegalArgumentException("Timeout must be greater than 0 seconds");
        }
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
        } catch (Exception e) {
            throw new RuntimeException("Failed to wait for attribute '" + attribute + "' to contain value '" + value + "'", e);
        }
    }
}
