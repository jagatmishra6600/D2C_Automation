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
     public static final By navigationBarVacuums = By.xpath("(//h5[normalize-space(@aria-label)='Vacuums'])[1]");
     public static final By allVacuums = By.xpath("(//span[text()='Explore Vacuums'])[1]");
     public static final By navigationBarLaundry = By.xpath("(//h5[@aria-label='Laundry'])[1]");
     public static final By washer = By.xpath("(//a[@href='/en/washers/electrolux?filterByStock=true'])[1]");
     public static final By searchBox = By.xpath("//input[@aria-label='search']");
     public static final By searchIcon = By.xpath("//*[contains(@class, 'elxIconsSearch ')]");
     public static final By productTitle = By.xpath("//div[contains(@class, 'Product-title')] | (//a[@href='/en/product/FHWC064TE1'])[2]");
     public static final By productLink = By.xpath("//div[contains(@class, 'Product-title')]/parent::a | (//a[@href='/en/product/FHWC064TE1'])[2]");
     public static final By productId = By.xpath("//div[text()='FRFG1723AV']");
     public static final By productPrice = By.xpath("//span[contains(@class, 'H3H3_Desktop')]");
}

