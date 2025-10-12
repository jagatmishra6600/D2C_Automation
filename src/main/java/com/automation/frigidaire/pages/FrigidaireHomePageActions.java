package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;

public class FrigidaireHomePageActions {

    // Locators remain the same
    private final By searchInput = By.cssSelector("input[type='search']");
    private final By searchButton = By.cssSelector("button[aria-label='Search']");
    private final By productsLink = By.linkText("Products");
    private final By frigidaireLogo = By.cssSelector("img[alt='Frigidaire']");

    public FrigidaireHomePageActions navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getProperty("app.url"));
        return this;
    }

    public boolean isHomePageLoaded() {
        // isDisplayed now handles the wait internally
        return WebElementUtil.isDisplayed(frigidaireLogo);
    }

    public FrigidaireHomePageActions enterSearchTerm(String searchTerm) {
        // sendKeys now handles the wait and clear internally
        WebElementUtil.sendKeys(searchInput, searchTerm);
        return this;
    }

    public SearchResultsPageActions clickSearchButton() {
        // clickElement now handles the wait internally
        WebElementUtil.clickElement(searchButton);
        return new SearchResultsPageActions();
    }

    public SearchResultsPageActions searchForProduct(String searchTerm) {
        return this.enterSearchTerm(searchTerm).clickSearchButton();
    }

    public ProductCategoryPageActions clickProductsLink() {
        WebElementUtil.clickElement(productsLink);
        return new ProductCategoryPageActions();
    }
}