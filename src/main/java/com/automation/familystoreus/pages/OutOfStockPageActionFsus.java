package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.OutOfStockLocatorsFsus;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OutOfStockPageActionFsus {

    OutOfStockLocatorsFsus outOfStockLocatorsFsus = new OutOfStockLocatorsFsus();

    public void selectInStock(String str, String product) {
        WaitUtils.sleep(2000);
        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.resetAll,10);
        WebElementUtil.clickElement(outOfStockLocatorsFsus.resetAll);

        WaitUtils.sleep(2000);
        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.inStockFilter);
        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.inStockFilter, 20);

        WaitUtils.sleep(2000);
        if (product.equalsIgnoreCase("Laundry")) {
            WebElementUtil.waitForElementToBeClickable(outOfStockLocatorsFsus.collapseButton, 5);
            WebElementUtil.clickElement(outOfStockLocatorsFsus.collapseButton);
            WaitUtils.sleep(2000);
            WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.checkBoxFilter(str));
            WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.checkBoxFilter(str), 10);
            WebElementUtil.waitForElementToBeClickable(outOfStockLocatorsFsus.checkBoxFilter(str),10);
            WebElementUtil.clickElement(outOfStockLocatorsFsus.checkBoxFilter(str));
            WaitUtils.sleep(3000);
        }
        else {
            WaitUtils.sleep(2000);
            WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.checkBoxFilter(str));
            WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.checkBoxFilter(str), 10);
            WebElementUtil.waitForElementToBeClickable(outOfStockLocatorsFsus.checkBoxFilter(str), 10);
            WebElementUtil.clickElement(outOfStockLocatorsFsus.checkBoxFilter(str));
            WaitUtils.sleep(3000);
        }

    }

    public void checkInStock(){

        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.productName);
        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.productName, 10);
        WebElementUtil.clickElement(outOfStockLocatorsFsus.productName);

        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.addToCartBtn);
        Assert.assertTrue(WebElementUtil.isDisplayed(outOfStockLocatorsFsus.addToCartBtn),
                "Add to Cart button is not Displayed");
    }
    public void checkOutStock(){
        WaitUtils.sleep(2000);
        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.productName);
        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.productName, 10);

        WebElementUtil.clickElement(outOfStockLocatorsFsus.productName);

        WaitUtils.sleep(5000);
        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.msg1);
        WebElement message1 = WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.msg1);
        Assert.assertEquals(message1.getText().trim(),
                "Temporarily out of stock in your area.");

        WebElement message2 = WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.msg2);
        Assert.assertEquals(message2.getText().trim(),
                "We'll notify you once this item is back in stock.");

    }
    public void checkEmailAddress(){

        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.emailField);
        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.emailField,10);

        WebElement element = WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.emailField,10);
        element.clear();
        element.sendKeys("demo11@gmail.com");

        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.submitBtn,10);
        WebElementUtil.waitForElementToBeClickable(outOfStockLocatorsFsus.submitBtn,10);
        WebElementUtil.clickElement(outOfStockLocatorsFsus.submitBtn);
    }
}
