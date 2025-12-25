package com.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Supplier;

public class WebElementUtil {

    private WebElementUtil() { throw new IllegalStateException("Utility class"); }

    private static WebDriver driver() { return DriverManager.getDriver(); }
    private static JavascriptExecutor jsDriver() { return (JavascriptExecutor) driver(); }
    private static Actions actions() { return new Actions(driver()); }
    
    public static void scrollToElementByXPath(String xpath) {
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(By.xpath(xpath));
            jsDriver()
                    .executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        } catch (NoSuchElementException e) {
            jsDriver()
                    .executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e) {
            System.out.println("Error scrolling to element: " + e.getMessage());
        }
    }

    public static void closeNewTabIfOpened(Set<String> beforeHandles) {
        Set<String> afterHandles = driver().getWindowHandles();
        if (afterHandles.size() > beforeHandles.size()) {
            afterHandles.removeAll(beforeHandles);
            if (!afterHandles.isEmpty()) {
                String newHandle = afterHandles.iterator().next();
                String original = driver().getWindowHandle();
                driver().switchTo().window(newHandle);
                driver().close();
                driver().switchTo().window(original);
            }
        }
    }

    public static void hoverOverElement(By locator) {
        retryOnFailure(() -> {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            actions().moveToElement(element).perform();
        }, 3, 1000);
    }

    public static Set<String> getWindowHandles() { return driver().getWindowHandles(); }
    public static String getWindowHandle() { return driver().getWindowHandle(); }

    private static void retryOnFailure(Runnable action, int maxRetries, long delayMillis) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try { 
                action.run(); 
                return; 
            }
            catch (Exception e) {
                attempts++;
                if (attempts >= maxRetries) throw e;
                // Exponential backoff for better stability
                long backoffTime = delayMillis * (long) Math.pow(2, attempts - 1);
                try {
                    Thread.sleep(Math.min(backoffTime, 3000)); // Cap at 3 seconds
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted during retry", ie);
                }
            }
        }
    }

    public static void clickElement(By locator) { 
        retryOnFailure(() -> {
            WebElement element = WaitUtils.waitForElementToBeClickable(locator);    
            try {
                element.click();
            } catch (ElementClickInterceptedException e) {
                // Fallback to JavaScript click if normal click fails
                jsDriver().executeScript("arguments[0].click();", element);
            }
        }, 3, 1000); 
    }

    public static void sendKeys(By locator, String text) {
        retryOnFailure(() -> {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            element.clear();
            element.sendKeys(text);
        }, 3, 1000);
    }

    public static void zoomInOrOut(int zoomPercentage) {
        if (zoomPercentage < 10 || zoomPercentage > 200) {
            System.out.println("Zoom percentage out of range. Provide between 10 and 200.");
            return;
        }
        jsDriver()
                .executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
    }

    public static String getText(By locator) {
        final String[] text = new String[1];
        retryOnFailure(() -> {
            WebElement element = WaitUtils.waitForElementToBeVisible(locator);
            text[0] = element.getText();
            // Fallback to textContent if getText returns empty
            if (text[0] == null || text[0].isEmpty()) {
                text[0] = (String) jsDriver().executeScript("return arguments[0].textContent;", element);
            }
        }, 3, 1000);
        return text[0];
    }

    public static boolean isDisplayed(By locator) {
        try { 
            return WaitUtils.waitForElementToBeVisible(locator).isDisplayed(); 
        } catch (Exception e) { 
            return false; 
        }
    }

   

    public static void scrollToElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            jsDriver().executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            WaitUtils.implicitWait(1);
        } catch (Exception e) { 
            throw new RuntimeException(e); 
        }
    }

    public static WebElement findElement(By locator) {
        try { 
            return driver().findElement(locator); 
        }
        catch (NoSuchElementException e) { 
            return null; 
        }
    }

    public static void mouseHover(WebElement element) {
        try { 
            actions().moveToElement(element).perform(); 
        }
        catch (Exception e) { 
            throw new RuntimeException("Failed to hover over element", e); 
        }
    }

    public static void scrollUp(int pixels) {
        try { 
            jsDriver().executeScript("window.scrollBy(0,-" + pixels + ")"); 
        }
        catch (Exception e) { 
            throw new RuntimeException(e); 
        }
    }

    public static boolean isElementPresented(By locator) {
        try {
            List<WebElement> elements = driver().findElements(locator);
            return !elements.isEmpty();
        } catch (Exception e) {
            System.err.println("Error while checking element presence: " + e.getMessage());
            return false;
        }
    }

    public static void switchToNewTab(String mainWindow) {
        for (String handle : driver().getWindowHandles()) {
            if (!handle.equals(mainWindow)) { 
                driver().switchTo().window(handle); 
                break; 
            }  
        }
    }

    public static boolean isElementPresent(By locator){
        try { 
            driver().findElement(locator); 
            return true; 
        }
        catch (NoSuchElementException e) { 
            return false; 
        }
    }

    public static void switchToFrame(String frameId) { 
        driver().switchTo().frame(frameId); 
    }
    
    public static void switchToDefaultContent() { 
        driver().switchTo().defaultContent(); 
    }

    public static int getRandomNumber(int range) { 
        return (int) (Math.random() * range); 
    }

    public static <T> T performInFrame(String frameNameOrId, Supplier<T> action) {
        try { 
            driver().switchTo().frame(frameNameOrId); 
            return action.get(); 
        }
        finally { 
            driver().switchTo().defaultContent(); 
        }
    }

    public static WebElement scrollIntoView(By locator) {
        isDisplayed(locator);
        WebElement element = driver().findElement(locator);
        jsDriver().executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center', inline: 'nearest'});", element);
        return element;
    }

    public static void scrollIntoView(By locator, int stickyHeaderHeight) {
        WebElement element = driver().findElement(locator);
        jsDriver().executeScript(
                "var rect = arguments[0].getBoundingClientRect(); window.scrollTo(0, window.pageYOffset + rect.top - " + stickyHeaderHeight + ");",
                element);
    }

    public static void scrollToElementStable(By locator) {
        WebElement element = driver().findElement(locator);
        JavascriptExecutor js = jsDriver();

        String script =
                "var elem = arguments[0];" +
                        "var viewportHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);" +
                        "var rect = elem.getBoundingClientRect();" +
                        "var elemY = rect.top + window.scrollY;" +
                        "var targetY = elemY - (viewportHeight * 0.30);" +  // scroll to 30% from top
                        "window.scrollTo({ top: targetY, behavior: 'instant' });" +
                        "return targetY;";

        // Receive Double safely
        Number returnedY = (Number) js.executeScript(script, element);
        long targetY = returnedY.longValue();

        // Wait scroll to finish
        try {
            new WebDriverWait(driver(), Duration.ofMillis(300))
                    .until(d -> {
                        Number nowY = (Number) ((JavascriptExecutor) d)
                                .executeScript("return Math.round(window.scrollY);");
                        return Math.abs(nowY.longValue() - targetY) < 2;
                    });
        } catch (Exception ignored) {
        }
    }

    public static void scrollToElementStable(WebElement element) {
        JavascriptExecutor js = jsDriver();

        String script =
                "var elem = arguments[0];" +
                        "var viewportHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);" +
                        "var rect = elem.getBoundingClientRect();" +
                        "var elemY = rect.top + window.scrollY;" +
                        "var targetY = elemY - (viewportHeight * 0.30);" +  // scroll to 30% from top
                        "window.scrollTo({ top: targetY, behavior: 'instant' });" +
                        "return targetY;";

        // Receive Double safely
        Number returnedY = (Number) js.executeScript(script, element);
        long targetY = returnedY.longValue();

        // Wait scroll to finish
        try {
            new WebDriverWait(driver(), Duration.ofMillis(300))
                    .until(d -> {
                        Number nowY = (Number) ((JavascriptExecutor) d)
                                .executeScript("return Math.round(window.scrollY);");
                        return Math.abs(nowY.longValue() - targetY) < 2;
                    });
        } catch (Exception ignored) {
        }
    }

    public static List<WebElement> findElements(By locator) {
        if (driver() == null) {
            throw new IllegalStateException("WebDriver is not initialized. Ensure DriverManager.getDriver() is called before using findElements.");
        }
        List<WebElement> elements = driver().findElements(locator);
        if (elements.isEmpty()) {
            System.err.println("No elements found for locator: " + locator);
        }
        return elements;
    }

    public static String getExactText(By locator) {
        WebElement element = WaitUtils.waitForElementToBeVisible(locator);
        jsDriver().executeScript("arguments[0].scrollIntoView(true);", element);
        return (String) jsDriver()
                .executeScript("return arguments[0].textContent;", element);
    }

    public static void waitForAttributeToContain(By locator, String attribute, String value, int timeoutInSeconds) {
       WaitUtils.untilAttributeContains(locator, attribute, value, timeoutInSeconds);
    }

    public static <T> T performInFrame(By frameElementLocator, Supplier<T> action) {
        WebElement frameElement = driver().findElement(frameElementLocator);
        try { 
            driver().switchTo().frame(frameElement); 
            return action.get(); 
        }
        finally { 
            driver().switchTo().defaultContent(); 
        }
    }

    public static void switchToFrame(By frameElementLocator) {
        WebElement frameElement = WaitUtils.waitForElementToBeVisible(frameElementLocator);
        driver().switchTo().frame(frameElement);
    }

    public static void switchToLatestTabAndClosePrevious() {
        var tabs = new ArrayList<>(driver().getWindowHandles());
        if (tabs.size() < 2) return;
        driver().switchTo().window(tabs.get(tabs.size() - 2)).close();
        driver().switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static void ctrlClick(By locator) {
        WebElement element = driver().findElement(locator);
        actions()
                .keyDown(Keys.CONTROL)
                .click(element)
                .keyUp(Keys.CONTROL)
                .perform();
    }

    public static WebElement findElementIfPresent(By locator) {
        try {
            List<WebElement> elements = driver().findElements(locator);
            if (!elements.isEmpty()) { 
                return elements.get(0); 
            }
        } catch (Exception ignored) {}
        return null;
    }

    public static void navigateTo(String url) { 
        driver().navigate().to(url); 
    }
    
    public static String getPageTitle() { 
        return driver().getTitle(); 
    }
    
    public static String getCurrentUrl() { 
        return driver().getCurrentUrl(); 
    }
    
    public static void clickBackButton() { 
        driver().navigate().back(); 
    }
    
    /**
     * Performs Control + Click action on a Element to open it into a new Tab using Java Script
     * @param -By locator of the Link Element we want to click and open in new Tab
     */
    public static void ctrlClickWithJS(By locator) {
        retryOnFailure(() -> {
            var element = driver().findElement(locator);
            scrollIntoView(locator);
            JavascriptExecutor js = jsDriver();
        
            String href = element.getAttribute("href");
            System.out.println(href);

            if (href != null && !href.isEmpty()) {
                js.executeScript("window.open(new URL(arguments[0], window.location.href).href, '_blank');", href);
            } else {
                js.executeScript("arguments[0].click();", element);
            }
        }, 3, 1000);
    }
    
    public static void openLinkInNewTab(By locator) {
        scrollIntoView(locator);
        var element = driver().findElement(locator);

        String href = element.getAttribute("href");
        if (href != null && !href.isBlank()) {
            WebDriver newTab = driver().switchTo().newWindow(WindowType.TAB);
            newTab.get(href); 
        } else {
            jsDriver().executeScript("arguments[0].click();", element);
        }
    }

    public static void scrollByPixels(int x, int y) {
        try {
            jsDriver().executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        } catch (Exception e) {
            throw new RuntimeException("Failed to scroll by pixels.", e);
        }
    }

    public static WebElement scrollToElementCenter(By locator) {
        JavascriptExecutor js = jsDriver();         
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(20));

        // 1️⃣ wait for element to exist
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        int maxAttempts = 15; // enough retries for unstable pages

        for (int i = 0; i < maxAttempts; i++) {

            // Re-locate element each iteration (React pages re-render!)
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            // Element position relative to viewport
            Long rectTop = (Long) js.executeScript("return Math.round(arguments[0].getBoundingClientRect().top);", element);
            Long viewportHeight = (Long) js.executeScript("return window.innerHeight;");

            long desiredPosition = viewportHeight / 2;  // exact center
            long offset = rectTop - desiredPosition;

            // If element already centered → stop
            if (Math.abs(offset) < 10) {
                break;
            }

            // Perform incremental scroll
            js.executeScript("window.scrollBy(0, arguments[0]);", offset);

            // Allow page to stabilize after scroll
            sleep(300);
        }

        // After loop → ensure element truly visible & interactable
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        return element;
    }

    private static void sleep(long ms) {
        try { 
            Thread.sleep(ms); 
        } catch (Exception ignored) {}
    }

    public static String getAttributeValue(By locator, String attributeName) {
        final String[] value = new String[1];
        retryOnFailure(() ->
                        value[0] = WaitUtils.waitForElementToBeVisible(locator).getAttribute(attributeName),
                3, 1000);

        return value[0];
    }

    public static float converStringToFloat(String text) {
        text = text.replace("$", "").trim();
        text = text.replaceAll(",", "");
        text = text.replaceAll("\\.(0|00)$", "");
        return Float.parseFloat(text);
    }

    public static float getPrice(By locator) {
        String priceText = getText(locator);
        return converStringToFloat(priceText);
    }

    public static void forceClick(By locator) {
        WebElement element = driver().findElement(locator);
        jsDriver()
                .executeScript("arguments[0].click();", element);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void waitForCondition(ExpectedCondition<?> condition) { 
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
            .until(condition);
    }
    
    public static void waitForCondition(ExpectedCondition<?> condition, int seconds) { 
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
            .until(condition);
    }

    public static WebElement waitForClickable(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void scrollAndClickUsingJSE(By locator) {
        try {
            WebElement element = driver().findElement(locator); 
            jsDriver().executeScript("arguments[0].scrollIntoView(true);", element);
            jsDriver().executeScript("arguments[0].click();", element);
        } catch (Exception e) { 
            throw new RuntimeException(e); 
        }
    }

    public static String getDomProperty(By locator, String propertyName) {
        var element = driver().findElement(locator);
        return element.getDomProperty(propertyName);
    }

    public static WebElement validateInsideShadowDom(By outer, By targetLocator) {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        try {
            // Wait for Shadow Host
            WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(outer));

            // Wait until shadowRoot becomes available
            SearchContext shadowRoot = wait.until(d -> {
                try {
                    return shadowHost.getShadowRoot();
                } catch (Exception e) {
                    return null; // retry
                }
            });

            if (shadowRoot == null) {
                throw new RuntimeException("Shadow root not found for host: " + outer);
            }

            // Now wait for element ***inside shadow DOM***
            WebElement innerElement = wait.until(d -> {
                try {
                    WebElement el = shadowRoot.findElement(targetLocator);
                    return el.isDisplayed() ? el : null;
                } catch (StaleElementReferenceException | NoSuchElementException ex) {
                    return null; // retry
                }
            });

            // Scroll to center (stable)
            ((JavascriptExecutor) driver())
                    .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", innerElement);

            return innerElement;

        } catch (Exception e) {
            System.err.println("Failed to locate element inside Shadow DOM → " + targetLocator);
            e.printStackTrace();
            return null;
        }
    }
    
    public static void refreshPage() {
        driver().navigate().refresh();
        WaitUtils.waitForPageLoad();
    }

    public static void clickElementUsingJSE(By locator) {
        try {
            WebElement element = driver().findElement(locator);
            jsDriver().executeScript("arguments[0].scrollIntoView(true);", element);
            jsDriver().executeScript("arguments[0].click();", element);
        } catch (Exception e) { 
            throw new RuntimeException(e);
        }
    }

    public static float getValueOfDom(By locator) {    
        WebElement element = driver().findElement(locator);

        String value = element.getAttribute("value");

        if (value == null || value.isEmpty()) {
            value = (String) ((JavascriptExecutor) driver())
                    .executeScript("return arguments[0].value;", element);
        }

        return converStringToFloat(value);
    }
}