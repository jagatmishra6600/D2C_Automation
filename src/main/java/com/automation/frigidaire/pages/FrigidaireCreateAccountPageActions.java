package com.automation.frigidaire.pages;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;

public class FrigidaireCreateAccountPageActions {

	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 private final By submitButton = By.cssSelector("input[value='Submit']");
	 private final By createAccountTitle = By.xpath("//h2[normalize-space()='Create an account']");
	 private final By createAccountSignUpMessage = By.xpath("//h2[contains(.,'Sign up and make')]");
	 private final By emailAddressField = By.cssSelector("input[placeholder='Email address *']");
	 private final By passwordField = By.cssSelector("input[placeholder='Password *']");
	 private final By confirmPasswordField = By.cssSelector("input[placeholder='Confirm Password *']");
	 private final By firstNameField = By.cssSelector("input[placeholder='First Name *']");
	 private final By lastNameField = By.cssSelector("input[placeholder='Last Name *']");
	 private final By confirmFieldShowPasswordIcon = By.xpath("//input[@placeholder='Confirm Password *']/parent::div//i");
	 private final By passwordFieldShowPasswordIcon = By.xpath("//input[@placeholder='Password *']/parent::div//i");
	 private final By electroluxLinkedAccountMessage = By.xpath("//label[contains(.,'Electrolux group')]");
	 private final By termsAndConditionsLink = By.id("register-terms-link");
	 private final By privacyPolicyLink = By.id("register-privacy-link");
	 private final By haveAccountAlreadyLink = By.id("register-already-have-act-link");
	 private final By signInWithAppleButton = By.id("Apple_btn");
	 private final By signInWithGoogleButton = By.id("Google_btn");
	 private final By verificationEmailSentMessage = By.cssSelector("#gigya-verification-sent-screen label");
	 private final By hereToHelpBanner = By.cssSelector("app-elux-question-banner");
	 private final By hereToHelpBannerPhoneSection = By.cssSelector("app-elux-question-banner .phoneSection");
	 private final By hereToHelpBannerChatSection = By.cssSelector("app-elux-question-banner .chatSection");
	 
	 public FrigidaireCreateAccountPageActions navigateToCreateAccountPage() {
		WebElementUtil.navigateTo(ConfigReader.getProperty("app.url")+"createAccount");
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
	 
	 public boolean isCreateAccountPageLoaded() {
		 return isSubmitButtonDisplayed();
	 }
	 
	 public boolean isCreateAnAccountTitleDisplayed() {
		 return WebElementUtil.isDisplayed(createAccountTitle);	 
	 }
	 
	 public String getCreateAccountSignUpMessage() {
		 return WebElementUtil.getText(createAccountSignUpMessage);
	 }
	 
	 public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(emailAddressField);
	 }
		
	 public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(passwordField);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(confirmPasswordField);
	 }
	 
	 public boolean isFirstNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(firstNameField);
	 }	
	 
	 public boolean isLastNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(lastNameField);
	 }
	 
	 public boolean isConfirmPasswordFieldShowPasswordIconDisplayed() {
		 return WebElementUtil.isDisplayed(confirmFieldShowPasswordIcon);
	 }
	 
	 public boolean isPasswordFieldShowPasswordIconDisplayed() {
		 return WebElementUtil.isDisplayed(passwordFieldShowPasswordIcon);
	 }
	 
	 public boolean isShowPasswordIconsDisplayed() {
		 return isConfirmPasswordFieldShowPasswordIconDisplayed() &&
				 isPasswordFieldShowPasswordIconDisplayed();
	 }
	 
	 public String getElectroluxLinkedAccountMessage() {
		 return WebElementUtil.getText(electroluxLinkedAccountMessage);
	 }
	 
	 public boolean isTermsAndConditionsLinkDisplayed() {
		 return WebElementUtil.isDisplayed(termsAndConditionsLink);
	 }
	 
	 public boolean isPrivacyPolicyLinkDisplayed() {
		 return WebElementUtil.isDisplayed(privacyPolicyLink);
	 }
	 
	 public boolean isSubmitButtonDisplayed() {
		 return WebElementUtil.isDisplayed(submitButton);
	 }
	 
	 public boolean isHaveAnAccountAlreadyLinkDisplayed() {
		 return WebElementUtil.isDisplayed(haveAccountAlreadyLink);
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
	 
	 public FrigidaireCreateAccountPageActions enterEmailAddress(String emailAddress) {
		 WebElementUtil.sendKeys(emailAddressField, emailAddress);
		 return this;
	 }
	 
	 public FrigidaireCreateAccountPageActions enterPassword(String password) {
		 WebElementUtil.sendKeys(passwordField, password);
		 return this;
	 }
	 
	 public FrigidaireCreateAccountPageActions enterConfirmPassword(String password) {
		 WebElementUtil.sendKeys(confirmPasswordField, password);
		 return this;
	 }
	 public FrigidaireCreateAccountPageActions enterFirstName(String firstName) {
		 WebElementUtil.sendKeys(firstNameField, firstName);
		 return this;
	 }
	 
	 public FrigidaireCreateAccountPageActions enterLastName(String lastName) {
		 WebElementUtil.sendKeys(lastNameField, lastName);
		 return this;
	 }
	 
	 public FrigidaireCreateAccountPageActions createAccount(String emailAddress, String password, String firstName, String lastName) {
		 return enterEmailAddress(emailAddress)
					 	.enterFirstName(firstName)
					 	.enterLastName(lastName)
					 	.enterPassword(password)
					 	.enterConfirmPassword(password)
					 	.clickSubmitButton();
	 }
	 
	 public FrigidaireCreateAccountPageActions clickSubmitButton() {
		 WebElementUtil.scrollIntoView(submitButton);
		 WebElementUtil.clickElement(submitButton);
		 return this;
	 }
	 
	 public String getVerificationEmailSentMessage() {
		 return WebElementUtil.getText(verificationEmailSentMessage);
	 }
	 
	 public boolean isHereToHelpBannerDisplayed() {
		 return WebElementUtil.isDisplayed(hereToHelpBanner);
	 }
	 
	 public boolean isHereToHelpBannerPhoneSectionDisplayed() {
		 return WebElementUtil.isDisplayed(hereToHelpBannerPhoneSection);
	 }
	 
	 public boolean isHereToHelpBannerChatSectionDisplayed() {
		 return WebElementUtil.isDisplayed(hereToHelpBannerChatSection);
	 }
	 
	 
}
