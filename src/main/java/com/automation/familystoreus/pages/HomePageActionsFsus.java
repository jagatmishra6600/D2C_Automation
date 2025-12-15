package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.WebElement;

import com.automation.familystoreus.locators.FSUS_Homepage;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class HomePageActionsFsus {

    private static String providedProductId;
    private static String providedProductTitle;
    private static String providedProductPrice;

	
	 public HomePageActionsFsus navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl());
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
	 
	 public MyAccountInviteFamilyFriendsPageActionsFsus navigateToMyAccountInviteFamilyFriendsPage() {
		 WebElementUtil.scrollIntoView(FSUS_Homepage.inviteFriendsFamilyHeaderLink);
		 WebElementUtil.clickElement(FSUS_Homepage.inviteFriendsFamilyHeaderLink);
		 return new MyAccountInviteFamilyFriendsPageActionsFsus();
	 }

    public PlpPageActions_FSUS clickVacuums() {
        WebElementUtil.clickElement(FSUS_Homepage.navigationBarVacuums);
        WebElementUtil.clickElement(FSUS_Homepage.allVacuums);
        return new PlpPageActions_FSUS();
    }

    public PlpPageActions_FSUS clickWasher() {
        WebElementUtil.clickElement(FSUS_Homepage.navigationBarLaundry);
        WebElementUtil.clickElement(FSUS_Homepage.washer);
        return new PlpPageActions_FSUS();
    }

    public HomePageActionsFsus clickSearchAndEnterProductId(String productId) {
        WebElementUtil.clickElement(FSUS_Homepage.searchBox);
        WebElementUtil.sendKeys(FSUS_Homepage.searchBox, productId);
        return this;
    }

    public HomePageActionsFsus clickSearchIcon() {
        WebElementUtil.clickElement(FSUS_Homepage.searchIcon);
        WebElementUtil.waitForElementToBeVisible(FSUS_Homepage.productTitle);
        return this;
    }

    public HomePageActionsFsus storeProvidedProductId() {
        WebElementUtil.scrollToElementCenter(FSUS_Homepage.productId);
        WaitUtils.untilVisible(FSUS_Homepage.productId);
        providedProductId = WebElementUtil.getText(FSUS_Homepage.productId);
        return this;
    }

    public HomePageActionsFsus storeProvidedProductTitle() {
        WebElementUtil.scrollToElementCenter(FSUS_Homepage.productTitle);
        WaitUtils.untilVisible(FSUS_Homepage.productTitle);
        providedProductTitle = WebElementUtil.getText(FSUS_Homepage.productTitle);
        return this;
    }

    public HomePageActionsFsus storeProvidedProductPrice() {
        WebElementUtil.scrollToElementCenter(FSUS_Homepage.productPrice);
        WaitUtils.untilVisible(FSUS_Homepage.productPrice);
        providedProductPrice = WebElementUtil.getText(FSUS_Homepage.productPrice);
        return this;
    }

    public PdpPageActions_FSUS clickProvidedProduct() {
        WebElementUtil.scrollToElementCenter(FSUS_Homepage.productTitle);
        WebElementUtil.clickElement(FSUS_Homepage.productLink);
        return new PdpPageActions_FSUS();
    }

    public static String getProvidedProductId() {
        return providedProductId;
    }

    public static String getProvidedProductTitle() {return providedProductTitle;}

    public static String getProvidedProductPrice() {return providedProductPrice;}

}
