package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.ForgotPasswordLocatorsElux;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class ForgotPasswordPageActionsElux {

	 public ForgotPasswordPageActionsElux navigateToForgotPasswordPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"forgotPassword");
      try {
          WebElement acceptBtn = untilClickable(ForgotPasswordLocatorsElux.acceptButtonLocator, 15);
          if (acceptBtn != null) {
              acceptBtn.click();
          }
      } catch (Exception ignored) {
          // Cookie banner not present or not interactable; continue
      }
      return this;
	}
	 
	 public boolean isSendResetButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.resetPasswordButton);
	 }
	 
	 public ForgotPasswordPageActionsElux enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(ForgotPasswordLocatorsElux.emailAddressInput, emailAddress);
		return this;
	 }
	 
	 public String getCheckYourEmailMessage() {
		 return WebElementUtil.getText(ForgotPasswordLocatorsElux.checkYourEmailMessage).replaceAll("\\s+", " ");
	 }
	 
	 public boolean isCheckYourEmailMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.checkYourEmailMessage);
	 }
	 
	 public boolean isCheckYourInboxMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.checkYourEmailMessage);
	 }
	 
	 public ForgotPasswordPageActionsElux clickResetPasswordButton() {
		 WebElementUtil.clickElement(ForgotPasswordLocatorsElux.resetPasswordButton);
		 return this;
	 }
	 
	 public ForgotPasswordPageActionsElux resetPassword(String emailAddress) {
		 return enterEmailAddress(emailAddress).clickResetPasswordButton();
	 }
	 
	 public Boolean isResetPasswordTitleDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.resetPasswordTitle);
	 }
	 
	 public String getConfirmEmailAddressMessage() {
		 return WebElementUtil.getText(ForgotPasswordLocatorsElux.confirmEmailAddressMessage);
	 }
	 
	 public Boolean isEmailAddressFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.emailAddressInput);
	 }
	 
	 public boolean isDontHaveAnAccountMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.dontHaveAccountMessage);
	 }
	 
	 public boolean isCreateAnAccountLinkDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.createAnAccountLink);
	 }
	 
	 public boolean isBackToLoginLinkDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.backToLoginLink);
	 }
	 
	 public boolean isHelpLineBannerDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordLocatorsElux.helpLineBanner);
	 }
	 
	 public ForgotPasswordPageActionsElux verifyForgotPasswordPage() {
		 Assert.assertTrue(isSendResetButtonDisplayed(),"Send Reset Link Button is not displayed in Forgot Password Page");
		 Assert.assertTrue(isResetPasswordTitleDisplayed(),"'Reset Password Title' is not displayed in Forgot Password Page");
		 Assert.assertTrue(getConfirmEmailAddressMessage().contains("Confirm the email address associated with your account, and we’ll send you a link to reset your password.")
				 			,"Confirm Email Address Message is not displayed in the forgot password page");
		 Assert.assertTrue(isEmailAddressFieldDisplayed(),"Email Address field is not displayed in Forgot Password Page");
		 Assert.assertTrue(isBackToLoginLinkDisplayed(),"'Back To Login' Link is not displayed in Forgot Password Page");
		 Assert.assertTrue(isCreateAnAccountLinkDisplayed(),"'Create An Account' Link is not displayed in Forgot Password Page");
		 Assert.assertTrue(isDontHaveAnAccountMessageDisplayed(),"'Don’t have an account? Create an account' Link is not displayed in Forgot Password Page");
		 Assert.assertTrue(isHelpLineBannerDisplayed(),"Help Line Banner not displayed in Forgot Password Page");
		 return this;
	 }
	
	 	 
}
