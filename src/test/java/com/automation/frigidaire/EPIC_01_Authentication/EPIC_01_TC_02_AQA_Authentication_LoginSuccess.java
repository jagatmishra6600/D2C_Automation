package com.automation.frigidaire.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;

public class EPIC_01_TC_02_AQA_Authentication_LoginSuccess extends BaseTest{
	 FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
	 String emailAddress = ConfigReader.getProperty("user.email");
 	 String password = ConfigReader.getProperty("user.password");
	 
	 @Test(groups = {"smoke", "regression"}, description = "User should be able to login Successfully with valid Credentials")
	    public void TC_02_S1_VerifyTestLoginSuccess() throws InterruptedException {
	        homePage.navigateToLoginPage()
	        		.login(emailAddress, password);

	        Assert.assertTrue(homePage.isHomePageLoaded(),"User is not navigated to HomePage after Logging in with Valid Credentials");
	        //Assert.assertTrue(homePage.isUserGreetingDropdownVisible(),"User Greeting Dropdown Button is not displayed");
	        ExtentReportManager.getTest().pass("User Logged In Using Valid Credentials and Navigated to HomePage");
	    }
}
