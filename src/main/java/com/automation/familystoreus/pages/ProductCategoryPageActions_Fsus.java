package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.PlpFiltersLocator_Fsus;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;


public class ProductCategoryPageActions_Fsus {

    public ProductCategoryPageActions_Fsus clickOnProductMenu(String text) {

        By locator=PlpFiltersLocator_Fsus.navBarFilter(text);
        WebElementUtil.isDisplayed(locator);
        WaitUtils.untilClickable(locator, 60);
        System.out.println("Product menu " + text + " displayed before clicking.");
        WebElementUtil.clickElement(locator);
        return this;
    }


}
