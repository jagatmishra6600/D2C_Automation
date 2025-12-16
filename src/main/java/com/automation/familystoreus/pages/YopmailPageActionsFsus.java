package com.automation.familystoreus.pages;

import org.testng.Assert;

import com.automation.familystoreus.locators.YopMailLocatorsFsus;
import com.automation.utils.WebElementUtil;

public class YopmailPageActionsFsus {
	
	public YopmailPageActionsFsus navigateToYopmailPage() {
		WebElementUtil.navigateTo("https://yopmail.com/");
		return this;
	}
	
	public YopmailPageActionsFsus enterEmailAddress(String emailAddress) throws InterruptedException {
		WebElementUtil.waitForElementToBeClickable(YopMailLocatorsFsus.emailAddressField);
		WebElementUtil.sendKeys(YopMailLocatorsFsus.emailAddressField, emailAddress);
		return this;
	}
	
	public YopmailPageActionsFsus clickCheckInboxButton() {
		WebElementUtil.clickElement(YopMailLocatorsFsus.checkInboxIcon);
		return this;
	}
	
	public boolean isInboxLoaded() {
		return WebElementUtil.isDisplayed(YopMailLocatorsFsus.inboxEmailIdTitle);
	}
	
	public YopmailPageActionsFsus login(String emailAddress) throws InterruptedException {
		return navigateToYopmailPage()
					.enterEmailAddress(emailAddress)
					.clickCheckInboxButton();
	}
	
	public YopmailPageActionsFsus clickInboxRefresh() {
		WebElementUtil.clickElement(YopMailLocatorsFsus.inboxRefreshButton);
		return this;
	}
	
	public YopmailPageActionsFsus clickFirstMailInInbox() {	
		WebElementUtil.switchToFrame("ifinbox");
		WebElementUtil.clickElement(YopMailLocatorsFsus.firstMail);
		WebElementUtil.switchToDefaultContent();
		return this;
	}
	
	public YopmailPageActionsFsus openFirstMailInInbox(String emailAddress) throws InterruptedException {
		return login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
	}
	
	public String getGreetingMessage() {
	    return WebElementUtil.performInFrame("ifmail", () -> 
	        WebElementUtil.getText(YopMailLocatorsFsus.mailGreetingMessage)
	    );
	}
	
	public Boolean isGreetingMessageDisplayed() {
		return WebElementUtil.performInFrame("ifmail", () -> 
        WebElementUtil.isDisplayed(YopMailLocatorsFsus.mailGreetingMessage)
    );	
	}
	
	public String getInvitationCode() {
		var registationDetailsText = WebElementUtil.performInFrame("ifmail", () -> 
				WebElementUtil.getText(YopMailLocatorsFsus.mailRegisterForFamilyStoreSectionText)
					);
		return registationDetailsText.split("Invitation Code:")[1]
                .trim()
                .split(" ")[0]; 
	}
	
	public Boolean isFSRegistrationLinkDisplayed() {
		return WebElementUtil.performInFrame("ifmail", () -> 
        WebElementUtil.isDisplayed(YopMailLocatorsFsus.mailRegistrationLink)
    );	
	}
	
	public String getFSInvitationMessage() {
		return WebElementUtil.performInFrame("ifmail", () -> 
    	WebElementUtil.getText(YopMailLocatorsFsus.mailFSInvitationMessage)
	);
	}
	
	public LoginPageActionsFsus clickOnRegistrationLink() {
		WebElementUtil.switchToFrame("ifmail");
		WebElementUtil.openLinkInNewTab(YopMailLocatorsFsus.mailRegistrationLink);
		WebElementUtil.switchToDefaultContent();
		WebElementUtil.switchToLatestTabAndClosePrevious();
		return new LoginPageActionsFsus();
	}
	
	public String getInvitedUserEmail() {
	    var registrationDetailsText = WebElementUtil.performInFrame("ifmail", () ->
	            WebElementUtil.getText(YopMailLocatorsFsus.mailRegisterForFamilyStoreSectionText)
	    );
	    return registrationDetailsText.split("Email Address:")[1]
	            .trim()
	            .split(" ")[0];
	}
	
	public Boolean isInvitationMailContactUsLinkDisplayed() {
		return WebElementUtil.performInFrame("ifmail", () -> 
        WebElementUtil.isDisplayed(YopMailLocatorsFsus.mailInvitationContactUsLink)
	);
	}
	
	public String getInvitationEmailValidityMessage() {
		return WebElementUtil.performInFrame("ifmail", () -> 
    	WebElementUtil.getText(YopMailLocatorsFsus.mailInvitationCodeEmailValidityMessage)
	);
	}
	
	public Boolean isTermsAndConditionsLinkDisplayed() {
		return WebElementUtil.performInFrame("ifmail", () -> 
        WebElementUtil.isDisplayed(YopMailLocatorsFsus.mailTermsAndCondtionsLink)
	);
	}
	
	public YopmailPageActionsFsus verifyUserInvitationMail(String invitedUserEmail) {
		Assert.assertTrue(isGreetingMessageDisplayed(),"Greeting Message is not present in the User Invitation Mail");
		Assert.assertTrue(isFSRegistrationLinkDisplayed(),"Family Store Registration Link is not present in the User Invitation Mail");
		Assert.assertTrue(getFSInvitationMessage().contains("You've been invited to join the Electrolux Family Store")
								,"'You've been invited to join the Electrolux Family Store' Invitation Message is not present in the User Invitation Mail");
		Assert.assertTrue(isInvitationMailContactUsLinkDisplayed(),"'Contact Us link' is not present in the User Invitation Mail");
		Assert.assertTrue(isTermsAndConditionsLinkDisplayed(),"'Terms and Conditions' link is not present in the User Invitation Mail");
		Assert.assertEquals(getInvitedUserEmail(), invitedUserEmail,"Invited User Email Address is not correct in the User Invitation Mail");
		Assert.assertEquals(getInvitationEmailValidityMessage(),"Important: This code is only valid for the email "+invitedUserEmail+" .This invitation cannot be forwarded."
								,"'Code is only valid for the email' message is not present in the User Invitation Mail ");
		return this;
	}
}
