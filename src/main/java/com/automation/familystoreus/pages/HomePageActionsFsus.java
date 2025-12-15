package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import com.automation.electrolux.pages.HomePageActionsElux;
import org.openqa.selenium.WebElement;

import com.automation.familystoreus.locators.HomeLocatorsFsus;
import com.automation.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;

public class HomePageActionsFsus {

    public HomePageActionsFsus navigateToHomePage() {
        com.automation.utils.WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        try {
            WebElement acceptBtn = untilClickable(HomeLocatorsFsus.acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
    }

	
	 public HomePageActionsFsus navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        try {
            WebElement acceptBtn = untilClickable(HomeLocatorsFsus.acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
	}
	 
	 public boolean isInviteFriendsFamilyHeaderLinkDisplayed() {
		 return WebElementUtil.isDisplayed(HomeLocatorsFsus.inviteFriendsFamilyHeaderLink);
	 }
	 
	 public boolean isUserGreetingDropdownDisplayed() {
		 return WebElementUtil.isDisplayed(HomeLocatorsFsus.userGreetingDropdown);
	 }
	 
	 public String getUserGreetingMessage() {
		 return WebElementUtil.getText(HomeLocatorsFsus.userGreetingDropdown)
						.replace("\n", " ").trim();	
	 }
	 
	 public boolean isHomePageLoaded() {
        return WebElementUtil.isDisplayed(HomeLocatorsFsus.familyStoreLogo)
        		&& WebElementUtil.isDisplayed(HomeLocatorsFsus.categoryNavigationMenuBar);
	 }
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus navigateToMyAccountInviteFamilyFriendsPage() {
		 WebElementUtil.scrollIntoView(HomeLocatorsFsus.inviteFriendsFamilyHeaderLink);
		 WebElementUtil.clickElement(HomeLocatorsFsus.inviteFriendsFamilyHeaderLink);
		 return new MyAccountInviteFamilyFriendsPageActionsFsus();
	 }
}
