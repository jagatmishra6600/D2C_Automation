package com.automation;


import com.automation.utils.DriverManager;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.ScreenshotUtility;
import com.automation.utils.VideoRecorder;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    @Parameters({"brand", "headless"})
    @BeforeSuite
    public void setUpSuite(@Optional("frigidaire") String brand,
                           @Optional("false") String headless) {
        // Allow TestNG to drive brand selection; can also be overridden by -Dbrand
        ConfigReader.setRuntimeProperty("brand", brand);
        ConfigReader.setRuntimeProperty("headless", headless);
        ExtentReportManager.setupExtentReport();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod(java.lang.reflect.Method method) throws Exception {
        ExtentReportManager.createTest(method.getName());
        String videoEnabled = ConfigReader.getProperty("video.enabled");
        if (videoEnabled != null && videoEnabled.equalsIgnoreCase("true")) {
            VideoRecorder.startRecording(method.getName());
        }
        DriverManager.getDriver(); // Initialize driver
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws Exception {
        String videoPath = VideoRecorder.stopRecording();

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.getTest().log(Status.FAIL, "TEST FAILED: " + result.getThrowable());
            String screenshotPath = ScreenshotUtility.captureScreenshot(DriverManager.getDriver(), result.getMethod().getMethodName());
            if (screenshotPath != null) {
                ExtentReportManager.getTest().fail("Screenshot on Failure", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
            if (videoPath != null) {
                ExtentReportManager.getTest().info("<b>Video Recording on Failure:</b> <a href='" + videoPath + "' target='_blank'>Click to view video</a>");

            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReportManager.getTest().log(Status.SKIP, "TEST SKIPPED");
        } else {
            ExtentReportManager.getTest().log(Status.PASS, "TEST PASSED");
        }

        DriverManager.quitDriver();

        // Flush report incrementally to ensure the HTML file is generated even if the suite aborts
        try {
            ExtentReportManager.flushReport();
        } catch (Exception ignored) {
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentReportManager.flushReport();
    }
}