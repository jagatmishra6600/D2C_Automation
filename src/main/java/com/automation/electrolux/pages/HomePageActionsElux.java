package com.automation.electrolux.pages;

import com.automation.electrolux.locators.HomepageLocatorsElux;
import com.automation.utils.ConfigReader;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automation.utils.UserTestData;


import static com.automation.utils.WaitUtils.untilClickable;

import java.util.List;

public class HomePageActionsElux {

    HomepageLocatorsElux homePage_Locator = new HomepageLocatorsElux();

    private static String providedProductId;
    private static String providedProductTitle;
    private static String providedProductPrice;
    private static final int DEFAULT_WAIT_TIMEOUT_SECONDS = 30;
    
    public HomePageActionsElux navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        try {
            WebElement acceptBtn = untilClickable(homePage_Locator.acceptButtonLocator, DEFAULT_WAIT_TIMEOUT_SECONDS);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
    }

    public PlpPageActionsElux clickVacuums() {
        WebElementUtil.clickElement(homePage_Locator.navigationBarVacuums);
        WebElementUtil.clickElement(homePage_Locator.allVacuums);
        return new PlpPageActionsElux();
    }

    public PlpPageActionsElux clickWasher() {
        WebElementUtil.clickElement(homePage_Locator.navigationBarLaundry);
        WebElementUtil.clickElement(homePage_Locator.washer);
        return new PlpPageActionsElux();
    }

    public HomePageActionsElux  clickSearchAndEnterProductId(String productId) {
        WebElementUtil.clickElement(homePage_Locator.searchBox);
        WebElementUtil.sendKeys(homePage_Locator.searchBox, productId);
        return this;
    }

    public HomePageActionsElux clickSearchIcon() {
        WebElementUtil.clickElement(homePage_Locator.searchIcon);
        WebElementUtil.waitForElementToBeVisible(homePage_Locator.productTitle);
        return this;
    }

    public HomePageActionsElux storeProvidedProductId() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.productId);
        WaitUtils.untilVisible(homePage_Locator.productId);
        providedProductId = WebElementUtil.getText(homePage_Locator.productId);
        return this;
    }

    public HomePageActionsElux storeProvidedProductTitle() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.productTitle);
        WaitUtils.untilVisible(homePage_Locator.productTitle);
        providedProductTitle = WebElementUtil.getText(homePage_Locator.productTitle);
        return this;
    }

    public HomePageActionsElux storeProvidedProductPrice() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.productPrice);
        WaitUtils.untilVisible(homePage_Locator.productPrice);
        providedProductPrice = WebElementUtil.getText(homePage_Locator.productPrice);
        return this;
    }

    public PdpPageActionsElux clickProvidedProduct() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.productTitle);
        WebElementUtil.clickElement(homePage_Locator.productLink);
        return new PdpPageActionsElux();
    }

    public HomePageActionsElux clickSearchIconAndWaitForAccessProduct() {
        WebElementUtil.clickElement(homePage_Locator.searchIcon);
        WebElementUtil.waitForElementToBeVisible(homePage_Locator.accesProductLink);
        return this;
    }

    public PdpPageActionsElux clickAccesProduct() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.accesProductLink);
        WebElementUtil.clickElement(homePage_Locator.accesProductLink);
        return new PdpPageActionsElux();
    }

    public static String getProvidedProductId() {
        return providedProductId;
    }

    public static String getProvidedProductTitle() {return providedProductTitle;}

    public static String getProvidedProductPrice() {return providedProductPrice;}

    private void acceptCookiesIfPresent() {
        try {
            try { WaitUtils.untilPresent(HomepageLocatorsElux.cookie_AcceptButton, 15); } catch (Exception ignored) {}
            if (WebElementUtil.isDisplayed(HomepageLocatorsElux.cookie_AcceptButton)) {
                WebElementUtil.clickElement(HomepageLocatorsElux.cookie_AcceptButton);
                WaitUtils.sleep(500);
            }
        } catch (Exception ignored) {}
    }

//    public HomePageActionsElux navigateToHomePage() {
//        WebElementUtil.navigateTo(ConfigReader.getAppUrl());
//        acceptCookiesIfPresent();
//        return this;
//    }

    public boolean isHomePageLoaded() {
        // isDisplayed now handles the wait internally
        return WebElementUtil.isDisplayed(HomepageLocatorsElux.electroluxLogo)
                && WebElementUtil.isDisplayed(HomepageLocatorsElux.homePageTemplate);
    }

    public boolean isLoginDisplayed() {
        return WebElementUtil.isDisplayed(HomepageLocatorsElux.mainMenu_Login_OrderStatus);
    }

    public HomePageActionsElux clickLoginOrderStatusLink() {
        WebElementUtil.clickElement(HomepageLocatorsElux.mainMenu_Login_OrderStatus);
        if(!WebElementUtil.isDisplayed(HomepageLocatorsElux.mainMenu_Login_OrderStatus_CreateAccount)) {
            WebElementUtil.clickElement(HomepageLocatorsElux.mainMenu_Login_OrderStatus);
        }
        return this;
    }

    public LoginPageActionsElux navigateToLoginPage() {
        WebElementUtil.hoverElement(homePage_Locator.mainMenu_Login_OrderStatus);
        WebElementUtil.clickElement(homePage_Locator.mainMenu_Login_OrderStatus_Login);
        return new LoginPageActionsElux();
    }

    public boolean isUserGreetingDropdownDisplayed() {
        return WebElementUtil.isDisplayed(HomepageLocatorsElux.userGreetingDropdownButton);
    }

    public String getGreetingMessage() {
        return WebElementUtil.getText(HomepageLocatorsElux.userGreetingDropdownButton)
                .replace("\n", " ").trim();
    }

    public HomePageActionsElux login(String emailAddress, String password) throws InterruptedException {
        return navigateToHomePage().navigateToLoginPage()
                .login(emailAddress, password);
    }

    public HomePageActionsElux loginWithDefaultCredentials() {
        return navigateToHomePage().navigateToLoginPage()
                .login(UserTestData.getUserName(), UserTestData.getPassword());
    }

    public ForgotPasswordPageActionsElux navigateToResetPasswordPage() {
        return navigateToHomePage().navigateToLoginPage().clickForgotPasswordLink();
    }
    
    public HomePageActionsElux clickProfileDropdown() {
    	WebElementUtil.isDisplayed(homePage_Locator.mainMenu_ProfileDropdown);
    	WebElementUtil.scrollIntoView(homePage_Locator.mainMenu_ProfileDropdown);
        WebElementUtil.clickElement(homePage_Locator.mainMenu_ProfileDropdown);
        return this;
    }
    
    public HomePageActionsElux clickMyAccountLink() {
    	WebElementUtil.scrollIntoView(homePage_Locator.mainMenu_ProfileDropdown_MyAccountLink);
        WebElementUtil.clickElement(homePage_Locator.mainMenu_ProfileDropdown_MyAccountLink);
        return this;
    }
	
	public AccountPreferencesPageActionsElux navigateToAccountPreferencesPage() {
    	clickProfileDropdown();
    	var count=0;
    	while(!WebElementUtil.isDisplayed(homePage_Locator.mainMenu_ProfileDropdown_MyAccountLink) && count<2) {
    		clickProfileDropdown();
    		count++;
    	}
    	if (!WebElementUtil.isDisplayed(homePage_Locator.mainMenu_ProfileDropdown_MyAccountLink)) {
            throw new RuntimeException("Profile dropdown did not open. 'My Account' not visible.");
        }
    	clickMyAccountLink();
    	return new AccountPreferencesPageActionsElux();
    }
	
	public PdpPageActionsElux selectFirstProductFromSearchResults() {
    	WebElementUtil.scrollIntoView(homePage_Locator.firstSearchResultProduct);
    	WebElementUtil.clickElement(homePage_Locator.firstSearchResultProduct);
    	return new PdpPageActionsElux();
    }
	



    public boolean isBrandLogoLoaded() {
        return WebElementUtil.isDisplayed(homePage_Locator.electroluxLogo);
    }
    
    public boolean isSearchIconDisplayed() {
        return WebElementUtil.isDisplayed(homePage_Locator.mainMenu_searchInput);
    }
    
    public boolean isSearchInputFieldDisplayed() {
        try {
            WebElement searchInputElement = WebElementUtil.waitForElementToBeVisible(homePage_Locator.mainMenu_searchInput);
            return searchInputElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickSearchInputAndEnterText(String searchText) {
        WebElementUtil.clickElement(homePage_Locator.mainMenu_searchInput);
        WebElement searchInputElement = WebElementUtil.waitForElementToBeVisible(homePage_Locator.mainMenu_searchInput);
        searchInputElement.clear();
        for (char c : searchText.toCharArray()) {
            searchInputElement.sendKeys(String.valueOf(c));
            WaitUtils.sleep(100);
        }
        if (searchText.length() >= 4) {
            WebElementUtil.waitForElementToBeVisible(homePage_Locator.mainMenu_searchSuggestions);
        }
    }
    
    public List<WebElement> getSearchSuggestionsList() {
        WaitUtils.untilPresent(homePage_Locator.mainMenu_searchSuggestions);
        return WebElementUtil.findElements(homePage_Locator.mainMenu_searchSuggestions);
    }
    
    public boolean areSearchSuggestionsDisplayed() {
        try {
            WebElement suggestionsElement = WebElementUtil.waitForElementToBeVisible(homePage_Locator.mainMenu_searchSuggestions);
            return suggestionsElement.isDisplayed() && !getSearchSuggestionsList().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void selectFirstSuggestion() {
        WebElementUtil.clickElement(homePage_Locator.mainMenu_searchSuggestions_FirstElement);
    }

    public boolean isUserOnSearchResultsPage() {
        try {
            WebElement resultsElement = WebElementUtil.waitForElementToBeVisible(homePage_Locator.mainMenu_searchSuggestions_Landing);
            return resultsElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isHeaderCategoryDisplayed(String categoryLabel) {
        By category = By.cssSelector("h5[aria-label='" + categoryLabel + "']");
        return WebElementUtil.isDisplayed(category);
    }
    
    public void openHeaderCategory(String categoryLabel) {
        By category = By.cssSelector("h5[aria-label='" + categoryLabel + "']");
        WebElementUtil.clickElement(category);
    }

    public boolean isHeaderSubcategoryDisplayed(String subLabel) {
        By sub = By.xpath("//h5[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')," +
                "'" + subLabel.toLowerCase() + "')]");
        return WebElementUtil.isDisplayed(sub);
    }
   
    public boolean isTermsOfOfferSelectionDisplayed() {
        return WebElementUtil.isDisplayed(homePage_Locator.mainMenu_termsOfOfferSection);
    }

}