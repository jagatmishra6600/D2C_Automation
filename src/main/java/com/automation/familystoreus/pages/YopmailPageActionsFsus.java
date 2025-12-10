package com.automation.familystoreus.pages;

import java.time.Duration;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.automation.familystoreus.locators.FSUS_YopMailPage;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class YopmailPageActionsFsus {
	
	public YopmailPageActionsFsus navigateToYopmailPage() {
		WebElementUtil.navigateTo("https://yopmail.com/");
		return this;
	}
	
	public YopmailPageActionsFsus enterEmailAddress(String emailAddress) throws InterruptedException {
		WebElementUtil.waitForElementToBeClickable(FSUS_YopMailPage.emailAddressField);
		WebElementUtil.sendKeys(FSUS_YopMailPage.emailAddressField, emailAddress);
		return this;
	}
	
	public YopmailPageActionsFsus clickCheckInboxButton() {
		WebElementUtil.clickElement(FSUS_YopMailPage.checkInboxIcon);	
		return this;
	}
	
	public boolean isInboxLoaded() {
		return WebElementUtil.isDisplayed(FSUS_YopMailPage.inboxEmailIdTitle);
	}
	
	public YopmailPageActionsFsus login(String emailAddress) throws InterruptedException {
		return navigateToYopmailPage()
					.enterEmailAddress(emailAddress)
					.clickCheckInboxButton();
	}
	
	public YopmailPageActionsFsus clickInboxRefresh() {
		WebElementUtil.clickElement(FSUS_YopMailPage.inboxRefreshButton);	
		return this;
	}
	
	public YopmailPageActionsFsus clickFirstMailInInbox() {	
		WebElementUtil.switchToFrame("ifinbox");
		WebElementUtil.clickElement(FSUS_YopMailPage.firstMail);
		WebElementUtil.switchToDefaultContent();
		return this;
	}
	
	public YopmailPageActionsFsus openFirstMailInInbox(String emailAddress) throws InterruptedException {
		return login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
	}
	
	public String getGreetingMessage() {
	    return WebElementUtil.performInFrame("ifmail", () -> 
	        WebElementUtil.getText(FSUS_YopMailPage.mailGreetingMessage)
	    );
	}
	
	public Boolean isGreetingMessageDisplayed() {
		return WebElementUtil.performInFrame("ifmail", () -> 
        WebElementUtil.isDisplayed(FSUS_YopMailPage.mailGreetingMessage)
    );	
	}
	
	public String getInvitationCode() {
		var registationDetailsText = WebElementUtil.performInFrame("ifmail", () -> 
				WebElementUtil.getText(FSUS_YopMailPage.mailRegisterForFamilyStoreSectionText)
					);
		return registationDetailsText.split("Invitation Code:")[1]
                .trim()
                .split(" ")[0]; 
	}
	
	public Boolean isFSRegistrationLinkDisplayed() {
		return WebElementUtil.performInFrame("ifmail", () -> 
        WebElementUtil.isDisplayed(FSUS_YopMailPage.mailRegistrationLink)
    );	
	}
	
	public String getFSInvitationMessage() {
		return WebElementUtil.performInFrame("ifmail", () -> 
    	WebElementUtil.getText(FSUS_YopMailPage.mailFSInvitationMessage)
	);
	}
	
	public LoginPageActionsFsus clickOnRegistrationLink() {
		WebElementUtil.switchToFrame("ifmail");
		WebElementUtil.openLinkInNewTab(FSUS_YopMailPage.mailRegistrationLink);
		WebElementUtil.switchToDefaultContent();
		WebElementUtil.switchToLatestTabAndClosePrevious();
		return new LoginPageActionsFsus();
	}
	
	public String getInvitedUserEmail() {
	    var registrationDetailsText = WebElementUtil.performInFrame("ifmail", () ->
	            WebElementUtil.getText(FSUS_YopMailPage.mailRegisterForFamilyStoreSectionText)
	    );
	    return registrationDetailsText.split("Email Address:")[1]
	            .trim()
	            .split(" ")[0];
	}
	
	public Boolean isInvitationMailContactUsLinkDisplayed() {
		return WebElementUtil.performInFrame("ifmail", () -> 
        WebElementUtil.isDisplayed(FSUS_YopMailPage.mailInvitationContactUsLink)
	);
	}
	
	public String getInvitationEmailValidityMessage() {
		return WebElementUtil.performInFrame("ifmail", () -> 
    	WebElementUtil.getText(FSUS_YopMailPage.mailInvitationCodeEmailValidityMessage)
	);
	}
	
	public Boolean isTermsAndConditionsLinkDisplayed() {
		return WebElementUtil.performInFrame("ifmail", () -> 
        WebElementUtil.isDisplayed(FSUS_YopMailPage.mailTermsAndCondtionsLink)
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
