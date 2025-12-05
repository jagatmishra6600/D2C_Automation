package com.automation.electrolux.EPIC_01_Authentication;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ForgotPasswordPageActions;
import com.automation.electrolux.pages.HomePageActions;
import com.automation.electrolux.pages.ResetPasswordPageActions;
import com.automation.electrolux.pages.MailDropPageActions;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

public class EPIC_01_TC_03_AQA_Authentication_Password_Reset_Success extends BaseTest{
	 HomePageActions homePage = new HomePageActions();
	 ForgotPasswordPageActions forgotPasswordPage = new ForgotPasswordPageActions();
	 MailDropPageActions mailDropPage = new MailDropPageActions();
	 ResetPasswordPageActions resetPasswordPage = new ResetPasswordPageActions();
	 String emailAddress = UserTestData.getUserName(); 
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that a user can successfully reset their password through the Electrolux website and that the corresponding password reset and confirmation emails are received and validated.")
	    public void EPIC_01_TC_03_VerifyPasswordResetFlowAndEmailNotifications() throws InterruptedException {
		 	homePage.navigateToResetPasswordPage();
		 	forgotPasswordPage.verifyForgotPasswordPage()
		 					.resetPassword(emailAddress);
		    Assert.assertTrue(forgotPasswordPage.isCheckYourInboxMessageDisplayed(), "Check Your Inbox Message and Label is not displayed");
			mailDropPage.openFirstMailInInbox(emailAddress, "Reset your Electrolux password")
	        			.verifyElectroluxPasswordResetMail()
        				.clickMailResetYourPasswordLink();
	        resetPasswordPage.verifyResetPasswordPage()
	        			.resetPassword(UserTestData.getPassword());
	        mailDropPage.openFirstMailInInbox(emailAddress, "Electrolux: Password Reset Confirmation")
	        			.verifyElectroluxPasswordResetSuccessMail();
	        ExtentReportManager.getTest().pass("Password reset flow completed successfully. Verified reset email, reset confirmation email, and all related UI elements."); 	
		}

}
