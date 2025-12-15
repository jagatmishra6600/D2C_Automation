package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class HomeLocatorsFsus {
	
	 public static final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 public static final By inviteFriendsFamilyHeaderLink = By.xpath("//cx-page-layout[@section='header']//a[contains(.,'Invite friends & family')]");
	 public static final By userGreetingDropdown = By.xpath("(//a[@id='dropdownMenuButton' and contains(.,'Hello')])[1]");
	 public static final By familyStoreLogo = By.cssSelector("cx-page-slot.SiteLogo img[src*='FamilyStore-Logo' ]");
	 public static final By categoryNavigationMenuBar = By.xpath("(//cx-category-navigation//cx-navigation-ui )[1]");
	 public static final By myAccountDropdownMenuButton = By.xpath("//a[normalize-space()='My account']");
	 public static final By logOutDropOption = By.xpath("//div[@class='dropdown-menu']//a[contains(.,'Log out')]");
	 	
}

