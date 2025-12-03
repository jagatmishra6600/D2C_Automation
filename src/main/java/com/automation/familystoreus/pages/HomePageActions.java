package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;

import com.automation.familystoreus.locators.FSUS_Homepage;
import com.automation.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;

public class HomePageActions {

	
	 public HomePageActions navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getProperty("app.url"));
        try {
            WebElement acceptBtn = untilClickable(FSUS_Homepage.acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
	}
	 
	 public boolean isInviteFriendsFamilyHeaderLinkDisplayed() {
		 return WebElementUtil.isDisplayed(FSUS_Homepage.inviteFriendsFamilyHeaderLink);
	 }
	 
	 public boolean isUserGreetingDropdownDisplayed() {
		 return WebElementUtil.isDisplayed(FSUS_Homepage.userGreetingDropdown);
	 }
	 
	 public String getUserGreetingMessage() {
		 return WebElementUtil.getText(FSUS_Homepage.userGreetingDropdown)
						.replace("\n", " ").trim();	
	 }
	 
	 public boolean isHomePageLoaded() {
        return WebElementUtil.isDisplayed(FSUS_Homepage.familyStoreLogo)
        		&& WebElementUtil.isDisplayed(FSUS_Homepage.categoryNavigationMenuBar);
	 }
}
