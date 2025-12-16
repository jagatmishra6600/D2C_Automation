package com.automation.electrolux.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

public class EPIC_01_TC_02_AQA_Authentication_LoginSuccess_Elux extends BaseTest{
    HomePageActionsElux homePage = new HomePageActionsElux();
	 
	 @Test(groups = {"smoke", "regression"}, description = "User should be able to login Successfully with valid Credentials")
	    public void  EPIC_01_TC_02_S1_VerifyTestLoginSuccess()  {
	        homePage.loginWithDefaultCredentials();
	        Assert.assertTrue(homePage.isHomePageLoaded()
				,"User is not navigated to HomePage after Logging in with Valid Credentials");
	        Assert.assertTrue(homePage.isUserGreetingDropdownDisplayed()
				,"User Greeting Dropdown Button is not displayed");
	        Assert.assertEquals(homePage.getGreetingMessage(),"Hello "+UserTestData.FIRST_NAME
				,"User Greeting Message is incorrect");
	        ExtentReportManager.getTest().pass("User Logged In Using Valid Credentials and Navigated to HomePage");
	    }
}
