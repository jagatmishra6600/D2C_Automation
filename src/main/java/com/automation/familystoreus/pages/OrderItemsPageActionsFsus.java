package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.OrderItemLocatorsFsus;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OrderItemsPageActionsFsus {

        OrderItemLocatorsFsus orderItemFsus = new OrderItemLocatorsFsus();

    public void verifyDeliveryAndProductDetails() {
        WebElementUtil.scrollToElementStable(orderItemFsus.deliveryTypeBanner);
        verifyElement(orderItemFsus.deliveryTypeBanner, "Delivery Type Banner");
        verifyElement(orderItemFsus.productNames, "Product Names");
        verifyElement(orderItemFsus.productDiscountPrice, "Product Discount Price");
        verifyElement(orderItemFsus.productMrpPrice, "Product MRP Price");
        verifyElement(orderItemFsus.productSku, "Product SKU");
        verifyElement(orderItemFsus.productQuantity, "Product Quantity");
        verifyElement(orderItemFsus.productAddon, "Product Add-On");
        verifyElement(orderItemFsus.protectionPlan, "Protection Plan");
        verifyElement(orderItemFsus.editButton, "Edit Button");
    }

    public void verifyElement(By locator, String elementName) {
        WebElementUtil.waitForElementToBeVisible(locator, 10);
        Assert.assertTrue(
                WebElementUtil.isDisplayed(locator),
                elementName + " is NOT displayed in Order Items section.");
    }
}
