package com.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        WebDriver drv = driver.get();

        if (drv == null) {
            String browser = System.getProperty("browser", ConfigReader.getProperty("browser", "chrome")).trim();
            String headlessProp = System.getProperty("headless", ConfigReader.getProperty("headless", "false")).trim();

            boolean headless = Boolean.parseBoolean(headlessProp);
            boolean isLinux = System.getProperty("os.name", "").toLowerCase().contains("linux");
            boolean isCI = "true".equalsIgnoreCase(System.getenv("CI"));

            if (browser.equalsIgnoreCase("chrome")) {
                drv = createChromeDriver(headless, isLinux, isCI);
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.set(drv);
        }
        return driver.get();
    }

    private static WebDriver createChromeDriver(boolean headless, boolean isLinux, boolean isCI) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        List<String> chromeArgs = new ArrayList<>();

        if (headless) chromeArgs.add("--headless=new");
        chromeArgs.add("--remote-allow-origins=*");
        chromeArgs.add("--window-size=1920,1080");
        chromeArgs.add("--disable-notifications");
        chromeArgs.add("--disable-popup-blocking");

        if (headless || isLinux || isCI) {
            chromeArgs.add("--no-sandbox");
            chromeArgs.add("--disable-dev-shm-usage");
            chromeArgs.add("--disable-gpu");
        }

        // ✅ Works with Selenium 4.22
        chromeOptions.addArguments(chromeArgs);

        WebDriver drv = new ChromeDriver(chromeOptions);
        drv.manage().window().maximize();
        return drv;
    }

    public static void quitDriver() {
        WebDriver drv = driver.get();
        if (drv != null) {
            try {
                drv.quit();
            } catch (Exception e) {
                System.err.println("⚠️ Warning: Exception while quitting WebDriver - " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}
