package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCategoryPageActionsFrig {


    private final By pageHeader = By.tagName("h1");


    public ProductCategoryPageActionsFrig clickOnProductMenu(String website, String text) {
        By locator;

        if (website.equalsIgnoreCase("frigidaire")) {
            locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        } else {
            throw new IllegalArgumentException("Unknown website: " + website);
        }

        untilClickable(locator);
        Assert.assertTrue(isDisplayed(locator), "Product menu '" + text + "' should be displayed before clicking.");
        System.out.println("Product menu " + text + " displayed before clicking.");
        clickElement(locator);

        return this;
    }


}