package com.automation.frigidaire.tests.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.frigidaire.pages.FrigidaireLoginPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;

public class TC_02_AQA_Authentication_LoginSuccess extends BaseTest{
	 FrigidaireLoginPageActions loginPage = new FrigidaireLoginPageActions();
	 
	 @Test(groups = {"smoke", "regression"}, description = "User should be able to login Successfully with valid Credentials")
	    public void TC_02_S1_VerifyValidCredentialsLoginSuccess() {
	    	var emailAddress = "00998811@yopmail.com";
	    	var password = "Test@1234";

	        var homePage = loginPage.navigateToLoginPage()
					        		.login(emailAddress, password);
	        
	        Assert.assertTrue(homePage.isHomePageLoaded(),"User is not navigated to HomePage after Login");
	        		
	        System.out.println(homePage.getWelcomeNameText()); // To Check as We are getting error while logging in through Automation Script
//	       	Add Assertion Step for Welcome Name Text once we are able to resolve the issue.
	        ExtentReportManager.getTest().pass("User Logged In Using Valid Credentials and Navigated to HomePage");
	    }

}
