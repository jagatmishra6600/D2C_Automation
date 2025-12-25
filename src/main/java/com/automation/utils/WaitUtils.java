package com.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtils {
    public static WebDriverWait waitSec(int seconds) { return new WebDriverWait(driver(), Duration.ofSeconds(seconds)); }
    private static Actions actions() { return new Actions(driver()); }
    private static WebDriver driver() { return DriverManager.getDriver(); }

    private static final int DEFAULT_TIMEOUT_SECONDS = 10;

    private WaitUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static WebDriverWait wait(Duration timeout) {
        return new WebDriverWait(driver(), timeout);
    }


    // Visibility
    public static WebElement untilVisible(By locator) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement untilVisible(WebElement element) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement untilClickable(By locator) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement untilClickable(WebElement element) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

    // Presence
    public static WebElement untilPresent(By locator) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement untilPresent(By locator, long timeoutSeconds) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean untilInvisible(By locator) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean untilInvisible(By locator, long timeoutSeconds) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean untilInvisible(WebElement element) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOf(element));
    }

    public static boolean untilInvisible(WebElement element, long timeoutSeconds) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOf(element));
    }

    public static boolean untilUrlContains(String fraction) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.urlContains(fraction));
    }

    public static boolean untilUrlContains(String fraction, long timeoutSeconds) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.urlContains(fraction));
    }

    public static boolean untilTitleContains(String fraction) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.titleContains(fraction));  
    }

    public static boolean untilTitleContains(String fraction, long timeoutSeconds) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.titleContains(fraction));
    }

    // Attribute & Text
    public static boolean untilAttributeContains(By locator, String attribute, String value) {
        WebElement element = untilPresent(locator);
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(driver -> {
            String attr = element.getAttribute(attribute);
            return attr != null && attr.contains(value);
        });
    }
    
    public static boolean untilAttributeContains(By locator, String attribute, String value, int timeoutSeconds) {
        return waitSec(timeoutSeconds).until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    public static boolean untilTextPresent(By locator, String text) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Selection
    public static boolean untilSelected(By locator) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static boolean untilSelected(WebElement element) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeSelected(element));
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
        return wait(Duration.ofSeconds(timeoutSeconds)).until(d -> {
            try {
                return "complete".equals(((JavascriptExecutor) d).executeScript("return document.readyState"));
            } catch (JavascriptException e) {
                return false;
            }
        });
    }

    public static void sleep(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    public static void implicitWait(long seconds) {
        driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static WebElement waitForVisibility(By locator) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
   
    public static WebElement waitForElementToBeVisible(By locator) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeVisible(WebElement element) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        return waitSec(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void hoverElement(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        actions().moveToElement(element).perform();
    }

}
