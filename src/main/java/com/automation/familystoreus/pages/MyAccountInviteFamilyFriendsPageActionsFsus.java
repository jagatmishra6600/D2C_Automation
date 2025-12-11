package com.automation.familystoreus.pages;


import org.openqa.selenium.By;

import com.automation.familystoreus.locators.FSUS_Homepage;
import com.automation.familystoreus.locators.FSUS_InviteFamilyFriendsPage;
import com.automation.models.CreateAccountData;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class MyAccountInviteFamilyFriendsPageActionsFsus {
	 private FSUS_InviteFamilyFriendsPage locator = new FSUS_InviteFamilyFriendsPage();
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus clickSendNewInvitationButton() {
		 WebElementUtil.isDisplayed(locator.sendNewInvitationButton);
		 WebElementUtil.scrollIntoView(locator.sendNewInvitationButton);
		 WebElementUtil.clickElement(locator.sendNewInvitationButton);
		 return this;
	 }
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus enterFirstName(String firstName) throws InterruptedException  { 
		 return typeAndVerify(locator.firstNameField, firstName);
	 }
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus enterLastName(String lastName) throws InterruptedException { 
		 return typeAndVerify(locator.lastNameField, lastName);
	 }
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus enterEmailAddress(String emailAddress) throws InterruptedException {
		 return typeAndVerify(locator.emailAddressField, emailAddress);
		 
	 }
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus clickSendInvitationButton() {
		 WebElementUtil.scrollIntoView(locator.sendInvitationButton);
		 WebElementUtil.clickElement(locator.sendInvitationButton);
		 return this;
	 }
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus inviteUser(String firstName, String lastName, String emailAddress) throws InterruptedException {
		 return clickSendNewInvitationButton()
				 .enterFirstName(firstName)
				 .enterLastName(lastName)
				 .enterEmailAddress(emailAddress)
				 .clickSendInvitationButton();
	 }
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus inviteUser(CreateAccountData data) throws InterruptedException {
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
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus clickUserGreetingDropdown() {
		 WebElementUtil.scrollIntoView(FSUS_Homepage.userGreetingDropdown);
		 WebElementUtil.clickElement(FSUS_Homepage.userGreetingDropdown);
		 return this;
	 }
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus clickLogoutOption() {
		 WebElementUtil.clickElement(FSUS_Homepage.logOutDropOption);
		 return this;
	 }
	 
	 private MyAccountInviteFamilyFriendsPageActionsFsus typeAndVerify(By locator, String text) throws InterruptedException {
		    WebElementUtil.waitForElementToBeClickable(locator);
		    int retries = 0;
		    while (retries < 3) {
		        WebElementUtil.sendKeys(locator, text);
		        var actualValue = WebElementUtil.getDomProperty(locator, "value");
		        if (text.equals(actualValue)) {
		            return this;
		        }
		        WaitUtils.sleep(1000);
		        retries++;
		    }
		   return this;
		}
	 
}
