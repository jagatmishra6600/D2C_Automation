package com.automation.electrolux.EPIC_09_CheckoutLogin;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.electrolux.pages.CheckoutForgotPasswordPageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.MailDropPageActionsElux;
import com.automation.electrolux.pages.ResetPasswordPageActionsElux;
import com.automation.electrolux.pages.ShippingAddressPageActionsElux;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

@Test
public class EPIC_09_TC_03_AQA_CheckoutLogin_PasswordResetSuccess_Frig extends BaseTest {
	HomePageActionsElux homePage = new HomePageActionsElux();
	ShippingAddressPageActionsElux shippingAddressPage = new ShippingAddressPageActionsElux();
	CheckoutForgotPasswordPageActionsElux forgotPasswordPage = new CheckoutForgotPasswordPageActionsElux();
	MailDropPageActionsElux mailDropPage = new MailDropPageActionsElux();
	ResetPasswordPageActionsElux resetPasswordPage = new ResetPasswordPageActionsElux();
	String emailAddress = UserTestData.getUserName();
	String productSKU = "ELFW7437AG";

	@Test(groups = { "smoke","regression" }, description = "Verify the checkout login forgot password flow from the Shipping Address page, including reset email validation, password reset success messages, and login option display.")
	public void EPIC_09_CheckoutLogin_TC_02_VerifyCheckoutPasswordResetSuccessFlow() {
		navigateToShippingAddressPage();
		shippingAddressPage.clickLoginButton().clickForgotPasswordLink().resetPassword(emailAddress);
		assertTrue(forgotPasswordPage.isCheckYourEmailMessageDisplayed(),"Check your Email Label and Message is not displayed");
		mailDropPage.openFirstMailInInbox(emailAddress, "Reset your Electrolux password").verifyElectroluxPasswordResetMail()
				.clickMailResetYourPasswordLink().verifyResetPasswordPage().resetPassword(UserTestData.getPassword());
		assertTrue(resetPasswordPage.getResetSuccessMessage().contains("Your password has been changed successfully."),
				"'Your Password has been changed successfully' message is not displayed in Reset Password page");
		assertTrue(resetPasswordPage.getResetSuccessMessage().contains("Log in with your new password."),
				"'Log in with your new password.' message is not displayed in Reset Password page");
		assertTrue(resetPasswordPage.isLoginToYourAccountLinkDisplayed(),
				"Log in to your account Link is not displayed in the Reset password page");
		
		ExtentReportManager.getTest().pass(
			    "Successfully validated the end-to-end checkout password reset flow initiated from the Shipping Address login section, "
			  + "including reset email verification, password update confirmation, "
			  + "and availability of the login option on the Reset Password page.");
		}

	 private void navigateToShippingAddressPage() {
		homePage.navigateToHomePage().clickSearchAndEnterProductId(productSKU).clickSearchIcon()
		.selectFirstProductFromSearchResults().closePopupModel().clickAddToCartButton()
		.clickSaveAndViewCartButton().clickProceedToCheckOutButton();
	}
}
