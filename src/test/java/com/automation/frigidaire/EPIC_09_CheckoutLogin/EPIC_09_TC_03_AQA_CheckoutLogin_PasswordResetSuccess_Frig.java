package com.automation.frigidaire.EPIC_09_CheckoutLogin;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.CheckoutForgotPasswordPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.MailDropPageActionsFrig;
import com.automation.frigidaire.pages.ResetPasswordPageActionsFrig;
import com.automation.frigidaire.pages.ShippingAddressPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

@Test
public class EPIC_09_TC_03_AQA_CheckoutLogin_PasswordResetSuccess_Frig extends BaseTest {
	HomePageActionsFrig homePage = new HomePageActionsFrig();
	ShippingAddressPageActionsFrig shippingAddressPage = new ShippingAddressPageActionsFrig();
	CheckoutForgotPasswordPageActionsFrig forgotPasswordPage = new CheckoutForgotPasswordPageActionsFrig();
	MailDropPageActionsFrig mailDropPage = new MailDropPageActionsFrig();
	ResetPasswordPageActionsFrig resetPasswordPage = new ResetPasswordPageActionsFrig();
	String emailAddress = UserTestData.getUserName();

	@Test(groups = { "smoke",
			"regression" }, description = "Verify the checkout login forgot password flow from the Shipping Address page, including reset email validation, password reset success messages, and login option display.")
	public void EPIC_09_CheckoutLogin_TC_02_VerifyCheckoutPasswordResetSuccessFlow() {
		navigateToShippingAddressPage();
		shippingAddressPage.clickLoginButton().clickForgotPasswordLink().resetPassword(UserTestData.getUserName());
		assertTrue(forgotPasswordPage.isCheckYourEmailMessageDisplayed(),
				"Check your Email Label and Message is not displayed");
		mailDropPage.openFirstMailInInbox(emailAddress, "Password Reset").verifyFrigidaireResponseMailIsCorrect()
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
		homePage.navigateToHomePage().clickFrenchDoor().closePopupModel().clickProvidedProduct().clickDeliveryOption()
				.clickAddToCartButton().clickSaveAndViewCartButton().clickProceedToCheckOutButton();
	}
}
