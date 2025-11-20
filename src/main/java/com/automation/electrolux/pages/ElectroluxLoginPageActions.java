package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.Electrolux_LoginPageLocators;
import com.automation.utils.ConfigReader;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class ElectroluxLoginPageActions {

	 
	 public ElectroluxLoginPageActions navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"login");
       try {
           WebElement acceptBtn = untilClickable(Electrolux_LoginPageLocators.acceptButtonLocator, 20);
           if (acceptBtn != null) {
               acceptBtn.click();
           }
       } catch (Exception ignored) {
           // Cookie banner not present or not interactable; continue
       }
       return this;
	}
	
	 public ElectroluxHomePageActions login(String emailAddress, String password) throws InterruptedException {
		 enterEmailAddress(emailAddress)
							 .enterPassword(password);
		 WaitUtils.sleep(4000);
		 return clickLoginButton();
	 }
	 
	public ElectroluxLoginPageActions enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(Electrolux_LoginPageLocators.emailAddressInput, emailAddress);
		return this;
	}
	
	public ElectroluxLoginPageActions enterPassword(String password) {
		WebElementUtil.sendKeys(Electrolux_LoginPageLocators.passwordInput, password);
		return this;
	}
	
	public ElectroluxHomePageActions clickLoginButton() {
		WebElementUtil.clickElement(Electrolux_LoginPageLocators.loginButton);
		return new ElectroluxHomePageActions();
	}
	
	public boolean isLoginPageLoaded() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.loginButton);
	}
	
	public boolean isLoginToFrigidaireTitleDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.loginToStoreTitle);
	}
	
	public boolean isLoginTitleMessageDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.loginTitleMessage);
	}
	
	public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.emailAddressInput);
	}
	
	public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.passwordInput);
	}
	
	public boolean isShowPasswordIconDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.showPasswordIcon);
	}
	
	public boolean isKeepMeLoggedInCheckboxDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.keepMeLoggedInCheckbox);
	}
	
	public String getNotRecommendedLabelText() {
		return WebElementUtil.getText(Electrolux_LoginPageLocators.notRecommendedMessage);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.createAccountLink);
	}
	
	public String getElectroluxLinkedAccountMessage() {
		return WebElementUtil.getText(Electrolux_LoginPageLocators.electroluxLinkedAccountMessage);
	}
	
	public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	}
	
	public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.signInWithAppleButton);
	}
	
	public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.signInWithGoogleButton);
	}
	
	public boolean isLoginToStoreTitleDisplayed() {
		return WebElementUtil.isDisplayed(Electrolux_LoginPageLocators.loginToStoreTitle);
	}
	
	public void verifyLoginPageFieldsAndMessages() {
		Assert.assertTrue(isLoginPageLoaded(),"User is not navigated to LoginPage");
    	Assert.assertTrue(isLoginToStoreTitleDisplayed(),"'Log in to Electrolux' title is not present");
    	Assert.assertTrue(isEmailAddressFieldDisplayed(),"Email Address field is not displayed");
    	Assert.assertTrue(isPasswordFieldDisplayed(),"Password field is not displayed");
    	Assert.assertTrue(isShowPasswordIconDisplayed(),"'Show Password' icon is not displayed");
    	Assert.assertTrue(isKeepMeLoggedInCheckboxDisplayed(),"'Keep Me Logged In' checkbox is not displayed");
    	Assert.assertTrue(isForgotPasswordLinkDisplayed(),"Forgot Password Link is not displayed");
    	Assert.assertTrue(isCreateAccountLinkDisplayed(),"Create an Account Link is not displayed");
    	Assert.assertEquals(getElectroluxLinkedAccountMessage(),"If you already have an account with Frigidaire.com, a part of the Electrolux Group, you can use those details to log in."
    																,"Frigidaire Linked Account Message not displayed");
    	Assert.assertTrue(isAlternateLoginOptionsDisplayed(),"Sign in Options with Google or Apple is not Displayed");
    	 
	}
}
