package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class FSUS_YopMailPage {
	
	public static final By emailAddressField = By.id("login");
	public static final By checkInboxIcon = By.cssSelector("#refreshbut i");
	public static final By inboxEmailIdTitle =  By.cssSelector(".bname");
	public static final By inboxRefreshButton = By.id("refresh");
	public static final By firstMail = By.cssSelector(".bodyinbox div[currentmail]");
	public static final By mailGreetingMessage = By.xpath("//h1[contains(.,'Dear')]");
	public static final By mailRegistrationLink = By.xpath("//h1[contains(.,'Dear')]//parent::td//p//a");
	public static final By mailRegisterForFamilyStoreSectionText = By.xpath("//td//div[contains(.,'Register for The Family Store')]//parent::td//p");
	public static final By mailFSInvitationMessage= By.xpath("//p[contains(.,'invited to join')]");	
	public static final By mailInvitationContactUsLink= By.xpath("//a[text()='Contact Us']");	
	public static final By mailInvitationCodeEmailValidityMessage = By.xpath("//p[contains(.,'code is only valid for the email')]");
	public static final By mailTermsAndCondtionsLink = By.xpath("//a[.='Terms and Conditions']");
}

