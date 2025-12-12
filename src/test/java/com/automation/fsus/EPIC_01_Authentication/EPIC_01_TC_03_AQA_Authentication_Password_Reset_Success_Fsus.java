package com.automation.fsus.EPIC_01_Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.familystoreus.pages.ForgotPasswordPageActionsFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.MailDropPageActionsFsus;
import com.automation.familystoreus.pages.ResetPasswordPageActionsFsus;
import com.automation.BaseTest;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

public class EPIC_01_TC_03_AQA_Authentication_Password_Reset_Success_Fsus extends BaseTest {
	private LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
	private MailDropPageActionsFsus mailDropPage = new MailDropPageActionsFsus();
	private ForgotPasswordPageActionsFsus forgotPasswordPage = new ForgotPasswordPageActionsFsus();
	private ResetPasswordPageActionsFsus resetPasswordPage = new ResetPasswordPageActionsFsus();
	private String emailAddress = "familystoreresetpasswordaccount@maildrop.cc";

	@Test(groups = { "smoke","regression" }, description = "Validate the complete password reset flow including email notification, reset link navigation, new password submission, and UI success confirmation.")
	public void EPIC_01_TC_03_VerifyPasswordResetAndEmailNotificationFlow() {
		var newPassword = UserTestData.generateRandomPassword();
		loginPage.resetPassword(emailAddress);
		Assert.assertTrue(forgotPasswordPage.isPasswordResetEmailSentMessageDisplayed(),
				"Password Reset Mail Sent Success Message is not displayed");
		Assert.assertTrue(forgotPasswordPage.isPasswordResetEmailSentMessageCorrect(),
				"Password Reset Mail Sent Success Message is Incorrect");
		mailDropPage.openFirstMailInInbox(emailAddress, "Please reset your password")
				.verifyPasswordResetMail()
				.clickMailResetYourPasswordLink()
				.verifyResetPasswordFieldAndButtons()
				.resetPassword(newPassword);
		Assert.assertTrue(resetPasswordPage.isResetPasswordSuccessMessageDisplayed(),
				"Your password has been successfully reset! You may now log in by going to Login page. message is not displayed After reset password");
		Assert.assertTrue(resetPasswordPage.isLoginLinkDisplayed(),
				"Login Link is not displayed after resetting password");
		ExtentReportManager.getTest().pass(
				"Password reset flow validated: reset request sent, reset email received and contents verified, reset link used to set new password, and success confirmation and login link displayed.");
	}

}
