package com.automation.frigidaire.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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


    public static void zoomInOrOut(int zoomPercentage) {

        if (zoomPercentage < 10 || zoomPercentage > 200) {
            System.out.println("Zoom percentage out of range. Please provide a value between 10 and 200.");
            return;
        }
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
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
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
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

    public static void scrollAndClickUsingJSE(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Scroll element into view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: 'smooth' ,block: 'center'});", element);
            Thread.sleep(500); // small pause

            // Perform JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

            System.out.println("Clicked successfully on: " + element);
        } catch (Exception e) {
            System.out.println("Failed to click element: " + e.getMessage());
        }
    }

    public static boolean isElementPresent(By locator) {
        WebDriver driver = DriverManager.getDriver();
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
