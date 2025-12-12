package com.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Supplier;

public class WebElementUtil {

    private WebElementUtil() { throw new IllegalStateException("Utility class"); }

    public static void scrollToElementByXPath(String xpath) {
        try {
            WebElement element = DriverManager.getDriver().findElement(By.xpath(xpath));
            ((JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        } catch (NoSuchElementException e) {
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

    public static Set<String> getWindowHandles() { return DriverManager.getDriver().getWindowHandles(); }
    public static String getWindowHandle() { return DriverManager.getDriver().getWindowHandle(); }

    private static void retryOnFailure(Runnable action, int maxRetries, long delayMillis) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try { action.run(); return; }
            catch (Exception e) {
                attempts++;
                if (attempts >= maxRetries) throw e;
                WaitUtils.implicitWait(delayMillis);
            }
        }
    }

    public static void clickElement(By locator) { retryOnFailure(() -> waitForElementToBeClickable(locator).click(), 3, 1000); }

    public static void sendKeys(By locator, String text) {
        retryOnFailure(() -> {
            WebElement element = waitForElementToBeVisible(locator);
            element.clear();
            element.sendKeys(text);
        }, 3, 1000);
    }

    public static void zoomInOrOut(int zoomPercentage) {
        if (zoomPercentage < 10 || zoomPercentage > 200) {
            System.out.println("Zoom percentage out of range. Provide between 10 and 200.");
            return;
        }
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
    }

    public static String getText(By locator) {
        final String[] text = new String[1];
        retryOnFailure(() -> text[0] = waitForElementToBeVisible(locator).getText(), 3, 1000);
        return text[0];
    }

    public static boolean isDisplayed(By locator) {
        try { return waitForElementToBeVisible(locator).isDisplayed(); } catch (Exception e) { return false; }
    }

    public static WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
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
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            WaitUtils.implicitWait(1);
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public static WebElement findElement(By locator) {
        try { return DriverManager.getDriver().findElement(locator); }
        catch (NoSuchElementException e) { return null; }
    }

    public static void scrollAndClickUsingJSE(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public static void mouseHover(WebDriver driver, WebElement element) {
        try { new Actions(driver).moveToElement(element).perform(); }
        catch (Exception e) { throw new RuntimeException("Failed to hover over element", e); }
    }

    public static void clickElementUsingJSE(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public static void scrollUp(WebDriver driver, int pixels) {
        try { ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-" + pixels + ")"); }
        catch (Exception e) { throw new RuntimeException(e); }
    }

    public static boolean isElementPresented(By locator) {
        WebDriver driver = DriverManager.getDriver();
        try {
            List<WebElement> elements = driver.findElements(locator);
            return !elements.isEmpty();
        } catch (Exception e) {
            System.err.println("Error while checking element presence: " + e.getMessage());
            return false;
        }
    }

    public static void switchToNewTab(WebDriver driver, String mainWindow) {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) { driver.switchTo().window(handle); break; }
        }
    }

    public static boolean isElementPresent(By locator){
        WebDriver driver = DriverManager.getDriver();
        try { driver.findElement(locator); return true; }
        catch (NoSuchElementException e) { return false; }
    }

    public static void switchToFrame(String frameId) { DriverManager.getDriver().switchTo().frame(frameId); }
    public static void switchToDefaultContent() { DriverManager.getDriver().switchTo().defaultContent(); }

    public static int getRandomNumber(int range) { return (int) (Math.random() * range); }

    public static <T> T performInFrame(String frameNameOrId, Supplier<T> action) {
        WebDriver driver = DriverManager.getDriver();
        try { driver.switchTo().frame(frameNameOrId); return action.get(); }
        finally { driver.switchTo().defaultContent(); }
    }

    public static WebElement scrollIntoView(By locator) {
    	isDisplayed(locator);
        WebElement element = DriverManager.getDriver().findElement(locator);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center', inline: 'nearest'});", element);
        return element;
    }

    public static void scrollIntoView(By locator, int stickyHeaderHeight) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "var rect = arguments[0].getBoundingClientRect(); window.scrollTo(0, window.pageYOffset + rect.top - " + stickyHeaderHeight + ");",
                element);
    }

    public static void scrollToElementStable(By locator) {
        WebDriver driver = DriverManager.getDriver();
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;

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
            new WebDriverWait(driver, Duration.ofMillis(300))
                    .until(d -> {
                        Number nowY = (Number) ((JavascriptExecutor) d)
                                .executeScript("return Math.round(window.scrollY);");
                        return Math.abs(nowY.longValue() - targetY) < 2;
                    });
        } catch (Exception ignored) {
        }
    }

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
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        return (String) ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("return arguments[0].textContent;", element);
    }

    public static void waitForAttributeToContain(By locator, String attribute, String value, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    public static <T> T performInFrame(By frameElementLocator, Supplier<T> action) {
        WebDriver driver = DriverManager.getDriver();
        WebElement frameElement = driver.findElement(frameElementLocator);
        try { driver.switchTo().frame(frameElement); return action.get(); }
        finally { driver.switchTo().defaultContent(); }
    }

    public static void switchToFrame(By frameElementLocator) {
        WebDriver driver = DriverManager.getDriver();
        WebElement frameElement = driver.findElement(frameElementLocator);
        driver.switchTo().frame(frameElement);
    }

    public static void switchToLatestTabAndClosePrevious() {
        WebDriver driver = DriverManager.getDriver();
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) {
            for (String handle : handles) { if (!handle.equals(currentHandle)) { driver.switchTo().window(handle); break; } }
            driver.close();
            driver.switchTo().window(currentHandle);
        }
    }

    public static void ctrlClick(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        new Actions(DriverManager.getDriver())
                .keyDown(Keys.CONTROL)
                .click(element)
                .keyUp(Keys.CONTROL)
                .perform();
    }

    public static WebElement findElementIfPresent(By locator) {
        try {
            List<WebElement> elements = DriverManager.getDriver().findElements(locator);
            if (!elements.isEmpty()) { return elements.get(0); }
        } catch (Exception ignored) {}
        return null;
    }

    public static void navigateTo(String url) { DriverManager.getDriver().navigate().to(url); }
    public static String getPageTitle() { return DriverManager.getDriver().getTitle(); }
    public static String getCurrentUrl() { return DriverManager.getDriver().getCurrentUrl(); }
    
    /**
     * Performs Control + Click action on a Element to open it into a new Tab using Java Script
     * @param -By locator of the Link Element we want to click and open in new Tab
     */
    public static void ctrlClickWithJS(By locator) {
        retryOnFailure(() -> {
            var element = DriverManager.getDriver().findElement(locator);
            scrollIntoView(locator);
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        
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
        var element = DriverManager.getDriver().findElement(locator);

        String href = element.getAttribute("href");
        if (href != null && !href.isBlank()) {
            WebDriver newTab = DriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
            newTab.get(href); 
        } else {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
        }
    }


    public static void scrollByPixels(WebDriver driver, int x, int y) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        } catch (Exception e) {
            throw new RuntimeException("Failed to scroll by pixels.", e);
        }
    }

    public static WebElement scrollToElementCenter(By locator) {
        WebDriver driver = DriverManager.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

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
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }

    public static String getAttributeValue(By locator, String attributeName) {
        final String[] value = new String[1];
        retryOnFailure(() ->
                        value[0] = waitForElementToBeVisible(locator).getAttribute(attributeName),
                3, 1000);

        return value[0];
    }

    public static float convertPriceToFloat(String price) {
        price = price.replace("$", "").trim();
        price = price.replaceAll(",", "");
        price = price.replaceAll("\\.(0|00)$", "");
        return Float.parseFloat(price);
    }


    public static float getPrice(By locator) {
        String priceText = getText(locator);
        return convertPriceToFloat(priceText);
    }

    public static void forceClick(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        ((JavascriptExecutor) DriverManager.getDriver())
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

    public static WebElement waitForClickable(WebDriver driver, By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void scrollAndClickUsingJSE(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    public static String getDomProperty(By locator, String propertyName) {
    	var element = DriverManager.getDriver().findElement(locator);
    	return element.getDomProperty(propertyName);
    }

    public static WebElement validateInsideShadowDom(By outer, By targetLocator) {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", innerElement);

            return innerElement;

        } catch (Exception e) {
            System.err.println("Failed to locate element inside Shadow DOM → " + targetLocator);
            e.printStackTrace();
            return null;
        }
    }

}