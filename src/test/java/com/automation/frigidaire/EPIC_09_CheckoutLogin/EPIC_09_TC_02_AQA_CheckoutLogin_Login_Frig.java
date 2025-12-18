package com.automation.frigidaire.EPIC_09_CheckoutLogin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.ShippingAddressPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;
import com.automation.utils.WaitUtils;

@Test
public class EPIC_09_TC_02_AQA_CheckoutLogin_Login_Frig extends BaseTest {
	HomePageActionsFrig homePage = new HomePageActionsFrig();
	ShippingAddressPageActionsFrig shippingAddressPage = new ShippingAddressPageActionsFrig();
	
	@Test(groups = { "smoke", "regression" }, description = "Verify that the Login section on the Shipping Address page displays correct messages and allows the user to successfully log in with valid credentials.")
	public void EPIC_09_CheckoutLogin_TC_02_VerifyShippingAddressLoginSection() {
		navigateToShippingAddressPage();
		
		assertTrue(shippingAddressPage.isLoginSectionDisplayed(),"Log In Section is not present in the Shipping Address Page");
		assertTrue(shippingAddressPage.isLoginButtonDisplayed(),"Log In Button is not displayed in the Shipping Address Page");
		assertEquals(shippingAddressPage.getAlreadyHaveAccountMessage(), "Already have an account?",
				"'Already have an account?' message is not displayed in the Login Section of Shipping Address Page");
		assertEquals(shippingAddressPage.getFasterCheckoutLoginMessage(),"Login for faster checkout or continue as a guest below.",
				"'Login for faster checkout or continue as a guest below.' message is not displayed in the Login Section of Shipping Address Page");
		
		shippingAddressPage.clickLoginButton()
							.verifyAccountLoginPageComponentFieldsAndMessages()
							.loginWithDefaultCredentials();
		
		assertEquals(shippingAddressPage.getWelcomeBackGreetingMessage(), "Welcome back, " + UserTestData.FIRST_NAME,
				"Welcome Back Greeting Message not displayed in the Shipping Details Page - Login Failed");
		assertTrue(shippingAddressPage.isLogoutLinkDisplayed(),
				"Logout Link is not displayed after logging through valid credentials");
		ExtentReportManager.getTest().pass(
			    "Verified Login section UI and messages on the Shipping Address page, validated Login page fields, " +
			    "and confirmed successful user login with welcome greeting and logout link.");
		}
	
	private void navigateToShippingAddressPage() {
		homePage.navigateToHomePage();
		WaitUtils.untilPageLoadComplete();
		homePage.clickFrenchDoor().closePopupModel().clickProvidedProduct().clickDeliveryOption().clickAddToCartButton()
				.clickSaveAndViewCartButton().clickProceedToCheckOutButton();
	}
}
