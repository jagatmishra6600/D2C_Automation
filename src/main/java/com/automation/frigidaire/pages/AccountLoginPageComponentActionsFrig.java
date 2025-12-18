package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.AccountLoginLocatorsFrig;
import com.automation.frigidaire.locators.LoginLocatorsFrig;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.automation.utils.UserTestData;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class AccountLoginPageComponentActionsFrig {
	private LoginLocatorsFrig login_Locators = new LoginLocatorsFrig();
	private AccountLoginLocatorsFrig accountLogin_Locators = new AccountLoginLocatorsFrig();
	
	 public ShippingAddressPageActionsFrig login(String emailAddress, String password) {
		 return	 enterEmailAddress(emailAddress)
								.enterPassword(password)
								.clickLoginButton();
	 }
	 
	public AccountLoginPageComponentActionsFrig enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(login_Locators.emailAddressInput, emailAddress);
		return this;
	}
	
	public AccountLoginPageComponentActionsFrig enterPassword(String password) {
		WebElementUtil.sendKeys(login_Locators.passwordInput, password);
		return this;
	}
	
	public ShippingAddressPageActionsFrig clickLoginButton() {
		WebElementUtil.clickElement(login_Locators.loginButton);
		return new ShippingAddressPageActionsFrig();
	}
	
	public boolean isAccountLoginPageComponentLoaded() {
		return WebElementUtil.isDisplayed(login_Locators.loginButton);
	}
	
	
	public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(login_Locators.emailAddressInput);
	}
	
	public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(login_Locators.passwordInput);
	}
	
	public boolean isShowPasswordIconDisplayed() {
		return WebElementUtil.isDisplayed(login_Locators.showPasswordIcon);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return WebElementUtil.isDisplayed(accountLogin_Locators.forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return WebElementUtil.isDisplayed(accountLogin_Locators.createAccountLink);
	}
	
	public String getElectroluxLinkedAccountMessage() {
		return WebElementUtil.getText(login_Locators.electroluxLinkedAccountMessage);
	}
	
	public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	}
	
	public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(login_Locators.signInWithAppleButton);
	}
	
	public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(login_Locators.signInWithGoogleButton);
	}
	
	public ForgotPasswordPageActionsFrig clickForgotPasswordLink() {
		WebElementUtil.clickElement(accountLogin_Locators.forgotPasswordLink);
		return new ForgotPasswordPageActionsFrig();
	}
	
	public boolean isAccountLoginTitleDisplayed() {
		return WebElementUtil.isDisplayed(accountLogin_Locators.accountLoginTitle);
	}
	
	public boolean isContinueAsGuestLinkDisplayed() {
		return WebElementUtil.isDisplayed(accountLogin_Locators.continueAsGuestLink);	
	}
	
	public AccountLoginPageComponentActionsFrig verifyAccountLoginPageComponentFieldsAndMessages() {
	   assertTrue(isAccountLoginPageComponentLoaded(), "User is not navigated to LoginPage");
       assertTrue(isAccountLoginTitleDisplayed(), "'Account Login' title is not present");
       assertTrue(isEmailAddressFieldDisplayed(), "Email Address field is not displayed");
       assertTrue(isPasswordFieldDisplayed(), "Password field is not displayed");
       assertTrue(isShowPasswordIconDisplayed(), "'Show Password' icon is not displayed");
       assertTrue(isForgotPasswordLinkDisplayed(), "Forgot Password Link is not displayed");
       assertTrue(isCreateAccountLinkDisplayed(), "Create an Account Link is not displayed");
       assertEquals(getElectroluxLinkedAccountMessage(), "Frigidaire is part of the Electrolux Group. If you already have an account with Electrolux.com, you can use those details to login here."
       												,"Electrolux Linked Account Message Not Displayed");
       assertTrue(isAlternateLoginOptionsDisplayed(), "Sign in Options with Google or Apple is not Displayed");
       assertTrue(isContinueAsGuestLinkDisplayed(), "'Continue as guest' link is not displayed");
       return this;
	}

	public ShippingAddressPageActionsFrig loginWithDefaultCredentials() {
		var isLoginSectionDisplayed = login(UserTestData.getUserName(),UserTestData.getPassword())
				.isLoginSectionDisplayed();
		if(isLoginSectionDisplayed) {
			WaitUtils.waitForPageLoad();
		}
		return new ShippingAddressPageActionsFrig();
	}
}
