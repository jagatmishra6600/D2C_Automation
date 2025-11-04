package com.automation.frigidaire.tests.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.frigidaire.pages.FrigidaireCreateAccountPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidaireLoginPageActions;
import com.automation.frigidaire.pages.YopmailPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WebElementUtil;

public class TC_01_AQA_Authentication_CustomerRegistration extends BaseTest {
	 FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
	 FrigidaireLoginPageActions loginPage = new FrigidaireLoginPageActions();
	 FrigidaireCreateAccountPageActions createAccountPage = new FrigidaireCreateAccountPageActions();
	 YopmailPageActions yopmailPage = new YopmailPageActions();
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify LoginPage Fields and Messages")
	    public void TC_01_S1_VerifyLoginPageFields() {
	    	var loginPage = homePage.navigateToLoginPage();
	    	
	    	Assert.assertTrue(loginPage.isLoginPageLoaded(),"User is not navigated to LoginPage");
	    	Assert.assertTrue(loginPage.isLoginToFrigidaireTitleDisplayed(),"'Log in to Frigidaire' title is not present");
	    	Assert.assertTrue(loginPage.isLoginTitleMessageDisplayed(),"'Log in with your email and password: *' message is not present");
	    	Assert.assertTrue(loginPage.isEmailAddressFieldDisplayed(),"Email Address field is not displayed");
	    	Assert.assertTrue(loginPage.isPasswordFieldDisplayed(),"Password field is not displayed");
	    	Assert.assertTrue(loginPage.isShowPasswordIconDisplayed(),"'Show Password' icon is not displayed");
	    	Assert.assertTrue(loginPage.isKeepMeLoggedInCheckboxDisplayed(),"'Keep Me Logged In' checkbox is not displayed");
	    	Assert.assertEquals(loginPage.getNotRecommendedLabelText(),"This is not recommended if you are using a shared or public device.","Not Recommended Text Message not displayed");
	    	Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(),"Forgot Password Link is not displayed");
	    	Assert.assertTrue(loginPage.isCreateAccountLinkDisplayed(),"Create an Account Link is not displayed");
	    	Assert.assertEquals(loginPage.getElectroluxLinkedAccountMessage(),"*Frigidaire is part of the Electrolux Group. If you already have an account with Electrolux.com, you can use those details to login here."
	    																,"Electrolux Linked Account Message not displayed");
	    	Assert.assertTrue(loginPage.isAlternateLoginOptionsDisplayed(),"Sign in Options with Google or Apple is not Displayed");
	    	
	    	ExtentReportManager.getTest().pass("Login Page loaded Successfully and its Fields and Messages are verified");  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify Navigation to Customer Registration Page after Click On Create Account Link")
	    public void TC_01_S1_VerifyNavigationToCustomerRegistrationPage() {
		 	var createAccountPage = loginPage.navigateToCreateAccountPage();
		 				                      
		 	Assert.assertTrue(createAccountPage.isCreateAccountPageLoaded(),"User is not navigated to Customer Registration Page");
	    	
		 	ExtentReportManager.getTest().pass("User Successfully Navigated to Customer Registration Page After Click on Create Account Link in Login Page");  	    			 	  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify Customer Registration Page Fields And Messages")
	    public void TC_01_S2_VerifyCustomerRegistrationPage() {
		 	createAccountPage.navigateToCreateAccountPage();
		 	
		 	Assert.assertTrue(createAccountPage.isCreateAnAccountTitleDisplayed(),"Create An Account title is not displayed");
		 	Assert.assertEquals(createAccountPage.getCreateAccountSignUpMessage(),"Sign up and make the most of your home with the inspiring products and special offers that Frigidaire has for you."
		 												,"Create Account Sign Up Message is not displayed");    	
		 	Assert.assertTrue(createAccountPage.isEmailAddressFieldDisplayed(),"Email Address Field is not displayed");
		 	Assert.assertTrue(createAccountPage.isPasswordFieldDisplayed(),"Password Field is not displayed");
		 	Assert.assertTrue(createAccountPage.isConfirmPasswordFieldDisplayed(),"Confirm Password Field is not displayed");
		 	Assert.assertTrue(createAccountPage.isFirstNameFieldDisplayed(),"First Name Field is not displayed");
		 	Assert.assertTrue(createAccountPage.isLastNameFieldDisplayed(),"Last Name Field is not displayed");
		 	Assert.assertTrue(createAccountPage.isShowPasswordIconsDisplayed(),"Show Password Icons for Confirm Password and Password Fields are not Displayed");
		 	Assert.assertEquals(createAccountPage.getElectroluxLinkedAccountMessage(),"Your login credentials will work across the Electrolux group including Frigidaire.com and Electrolux.com."
										,"Electrolux linked Account Message is not Displayed");
		 	Assert.assertTrue(createAccountPage.isTermsAndConditionsLinkDisplayed(),"Terms and Conditions Link is not displayed");
		 	Assert.assertTrue(createAccountPage.isPrivacyPolicyLinkDisplayed(),"Privacy Policy Link is not displayed");
		 	Assert.assertTrue(createAccountPage.isSubmitButtonDisplayed(),"Submit Button is not displayed");
		 	Assert.assertTrue(createAccountPage.isHaveAnAccountAlreadyLinkDisplayed(),"Have an Account Already link is not displayed");
		 	Assert.assertTrue(createAccountPage.isAlternateLoginOptionsDisplayed(),"Sign in Options with Google or Apple is not Displayed");
		 	Assert.assertTrue(createAccountPage.isHereToHelpBannerDisplayed(),"We're here to help banner is not displayed");
		 	Assert.assertTrue(createAccountPage.isHereToHelpBannerPhoneSectionDisplayed(),"Help Banner with Phone Section is not displayed");
		 	Assert.assertTrue(createAccountPage.isHereToHelpBannerChatSectionDisplayed(),"Help Banner with Chat Section is not displayed");
		 	
		 	ExtentReportManager.getTest().pass("Verified Succesfully the Fields and Messages on Customer Registration Page");  	    			 	  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify verification email message and email receipt after account creation.")
	    public void TC_01_S3_S4_S5_VerifyVerificationEmailReceivedAfterAccountCreation() {

		 	var number = WebElementUtil.getRandomNumber(10000);
		 	var emailAddress = "automationTestEngineer+"+number+"@yopmail.com";
		 	var firstName = "TestFirstName";
		 	var lastName = "TestLastName";
		 	var password = ConfigReader.getProperty("user.password");
		 	createAccountPage.navigateToCreateAccountPage()
		 					.createAccount(emailAddress,password,firstName, lastName);
		 	
		 	Assert.assertEquals(createAccountPage.getVerificationEmailSentMessage(),"A verification email with a link to verify your account has been sent to you."
						,"'A verification email with a link to verify your account has been sent to you.' message is not displayed");

		 	yopmailPage.openFirstMailInInbox(emailAddress);
		 	Assert.assertTrue(yopmailPage.isClickHereToActivateAccountLinkDisplayed(),"Click Here to Activate Your Account link is not present in the mail"); 	
		 	Assert.assertEquals(yopmailPage.getMailGreetingMessage(), "Dear "+firstName+" "+lastName+",","Greeting Text does not contain First Name and Last Name");
		 	Assert.assertEquals(yopmailPage.getMailThanksForCreatingAccountMessage(), "Thanks for creating an account with Frigidaire. Please take a second to make sure we have your correct email address so that we can activate your account now. You can always change your password on your profile."
		 			               ,"Thank you for creating account body text is not present in the mail");
		 	Assert.assertTrue(yopmailPage.getLinkExpiresMessage().contains("This link expires in 24 hours."),"Link expires in 24 hours text is not present in the mail");
		 	Assert.assertEquals(yopmailPage.getNotIntendedRecipientMessage(),"If you are not the intended recipient of this email, please delete this message and contact us immediately. Thanks for your help."
		 									,"'If you are not intended recipient of this email' text is not present in the mail");
		 	Assert.assertTrue(yopmailPage.isMailFooterSocialMediaLinksDisplayed(),"Social Media Links are present in the mail footer section");
		 	
		 	ExtentReportManager.getTest().pass("Verified that the 'Verification Email Sent' message is displayed on UI and the corresponding verification email with correct content and activation link is received.");	  	    
	 }

}
