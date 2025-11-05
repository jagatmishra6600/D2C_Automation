package com.automation.frigidaire.pages;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;

public class FrigidaireLoginPageActions {

	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 private final By emailAddressInput = By.cssSelector("input[placeholder='Email address *']");
	 private final By passwordInput = By.cssSelector("input[placeholder='Password *']");
//	 private final By passwordInput = By.cssSelector("input[id*='gigya-password']");
	 private final By loginButton = By.cssSelector("input[value='Log in']");
	 private final By loginToFrigidaireTitle = By.xpath("//h2[normalize-space()='Log in to Frigidaire']");
	 private final By loginTitleMessage = By.xpath("//label[normalize-space()='Log in with your email and password: *']");
	 private final By showPasswordIcon = By.cssSelector("button[title='Show Password'] i");
	 private final By keepMeLoggedInCheckbox = By.id("gigya-checkbox-remember");
	 private final By notRecommendedMessage = By.xpath("//label[contains(.,'shared or public device')]");
	 private final By forgotPasswordLink = By.id("login-forgot-password-link");
	 private final By createAccountLink = By.id("login-create-account-link");
	 private final By electroluxLinkedAccountMessage = By.xpath("//label[contains(.,'*Frigidaire is part of the Electrolux Group')]");
	 private final By signInWithAppleButton = By.id("Apple_btn");
	 private final By signInWithGoogleButton = By.id("Google_btn");
	 
	 
	 public FrigidaireLoginPageActions navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getProperty("app.url")+"login");
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
	
	 public FrigidaireHomePageActions login(String emailAddress, String password) {
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
		return WebElementUtil.isDisplayed(loginToFrigidaireTitle);
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
		WebElementUtil.clickElement(createAccountLink);
		return new FrigidaireCreateAccountPageActions();
	}
	
	public FrigidaireForgotPasswordPageActions clickForgotPasswordLink() {
		WebElementUtil.clickElement(forgotPasswordLink);
		return new FrigidaireForgotPasswordPageActions();
	}
	
	public FrigidaireCreateAccountPageActions navigateToCreateAccountPage() {
		return navigateToLoginPage().clickCreateAccountLink();
	}
	
}
