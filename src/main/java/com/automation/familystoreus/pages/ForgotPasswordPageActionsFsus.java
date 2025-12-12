package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;

import com.automation.familystoreus.locators.ForgotPasswordPage_Fsus;
import com.automation.familystoreus.locators.FSUS_Homepage;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class ForgotPasswordPageActionsFsus {

	 public ForgotPasswordPageActionsFsus navigateToForgotPasswordPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"forgotPassword");
        try {
            WebElement acceptBtn = untilClickable(FSUS_Homepage.acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
	}
	 
	 public ForgotPasswordPageActionsFsus enterEmailAddress(String emailAddress) {
		 WebElementUtil.sendKeys(ForgotPasswordPage_Fsus.emailAddressInput,emailAddress);
		 return this;
	 }
	 
	 public ForgotPasswordPageActionsFsus clickSendNewPasswordButton() {
		 WebElementUtil.scrollIntoView(ForgotPasswordPage_Fsus.sendNewPasswordButton);
		 WebElementUtil.clickElement(ForgotPasswordPage_Fsus.sendNewPasswordButton);
		 return this;
	 }
	 
	 public boolean isPasswordResetEmailSentMessageDisplayed() {
		 return WebElementUtil.isDisplayed(ForgotPasswordPage_Fsus.resetPasswordEmailSentMessage);
	 }
	 
	 public ForgotPasswordPageActionsFsus resetPassword(String emailAddress) {
		 return enterEmailAddress(emailAddress).clickSendNewPasswordButton();
	 }
	 
	 public boolean isPasswordResetEmailSentMessageCorrect() {
		 return WebElementUtil.getText(ForgotPasswordPage_Fsus.resetPasswordEmailSentMessage)
				 .equalsIgnoreCase("Thanks! We've sent an email containing a link to reset your password. For security purposes, the link is only active for the next 24 hours. Please make sure to check your spam folder if you don't receive the email within a few minutes.");
	 }
	 
}
