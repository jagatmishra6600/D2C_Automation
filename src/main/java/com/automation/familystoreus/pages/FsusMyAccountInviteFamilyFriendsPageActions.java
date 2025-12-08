package com.automation.familystoreus.pages;


import org.openqa.selenium.By;

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
		 return typeAndVerify(FSUS_InviteFamilyFriendsPage.firstNameField, firstName);
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions enterLastName(String lastName) { 
		 return typeAndVerify(FSUS_InviteFamilyFriendsPage.lastNameField, lastName);
	 }
	 
	 public FsusMyAccountInviteFamilyFriendsPageActions enterEmailAddress(String emailAddress) {
		 return typeAndVerify(FSUS_InviteFamilyFriendsPage.emailAddressField, emailAddress);
		 
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
	 
	 private FsusMyAccountInviteFamilyFriendsPageActions typeAndVerify(By locator, String text) {
		    WebElementUtil.waitForElementToBeClickable(locator);
		    int retries = 0;
		    while (retries < 3) {
		        WebElementUtil.sendKeys(locator, text);
		        var actualValue = WebElementUtil.getDomProperty(locator, "value");
		        if (text.equals(actualValue)) {
		            return this;
		        }
		        retries++;
		    }
		   return this;
		}
	 
}
