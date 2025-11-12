package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.utils.ConfigReader;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class FrigidaireLoginPageActions {

	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 private final By emailAddressInput = By.xpath("//input[@placeholder='Email address *' or @placeholder='jane.doe@company.com *']");
	 private final By passwordInput = By.xpath("//input[@placeholder='Password *' or contains(@id,'gigya-password')]");
	 private final By loginButton = By.cssSelector("input[value='Log in']");
	 private final By loginToStoreTitle = By.xpath("//h2[normalize-space()='Log in to Frigidaire' or normalize-space()='Log in to Electrolux']");
	 private final By loginTitleMessage = By.xpath("//label[normalize-space()='Log in with your email and password: *']");
	 private final By showPasswordIcon = By.cssSelector("button[title='Show Password'] i");
	 private final By keepMeLoggedInCheckbox = By.xpath("//input[@id='gigya-checkbox-remember']");
	 private final By notRecommendedMessage = By.xpath("//label[contains(.,'shared or public device')]");
	 private final By forgotPasswordLink = By.xpath("//a[@id='login-forgot-password-link']");
	 private final By createAccountLink = By.xpath("//a[@id='createAccButton']");
	 private final By electroluxLinkedAccountMessage = By.xpath("//label[contains(.,'part of the Electrolux Group')]");
	 private final By signInWithAppleButton = By.id("Apple_btn");
	 private final By signInWithGoogleButton = By.id("Google_btn");
	 
	 
	 public FrigidaireLoginPageActions navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"login");
       try {
           WebElement acceptBtn = untilClickable(acceptButtonLocator, 15);
           if (acceptBtn != null) {
               acceptBtn.click();
           }
       } catch (Exception ignored) {
           // Cookie banner not present or not interactable; continue
       }
       return this;
	}
	
	 public FrigidaireHomePageActions login(String emailAddress, String password) throws InterruptedException {
		 enterEmailAddress(emailAddress)
							 .enterPassword(password);
		 WaitUtils.sleep(4000);
						return	 clickLoginButton();
	 }
	 
	public FrigidaireLoginPageActions enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(emailAddressInput, emailAddress);
		return this;
	}
	
	public FrigidaireLoginPageActions enterPassword(String password) {
		WebElementUtil.sendKeys(passwordInput, password);
		return this;
	}
	
	public FrigidaireHomePageActions clickLoginButton() {
		WebElementUtil.clickElement(loginButton);
		return new FrigidaireHomePageActions();
	}
	
	public boolean isLoginPageLoaded() {
		return WebElementUtil.isDisplayed(loginButton);
	}
	
	public boolean isLoginToFrigidaireTitleDisplayed() {
		return WebElementUtil.isDisplayed(loginToStoreTitle);
	}
	
	public boolean isLoginTitleMessageDisplayed() {
		return WebElementUtil.isDisplayed(loginTitleMessage);
	}
	
	public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(emailAddressInput);
	}
	
	public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(passwordInput);
	}
	
	public boolean isShowPasswordIconDisplayed() {
		return WebElementUtil.isDisplayed(showPasswordIcon);
	}
	
	public boolean isKeepMeLoggedInCheckboxDisplayed() {
		return WebElementUtil.isDisplayed(keepMeLoggedInCheckbox);
	}
	
	public String getNotRecommendedLabelText() {
		return WebElementUtil.getText(notRecommendedMessage);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return WebElementUtil.isDisplayed(forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return WebElementUtil.isDisplayed(createAccountLink);
	}
	
	public String getElectroluxLinkedAccountMessage() {
		return WebElementUtil.getText(electroluxLinkedAccountMessage);
	}
	
	public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	}
	
	public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(signInWithAppleButton);
	}
	
	public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(signInWithGoogleButton);
	}
	
	public FrigidaireCreateAccountPageActions clickCreateAccountLink() {
		WebElementUtil.scrollIntoView(createAccountLink);
		WebElementUtil.clickElement(createAccountLink);
		return new FrigidaireCreateAccountPageActions();
	}
	
	public FrigidaireForgotPasswordPageActions clickForgotPasswordLink() {
		WebElementUtil.clickElement(forgotPasswordLink);
		return new FrigidaireForgotPasswordPageActions();
	}
	
	public boolean isLoginToStoreTitleDisplayed() {
		return WebElementUtil.isDisplayed(loginToStoreTitle);
	}

	public FrigidaireCreateAccountPageActions navigateToCreateAccountPage() {
		return navigateToLoginPage().clickCreateAccountLink();
	}
	
	public void verifyLoginPageFieldsAndMessages() {
		Assert.assertTrue(isLoginPageLoaded(), "User is not navigated to LoginPage");
       Assert.assertTrue(isLoginToFrigidaireTitleDisplayed(), "'Log in to Frigidaire' title is not present");
       Assert.assertTrue(isEmailAddressFieldDisplayed(), "Email Address field is not displayed");
       Assert.assertTrue(isPasswordFieldDisplayed(), "Password field is not displayed");
       Assert.assertTrue(isShowPasswordIconDisplayed(), "'Show Password' icon is not displayed");
       Assert.assertTrue(isKeepMeLoggedInCheckboxDisplayed(), "'Keep Me Logged In' checkbox is not displayed");
       Assert.assertTrue(isForgotPasswordLinkDisplayed(), "Forgot Password Link is not displayed");
       Assert.assertTrue(isCreateAccountLinkDisplayed(), "Create an Account Link is not displayed");
       Assert.assertEquals(getElectroluxLinkedAccountMessage(), "Frigidaire is part of the Electrolux Group. If you already have an account with Electrolux.com, you can use those details to log in."
       												,"Electrolux Linked Account Message Not Displayed");
       Assert.assertTrue(isAlternateLoginOptionsDisplayed(), "Sign in Options with Google or Apple is not Displayed");
       
	}
}
