package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;

public class SearchResultsPageActions {

    private final By searchResultsHeader = By.xpath("//h1[contains(text(), 'Search results for')]");
    private final By productGrid = By.cssSelector(".product-grid");
    private final By noResultsMessage = By.cssSelector(".no-results");

    public boolean isPageLoaded() {
        return WebElementUtil.isDisplayed(searchResultsHeader);
    }

    public boolean areResultsFound() {
        // We still use findElements here, but we could add a utility for that too if needed.
        // For now, this is acceptable as it's a more complex check.
        return DriverManager.getDriver().findElements(productGrid).size() > 0 &&
                !WebElementUtil.isDisplayed(noResultsMessage);
    }

    public String getSearchResultsHeaderText() {
        return WebElementUtil.getText(searchResultsHeader);
    }
}