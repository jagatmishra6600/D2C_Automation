package com.automation.frigidaire.tests.EPIC_01_Authentication;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;

public class TC_01_AQA_Authentication_CustomerRegistration extends BaseTest {
	 FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify LoginPage Fields and Messages")
	    public void TC_01_S1_VerifyLoginPageFields() {

	    	var loginPage = homePage.navigateToHomePage().navigateToLoginPage();
	    	
	    	Assert.assertTrue(loginPage.isLoginPageLoaded(),"User is not navigated to LoginPage");
	    	Assert.assertTrue(loginPage.isLoginToFrigidaireTitleDisplayed(),"'Log in to Frigidaire' title is not present");
	    	Assert.assertTrue(loginPage.isLoginTitleMessageDisplayed(),"'Log in with your email and password: *' message is not present");
	    	Assert.assertTrue(loginPage.isShowPasswordIconDisplayed(),"'Show Password' icon is not displayed");
	    	Assert.assertTrue(loginPage.isKeepMeLoggedInCheckboxDisplayed(),"'Keep Me Logged In' checkbox is not displayed");
	    	Assert.assertEquals(loginPage.getNotRecommendedLabelText(),"This is not recommended if you are using a shared or public device.","Not Recommended Text Message not displayed");
	    	Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(),"Forgot Password Link is not displayed");
	    	Assert.assertTrue(loginPage.isCreateAccountLinkDisplayed(),"Create an Account Link is not displayed");
	    	Assert.assertEquals(loginPage.getElectroluxLinkedAccountMessage(),"*Frigidaire is part of the Electrolux Group. If you already have an account with Electrolux.com, you can use those details to login here."
	    																,"Electrolux Linked Account Message not displayed");
	    	Assert.assertTrue(loginPage.isAlternateLoginOptionsDisplayed(),"Sign in Options with Google or Apple is not Displayed");
	    	
	    	ExtentReportManager.getTest().pass("Login Page loaded Successfully and its Fields and Messages are verified successfully");  	    
	 }

}
