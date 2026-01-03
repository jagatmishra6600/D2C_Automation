package com.automation.electrolux.pages;

import com.automation.electrolux.locators.CartLocatorsElux;
import com.automation.electrolux.locators.DandSLocatorsElux;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DeliveryAndServicePageActionsElux {
    DandSLocatorsElux dns_Locator = new DandSLocatorsElux();
    CartLocatorsElux cartPage_Locator = new CartLocatorsElux();

    public boolean isDeliveryAndServicePageHeadingVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(dns_Locator.pageHeading);
        String actualText =  WebElementUtil.getText(dns_Locator.pageHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isProductTitleMatchingWithHomePage() {
        WaitUtils.untilVisible(dns_Locator.productTitle);
        String actualTitle = WebElementUtil.getText(dns_Locator.productTitle).trim();
        String expectedTitle = HomePageActionsElux.getProvidedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithHomePage() {
        WaitUtils.untilVisible(dns_Locator.productPrice);
        String actualPrice = WebElementUtil.getText(dns_Locator.productPrice).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = HomePageActionsElux.getProvidedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isDeliveryAndServiceTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(dns_Locator.deliverAndServicesHeading);
        WebElementUtil.isDisplayed(dns_Locator.deliverAndServicesHeading);
        String actualText =  WebElementUtil.getText(dns_Locator.deliverAndServicesHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }


    public boolean clickDeliveryOnlyAndCheckTheUpdatedTotalPrice() {

        String deliveryText = WebElementUtil.getText(dns_Locator.deliveryOnlyPrice).trim();
        float deliveryPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.converStringToFloat(deliveryText);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.deliveryOnlyCheckBox);

        WebElementUtil.clickElement(dns_Locator.deliveryOnlyCheckBox);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        return afterClickTotal == startingTotal + deliveryPrice;
    }

    public boolean isRequireInstallationPartsTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(dns_Locator.deliveryOnlyCheckBox);
        WebElementUtil.clickElement(dns_Locator.deliveryOnlyCheckBox);
        WebElementUtil.scrollToElementCenter(dns_Locator.requireInstallationPartsText);
        WebElementUtil.isDisplayed(dns_Locator.requireInstallationPartsText);
        String actualText =  WebElementUtil.getText(dns_Locator.requireInstallationPartsText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean clickPartAndCheckTheUpdatedTotalPrice() {
        WebElementUtil.scrollToElementCenter(dns_Locator.deliveryOnlyCheckBox);
        WebElementUtil.clickElement(dns_Locator.deliveryOnlyCheckBox);

        actionMethod(dns_Locator.partPrice,dns_Locator.totalPrice, dns_Locator.partCheckBox, dns_Locator.partPriceOrderSummary, dns_Locator.partCheckBox);
        return true;
    }

    public boolean clickProfessionalInstallationAndCheckTheUpdatedTotalPrice() {

        String deliveryText = WebElementUtil.getText(dns_Locator.professionalInstallationPrice).trim();
        float deliveryAndInstallationPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.converStringToFloat(deliveryText);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.professionalInstallationCheckBox);

        WebElementUtil.clickElement(dns_Locator.professionalInstallationCheckBox);

        WebElementUtil.scrollToElementCenter(dns_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        return afterClickTotal == startingTotal + deliveryAndInstallationPrice;
    }

    public DeliveryAndServicePageActionsElux clickAdditionalDetailsLink() {
        WebElementUtil.scrollToElementCenter(dns_Locator.additionalDetailsLink);
        WebElementUtil.clickElement(dns_Locator.additionalDetailsLink);
        return this;
    }

    public boolean isAdditionalDetailsTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(dns_Locator.deliveryAndAppliancesInstallText);
        String actualText =  WebElementUtil.getText(dns_Locator.deliveryAndAppliancesInstallText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public DeliveryAndServicePageActionsElux clickCloseButtonAdditionalDetails() {
        WebElementUtil.clickElement(dns_Locator.closePopUpButton);
        return this;
    }

    public boolean isAddonServicesTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(dns_Locator.addOnServiceText);
        WebElementUtil.isDisplayed(dns_Locator.addOnServiceText);
        String actualText =  WebElementUtil.getText(dns_Locator.addOnServiceText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean clickHaulAwayCheckBoxAndCheckTheUpdatedTotalPrice() {

        actionMethod(dns_Locator.haulAwayPrice, dns_Locator.totalPrice, dns_Locator.haulAwayCheckBox, dns_Locator.addOnServicesPriceOrderSummary, dns_Locator.haulAwayCheckBox);
        return true;
    }

    public boolean clickMoveOldUnitCheckBoxAndCheckTheUpdatedTotalPrice() {

        actionMethod(dns_Locator.moveOldUnitPrice, dns_Locator.totalPrice, dns_Locator.moveOldUnitCheckBox, dns_Locator.addOnServicesPriceOrderSummary, dns_Locator.moveOldUnitCheckBox);
        return true;
    }

    public boolean clickDoorSwingCheckBoxAndCheckTheUpdatedTotalPrice() {

        actionMethod(dns_Locator.doorSwingPrice, dns_Locator.totalPrice, dns_Locator.doorSwingCheckBox, dns_Locator.addOnServicesPriceOrderSummary, dns_Locator.doorSwingCheckBox);
        return true;
    }


    public boolean isProtectionPlanTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(dns_Locator.availableProtectionPlanText);
        WebElementUtil.isDisplayed(dns_Locator.availableProtectionPlanText);
        String actualText =  WebElementUtil.getText(dns_Locator.availableProtectionPlanText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean validateDeclineOptionIsSelected(String expectedClassName){
        WebElementUtil.scrollToElementCenter(dns_Locator.declineProtection);
        String actualClassName = WebElementUtil.getAttributeValue(dns_Locator.declineProtection, "class");
        return actualClassName.toLowerCase().contains(expectedClassName.toLowerCase());
    }

    public boolean clickOneYearProtectionAndCheckTheUpdatedTotalPrice() {

        actionMethod(dns_Locator.oneYearPlanPrice,dns_Locator.totalPrice, dns_Locator.oneYearCheckBox, dns_Locator.protectionPlanPriceOrderSummary, dns_Locator.declineProtection);
        return true;
    }

    public boolean clickThreeYearProtectionAndCheckTheUpdatedTotalPrice() {

        actionMethod(dns_Locator.threeYearsPlanPrice,dns_Locator.totalPrice, dns_Locator.threeYearsCheckBox, dns_Locator.protectionPlanPriceOrderSummary, dns_Locator.declineProtection);
        return true;
    }

    public boolean clickFiveYearProtectionAndCheckTheUpdatedTotalPrice() {
        actionMethod(dns_Locator.fiveYearsPlanPrice,dns_Locator.totalPrice, dns_Locator.fiveYearsCheckBox, dns_Locator.protectionPlanPriceOrderSummary, dns_Locator.declineProtection);
        return true;
    }

    public CartPageActionsElux clickSaveAndViewCartButton() {
        for (int attempt = 1; attempt <= 2; attempt++) {
            WebElementUtil.clickElement(dns_Locator.saveAndViewCartButton);

            if (isCartPageLoaded()) {
                return new CartPageActionsElux();
            }
        }
        return new CartPageActionsElux();
    }

    public boolean actionMethod(By elementPriceLocator, By totalPriceLocator, By elementCheckBoxLocator, By orderSummaryLocator, By defaultCheckBox) {

        WebElementUtil.scrollToElementCenter(elementPriceLocator);
        String price = WebElementUtil.getText(elementPriceLocator).trim();
        float finalPrice = price.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.converStringToFloat(price);

        float startingTotal = WebElementUtil.getPrice(totalPriceLocator);

        WebElementUtil.scrollToElementCenter(elementCheckBoxLocator);

        WebElementUtil.clickElement(elementCheckBoxLocator);

        WebElementUtil.scrollToElementCenter(totalPriceLocator);

        float afterClickTotal = WebElementUtil.getPrice(totalPriceLocator);

        String priceOrderSummary = WebElementUtil.getText(orderSummaryLocator).trim();

        float finalOrderSummaryPrice = priceOrderSummary.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.converStringToFloat(priceOrderSummary);

        Assert.assertEquals(finalPrice, finalOrderSummaryPrice, "Both the price doesn't matched");

        WebElementUtil.scrollToElementCenter(defaultCheckBox);
        WebElementUtil.forceClick(defaultCheckBox);

        return afterClickTotal == startingTotal + finalPrice;
    }
    
    private boolean isCartPageLoaded() {
    	return WebElementUtil.isDisplayed(cartPage_Locator.proceedToCheckOutButton);
    }

}
