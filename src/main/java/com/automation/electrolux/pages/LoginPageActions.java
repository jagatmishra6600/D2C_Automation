package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.ELUX_LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class LoginPageActions {

	 
	 public LoginPageActions navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"login");
       try {
           WebElement acceptBtn = untilClickable(ELUX_LoginPage.acceptButtonLocator, 20);
           if (acceptBtn != null) {
               acceptBtn.click();
           }
       } catch (Exception ignored) {
           // Cookie banner not present or not interactable; continue
       }
       return this;
	}
	
	 public HomePageActions login(String emailAddress, String password) throws InterruptedException {
		 enterEmailAddress(emailAddress)
							 .enterPassword(password);
		 return clickLoginButton();
	 }
	 
	public LoginPageActions enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(ELUX_LoginPage.emailAddressInput, emailAddress);
		return this;
	}
	
	public LoginPageActions enterPassword(String password) {
		WebElementUtil.sendKeys(ELUX_LoginPage.passwordInput, password);
		return this;
	}
	
	public HomePageActions clickLoginButton() {
		WebElementUtil.clickElement(ELUX_LoginPage.loginButton);
		return new HomePageActions();
	}
	
	public boolean isLoginPageLoaded() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.loginButton);
	}
	
	public boolean isLoginToFrigidaireTitleDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.loginToStoreTitle);
	}
	
	public boolean isLoginTitleMessageDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.loginTitleMessage);
	}
	
	public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.emailAddressInput);
	}
	
	public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.passwordInput);
	}
	
	public boolean isShowPasswordIconDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.showPasswordIcon);
	}
	
	public boolean isKeepMeLoggedInCheckboxDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.keepMeLoggedInCheckbox);
	}
	
	public String getNotRecommendedLabelText() {
		return WebElementUtil.getText(ELUX_LoginPage.notRecommendedMessage);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.createAccountLink);
	}
	
	public String getElectroluxLinkedAccountMessage() {
		return WebElementUtil.getText(ELUX_LoginPage.electroluxLinkedAccountMessage);
	}
	
	public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	}
	
	public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.signInWithAppleButton);
	}
	
	public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.signInWithGoogleButton);
	}
	
	public boolean isLoginToStoreTitleDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_LoginPage.loginToStoreTitle);
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
