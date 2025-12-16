package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import com.automation.frigidaire.pages.HomePageActionsFrig;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.LoginPageLocatorsElux;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class LoginPageActionsElux {

	 
	 public LoginPageActionsElux navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"login");
       try {
           WebElement acceptBtn = untilClickable(LoginPageLocatorsElux.acceptButtonLocator, 20);
           if (acceptBtn != null) {
               acceptBtn.click();
           }
       } catch (Exception ignored) {
           // Cookie banner not present or not interactable; continue
       }
       return this;
	}
	
	 public HomePageActionsElux login(String emailAddress, String password){
		 enterEmailAddress(emailAddress)
							 .enterPassword(password);
		 return clickLoginButton();
	 }
	 
	public LoginPageActionsElux enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(LoginPageLocatorsElux.emailAddressInput, emailAddress);
		return this;
	}
	
	public LoginPageActionsElux enterPassword(String password) {
		WebElementUtil.sendKeys(LoginPageLocatorsElux.passwordInput, password);
		return this;
	}
	
	public HomePageActionsElux clickLoginButton() {
		WebElementUtil.clickElement(LoginPageLocatorsElux.loginButton);
		return new HomePageActionsElux();
	}
	
	public boolean isLoginPageLoaded() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.loginButton);
	}
	
	public boolean isLoginToFrigidaireTitleDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.loginToStoreTitle);
	}
	
	public boolean isLoginTitleMessageDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.loginTitleMessage);
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
	
	public boolean isKeepMeLoggedInCheckboxDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.keepMeLoggedInCheckbox);
	}
	
	public String getNotRecommendedLabelText() {
		return WebElementUtil.getText(LoginPageLocatorsElux.notRecommendedMessage);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.createAccountLink);
	}
	
	public String getFrigidaireLinkedAccountMessage() {
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
	
	public boolean isLoginToStoreTitleDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.loginToStoreTitle);
	}
	
	public void verifyLoginPageFieldsAndMessages() {
		Assert.assertTrue(isLoginPageLoaded(),"Login Button is not Present in Login Page");
    	Assert.assertTrue(isLoginToStoreTitleDisplayed(),"'Log in to Electrolux' title is not present");
    	Assert.assertTrue(isEmailAddressFieldDisplayed(),"Email Address field is not displayed");
    	Assert.assertTrue(isPasswordFieldDisplayed(),"Password field is not displayed");
    	Assert.assertTrue(isShowPasswordIconDisplayed(),"'Show Password' icon is not displayed");
    	Assert.assertTrue(isKeepMeLoggedInCheckboxDisplayed(),"'Keep Me Logged In' checkbox is not displayed");
    	Assert.assertTrue(isForgotPasswordLinkDisplayed(),"Forgot Password Link is not displayed");
    	Assert.assertTrue(isCreateAccountLinkDisplayed(),"Create an Account Link is not displayed");
    	Assert.assertTrue(isNewToElectroluxLabelDisplayed(),"'New To Electrolux?' label  is not displayed");	
    	Assert.assertTrue(isAccountBenefitsLabelsDisplayed(),"Account Benefits are not mentioned in the Login Page");
    	Assert.assertEquals(getFrigidaireLinkedAccountMessage(),"If you already have an account with Frigidaire.com, a part of the Electrolux Group, you can use those details to log in."
    																,"Frigidaire Linked Account Message not displayed");
    	Assert.assertTrue(isAlternateLoginOptionsDisplayed(),"Sign in Options with Google or Apple is not Displayed");
    	 
	}
	
	public CreateAccountPageActionsElux navigateToCreateAccountPage() {
		return navigateToLoginPage().clickCreateAccountLink();
	}
	
	public CreateAccountPageActionsElux clickCreateAccountLink() {
		WebElementUtil.scrollIntoView(LoginPageLocatorsElux.createAccountLink);
		WebElementUtil.clickElement(LoginPageLocatorsElux.createAccountLink);
		return new CreateAccountPageActionsElux();
	}
	
	public boolean isNewToElectroluxLabelDisplayed() {
		return WebElementUtil.isDisplayed(LoginPageLocatorsElux.newToElectroluxLabel);
	}
	
	public boolean isAccountBenefitsLabelsDisplayed() {
	    return !WebElementUtil.findElements(LoginPageLocatorsElux.accountBenefitsLabelList)
	    					.isEmpty();
	}
	
	public ForgotPasswordPageActionsElux clickForgotPasswordLink() {
		WebElementUtil.clickElement(LoginPageLocatorsElux.forgotPasswordLink);
		return new ForgotPasswordPageActionsElux();
	}
}
