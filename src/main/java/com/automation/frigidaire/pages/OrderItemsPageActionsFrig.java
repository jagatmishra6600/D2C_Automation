package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.OrderItemsLocatorsFrig;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class OrderItemsPageActionsFrig {

    OrderItemsLocatorsFrig orderItems = new OrderItemsLocatorsFrig();

    public void orderItemsDetails(){
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
        try {
            WebElementUtil.waitForElementToBeVisible(locator, 10);
            WebElementUtil.isDisplayed(locator);
            System.out.println(elementName + " is displayed.");
        } catch (Exception e) {
            System.out.println(elementName + " is NOT present.");
        }
    }

}
