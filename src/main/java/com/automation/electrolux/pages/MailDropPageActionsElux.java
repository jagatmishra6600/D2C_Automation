package com.automation.electrolux.pages;

import java.util.stream.Stream;

import org.testng.Assert;

import com.automation.electrolux.locators.MailDropLocatorsElux;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class MailDropPageActionsElux {

	public MailDropPageActionsElux navigateToMailDropPage() {
		WebElementUtil.navigateTo("https://maildrop.cc/");
		return this;
	}
	
	public MailDropPageActionsElux enterEmailAddress(String emailAddress) throws InterruptedException {
		WaitUtils.sleep(2000);
		WebElementUtil.sendKeys(MailDropLocatorsElux.headerEmailAddressField, emailAddress);
		return this;
	}
	
	public MailDropPageActionsElux clickViewMailBoxButton() {
		WebElementUtil.clickElement(MailDropLocatorsElux.headerViewMailBoxButton);
		return this;
	}
	
	public boolean isInboxLoaded() {
		return WebElementUtil.isDisplayed(MailDropLocatorsElux.inboxRefreshButton);
	}
	
	public MailDropPageActionsElux login(String emailAddress) throws InterruptedException {
		return navigateToMailDropPage()
					.enterEmailAddress(emailAddress)
					.clickViewMailBoxButton();
	}

	public MailDropPageActionsElux clickInboxRefresh() {
		WebElementUtil.clickElement(MailDropLocatorsElux.inboxRefreshButton);
		return this;
	}
	
	public MailDropPageActionsElux clickFirstMailInInbox() {
		WebElementUtil.clickElement(MailDropLocatorsElux.firstMail);
		return this;
	}
	
	public MailDropPageActionsElux openFirstMailInInbox(String emailAddress) throws InterruptedException {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		WaitUtils.sleep(2000);
		return this;
	}
	
	public MailDropPageActionsElux openFirstMailInInbox(String emailAddress, String expectedMailTitle) throws InterruptedException {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		for(int i=0;i<5;i++) {
			WaitUtils.sleep(2000);
			if(getMailTitle().equalsIgnoreCase(expectedMailTitle)) {
				return this;
			}
			clickInboxRefresh();
		}
		WaitUtils.sleep(1000);
		return this;
	}

	public String getMailTitle() throws InterruptedException {
		var mailTitleValue = WebElementUtil.getText(MailDropLocatorsElux.mailTitle);
	    if(mailTitleValue.equals(null) || mailTitleValue.isEmpty() || mailTitleValue.equals("")) {
	    	WaitUtils.sleep(2000);
	    	mailTitleValue = WebElementUtil.getText(MailDropLocatorsElux.mailTitle);
	    }
	    return mailTitleValue;
	}
	

	public boolean isMailResetYourPasswordLinkDisplayed() {
	    return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
	        WebElementUtil.isDisplayed(MailDropLocatorsElux.mailResetPasswordLink)
	    );
	}
	
	public ResetPasswordPageActionsElux clickMailResetYourPasswordLink() throws InterruptedException {
		WaitUtils.sleep(2000);
		WebElementUtil.switchToFrame(MailDropLocatorsElux.mailFrame);
//		WebElementUtil.ctrlClick(mailResetPasswordLink);
//		WebElementUtil.ctrlClickWithJS(mailResetPasswordLink);
		WebElementUtil.openLinkInNewTab(MailDropLocatorsElux.mailResetPasswordLink);
		WebElementUtil.switchToDefaultContent();
		WebElementUtil.switchToLatestTabAndClosePrevious();
		return new ResetPasswordPageActionsElux();
	}
	
	public String getPasswordResetMailMessage() {
	    return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
	        WebElementUtil.getText(MailDropLocatorsElux.mailBodyText)
	    );
	}
	
	
	public String getPasswordChangeSuccessMailMessage() {
	    return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
	        WebElementUtil.getText(MailDropLocatorsElux.mailBodyText)
	    );
	}
	
	public Boolean isMailContactUsLinkDisplayed() {
		return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
			WebElementUtil.isDisplayed(MailDropLocatorsElux.mailContactUsLink)
		);
	}
	
	public boolean isMailConnectSocialMediaLinksDisplayed() {
		WebElementUtil.switchToFrame(MailDropLocatorsElux.mailFrame);
	    var isDisplayed =  DriverManager.getDriver()
	        .findElements(MailDropLocatorsElux.mailConnectSocialMediaLinks)
	        .size() > 1;
	    WebElementUtil.switchToDefaultContent();
	    return isDisplayed;
	}
	
	public boolean isMailFooterLinksDisplayed() {
        WebElementUtil.switchToFrame(MailDropLocatorsElux.mailFrame);
	    var isDisplayed =  DriverManager.getDriver()
	        .findElements(MailDropLocatorsElux.mailFooterLinks)
	        .size() > 1;
	    WebElementUtil.switchToDefaultContent();
	    return isDisplayed;
	}	
	
	
	public String getMailText() {
	    String mailSubject = getFirstMailSubject();
	    if (mailSubject == null) return null;
	    switch (mailSubject.toLowerCase()) {
	        case "reset your electrolux password":
	            return getPasswordResetMailMessage();
	        case "electrolux: password reset confirmation":
	            return getPasswordChangeSuccessMailMessage();
	        default:
	            return null;
	    }
	}
	
	public String getFirstMailSubject() {	
		return WebElementUtil.getText(MailDropLocatorsElux.firstMailSubject);
	}
	
	public MailDropPageActionsElux verifyElectroluxPasswordResetMail() throws InterruptedException {
		Assert.assertEquals(getMailTitle(), "Reset your Electrolux password", "'Reset your Electrolux password' title is not present in password reset mail");
        Assert.assertTrue(isMailResetYourPasswordLinkDisplayed(), "'Click here to reset your password' link is not displayed in the in password reset mail");
        Assert.assertTrue(getMailText().contains("You have requested to have your password reset for Electrolux"), "Email Body does not contain Message stating Request for Password Reset");
        Assert.assertTrue(isMailElectroluxLogoDisplayed(), "Electrolux Logo is not displayed in password reset mail");
        return this;
	}
	
	public MailDropPageActionsElux verifyElectroluxPasswordResetSuccessMail() throws InterruptedException {
		Assert.assertEquals(getMailTitle(), "Electrolux: Password Reset Confirmation", "'Electrolux: Password Reset Confirmation' title is not present in reset success mail");
        Assert.assertTrue(isMailElectroluxLogoDisplayed(), "Electrolux Brand logo is not present in reset success mail");
        Assert.assertTrue(getMailText().contains("your password was successfully changed"), "Reset Successful Text is not present in reset success mail");
        Assert.assertTrue(isMailContactUsLinkDisplayed(), "Contact Us Link is not present in reset success mail");
        Assert.assertTrue(getMailText().contains("Electrolux team"), "Electrolux team Text is not present in reset success mail");
        Assert.assertTrue(isMailConnectSocialMediaLinksDisplayed(), "Connect Social Media Links Section is not present in reset success mail");
        return this;
	}
	
	public Boolean isMailElectroluxLogoDisplayed() {
		return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
			WebElementUtil.isDisplayed(MailDropLocatorsElux.mailElectroluxLogo)
        );
	}
	
	public MailDropPageActionsElux verifyCustomerRegistrationVerificationMail(String firstName, String lastName) throws InterruptedException {
		Assert.assertEquals(getMailTitle(), "Electrolux: Account Verification", "'Electrolux: Account Verification' title is not present in reset success mail");    
		Assert.assertTrue(isClickHereToActivateAccountLinkDisplayed(), "Click Here to Activate Your Account link is not present in the mail");
        Assert.assertEquals(getMailGreetingMessage(), "Dear " + firstName + " " + lastName + ",", "Greeting Text does not contain First Name and Last Name");
        Assert.assertEquals(getMailThanksForCreatingAccountMessage(),"Thanks for creating an account with Electrolux. Please take a second to make sure we have your correct email address so that we can activate your account now. You can always change your password on your profile."
    		 	, "Thank you for creating account body text is not present in the mail");
        Assert.assertTrue(getLinkExpiresMessage().contains("This link expires in 24 hours."), "Link expires in 24 hours text is not present in the mail");
        Assert.assertEquals(getNotIntendedRecipientMessage(), "If you are not the intended recipient of this email, please delete this message and contact us immediately. Thanks for your help.", "'If you are not intended recipient of this email' text is not present in the mail");
        Assert.assertTrue(isMailFooterSocialMediaLinksDisplayed(), "Social Media Links are present in the mail footer section");
        return this;
	}
	
	public boolean isMailFooterSocialMediaLinksDisplayed() {
	    return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
	        Stream.of(
	        		MailDropLocatorsElux.mailCreateAccountFooterFacebookLink,
	        		MailDropLocatorsElux.mailCreateAccountFooterInstagramLink,
	        		MailDropLocatorsElux.mailCreateAccountFooterPintrestLink,
	        		MailDropLocatorsElux.mailCreateAccountFooterTwitterLink,
	        		MailDropLocatorsElux.mailCreateAccountFooterYoutubeLink
	        ).allMatch(WebElementUtil::isDisplayed)
	    );
	}

	private String getNotIntendedRecipientMessage() {
		return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
        WebElementUtil.getText(MailDropLocatorsElux.mailNotIntendedRecipientText)
		);
	}

	private String getLinkExpiresMessage() {
		return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
        WebElementUtil.getText(MailDropLocatorsElux.mailLinkExpiresText)
		);
	}

	private String getMailThanksForCreatingAccountMessage() {
		return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
        WebElementUtil.getText(MailDropLocatorsElux.mailThanksForCreatingAccountMessage)
		);
	}

	private String getMailGreetingMessage() {
		return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
        WebElementUtil.getText(MailDropLocatorsElux.mailGreetingMessage)
		);
	}

	private boolean isClickHereToActivateAccountLinkDisplayed() {
		return WebElementUtil.performInFrame(MailDropLocatorsElux.mailFrame, () ->
		WebElementUtil.isDisplayed(MailDropLocatorsElux.mailClickToActivateAccountLink)
    );
	}
	

}
