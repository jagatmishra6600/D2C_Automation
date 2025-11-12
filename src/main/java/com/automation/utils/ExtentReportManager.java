package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void setupExtentReport() {
        String defaultRelative = "test-output/ExtentReport.html";
        String configured = null;
        try { configured = ConfigReader.getProperty("extent.report.path"); } catch (Exception ignored) {}

        String relativePath = (configured != null && !configured.trim().isEmpty()) ? configured.trim() : defaultRelative;
        String reportPath = System.getProperty("user.dir") + File.separator + relativePath.replace("/", File.separator);

        File parent = new File(reportPath).getParentFile();
        if (parent != null && !parent.exists()) { parent.mkdirs(); }

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Web UI Test Results");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    public static void createTest(String testName) {
        if (extent == null) { setupExtentReport(); }
        test.set(extent.createTest(testName));
    }

    public static ExtentTest getTest() { return test.get(); }

    public static void flushReport() { if (extent != null) { extent.flush(); } }
}