package com.automation.electrolux.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.electrolux.pages.CreateAccountPageActions;
import com.automation.electrolux.pages.HomePageActions;
import com.automation.electrolux.pages.LoginPageActions;
import com.automation.electrolux.pages.MailDropPageActions;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

@Test(singleThreaded = true)
public class EPIC_01_TC_01_AQA_Authentication_CustomerRegistration extends BaseTest {
 	HomePageActions homePage = new HomePageActions();
 	LoginPageActions loginPage = new LoginPageActions();
 	CreateAccountPageActions createAccountPage = new CreateAccountPageActions();
    MailDropPageActions mailDropPage = new MailDropPageActions();

    @Test(groups = {"smoke", "regression"}, description = "Verify LoginPage Fields and Messages")
    public void EPIC_01_Authentication_TC_01_S1_VerifyLoginPageFields() {
        var loginPage = homePage.navigateToHomePage().navigateToLoginPage();
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
    	var createAccountData = UserTestData.getCreateAccountData();
        createAccountPage.navigateToCreateAccountPage()
        				.createAccount(createAccountData);
        Assert.assertTrue(createAccountPage.getVerificationEmailSentMessage().contains("Almost there! We’ve sent a verification link to your email. Click the link to finish setting up your account")
				,"Verification Email Sent message is not displayed");
        mailDropPage.openFirstMailInInbox(createAccountData.emailAddress());
        mailDropPage.verifyCustomerRegistrationVerificationMail(createAccountData.firstName(), createAccountData.lastName());
        ExtentReportManager.getTest().pass("Verified that the 'Verification Email Sent' message is displayed on UI and the corresponding verification email with correct content and activation link is received.");
    }
}
