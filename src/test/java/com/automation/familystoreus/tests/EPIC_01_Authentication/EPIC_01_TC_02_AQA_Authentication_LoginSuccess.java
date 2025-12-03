package com.automation.familystoreus.tests.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.familystoreus.pages.HomePageActions;
import com.automation.familystoreus.pages.LoginPageActions;
import com.automation.BaseTest;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

public class EPIC_01_TC_02_AQA_Authentication_LoginSuccess extends BaseTest{
	HomePageActions homePage = new HomePageActions();
	LoginPageActions loginPage = new LoginPageActions();
	
	 @Test(groups = {"smoke", "regression"}, description = "User should be able to login Successfully with valid Credentials")
	    public void TC_02_S1_VerifyTestLoginSuccess() throws InterruptedException {
		 	loginPage.loginWithDefaultCredentials();
	        Assert.assertTrue(homePage.isHomePageLoaded(),"User is not navigated to HomePage after Logging in with Valid Credentials");
	        Assert.assertTrue(homePage.isUserGreetingDropdownDisplayed(),"User Greeting Dropdown Button is not displayed");
	        Assert.assertEquals(homePage.getUserGreetingMessage(),"Hello Test"+UserTestData.FIRST_NAME
									,"User Greeting Message is incorrect");
	        ExtentReportManager.getTest().pass("User Logged In Using Valid Credentials and Navigated to HomePage");
	    }
}
