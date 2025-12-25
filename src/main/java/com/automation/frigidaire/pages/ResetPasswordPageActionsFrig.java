package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.frigidaire.locators.ResetPasswordLocatorsFrig;
import com.automation.utils.WebElementUtil;

public class ResetPasswordPageActionsFrig {

	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	 private final ResetPasswordLocatorsFrig rpLocator = new ResetPasswordLocatorsFrig();
	 	
	 
	 public ResetPasswordPageActionsFrig acceptAllCookies() {
		 try {
	            WebElement acceptBtn = untilClickable(acceptButtonLocator);
	            if (acceptBtn != null) {
	                acceptBtn.click();
	            }
	        } catch (Exception ignored) {
	            // Cookie banner not present or not interactable; continue
	        }
	        return this;
	 }
	 
	 
	 public boolean isResetPasswordButtonDisplayed() {
		 return WebElementUtil.isDisplayed(rpLocator.submitButton);			 
	 }
	 
	 public ResetPasswordPageActionsFrig enterNewPassword(String password) {
		sendKeys(rpLocator.newPasswordInput, password);
		return this;
	 }
	 
	 public ResetPasswordPageActionsFrig enterConfirmPassword(String password) {
		sendKeys(rpLocator.confirmPasswordInput,password);
		return this;
	 }
	 
	 public ResetPasswordPageActionsFrig clickSubmitButton() {
		 clickElement(rpLocator.submitButton);
		 return this;
	 }
	 
	 public ResetPasswordPageActionsFrig resetPassword(String newPassword) {
		 return enterNewPassword(newPassword)
			.enterConfirmPassword(newPassword)
			.clickSubmitButton();
	 }
	 
	 public boolean isNewPasswordFieldDisplayed() {
		 return isDisplayed(rpLocator.newPasswordInput);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		 return isDisplayed(rpLocator.confirmPasswordInput);
	 }
	 
	 public boolean isSubmitButtonDisplayed() {
		 return isDisplayed(rpLocator.submitButton);
	 }
	 
	 public boolean isNewPasswordShowHideIconDisplayed() {
		 return isDisplayed(rpLocator.newPasswordShowHideIcon);
	 }
	 
	 public boolean isConfirmPasswordShowHideIconDisplayed() {
		 return isDisplayed(rpLocator.confirmPasswordShowHideIcon);
	 }
	 
	 public boolean isChangePasswordTitleDisplayed() {
		 return isDisplayed(rpLocator.changePasswordTitle);
	 }
	 
	 public boolean isAllResetPasswordFieldsAndButtonsDisplayed() {
		 
		 return isChangePasswordTitleDisplayed() &&
				 isNewPasswordFieldDisplayed() &&
				 isConfirmPasswordFieldDisplayed() &&
				 isNewPasswordShowHideIconDisplayed() &&
				 isConfirmPasswordShowHideIconDisplayed() &&
				 isSubmitButtonDisplayed();
		 
	 } 
	 
	 public ResetPasswordPageActionsFrig verifyResetPasswordPage() {
		 Assert.assertTrue(isChangePasswordTitleDisplayed(), "'Change Password' Title is not displayed in reset password page");
		 Assert.assertTrue(isNewPasswordFieldDisplayed(), "New Password field is not displayed in reset password page");
		 Assert.assertTrue(isConfirmPasswordFieldDisplayed(), "Confirm Password field is not displayed in reset password page");
		 Assert.assertTrue(isNewPasswordShowHideIconDisplayed(), "New Password Show/Hide Eye Icon is not displayed in reset password page");
	     Assert.assertTrue(isConfirmPasswordShowHideIconDisplayed(), "Confirm Password Show/Hide Eye Icon is not displayed in reset password page");
	     Assert.assertTrue(isSubmitButtonDisplayed(), "Submit Button is not displayed in reset password page");            
	     return this;
	 } 
	 
	 public String getResetSuccessMessage() {
		 return getText(rpLocator.resetPasswordSucccessScreenMessage);
	 }
	 
	 public boolean isLoginToYourAccountLinkDisplayed() {
		 return isDisplayed(rpLocator.loginToYourAccountLink);
	 }
}
