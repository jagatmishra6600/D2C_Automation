package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.OrderItemsLocatorsFrig;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OrderItemsPageActionsFrig {

    OrderItemsLocatorsFrig orderItems = new OrderItemsLocatorsFrig();

    public void orderItemsDetails() {
        verifyElement(orderItems.orderItemsHeader, "Order Items Header");
        verifyElement(orderItems.orderProductName, "Product Name");
        verifyElement(orderItems.productPriceDiscount, "Product Price Discount");
        verifyElement(orderItems.productPriceMRP, "Product Price MRP");
        verifyElement(orderItems.productSku, "Product SKU");
        verifyElement(orderItems.productQuantity, "Product Quantity");
        verifyElement(orderItems.orderAddOn, "Add-On");
        verifyElement(orderItems.orderProtectionPlan, "Protection Plan");
        verifyElement(orderItems.editButton, "Edit Button");
    }

    public void verifyElement(By locator, String elementName) {
        Assert.assertTrue(WebElementUtil.isDisplayed(locator),
                elementName + " is NOT displayed in Order Items section.");
    }
}
