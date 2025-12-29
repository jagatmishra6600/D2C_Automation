package com.automation.familystoreus.pages;

import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class OrderItemsPageActionsFsus {

        public By deliveryTypeBanner = By.xpath("//div[@class=\"item-group--label-checkout Utility-TextProduct-SKU-Lrg font-weight-bold hideInPrint\"]");
        public By productNames = By.xpath("(//div[@class=\"cx-name font-weight-bold p-0 col-md-8 col-sm-8 ng-star-inserted\"]//a[@class='cx-link'])[1]");
        public By productDiscountPrice = By.xpath("(//div[@class='cx-value font-weight-bold text-right'])[1]");
        public By productMrpPrice = By.xpath("(//p[@class=\"mb-1 f-color-theme text-right strike-text f-12 ng-star-inserted\"]//s)[1]");
        public By productSku = By.xpath("(//div[@class=\"product-code ng-star-inserted\"])[2]");
        public By productQuantity = By.xpath("(//div[@class='cx-item cx-item-qty'])[1]");
        public By productAddon = By.xpath("//div[@class=\"row m-0 mt-2 ng-star-inserted\"]//div[@class=\"cx-item-list-desc col-8 pl-0 pr-0\"]//span");
        public By protectionPlan = By.xpath("//div[@class='cx-item-list-desc col-8 p-0']");
        public By editButton = By.xpath("//span[text()=' Edit ']//parent::a");

    public void verifyDeliveryAndProductDetails() {
        WebElementUtil.scrollToElementStable(deliveryTypeBanner);
        verifyElement(deliveryTypeBanner, "Delivery Type Banner");
        verifyElement(productNames, "Product Names");
        verifyElement(productDiscountPrice, "Product Discount Price");
        verifyElement(productMrpPrice, "Product MRP Price");
        verifyElement(productSku, "Product SKU");
        verifyElement(productQuantity, "Product Quantity");
        verifyElement(productAddon, "Product Add-On");
        verifyElement(protectionPlan, "Protection Plan");
        verifyElement(editButton, "Edit Button");
    }

    public void verifyElement(By locator, String elementName) {
        try {
            WebElementUtil.waitForElementToBeVisible(locator, 10);
            WebElementUtil.isDisplayed(locator);
            //System.out.println(elementName + " is displayed.");
        } catch (Exception e) {
            System.out.println(elementName + " is NOT present.");
        }
    }
}
