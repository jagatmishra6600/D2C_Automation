package com.automation.frigidaire.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class WebElementUtil {

    // Private constructor to prevent instantiation of this utility class
    private WebElementUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static void scrollToElementByXPath(String xpath) {
        try {
            WebElement element = DriverManager.getDriver().findElement(By.xpath(xpath));
            ((JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found with XPath: " + xpath);
            // Fallback to scroll to bottom if element not found
            ((JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e) {
            System.out.println("Error scrolling to element: " + e.getMessage());
        }
    }

    public static void closeNewTabIfOpened(Set<String> beforeHandles) {
        WebDriver driver = DriverManager.getDriver();
        Set<String> afterHandles = driver.getWindowHandles();
        if (afterHandles.size() > beforeHandles.size()) {
            afterHandles.removeAll(beforeHandles);
            if (!afterHandles.isEmpty()) {
                String newHandle = afterHandles.iterator().next();
                String original = driver.getWindowHandle();
                driver.switchTo().window(newHandle);
                driver.close();
                driver.switchTo().window(original);
            }
        }
    }

    public static void hoverOverElement(By locator) {
        retryOnFailure(() -> {
            WebElement element = waitForElementToBeVisible(locator);
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(element).perform();
        }, 3, 1000);
    }


    public static Set<String> getWindowHandles() {
        return DriverManager.getDriver().getWindowHandles();
    }

    public static String getWindowHandle() {
        return DriverManager.getDriver().getWindowHandle();
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
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable for a maximum of 10 seconds.
     *
     * @param locator The By locator of the element.
     * @return The WebElement once it is clickable.
     */
    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void hoverElement(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).perform();
    }

    public static WebElement waitForElementToBeVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static WebElement waitForElementToBeClickable(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
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

    public static WebElement findElement(By locator) {
        if (DriverManager.getDriver() == null) {
            throw new IllegalStateException("WebDriver is not initialized. Ensure DriverManager.getDriver() is called before using findElement.");
        }
        try {
            return DriverManager.getDriver().findElement(locator);
        } catch (NoSuchElementException e) {
            System.err.println("Element not found for locator: " + locator);
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to find element: " + locator, e);
        }
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
    public static boolean isElementPresented(By locator) {
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
    public static boolean isElementPresent(By locator){
            WebDriver driver = DriverManager.getDriver();
            try {
                driver.findElement(locator);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
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
        }
    }

    /**
     * Scrolls the element into view using JavaScript and waits until it is clickable.
     *
     * @param locator The By locator of the element to scroll into view.
     * @return
     */


    public static WebElement scrollIntoView(By locator) {
        WebDriver driver = DriverManager.getDriver();
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest', behavior:'smooth'});",
                element);

        try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));

        return element;
    }


    /**
     * Scrolls the element into view using JavaScript with adjustable sticky header height offset.
     * @param locator The By locator of the element.
     * @param stickyHeaderHeight The height of the sticky header to offset.
     */
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
    
    /**
     * Switch to Frame and perform the Action and then Switches back to Default Content
     * @param - to switch to the frame, action- Action we want to perform Ex: getText(), isDisplayed()
     * @return it return the output value of action (Ex: boolean, String, int)
     */   
    public static <T> T performInFrame(By frameElementLocator, Supplier<T> action) {
        try {
            switchToFrame(frameElementLocator);
            return action.get();
        } finally {
            switchToDefaultContent();
        }
    }

    /**
     * Switches the Driver focus to Frame
     * @paramlocator to which user wants to switch the reference to
     */
    public static void switchToFrame(By  frameElementLocator) {	
    	var frameElement = DriverManager.getDriver().findElement(frameElementLocator);
    	DriverManager.getDriver().switchTo().frame(frameElement);
    }   
    
    /**
     * Switches the Driver focus to Latest Tab and closes the current tab
     */
    public static void switchToLatestTabAndClosePrevious() {
        var tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
        if (tabs.size() < 2) return;

        DriverManager.getDriver().switchTo().window(tabs.get(tabs.size() - 2)).close();
        DriverManager.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static WebElement validateInsideShadowDom(By outer, By targetLocator) {

        WebElement target = null;
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1️ - Find the outer shadow host
            WebElement outerHost = wait.until(ExpectedConditions.presenceOfElementLocated(outer));

            // Step 2 - Access its shadow root
            SearchContext shadowRoot = null;
            try {
                shadowRoot = outerHost.getShadowRoot();
                System.out.println("Outer shadow root accessed.");
            } catch (NoSuchShadowRootException e) {
                System.out.println("Outer host has no shadow root!");
            }

            // Step 3 - If an inner shadow host is provided, go one level deeper
            SearchContext activeRoot = shadowRoot;

            // Step 4 - Find and click the target element
            target = wait.until(d -> {
                assert activeRoot != null;
                return activeRoot.findElement(targetLocator);
            });

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", target);

            System.out.println("Clicked element inside shadow DOM successfully!");

        } catch (Exception e) {
            System.err.println("Failed to click inside shadow DOM.");
            e.printStackTrace();
        }
        return target;
    }
    
    /**
     * Performs Control + Click action on a Element to open it into a new Tab
     * @param  locator of the Element we want perform Control + Click
     */
    public static void ctrlClick(By locator) {
        retryOnFailure(() -> {
            WebElement element = waitForElementToBeClickable(locator);
            new Actions(DriverManager.getDriver())
                .keyDown(Keys.CONTROL)
                .click(element)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        }, 3, 1000);
    }




    public static WebElement findElementIfPresent(By locator) {
        try {
            List<WebElement> elements = DriverManager.getDriver().findElements(locator);
            if (!elements.isEmpty()) {
                return elements.get(0);
            }
        } catch (Exception ignored) {}
        return null;
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


}
