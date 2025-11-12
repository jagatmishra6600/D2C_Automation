package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    public static String switchToNewWindow() {
        WebDriver driver = DriverManager.getDriver();
        String parentWindow = driver.getWindowHandle();

        // Wait until a new tab/window appears
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        return parentWindow;
    }

    /**
     * Switches WebDriver control back to the parent/original window.
     */
    public static void switchToParentWindow(String parentWindow) {
        WebDriver driver = DriverManager.getDriver();
        driver.switchTo().window(parentWindow);
    }

    /**
     * Closes the current tab and switches back to the parent.
     */
    public static void closeCurrentAndSwitchToParent(String parentWindow) {
        WebDriver driver = DriverManager.getDriver();
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}