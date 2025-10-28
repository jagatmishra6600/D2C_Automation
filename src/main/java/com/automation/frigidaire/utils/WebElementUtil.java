package com.automation.frigidaire.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

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
     *
     * @param locator The By locator of the element.
     */
    public static void clickElement(By locator) {
        retryOnFailure(() -> waitForElementToBeClickable(locator).click(), 3, 1000);
    }


    /**
     * Waits for an element to be visible, clears it, and sends the provided text.
     * Retries up to 3 times if interaction fails.
     *
     * @param locator The By locator of the element.
     * @param text    The text to type into the element.
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
     *
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
     *
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
     *
     * @param locator The By locator of the element.
     * @return The WebElement once it is visible.
     */
    public static WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable for a maximum of 10 seconds.
     *
     * @param locator The By locator of the element.
     * @return The WebElement once it is clickable.
     */
    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Navigates the browser to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    public static void navigateTo(String url) {
        DriverManager.getDriver().get(url);
    }

    /**
     * Gets the title of the current page.
     *
     * @return The title of the page.
     */
    public static String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    /**
     * Gets the current URL of the page.
     *
     * @return The current URL.
     */
    public static String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }


    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Scroll element into view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", element);
            Thread.sleep(500); // small pause
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void zoomInOrOut(int zoomPercentage) {

        if (zoomPercentage < 10 || zoomPercentage > 200) {
            System.out.println("Zoom percentage out of range. Please provide a value between 10 and 200.");
            return;
        }
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
    }

    public static void scrollAndClickUsingJSE(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Scroll element into view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", element);
            Thread.sleep(500); // small pause

            // Perform JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

            System.out.println("Clicked successfully on: " + element);
        } catch (Exception e) {
            System.out.println("Failed to click element: " + e.getMessage());
        }
    }


    /**
     * Perform mouse hover on a specific WebElement
     * @param driver WebDriver instance
     * @param element WebElement to hover on
     */
    public static void mouseHover(WebDriver driver, WebElement element) {
        try {
            // Wait until the element is visible and enabled (optional, if needed)
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();

            System.out.println("Mouse hovered successfully on: " + element);
        } catch (Exception e) {
            System.out.println("Failed to hover on element: " + e.getMessage());
        }
    }

        public static void clickElementUsingJSE(WebDriver driver, By locator) {
            try {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
                WebElement element =driver.findElement(locator);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

                System.out.println("Successfully clicked on element: " + element);
            } catch (TimeoutException e) {
                System.out.println("Timeout: Element not clickable after waiting for 60 seconds: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + e.getMessage());
            } catch (WebDriverException e) {
                System.out.println("WebDriverException occurred while attempting to click: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Failed to click element due to an unknown error: " + e.getMessage());
            }
        }




    public static void scrollUp(WebDriver driver, int pixels) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            // Wait for the page to be ready (optional, can be skipped if not needed)
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));

            // Scroll the page up by a specified number of pixels
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -arguments[0]);", pixels);

            // Optional small pause to ensure the scroll action completes
            Thread.sleep(500); // This can be adjusted or removed if you need more performance
        } catch (Exception e) {
            throw new RuntimeException("Error scrolling up", e);
        }
    }

    /**
     * Checks if an element is present in the DOM.
     * Does NOT require the element to be visible.
     *
     * @param locator The By locator of the element to check.
     * @return true if the element exists in the DOM, false otherwise.
     */
    public static boolean isElementPresent(By locator) {
        WebDriver driver = DriverManager.getDriver();
        try {
            List<WebElement> elements = driver.findElements(locator);
            return !elements.isEmpty(); // Returns true if at least one element found
        } catch (Exception e) {
            System.err.println("Error while checking element presence: " + e.getMessage());
            return false;
        }
    }



    public static void switchToNewTab( WebDriver driver , String mainWindow) {

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
}
