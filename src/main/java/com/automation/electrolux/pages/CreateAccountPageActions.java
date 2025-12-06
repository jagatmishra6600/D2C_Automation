package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.ELUX_CreateAccountPage;
import com.automation.electrolux.locators.ELUX_LoginPage;
import com.automation.models.CreateAccountData;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class CreateAccountPageActions {

	 public CreateAccountPageActions navigateToCreateAccountPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"createAccount");
       try {
           WebElement acceptBtn = untilClickable(ELUX_CreateAccountPage.acceptButtonLocator, 15);
           if (acceptBtn != null) {
               acceptBtn.click();
           }
       } catch (Exception ignored) {
           // Cookie banner not present or not interactable; continue
       }
       return this;
	}
	 
	 public boolean isCreateAccountPageLoaded() {
		 return isCreateAccountButtonDisplayed();
	 }
	 
	 public boolean isCreateAnAccountTitleDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.createAccountTitle);	 
	 }
	 
	 public String getCreateAccountSignUpMessage() {
		 return WebElementUtil.getText(ELUX_CreateAccountPage.accessToExclusiveSignUpMessage);
	 }
	 
	 public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.emailAddressField);
	 }
		
	 public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.passwordField);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.confirmPasswordField);
	 }
	 
	 public boolean isFirstNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.firstNameField);
	 }	
	 
	 public boolean isLastNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.lastNameField);
	 }
	 
	 public boolean isConfirmPasswordFieldShowPasswordIconDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.confirmFieldShowPasswordIcon);
	 }
	 
	 public boolean isPasswordFieldShowPasswordIconDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.passwordFieldShowPasswordIcon);
	 }
	 
	 public boolean isShowPasswordIconsDisplayed() {
		 WebElementUtil.scrollIntoView(ELUX_CreateAccountPage.passwordFieldShowPasswordIcon);
		 return isConfirmPasswordFieldShowPasswordIconDisplayed() &&
				 isPasswordFieldShowPasswordIconDisplayed();
	 }
	 
	 public String getElectroluxLinkedAccountMessage() {
		 return WebElementUtil.getText(ELUX_CreateAccountPage.electroluxLinkedAccountMessage);
	 }
	 
	 public boolean isTermsAndConditionsLinkDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.termsAndConditionsLink);
	 }
	 
	 public boolean isPrivacyPolicyLinkDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.privacyPolicyLink);
	 }
	 
	 public boolean isCreateAccountButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.createAccountButton);
	 }
	 
	 public boolean isHaveAnAccountAlreadyLinkDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.haveAccountAlreadyLink);
	 }
	 
	 public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	 }
		
	 public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.signInWithAppleButton);
	 }
		
	 public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.signInWithGoogleButton);
	 }
	 
	 public CreateAccountPageActions enterEmailAddress(String emailAddress) {
		 WebElementUtil.sendKeys(ELUX_CreateAccountPage.emailAddressField, emailAddress);
		 return this;
	 }
	 
	 public CreateAccountPageActions enterPassword(String password) {
		 WebElementUtil.sendKeys(ELUX_CreateAccountPage.passwordField, password);
		 return this;
	 }
	 
	 public CreateAccountPageActions enterConfirmPassword(String password) {
		 WebElementUtil.sendKeys(ELUX_CreateAccountPage.confirmPasswordField, password);
		 return this;
	 }
	 public CreateAccountPageActions enterFirstName(String firstName) {
		 WebElementUtil.sendKeys(ELUX_CreateAccountPage.firstNameField, firstName);
		 return this;
	 }
	 
	 public CreateAccountPageActions enterLastName(String lastName) {
		 WebElementUtil.sendKeys(ELUX_CreateAccountPage.lastNameField, lastName);
		 return this;
	 }
	 
	 public CreateAccountPageActions createAccount(String emailAddress, String password, String firstName, String lastName) {
		 return enterEmailAddress(emailAddress)
					 	.enterFirstName(firstName)
					 	.enterLastName(lastName)
					 	.enterPassword(password)
					 	.enterConfirmPassword(password)
					 	.clickCreateAccountButton();
	 }
	 
	 public CreateAccountPageActions createAccount(CreateAccountData data) {
		 return enterEmailAddress(data.emailAddress())
					 	.enterFirstName(data.firstName())
					 	.enterLastName(data.lastName())
					 	.enterPassword(data.password())
					 	.enterConfirmPassword(data.password())
					 	.clickCreateAccountButton();
	 }
	 
	 
	 
	 public CreateAccountPageActions clickCreateAccountButton() {
		 WebElementUtil.scrollIntoView(ELUX_CreateAccountPage.createAccountButton);
		 WebElementUtil.clickElement(ELUX_CreateAccountPage.createAccountButton);
		 return this;
	 }
	 
	 public String getVerificationEmailSentMessage() {
		 WebElementUtil.isDisplayed(ELUX_CreateAccountPage.verificationEmailSentMessage);
		 WebElementUtil.scrollIntoView(ELUX_CreateAccountPage.verificationEmailSentMessage);
		 return WebElementUtil.getText(ELUX_CreateAccountPage.verificationEmailSentMessage);
	 }
	 
	 public boolean isHereToHelpBannerDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.hereToHelpBanner);
	 }
	 
	 public boolean isHereToHelpBannerPhoneSectionDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.hereToHelpBannerPhoneSection);
	 }
	 
	 public boolean isHereToHelpBannerChatSectionDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.hereToHelpBannerChatSection);
	 }
	 
	 public boolean isAlreadyHaveAccountLinkDisplayed() {
			 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.alreadyHaveAnAccountLink);
	 }
	 
	 public boolean isCreateAccountSignUpMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.createAccountSignUpMessage);
	 }
	 
	 public boolean isElectroluxGroupLinkedAccountMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_CreateAccountPage.electroluxLinkedAccountMessage);
	 }
	 
	 public boolean isAccountBenefitsLabelsDisplayed() {
		    return !WebElementUtil.findElements(ELUX_CreateAccountPage.accountBenefitsLabelList)
		    					.isEmpty();
		}
	 
	 public void verifyCreateAccountPageFieldAndMessages() {
		 Assert.assertTrue(isCreateAnAccountTitleDisplayed(),"Create An Account title is not displayed");
	 	Assert.assertEquals(getCreateAccountSignUpMessage(),"Get access to exclusive savings, easy order tracking and faster checkout."
	 			,"Create Account Sign Up Message 'Get access to exclusive savings' is not displayed");    	
	 	Assert.assertTrue(isEmailAddressFieldDisplayed(),"Email Address Field is not displayed");
	 	Assert.assertTrue(isPasswordFieldDisplayed(),"Password Field is not displayed");
	 	Assert.assertTrue(isConfirmPasswordFieldDisplayed(),"Confirm Password Field is not displayed");
	 	Assert.assertTrue(isFirstNameFieldDisplayed(),"First Name Field is not displayed");
	 	Assert.assertTrue(isLastNameFieldDisplayed(),"Last Name Field is not displayed");
	 	Assert.assertTrue(isShowPasswordIconsDisplayed(),"Show Password Icons for Confirm Password and Password Fields are not Displayed");
	 	Assert.assertTrue(isElectroluxGroupLinkedAccountMessageDisplayed(),"Electrolux Group Linked Account Message is not Displayed");
	 	Assert.assertTrue(isTermsAndConditionsLinkDisplayed(),"Terms and Conditions Link is not displayed");
	 	Assert.assertTrue(isPrivacyPolicyLinkDisplayed(),"Privacy Policy Link is not displayed");
	 	Assert.assertTrue(isCreateAccountButtonDisplayed(),"Submit Button is not displayed");
	 	Assert.assertTrue(isAlreadyHaveAccountLinkDisplayed(),"Already have an account Log in link is not displayed");
	 	Assert.assertTrue(isAlternateLoginOptionsDisplayed(),"Sign in Options with Google or Apple is not Displayed");
	 	Assert.assertTrue(isAccountBenefitsLabelsDisplayed(),"Account Benefits are not mentioned in Create Account Page");
	 	Assert.assertTrue(isHereToHelpBannerDisplayed(),"We're here to help banner is not displayed");
	 	Assert.assertTrue(isHereToHelpBannerPhoneSectionDisplayed(),"Help Banner with Phone Section is not displayed");
	 	Assert.assertTrue(isHereToHelpBannerChatSectionDisplayed(),"Help Banner with Chat Section is not displayed");
		}
	 
}
