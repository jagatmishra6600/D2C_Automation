package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class FSUS_InviteFamilyFriendsPage {
	
	 public static final By inviteFriendsFamilyHeaderLink = By.xpath("//cx-page-layout[@section='header']//a[contains(.,'Invite friends & family')]");
	 public static final By sendNewInvitationButton = By.xpath("//button[normalize-space()='Send new invitations']");
	 public static final By firstNameField = By.xpath("//div[@class='input_wrap']//input[@formcontrolname='firstName']");
	 public static final By lastNameField = By.xpath("//div[@class='input_wrap']//input[@formcontrolname='lastName']");
	 public static final By emailAddressField = By.xpath("//input[@id='email']");
	 public static final By sendInvitationButton = By.xpath("//button[normalize-space()='Send Invitation']");
	 public static final By logOutDropOption = By.xpath("//div[@class='dropdown-menu']//a[contains(.,'Log out')]");
	 public static final By requiredFieldErrorMessage = By.xpath("div.error-message");
}

