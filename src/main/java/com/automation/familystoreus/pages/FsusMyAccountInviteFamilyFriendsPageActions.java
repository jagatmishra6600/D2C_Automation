package com.automation.familystoreus.pages;


import com.automation.familystoreus.locators.FSUS_Homepage;
import com.automation.familystoreus.locators.FSUS_InviteFamilyFriendsPage;
import com.automation.models.CreateAccountData;
import com.automation.utils.WebElementUtil;

public class FsusMyAccountInviteFamilyFriendsPageActions {
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions clickSendNewInvitationButton() {
		 WebElementUtil.isDisplayed(FSUS_InviteFamilyFriendsPage.sendNewInvitationButton);
		 WebElementUtil.scrollIntoView(FSUS_InviteFamilyFriendsPage.sendNewInvitationButton);
		 WebElementUtil.clickElement(FSUS_InviteFamilyFriendsPage.sendNewInvitationButton);
		 return this;
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions enterFirstName(String firstName)  {
		 WebElementUtil.waitForElementToBeClickable(FSUS_InviteFamilyFriendsPage.firstNameField);
		 WebElementUtil.sendKeys(FSUS_InviteFamilyFriendsPage.firstNameField, firstName);
		 var count = 0;
		 while(WebElementUtil.getDomProperty(FSUS_InviteFamilyFriendsPage.firstNameField, "value").isEmpty() && count<2) {
			 WebElementUtil.sendKeys(FSUS_InviteFamilyFriendsPage.firstNameField, firstName);
			 count++;
		 }
		 return this;
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions enterLastName(String lastName) {
		 WebElementUtil.waitForElementToBeClickable(FSUS_InviteFamilyFriendsPage.lastNameField);
		 WebElementUtil.sendKeys(FSUS_InviteFamilyFriendsPage.lastNameField, lastName);
		 var count = 0;
		 while(WebElementUtil.getDomProperty(FSUS_InviteFamilyFriendsPage.lastNameField, "value").isEmpty() && count<2) {
			 WebElementUtil.sendKeys(FSUS_InviteFamilyFriendsPage.lastNameField, lastName);
			 count++;
		 }
		 return this;
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions enterEmailAddress(String emailAddress) {
		 WebElementUtil.waitForElementToBeClickable(FSUS_InviteFamilyFriendsPage.emailAddressField);
		 WebElementUtil.sendKeys(FSUS_InviteFamilyFriendsPage.emailAddressField, emailAddress);
		 var count = 0;
		 while(WebElementUtil.getDomProperty(FSUS_InviteFamilyFriendsPage.emailAddressField, "value").isEmpty() && count<2) {
			 WebElementUtil.sendKeys(FSUS_InviteFamilyFriendsPage.emailAddressField, emailAddress);
			 count++;
		 }
		 return this;
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions clickSendInvitationButton() {
		 WebElementUtil.scrollIntoView(FSUS_InviteFamilyFriendsPage.sendInvitationButton);
		 WebElementUtil.clickElement(FSUS_InviteFamilyFriendsPage.sendInvitationButton);
		 return this;
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions inviteUser(String firstName, String lastName, String emailAddress) {
		 return clickSendNewInvitationButton()
				 .enterFirstName(firstName)
				 .enterLastName(lastName)
				 .enterEmailAddress(emailAddress)
				 .clickSendInvitationButton();
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions inviteUser(CreateAccountData data) {
		 return clickSendNewInvitationButton()
				 .enterFirstName(data.firstName())
				 .enterLastName(data.lastName())
				 .enterEmailAddress(data.emailAddress())
				 .clickSendInvitationButton();
	 }
	 
	 public void logOut() {
		 clickUserGreetingDropdown();
		 if(!WebElementUtil.isDisplayed(FSUS_Homepage.logOutDropOption)) {
			 clickUserGreetingDropdown();
		 }
		 clickLogoutOption();
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions clickUserGreetingDropdown() {
		 WebElementUtil.scrollIntoView(FSUS_Homepage.userGreetingDropdown);
		 WebElementUtil.clickElement(FSUS_Homepage.userGreetingDropdown);
		 return this;
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions clickLogoutOption() {
		 WebElementUtil.clickElement(FSUS_Homepage.logOutDropOption);
		 return this;
	 }
	 
}
