package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCategoryPageActions {

    private final By refrigeratorsCategoryLink = By.cssSelector("[data-testid='Refrigerators'] a");
    private final By pageHeader = By.tagName("h1");

    public boolean isPageLoaded() {
        return WebElementUtil.isDisplayed(pageHeader);
    }

    public void clickRefrigeratorsCategory() {
        WebElementUtil.clickElement(refrigeratorsCategoryLink);
    }






    public ProductCategoryPageActions  clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WaitUtils.untilClickable(locator,60);
        Assert.assertTrue(WebElementUtil.isDisplayed(locator), "Product menu '" + text + "' should be displayed before clicking.");
        System.out.println("Product menu " + text +" displayed before clicking.");
//        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
        return this;
    }
}