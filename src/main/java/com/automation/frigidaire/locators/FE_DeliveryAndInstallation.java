package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

import static java.awt.SystemColor.text;


public class FE_DeliveryAndInstallation {



    public static By getRadioButton(String deliveryOption) {
        return By.xpath("//div[normalize-space(text())='" + deliveryOption + "']/parent::div/parent::div//div[@id=\"deliveryServiceDiv\"]//input");
    }



    public static By radioButton = By.xpath("//div[text()=\" Delivery only (No Install) \"]/parent::div/parent::div//div[@id=\"deliveryServiceDiv\"]//input");
    public static By plpProductOpen = By.xpath("//div[@class=\"container-fluid px-2 plp\"]//div[@id=\"PlpItem0\"]//div[@class=\"col- Product-Image-Placeholder\"]//app-elux-image\n");
    public static By addToCart = By.xpath("//app-elux-action-button[@class=\"luxuryProductDetails productDetails ng-star-inserted\"]");
    public static By deliveryAndInStoreBox = By.xpath("//div[text()='" + text + "']");
    public static By deliveryAndInstallationHeading = By.xpath("//h3[text()='" + text + "']");
    public static By viewIncludedPartsLink = By.xpath("//a[text()='View included parts and additional details']");
    public static By DeliveryAndAppliancePopUp = By.xpath("//span[text()=\"Delivery & appliance install\"]");
    public static By DeliveryAndAppliancePopUpSubText = By.xpath("//div[text()=\" 6' Long Stainless Steel Braided Refrigerator Water Supply Line (912001026) \"]\n");
    public static By DAndAppIncludedProductTxt= By.xpath("//p[text()=\"We’ll install your product and ensure that it is ready for immediate use.  Delivery and required parts for installation are included in the price.\"]\n");
    public static By selectProtectionHeading = By.xpath("//h3[text()=\" Select a protection plan\"]");
    public static By protectionPlanSubText = By.xpath("//p[text()=\"Get peace of mind with our Total Appliance Protection plan that begins as soon as your manufacturer warranty ends.\"]\n");
    public static By protectionPlanViewDetailsLink = By.xpath("//u[text()=\"View Details\"]");
    public static By protectionPlanPopUpHeading = By.xpath("//button/following-sibling::p");
    public static By declineprotectionBy = By.xpath("//div[@class=\"Decline Body-SmallBody_Small_Centered\"]\n");
    public static By differentProtectionPlan = By.xpath("//div[@class=\"vertical-separator-sep\"]//span[text()=\"1 year\"]");
    public static By protectProtectionPlan = By.xpath("//p[text()=\"Protect your investment with our appliance protection plan.\"]");
    public static By totalProtectionPlan = By.xpath("//p[@class=\"tap-heading\"]");
    public static By totalProtectionPlanSubTxt = By.xpath("//p[text()=\"Protect your investment with our appliance protection plan\"]");
    public static By protectionPlanPopUp = By.xpath("//div[@id=\"tap-modal\"]");

    public static By optionByText(String text) {
        return By.xpath("//p[normalize-space()='" + text + "']");
    }

    public static By includeWithService(String text){
        return By.xpath("//span[text()='" + text +"']");
    }




}
