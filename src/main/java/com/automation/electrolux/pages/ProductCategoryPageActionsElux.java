package com.automation.electrolux.pages;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCategoryPageActionsElux {


    public ProductCategoryPageActionsElux clickOnProductMenu(String website, String text) {
        By locator;

       if (website.equalsIgnoreCase("electrolux")) {
            locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        }else {
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
