package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;

public class ProductCategoryPageActions {

    private final By refrigeratorsCategoryLink = By.cssSelector("[data-testid='Refrigerators'] a");
    private final By pageHeader = By.tagName("h1");

    public boolean isPageLoaded() {
        return WebElementUtil.isDisplayed(pageHeader);
    }

    public void clickRefrigeratorsCategory() {
        WebElementUtil.clickElement(refrigeratorsCategoryLink);
    }
}