package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.familystoreus.locators.HomeLocatorsFsus;
import com.automation.familystoreus.locators.ResetPasswordLocatorsFsus;
import com.automation.utils.WebElementUtil;

public class ResetPasswordPageActionsFsus {

	 public ResetPasswordPageActionsFsus acceptAllCookies() {
		 try {
	            WebElement acceptBtn = untilClickable(HomeLocatorsFsus.acceptButtonLocator, 15);
	            if (acceptBtn != null) {
	                acceptBtn.click();
	            }
	        } catch (Exception ignored) {
	            // Cookie banner not present or not interactable; continue
	        }
	        return this;
	 }
	 
	 public boolean isResetPasswordButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsFsus.submitButton);
	 }
	 
	 public ResetPasswordPageActionsFsus enterNewPassword(String password) {
		WebElementUtil.sendKeys(ResetPasswordLocatorsFsus.newPasswordInput, password);
		return this;
	 }
	 
	 public ResetPasswordPageActionsFsus enterConfirmPassword(String password) {
		WebElementUtil.sendKeys(ResetPasswordLocatorsFsus.confirmPasswordInput,password);
		return this;
	 }
	 
	 public ResetPasswordPageActionsFsus clickSubmitButton() {
		 WebElementUtil.clickElement(ResetPasswordLocatorsFsus.submitButton);
		 return this;
	 }
	 
	 public ResetPasswordPageActionsFsus resetPassword(String newPassword) {
		 return enterNewPassword(newPassword)
			.enterConfirmPassword(newPassword)
			.clickSubmitButton();
	 }
	 
	 public boolean isNewPasswordFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsFsus.newPasswordInput);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsFsus.confirmPasswordInput);
	 }
	 
	 public boolean isSubmitButtonDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsFsus.submitButton);
	 }
	 
	 
	 public boolean isChangePasswordTitleDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsFsus.resetPasswordTitle);
	 }
	 
	 public boolean isAllResetPasswordFieldsAndButtonsDisplayed() {
		 return isChangePasswordTitleDisplayed() &&
				 isNewPasswordFieldDisplayed() &&
				 isConfirmPasswordFieldDisplayed() &&
				 isSubmitButtonDisplayed();
	 }
	 
	 public ResetPasswordPageActionsFsus verifyResetPasswordFieldAndButtons() {
		 Assert.assertTrue(isChangePasswordTitleDisplayed(),"'Change Password' title is not displayed in Reset Password page");
		 Assert.assertTrue(isNewPasswordFieldDisplayed(),"'New Password' field is not displayed in Reset Password page");
		 Assert.assertTrue(isConfirmPasswordFieldDisplayed(),"'Confirm Password' field is not displayed in Reset Password page");
		 Assert.assertTrue(isSubmitButtonDisplayed(),"Submit Button is not displayed in Reset Password page");
		 return this;
	 }
	 
	 public boolean isResetPasswordSuccessMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsFsus.resetPasswordSuccessMessage);
	 }
	
	 public boolean isLoginLinkDisplayed() {
		 return WebElementUtil.isDisplayed(ResetPasswordLocatorsFsus.loginLink);
	 }
	
	 
}
