package com.automation.electrolux.pages;

import com.automation.electrolux.locators.COPS_OrderItemsLocatorsElux;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class COPS_OrderItemsPageActionsElux {
    COPS_OrderItemsLocatorsElux orderItemLocators = new COPS_OrderItemsLocatorsElux();

    public void orderItemsDetails() {
        verifyElements(orderItemLocators.deliveryTypeBanner, "Delivery Type Banner");
        verifyElements(orderItemLocators.productsName, "Product Name");
        verifyElements(orderItemLocators.productDiscount, "Product Discount Price");
        verifyElements(orderItemLocators.productPrice, "Product MRP Price");
        verifyElements(orderItemLocators.productSku, "Product SKU");
        verifyElements(orderItemLocators.productQuantity, "Product Quantity");
        verifyElements(orderItemLocators.addOnServices, "Add-On Services");
        verifyElements(orderItemLocators.protectionPlan, "Protection Plan");
        verifyElements(orderItemLocators.editButton, "Edit Button");
    }
    public void verifyElements(By locator, String elementName) {
        WebElementUtil.scrollToElementStable(locator);
        Assert.assertTrue(WebElementUtil.isDisplayed(locator),
                elementName + " is NOT displayed in Order Items section.");
    }

}
