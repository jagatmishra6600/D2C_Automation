package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.OutOfStockLocatorsFsus;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OutOfStockPageActionFsus {

    OutOfStockLocatorsFsus outOfStockLocatorsFsus = new OutOfStockLocatorsFsus();

    public void selectInStock(String str){

        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.inStockFilter);
        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.inStockFilter, 10);

        WebElementUtil.waitForElementToBeClickable(outOfStockLocatorsFsus.collapseButton,10);
        WebElementUtil.clickElement(outOfStockLocatorsFsus.collapseButton);

        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.checkBoxFilter(str), 10);
        WebElement element= WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.checkBoxFilter(str));

        if(element.isSelected()){
            element.click();
        }
        element.click();
    }

    public void checkInStock(){

        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.productName);
        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.productName, 10);

        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.addToCartBtn,10);
        WebElement element = WebElementUtil.waitForElementToBeClickable(outOfStockLocatorsFsus.addToCartBtn);

        Assert.assertTrue(element.isEnabled(), "Add to Cart button is not enabled");
    }
    public void checkOutStock(){
        WebElementUtil.scrollToElementStable(outOfStockLocatorsFsus.productName);
        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.productName, 10);

        WebElementUtil.clickElement(outOfStockLocatorsFsus.productName);

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
        element.sendKeys("rajatverma@12.com");

        WebElementUtil.waitForElementToBeVisible(outOfStockLocatorsFsus.submitBtn,10);
        WebElementUtil.waitForElementToBeClickable(outOfStockLocatorsFsus.submitBtn,10);
        WebElementUtil.clickElement(outOfStockLocatorsFsus.submitBtn);
    }
}
