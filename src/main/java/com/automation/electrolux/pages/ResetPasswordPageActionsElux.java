package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.ResetPasswordLocatorsElux;
import com.automation.utils.WebElementUtil;

public class ResetPasswordPageActionsElux {
	 
	 public ResetPasswordPageActionsElux acceptAllCookies() {
		 try {
	            WebElement acceptBtn = untilClickable(ResetPasswordLocatorsElux.acceptButtonLocator, 15);
	            if (acceptBtn != null) {
	                acceptBtn.click();
	            }
	        } catch (Exception ignored) {
	            // Cookie banner not present or not interactable; continue
	        }
	        return this;
	 }
	 
	 
	 public boolean isResetPasswordButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.submitButton);
	 }
	 
	 public ResetPasswordPageActionsElux enterNewPassword(String password) {
		WebElementUtil.sendKeys(ResetPasswordLocatorsElux.newPasswordInput, password);
		return this;
	 }
	 
	 public ResetPasswordPageActionsElux enterConfirmPassword(String password) {
		WebElementUtil.sendKeys(ResetPasswordLocatorsElux.confirmPasswordInput,password);
		return this;
	 }
	 
	 public ResetPasswordPageActionsElux clickSubmitButton() {
		 WebElementUtil.clickElement(ResetPasswordLocatorsElux.submitButton);
		 return this;
	 }
	 
	 public ResetPasswordPageActionsElux resetPassword(String newPassword) {
		 return enterNewPassword(newPassword)
			.enterConfirmPassword(newPassword)
			.clickSubmitButton();
	 }
	 
	 public boolean isNewPasswordFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.newPasswordInput);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.confirmPasswordInput);
	 }
	 
	 public boolean isSubmitButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.submitButton);
	 }
	 
	 public boolean isNewPasswordShowHideIconDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.newPasswordShowHideIcon);
	 }
	 
	 public boolean isConfirmPasswordShowHideIconDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.confirmPasswordShowHideIcon);
	 }
	 
	 public boolean isChangePasswordTitleDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.changePasswordTitle);
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
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.setNewPasswordMessage);
	 }
	 
	 public boolean isPasswordRulesMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsElux.passwordRulesMessage);
	 }
	 
	 public String getCredentialUpdateAccrossGroupMessage() {
		 return WebElementUtil.getText(ResetPasswordLocatorsElux.credentialsUpdateAccrossGroupMessage);
		 
	 }
	 public ResetPasswordPageActionsElux verifyResetPasswordPage() {
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
