package com.automation.frigidaire.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public final class WaitUtils {

    private static final long DEFAULT_TIMEOUT_SECONDS = 10;
    private static final long DEFAULT_POLL_MILLIS = 500;

    private WaitUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static WebDriverWait wait(Duration timeout) {
        return new WebDriverWait(DriverManager.getDriver(), timeout);
    }

    private static WebDriverWait defaultWait() {
        return wait(Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    // Visibility
    public static WebElement untilVisible(By locator) {
        return defaultWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement untilVisible(By locator, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement untilVisible(WebElement element) {
        return defaultWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement untilVisible(WebElement element, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement untilVisible(WebElement element, int timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.visibilityOf(element));
    }

    // Clickable
    public static WebElement untilClickable(By locator) {
        return defaultWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement untilClickable(By locator, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement untilClickable(WebElement element) {
        return defaultWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement untilClickable(WebElement element, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    // Presence
    public static WebElement untilPresent(By locator) {
        return defaultWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement untilPresent(By locator, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Invisibility
    public static boolean untilInvisible(By locator) {
        return defaultWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean untilInvisible(By locator, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean untilInvisible(WebElement element) {
        return defaultWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public static boolean untilInvisible(WebElement element, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.invisibilityOf(element));
    }

    // URL & Title
    public static boolean untilUrlContains(String fraction) {
        return defaultWait().until(ExpectedConditions.urlContains(fraction));
    }

    public static boolean untilUrlContains(String fraction, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.urlContains(fraction));
    }

    public static boolean untilTitleContains(String fraction) {
        return defaultWait().until(ExpectedConditions.titleContains(fraction));
    }

    public static boolean untilTitleContains(String fraction, long timeoutSeconds) {
        return wait(Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.titleContains(fraction));
    }

    // Attribute & Text
    public static boolean untilAttributeContains(By locator, String attribute, String value) {
        WebElement element = untilPresent(locator);
        return defaultWait().until(driver -> {
            String attr = element.getAttribute(attribute);
            return attr != null && attr.contains(value);
        });
    }

    public static boolean untilTextPresent(By locator, String text) {
        return defaultWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Selection
    public static boolean untilSelected(By locator) {
        return defaultWait().until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static boolean untilSelected(WebElement element) {
        return defaultWait().until(ExpectedConditions.elementToBeSelected(element));
    }

    // Page load
    public static boolean untilPageLoadComplete() {
        return untilPageLoadComplete(DEFAULT_TIMEOUT_SECONDS);
    }

    // Page load helpers
    public static void waitForPageLoad() {
        WaitUtils.untilPageLoadComplete();
    }

    public static boolean untilPageLoadComplete(long timeoutSeconds) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait w = wait(Duration.ofSeconds(timeoutSeconds));
        return w.until(d -> {
            try {
                return "complete".equals(((JavascriptExecutor) d).executeScript("return document.readyState"));
            } catch (JavascriptException e) {
                return false;
            }
        });
    }

    // Fluent wait with custom polling and ignored exceptions
    public static <T> T fluentUntil(java.util.function.Function<WebDriver, T> condition,
                                    long timeoutSeconds,
                                    long pollMillis,
                                    Class<? extends Throwable>... ignored) {
        FluentWait<WebDriver> fluent = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(pollMillis));
        Arrays.stream(ignored).forEach(fluent::ignoring);
        return fluent.until(condition);
    }

    // Safe sleep helper
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}