package com.automation.electrolux.tests;


import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.ScreenshotUtility;
import com.automation.frigidaire.utils.VideoRecorder;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUpSuite() {
        ExtentReportManager.setupExtentReport();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod(java.lang.reflect.Method method) throws Exception {
        ExtentReportManager.createTest(method.getName());
        VideoRecorder.startRecording(method.getName());
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
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentReportManager.flushReport();
    }
}