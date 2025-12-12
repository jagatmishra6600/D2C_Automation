package com.automation.fsus.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;



import com.automation.BaseTest;
import com.automation.familystoreus.pages.CustomerRegistrationPageActionsFsus;
import com.automation.familystoreus.pages.HomePageActionsFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.YopmailPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

public class EPIC_01_TC_01_AQA_Authentication_CustomerRegistration_Fsus extends BaseTest {
	 LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
	 YopmailPageActionsFsus yopmailPage = new YopmailPageActionsFsus();
	 CustomerRegistrationPageActionsFsus customerRegistrationPage = new CustomerRegistrationPageActionsFsus();
	 HomePageActionsFsus homePage = new HomePageActionsFsus();
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that a new user receives the email invitation, uses the invitation code, completes registration successfully, and is logged in with the correct greeting message.")
	    public void EPIC_01_TC_01_Verify_NewUserInvitation_And_RegistrationFlow() throws InterruptedException {
		 	var newUserEmail = UserTestData.getDisposableYopmailEmailAddress();
		 	var inviteUserData = UserTestData.getInviteUserData(newUserEmail);
		 	loginPage.loginWithDefaultCredentials()
						.navigateToMyAccountInviteFamilyFriendsPage()
						.inviteUser(inviteUserData)
						.logOut();
		 			
		 	var invitationCode =yopmailPage
			 						.openFirstMailInInbox(newUserEmail)
			 						.verifyUserInvitationMail(newUserEmail)
		 							.getInvitationCode();
		 	
		 	var createAccountData = UserTestData.getFSCreateAccountData(newUserEmail, invitationCode);
		 	Assert.assertTrue(yopmailPage.isFSRegistrationLinkDisplayed()
		 						,"Registration Link is not present in Invitation Mail");
	    	
		 	yopmailPage.clickOnRegistrationLink().clickregisterWithInvitationCodeLink();
		 	customerRegistrationPage.verifyCustomerRegistrationPageFieldsAndMessages()
		 							.createAccount(createAccountData);
		 	Assert.assertEquals(homePage.getUserGreetingMessage(), "Hello "+createAccountData.firstName()
		 								,"User Account is not created and is not navigated to HomePage");
	    	ExtentReportManager.getTest().pass("Verified that user received the invitation email, registered successfully using the invitation code, and logged in to the application.");  	    
	 }
}
