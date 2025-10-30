package com.automation.frigidaire.pages;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;

public class FrigidaireResetPasswordPageActions {

	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	 private final By submitButton = By.cssSelector("input[value='Submit']");
	 private final By newPasswordInput = By.cssSelector("input[placeholder='New password *']");
	 private final By confirmPasswordInput = By.cssSelector("input[placeholder='Confirm password *']");
	 private final By changePasswordTitle = By.xpath("//h2[normalize-space()='Change Password']");
	 private final By newPasswordShowHideIcon = By.xpath("//input[@placeholder='New password *']/parent::div//button[@title='Show Password']");
	 private final By confirmPasswordShowHideIcon = By.xpath("//input[@placeholder='Confirm password *']/parent::div//button[@title='Show Password']");
		
	 
	 public FrigidaireResetPasswordPageActions acceptAllCookies() {
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
	 
	 public boolean isResetPasswordButtonDisplayed() {
		 return WebElementUtil.isDisplayed(submitButton);			 
	 }
	 
	 public FrigidaireResetPasswordPageActions enterNewPassword(String password) {
		WebElementUtil.sendKeys(newPasswordInput, password);
		return this;
	 }
	 
	 public FrigidaireResetPasswordPageActions enterConfirmPassword(String password) {
		WebElementUtil.sendKeys(confirmPasswordInput,password);
		return this;
	 }
	 
	 public FrigidaireResetPasswordPageActions clickSubmitButton() {
		 WebElementUtil.clickElement(submitButton);
		 return this;
	 }
	 
	 public FrigidaireResetPasswordPageActions resetPassword(String newPassword) {
		 return enterNewPassword(newPassword)
			.enterConfirmPassword(newPassword)
			.clickSubmitButton();
	 }
	 
	 public boolean isNewPasswordFieldDisplayed() {
		 return WebElementUtil.isDisplayed(newPasswordInput);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		 return WebElementUtil.isDisplayed(confirmPasswordInput);
	 }
	 
	 public boolean isSubmitButtonDisplayed() {
		 return WebElementUtil.isDisplayed(submitButton);
	 }
	 
	 public boolean isNewPasswordShowHideIconDisplayed() {
		 return WebElementUtil.isDisplayed(newPasswordShowHideIcon);
	 }
	 
	 public boolean isConfirmPasswordShowHideIconDisplayed() {
		 return WebElementUtil.isDisplayed(confirmPasswordShowHideIcon);
	 }
	 
	 public boolean isChangePasswordTitleDisplayed() {
		 return WebElementUtil.isDisplayed(changePasswordTitle);
	 }
	 
	 public boolean isAllResetPasswordFieldsAndButtonsDisplayed() {
		 return isChangePasswordTitleDisplayed() &&
				 isNewPasswordFieldDisplayed() &&
				 isConfirmPasswordFieldDisplayed() &&
				 isNewPasswordShowHideIconDisplayed() &&
				 isConfirmPasswordShowHideIconDisplayed() &&
				 isSubmitButtonDisplayed();
	 } 
}
