package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.ELUX_ResetPasswordPage;
import com.automation.utils.WebElementUtil;

public class ResetPasswordPageActions {
	 
	 public ResetPasswordPageActions acceptAllCookies() {
		 try {
	            WebElement acceptBtn = untilClickable(ELUX_ResetPasswordPage.acceptButtonLocator, 15);
	            if (acceptBtn != null) {
	                acceptBtn.click();
	            }
	        } catch (Exception ignored) {
	            // Cookie banner not present or not interactable; continue
	        }
	        return this;
	 }
	 
	 
	 public boolean isResetPasswordButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.submitButton);			 
	 }
	 
	 public ResetPasswordPageActions enterNewPassword(String password) {
		WebElementUtil.sendKeys(ELUX_ResetPasswordPage.newPasswordInput, password);
		return this;
	 }
	 
	 public ResetPasswordPageActions enterConfirmPassword(String password) {
		WebElementUtil.sendKeys(ELUX_ResetPasswordPage.confirmPasswordInput,password);
		return this;
	 }
	 
	 public ResetPasswordPageActions clickSubmitButton() {
		 WebElementUtil.clickElement(ELUX_ResetPasswordPage.submitButton);
		 return this;
	 }
	 
	 public ResetPasswordPageActions resetPassword(String newPassword) {
		 return enterNewPassword(newPassword)
			.enterConfirmPassword(newPassword)
			.clickSubmitButton();
	 }
	 
	 public boolean isNewPasswordFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.newPasswordInput);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.confirmPasswordInput);
	 }
	 
	 public boolean isSubmitButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.submitButton);
	 }
	 
	 public boolean isNewPasswordShowHideIconDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.newPasswordShowHideIcon);
	 }
	 
	 public boolean isConfirmPasswordShowHideIconDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.confirmPasswordShowHideIcon);
	 }
	 
	 public boolean isChangePasswordTitleDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.changePasswordTitle);
	 }
	 
	 public boolean isAllResetPasswordFieldsAndButtonsDisplayed() {
		 
		 return isChangePasswordTitleDisplayed() &&
				 isNewPasswordFieldDisplayed() &&
				 isConfirmPasswordFieldDisplayed() &&
				 isNewPasswordShowHideIconDisplayed() &&
				 isConfirmPasswordShowHideIconDisplayed() &&
				 isSubmitButtonDisplayed();
		 
	 } 
	 
	 public boolean isSetNewPasswordMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.setNewPasswordMessage); 
	 }
	 
	 public boolean isPasswordRulesMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ELUX_ResetPasswordPage.passwordRulesMessage);  
	 }
	 
	 public String getCredentialUpdateAccrossGroupMessage() {
		 return WebElementUtil.getText(ELUX_ResetPasswordPage.credentialsUpdateAccrossGroupMessage);  
		 
	 }
	 public ResetPasswordPageActions verifyResetPasswordPage() {
		 Assert.assertTrue(isChangePasswordTitleDisplayed(), "'Change Password' Title is not displayed in reset password page");
		 Assert.assertTrue(isNewPasswordFieldDisplayed(), "New Password field is not displayed in reset password page");
		 Assert.assertTrue(isConfirmPasswordFieldDisplayed(), "Confirm Password field is not displayed in reset password page");
		 Assert.assertTrue(isNewPasswordShowHideIconDisplayed(), "New Password Show/Hide Eye Icon is not displayed in reset password page");
	     Assert.assertTrue(isConfirmPasswordShowHideIconDisplayed(), "Confirm Password Show/Hide Eye Icon is not displayed in reset password page");
	     Assert.assertTrue(isSubmitButtonDisplayed(), "Submit Button is not displayed in reset password page");            
	     Assert.assertTrue(isSetNewPasswordMessageDisplayed(), "Set a new Password for your account Message is not displayed in reset password page");            
	     Assert.assertTrue(isPasswordRulesMessageDisplayed(), "Password Rules Message is not displayed in reset password page");            
	     Assert.assertTrue(getCredentialUpdateAccrossGroupMessage().contains("This reset will update your login credentials across the Electrolux group, including Frigidaire.com and Electrolux.com.")
	    		 						, "Reset update login credentials accross Electrolux Group Message is not displayed in reset password page");            
	     
	     return this;
	 } 
}
