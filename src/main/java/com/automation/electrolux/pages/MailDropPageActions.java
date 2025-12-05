package com.automation.electrolux.pages;

import java.util.stream.Stream;

import org.testng.Assert;

import com.automation.electrolux.locators.ELUX_MailDropPage;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class MailDropPageActions {

	public MailDropPageActions navigateToMailDropPage() {
		WebElementUtil.navigateTo("https://maildrop.cc/");
		return this;
	}
	
	public MailDropPageActions enterEmailAddress(String emailAddress) throws InterruptedException {
		WaitUtils.sleep(2000);
		WebElementUtil.sendKeys(ELUX_MailDropPage.headerEmailAddressField, emailAddress);
		return this;
	}
	
	public MailDropPageActions clickViewMailBoxButton() {
		WebElementUtil.clickElement(ELUX_MailDropPage.headerViewMailBoxButton);
		return this;
	}
	
	public boolean isInboxLoaded() {
		return WebElementUtil.isDisplayed(ELUX_MailDropPage.inboxRefreshButton);
	}
	
	public MailDropPageActions login(String emailAddress) throws InterruptedException {
		return navigateToMailDropPage()
					.enterEmailAddress(emailAddress)
					.clickViewMailBoxButton();
	}

	public MailDropPageActions clickInboxRefresh() {
		WebElementUtil.clickElement(ELUX_MailDropPage.inboxRefreshButton);
		return this;
	}
	
	public MailDropPageActions clickFirstMailInInbox() {	
		WebElementUtil.clickElement(ELUX_MailDropPage.firstMail);
		return this;
	}
	
	public MailDropPageActions openFirstMailInInbox(String emailAddress) throws InterruptedException {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		WaitUtils.sleep(2000);
		return this;
	}
	
	public MailDropPageActions openFirstMailInInbox(String emailAddress, String expectedMailTitle) throws InterruptedException {
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
		var mailTitleValue = WebElementUtil.getText(ELUX_MailDropPage.mailTitle);
	    if(mailTitleValue.equals(null) || mailTitleValue.isEmpty() || mailTitleValue.equals("")) {
	    	WaitUtils.sleep(2000);
	    	mailTitleValue = WebElementUtil.getText(ELUX_MailDropPage.mailTitle);
	    }
	    return mailTitleValue;
	}
	

	public boolean isMailResetYourPasswordLinkDisplayed() {
	    return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
	        WebElementUtil.isDisplayed(ELUX_MailDropPage.mailResetPasswordLink)
	    );
	}
	
//	public ResetPasswordPageActions clickMailResetYourPasswordLink() throws InterruptedException {
//		WaitUtils.sleep(2000);
//		WebElementUtil.switchToFrame(ELUX_MailDropPage.mailFrame);
////		WebElementUtil.ctrlClick(mailResetPasswordLink);
////		WebElementUtil.ctrlClickWithJS(mailResetPasswordLink);
//		WebElementUtil.openLinkInNewTab(ELUX_MailDropPage.mailResetPasswordLink);
//		WebElementUtil.switchToDefaultContent();
//		WebElementUtil.switchToLatestTabAndClosePrevious();
//		return new ResetPasswordPageActions();
//	}
	
	public String getPasswordResetMailMessage() {
	    return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
	        WebElementUtil.getText(ELUX_MailDropPage.mailBodyText)
	    );
	}
	
	
	public String getPasswordChangeSuccessMailMessage() {
	    return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
	        WebElementUtil.getText(ELUX_MailDropPage.mailBodyText)
	    );
	}
	
	public Boolean isMailContactUsLinkDisplayed() {
		return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
			WebElementUtil.isDisplayed(ELUX_MailDropPage.mailContactUsLink)
		);
	}
	
	public boolean isMailConnectSocialMediaLinksDisplayed() {
		WebElementUtil.switchToFrame(ELUX_MailDropPage.mailFrame);
	    var isDisplayed =  DriverManager.getDriver()
	        .findElements(ELUX_MailDropPage.mailConnectSocialMediaLinks)
	        .size() > 1;
	    WebElementUtil.switchToDefaultContent();
	    return isDisplayed;
	}
	
	public boolean isMailFooterLinksDisplayed() {
        WebElementUtil.switchToFrame(ELUX_MailDropPage.mailFrame);
	    var isDisplayed =  DriverManager.getDriver()
	        .findElements(ELUX_MailDropPage.mailFooterLinks)
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
		return WebElementUtil.getText(ELUX_MailDropPage.firstMailSubject);
	}
	
	public void verifyElectroluxPasswordResetMail() throws InterruptedException {	
		Assert.assertEquals(getMailTitle(), "Reset your Electrolux password", "'Reset your Electrolux password' title is not present in password reset mail");
        Assert.assertTrue(isMailResetYourPasswordLinkDisplayed(), "'Click here to reset your password' link is not displayed in the in password reset mail");
        Assert.assertTrue(getMailText().contains("You have requested to have your password reset for Electrolux"), "Email Body does not contain Message stating Request for Password Reset");
        Assert.assertTrue(isMailElectroluxLogoDisplayed(), "Electrolux Logo is not displayed in password reset mail");
	}
	
	public void verifyElectroluxPasswordResetSuccessMail() throws InterruptedException {
		Assert.assertEquals(getMailTitle(), "Electrolux: Password Reset Confirmation", "'Electrolux: Password Reset Confirmation' title is not present in reset success mail");
        Assert.assertTrue(isMailElectroluxLogoDisplayed(), "Electrolux Brand logo is not present in reset success mail");
        Assert.assertTrue(getMailText().contains("your password was successfully changed"), "Reset Successful Text is not present in reset success mail");
        Assert.assertTrue(isMailContactUsLinkDisplayed(), "Contact Us Link is not present in reset success mail");
        Assert.assertTrue(getMailText().contains("Electrolux team"), "Electrolux team Text is not present in reset success mail");
        Assert.assertTrue(isMailConnectSocialMediaLinksDisplayed(), "Connect Social Media Links Section is not present in reset success mail");
        }
	
	public Boolean isMailElectroluxLogoDisplayed() {
		return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
			WebElementUtil.isDisplayed(ELUX_MailDropPage.mailElectroluxLogo)
        );
	}
	
	public void verifyCustomerRegistrationVerificationMail(String firstName, String lastName) throws InterruptedException {
		Assert.assertEquals(getMailTitle(), "Electrolux: Account Verification", "'Electrolux: Account Verification' title is not present in reset success mail");    
		Assert.assertTrue(isClickHereToActivateAccountLinkDisplayed(), "Click Here to Activate Your Account link is not present in the mail");
        Assert.assertEquals(getMailGreetingMessage(), "Dear " + firstName + " " + lastName + ",", "Greeting Text does not contain First Name and Last Name");
        Assert.assertEquals(getMailThanksForCreatingAccountMessage(),"Thanks for creating an account with Electrolux. Please take a second to make sure we have your correct email address so that we can activate your account now. You can always change your password on your profile."
    		 	, "Thank you for creating account body text is not present in the mail");
        Assert.assertTrue(getLinkExpiresMessage().contains("This link expires in 24 hours."), "Link expires in 24 hours text is not present in the mail");
        Assert.assertEquals(getNotIntendedRecipientMessage(), "If you are not the intended recipient of this email, please delete this message and contact us immediately. Thanks for your help.", "'If you are not intended recipient of this email' text is not present in the mail");
        Assert.assertTrue(isMailFooterSocialMediaLinksDisplayed(), "Social Media Links are present in the mail footer section");
	}
	
	public boolean isMailFooterSocialMediaLinksDisplayed() {
	    return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () ->
	        Stream.of(
	        		ELUX_MailDropPage.mailCreateAccountFooterFacebookLink,
	        		ELUX_MailDropPage.mailCreateAccountFooterInstagramLink,
	        		ELUX_MailDropPage.mailCreateAccountFooterPintrestLink,
	        		ELUX_MailDropPage.mailCreateAccountFooterTwitterLink,
	        		ELUX_MailDropPage.mailCreateAccountFooterYoutubeLink
	        ).allMatch(WebElementUtil::isDisplayed)
	    );
	}

	private String getNotIntendedRecipientMessage() {
		return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
        WebElementUtil.getText(ELUX_MailDropPage.mailNotIntendedRecipientText)
		);
	}

	private String getLinkExpiresMessage() {
		return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
        WebElementUtil.getText(ELUX_MailDropPage.mailLinkExpiresText)
		);
	}

	private String getMailThanksForCreatingAccountMessage() {
		return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
        WebElementUtil.getText(ELUX_MailDropPage.mailThanksForCreatingAccountMessage)
		);
	}

	private String getMailGreetingMessage() {
		return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
        WebElementUtil.getText(ELUX_MailDropPage.mailGreetingMessage)
		);
	}

	private boolean isClickHereToActivateAccountLinkDisplayed() {
		return WebElementUtil.performInFrame(ELUX_MailDropPage.mailFrame, () -> 
		WebElementUtil.isDisplayed(ELUX_MailDropPage.mailClickToActivateAccountLink)
    );
	}
}
