package com.automation.frigidaire.pages;

import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCategoryPageActions {

    private final By refrigeratorsCategoryLink = By.cssSelector("[data-testid='Refrigerators'] a");
    private final By pageHeader = By.tagName("h1");

    public boolean isPageLoaded() {
        return WebElementUtil.isDisplayed(pageHeader);
    }


public ProductCategoryPageActions clickOnProductMenu(String website, String text) {
    By locator;

    if (website.equalsIgnoreCase("frigidaire")) {
        locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
    } else if (website.equalsIgnoreCase("electrolux")) {
        locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
    } else {
        throw new IllegalArgumentException("Unknown website: " + website);
    }

    WaitUtils.untilClickable(locator, 60);
    Assert.assertTrue(WebElementUtil.isDisplayed(locator),
            "Product menu '" + text + "' should be displayed before clicking.");
    System.out.println("Product menu " + text + " displayed before clicking.");
    WebElementUtil.clickElement(locator);

    return this;
}
  
  
}