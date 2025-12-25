package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.AccountLoginLocatorsFrig;
import com.automation.frigidaire.locators.LoginLocatorsFrig;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import com.automation.utils.UserTestData;


public class AccountLoginPageComponentActionsFrig {
	private final LoginLocatorsFrig login_Locators = new LoginLocatorsFrig();
	private final AccountLoginLocatorsFrig accountLogin_Locators = new AccountLoginLocatorsFrig();
	
	public ShippingAddressPageActionsFrig login(String emailAddress, String password) {
		 enterEmailAddress(emailAddress)
						.enterPassword(password)
						.clickLoginButton();
		 //Handling 2 Refreshes before the page becomes stable
		 waitForPageLoad();
	     waitForPageLoad();
		 return new ShippingAddressPageActionsFrig();	
	}
	 
	public AccountLoginPageComponentActionsFrig enterEmailAddress(String emailAddress) {
		sendKeys(login_Locators.emailAddressInput, emailAddress);
		return this;
	}
	
	public AccountLoginPageComponentActionsFrig enterPassword(String password) {
		sendKeys(login_Locators.passwordInput, password);
		return this;
	}
	
	public ShippingAddressPageActionsFrig clickLoginButton() {
		clickElement(login_Locators.loginButton);
		return new ShippingAddressPageActionsFrig();
	}
	
	public boolean isAccountLoginPageComponentLoaded() {
		return isDisplayed(login_Locators.loginButton);
	}
	
	
	public boolean isEmailAddressFieldDisplayed() {
		return isDisplayed(login_Locators.emailAddressInput);
	}
	
	public boolean isPasswordFieldDisplayed() {
		return isDisplayed(login_Locators.passwordInput);
	}
	
	public boolean isShowPasswordIconDisplayed() {
		return isDisplayed(login_Locators.showPasswordIcon);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return isDisplayed(accountLogin_Locators.forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return isDisplayed(accountLogin_Locators.createAccountLink);
	}
	
	public String getElectroluxLinkedAccountMessage() {
		return getText(login_Locators.electroluxLinkedAccountMessage);
	}
	
	public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	}
	
	public boolean isSignInWithAppleButtonDisplayed() {
		return isDisplayed(login_Locators.signInWithAppleButton);
	}
	
	public boolean isSignInWithGoogleButtonDisplayed() {
		return isDisplayed(login_Locators.signInWithGoogleButton);
	}
	
	public ForgotPasswordPageActionsFrig clickForgotPasswordLink() {
		clickElement(accountLogin_Locators.forgotPasswordLink);
		return new ForgotPasswordPageActionsFrig();
	}
	
	public boolean isAccountLoginTitleDisplayed() {
		return isDisplayed(accountLogin_Locators.accountLoginTitle);
	}
	
	public boolean isContinueAsGuestLinkDisplayed() {
		return isDisplayed(accountLogin_Locators.continueAsGuestLink);	
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
		return login(UserTestData.getUserName(),UserTestData.getPassword());
	}
}
