package com.automation.frigidaire.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.BaseTest;


import com.automation.frigidaire.pages.CreateAccountPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.LoginPageActionsFrig;
import com.automation.frigidaire.pages.YopmailPageActionsFrig;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;

@Test(singleThreaded = true)
public class EPIC_01_TC_01_AQA_Authentication_CustomerRegistration_Frig extends BaseTest {
	 HomePageActionsFrig homePage = new HomePageActionsFrig();
	    LoginPageActionsFrig loginPage = new LoginPageActionsFrig();
	    CreateAccountPageActionsFrig createAccountPage = new CreateAccountPageActionsFrig();
	    YopmailPageActionsFrig yopmailPage = new YopmailPageActionsFrig();
	    String password = ConfigReader.getProperty("user.password");

	    @Test(groups = {"smoke", "regression"}, description = "Verify LoginPage Fields and Messages")
	    public void EPIC_01_Authentication_TC_01_S1_VerifyLoginPageFields() {
	        var loginPage = homePage.navigateToLoginPage();
	        loginPage.verifyLoginPageFieldsAndMessages();
	        ExtentReportManager.getTest().pass("Login Page loaded Successfully and its Fields and Messages are verified");
	    }

	    @Test(groups = {"smoke", "regression"}, description = "Verify Navigation to Customer Registration Page after Click On Create Account Link")
	    public void EPIC_01_Authentication_TC_01_S1_VerifyNavigationToCustomerRegistrationPage() {
	        var createAccountPage = loginPage.navigateToCreateAccountPage();
	        Assert.assertTrue(createAccountPage.isCreateAccountPageLoaded(), "User is not navigated to Customer Registration Page");
	        ExtentReportManager.getTest().pass("User Successfully Navigated to Customer Registration Page After Click on Create Account Link in Login Page");
	    }

	    @Test(groups = {"smoke", "regression"}, description = "Verify Customer Registration Page Fields And Messages")
	    public void EPIC_01_Authentication_TC_01_S2_VerifyCustomerRegistrationPage() {
	        createAccountPage.navigateToCreateAccountPage();
	        createAccountPage.verifyCreateAccountPageFieldAndMessages();
	        ExtentReportManager.getTest().pass("Verified Succesfully the Fields and Messages on Customer Registration Page");
	    }

	    @Test(groups = {"smoke", "regression"}, description = "Verify verification email message and email receipt after account creation.")
	    public void EPIC_01_Authentication_TC_01_S3_S4_S5_VerifyVerificationEmailReceivedAfterAccountCreation() throws InterruptedException {

	        var number = WebElementUtil.getRandomNumber(10000);
	        var emailAddress = "automationTestEngineer+" + number + "@yopmail.com";
	        var firstName = "TestFirstName";
	        var lastName = "TestLastName";
	        createAccountPage.navigateToCreateAccountPage().createAccount(emailAddress, password, firstName, lastName);

	        Assert.assertTrue(createAccountPage.getVerificationEmailSentMessage().contains("Almost there! We’ve sent a verification link to your email. Click the link to finish setting up your account")
	        						,"Verification Email Sent Message is not displayed");

	        yopmailPage.openFirstMailInInbox(emailAddress);
	        yopmailPage.verifyCustomerRegistrationVerificationMail(firstName, lastName);
	       
	        ExtentReportManager.getTest().pass("Verified that the 'Verification Email Sent' message is displayed on UI and the corresponding verification email with correct content and activation link is received.");
	    }
}
