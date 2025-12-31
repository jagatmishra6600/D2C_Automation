package com.automation.electrolux.EPIC_09_CheckoutLogin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.ShippingAddressPageActionsElux;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

@Test
public class EPIC_09_TC_02_AQA_CheckoutLogin_Login_Elux extends BaseTest {
	HomePageActionsElux homePage = new HomePageActionsElux();
	ShippingAddressPageActionsElux shippingAddressPage = new ShippingAddressPageActionsElux();
	String productSKU = "ELFW7437AG";
	
	@Test(groups = { "smoke",
			"regression" }, description = "Verify that the Login section on the Checkout Shipping Address page displays correct UI, messages, fields  and allows the user to successfully log in with valid credentials.")
	public void EPIC_09_CheckoutLogin_TC_02_VerifyCheckoutLoginSectionAndUserLoginSuccess() {
		navigateToShippingAddressPage();
		assertTrue(shippingAddressPage.isLoginSectionDisplayed(),
				"Log In Section is not present in the Checkout Shipping Address Page");
		assertTrue(shippingAddressPage.isLoginButtonDisplayed(),
				"Log In Button is not displayed in the Checkout Shipping Address Page");
		assertEquals(shippingAddressPage.getAlreadyHaveAccountMessage(), "Already have an account?",
				"'Already have an account?' message is not displayed in the Login Section of Checkout Shipping Address Page");
		assertEquals(shippingAddressPage.getFasterCheckoutLoginMessage(),
				"Login for faster checkout or continue as a guest below.",
				"'Login for faster checkout or continue as a guest below.' message is not displayed in the Login Section of Checkout Shipping Address Page");

		shippingAddressPage.clickLoginButton().verifyAccountLoginPageComponentFieldsAndMessages()
				.loginWithDefaultCredentials();

		assertEquals(shippingAddressPage.getWelcomeBackGreetingMessage(), "Welcome back, " + UserTestData.FIRST_NAME,
				"Welcome Back Greeting Message not displayed in the Checkout Shipping Address Page - Login Failed");
		assertTrue(shippingAddressPage.isLogoutLinkDisplayed(),
				"Logout Link is not displayed after logging through valid credentials in the Checkout Shipping Address Page");
		ExtentReportManager.getTest()
				.pass("Verified Login section UI, fields and messages on the Checkout Shipping Address page, "
						+ "and confirmed successful valid user login with welcome greeting and logout link.");
	}
	
	private void navigateToShippingAddressPage() {
		homePage.navigateToHomePage().clickSearchAndEnterProductId(productSKU).clickSearchIcon()
				.clickProvidedProduct().closePopupModel().clickAddToCartButton()
				.clickSaveAndViewCartButton().clickProceedToCheckOutButton();
	}

}
