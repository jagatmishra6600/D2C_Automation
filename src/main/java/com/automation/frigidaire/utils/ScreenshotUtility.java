package com.automation.frigidaire.utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        // Format the timestamp to make the filename unique
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            // Cast driver to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);

            // Ensure the screenshots directory exists
            File destination = new File(destinationPath);
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot captured: " + destinationPath);
            return destinationPath;
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
}