package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebElement;

import com.automation.familystoreus.locators.HomeLocatorsFsus;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

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

    private static String providedProductId;
    private static String providedProductTitle;
    private static String providedProductPrice;


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

    public PlpPageActions_FSUS clickVacuums() {
        WebElementUtil.clickElement(HomeLocatorsFsus.navigationBarVacuums);
        WebElementUtil.clickElement(HomeLocatorsFsus.allVacuums);
        return new PlpPageActions_FSUS();
    }

    public PlpPageActions_FSUS clickWasher() {
        WebElementUtil.clickElement(HomeLocatorsFsus.navigationBarLaundry);
        WebElementUtil.clickElement(HomeLocatorsFsus.washer);
        return new PlpPageActions_FSUS();
    }

    public HomePageActionsFsus clickSearchAndEnterProductId(String productId) {
        WebElementUtil.clickElement(HomeLocatorsFsus.searchBox);
        WebElementUtil.sendKeys(HomeLocatorsFsus.searchBox, productId);
        return this;
    }

    public HomePageActionsFsus clickSearchIcon() {
        WebElementUtil.clickElement(HomeLocatorsFsus.searchIcon);
        WebElementUtil.waitForElementToBeVisible(HomeLocatorsFsus.productTitle);
        return this;
    }

    public HomePageActionsFsus storeProvidedProductId() {
        WebElementUtil.scrollToElementCenter(HomeLocatorsFsus.productId);
        WaitUtils.untilVisible(HomeLocatorsFsus.productId);
        providedProductId = WebElementUtil.getText(HomeLocatorsFsus.productId);
        return this;
    }

    public HomePageActionsFsus storeProvidedProductTitle() {
        WebElementUtil.scrollToElementCenter(HomeLocatorsFsus.productTitle);
        WaitUtils.untilVisible(HomeLocatorsFsus.productTitle);
        providedProductTitle = WebElementUtil.getText(HomeLocatorsFsus.productTitle);
        return this;
    }

    public HomePageActionsFsus storeProvidedProductPrice() {
        WebElementUtil.scrollToElementCenter(HomeLocatorsFsus.productPrice);
        WaitUtils.untilVisible(HomeLocatorsFsus.productPrice);
        providedProductPrice = WebElementUtil.getText(HomeLocatorsFsus.productPrice);
        return this;
    }

    public PdpPageActions_FSUS clickProvidedProduct() {
        WebElementUtil.scrollToElementCenter(HomeLocatorsFsus.productTitle);
        WebElementUtil.clickElement(HomeLocatorsFsus.productLink);
        return new PdpPageActions_FSUS();
    }

    public static String getProvidedProductId() {
        return providedProductId;
    }

    public static String getProvidedProductTitle() {return providedProductTitle;}

    public static String getProvidedProductPrice() {return providedProductPrice;}

}
