package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.ELUX_ForgotPasswordPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class ForgotPasswordPageActions {

	 public ForgotPasswordPageActions navigateToForgotPasswordPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"forgotPassword");
      try {
          WebElement acceptBtn = untilClickable(ELUX_ForgotPasswordPage.acceptButtonLocator, 15);
          if (acceptBtn != null) {
              acceptBtn.click();
          }
      } catch (Exception ignored) {
          // Cookie banner not present or not interactable; continue
      }
      return this;
	}
	 
	 public boolean isSendResetButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.resetPasswordButton);			 
	 }
	 
	 public ForgotPasswordPageActions enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(ELUX_ForgotPasswordPage.emailAddressInput, emailAddress);
		return this;
	 }
	 
	 public String getCheckYourEmailMessage() {
		 return WebElementUtil.getText(ELUX_ForgotPasswordPage.checkYourEmailMessage).replaceAll("\\s+", " ");
	 }
	 
	 public boolean isCheckYourEmailMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.checkYourEmailMessage);	
	 }
	 
	 public boolean isCheckYourInboxMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.checkYourEmailMessage);	
	 }
	 
	 public ForgotPasswordPageActions clickResetPasswordButton() {
		 WebElementUtil.clickElement(ELUX_ForgotPasswordPage.resetPasswordButton);
		 return this;
	 }
	 
	 public ForgotPasswordPageActions resetPassword(String emailAddress) {
		 return enterEmailAddress(emailAddress).clickResetPasswordButton();
	 }
	 
	 public Boolean isResetPasswordTitleDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.resetPasswordTitle); 
	 }
	 
	 public String getConfirmEmailAddressMessage() {
		 return WebElementUtil.getText(ELUX_ForgotPasswordPage.confirmEmailAddressMessage);
	 }
	 
	 public Boolean isEmailAddressFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.emailAddressInput);  
	 }
	 
	 public boolean isDontHaveAnAccountMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.dontHaveAccountMessage);   
	 }
	 
	 public boolean isCreateAnAccountLinkDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.createAnAccountLink);   
	 }
	 
	 public boolean isBackToLoginLinkDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.backToLoginLink);   
	 }
	 
	 public boolean isHelpLineBannerDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ForgotPasswordPage.helpLineBanner);   		 
	 }
	 
	 public ForgotPasswordPageActions verifyForgotPasswordPage() {
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
