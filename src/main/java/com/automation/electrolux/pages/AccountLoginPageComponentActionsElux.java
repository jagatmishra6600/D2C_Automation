package com.automation.electrolux.pages;

import com.automation.electrolux.locators.AccountLoginLocatorsElux;
import com.automation.electrolux.locators.LoginPageLocatorsElux;
import com.automation.frigidaire.locators.AccountLoginLocatorsFrig;
import com.automation.frigidaire.locators.LoginLocatorsFrig;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import com.automation.utils.UserTestData;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class AccountLoginPageComponentActionsElux {
	private AccountLoginLocatorsElux accountLogin_Locators = new AccountLoginLocatorsElux();
	
	public ShippingAddressPageActionsElux login(String emailAddress, String password) {
		 enterEmailAddress(emailAddress)
						.enterPassword(password)
						.clickLoginButton();
		 //Handling 2 Refreshes before the page becomes stable
		 WaitUtils.waitForPageLoad();  
	     WaitUtils.waitForPageLoad();
		 return new ShippingAddressPageActionsElux();	
	}
	 
	public AccountLoginPageComponentActionsElux enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(LoginPageLocatorsElux.emailAddressInput, emailAddress);
		return this;
	}
	
	public AccountLoginPageComponentActionsElux enterPassword(String password) {
		WebElementUtil.sendKeys(LoginPageLocatorsElux.passwordInput, password);
		return this;
	}
	
	public ShippingAddressPageActionsElux clickLoginButton() {
		WebElementUtil.clickElement(LoginPageLocatorsElux.loginButton);
		return new ShippingAddressPageActionsElux();
	}
	
	public boolean isAccountLoginPageComponentLoaded() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.loginButton);
	}
	
	
	public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.emailAddressInput);
	}
	
	public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.passwordInput);
	}
	
	public boolean isShowPasswordIconDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.showPasswordIcon);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return WebElementUtil.isDisplayed(accountLogin_Locators.forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return WebElementUtil.isDisplayed(accountLogin_Locators.createAccountLink);
	}
	
	public String getElectroluxLinkedAccountMessage() {
		return WebElementUtil.getText(LoginPageLocatorsElux.frigidaireLinkedAccountMessage);
	}
	
	public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	}
	
	public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.signInWithAppleButton);
	}
	
	public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.signInWithGoogleButton);
	}
	
	public ForgotPasswordPageActionsElux clickForgotPasswordLink() {
		WebElementUtil.clickElement(accountLogin_Locators.forgotPasswordLink);
		return new ForgotPasswordPageActionsElux();
	}
	
	public boolean isAccountLoginTitleDisplayed() {
		return WebElementUtil.isDisplayed(accountLogin_Locators.accountLoginTitle);
	}
	
	public boolean isContinueAsGuestLinkDisplayed() {
		return WebElementUtil.isDisplayed(accountLogin_Locators.continueAsGuestLink);	
	}
	
	public AccountLoginPageComponentActionsElux verifyAccountLoginPageComponentFieldsAndMessages() {
	   assertTrue(isAccountLoginPageComponentLoaded(), "User is not navigated to LoginPage");
       assertTrue(isAccountLoginTitleDisplayed(), "'Account Login' title is not present");
       assertTrue(isEmailAddressFieldDisplayed(), "Email Address field is not displayed");
       assertTrue(isPasswordFieldDisplayed(), "Password field is not displayed");
       assertTrue(isShowPasswordIconDisplayed(), "'Show Password' icon is not displayed");
       assertTrue(isForgotPasswordLinkDisplayed(), "Forgot Password Link is not displayed");
       assertTrue(isCreateAccountLinkDisplayed(), "Create an Account Link is not displayed");
       assertEquals(getFrigidaireLinkedAccountMessage(), "If you already have an account with Frigidaire.com, you can use those details to log in here."
       												,"Frigidaire Linked Account Message Not Displayed");
       assertTrue(isAlternateLoginOptionsDisplayed(), "Sign in Options with Google or Apple is not Displayed");
       assertTrue(isContinueAsGuestLinkDisplayed(), "'Continue as guest' link is not displayed");
       return this;
	}

	public ShippingAddressPageActionsElux loginWithDefaultCredentials() {
		return login(UserTestData.getUserName(),UserTestData.getPassword());
	}
	
	public String getFrigidaireLinkedAccountMessage() {
		return WebElementUtil.getText(accountLogin_Locators.frigidaireLinkedAccountMessage);
	}
}
