package com.automation.electrolux.pages;

import com.automation.electrolux.locators.DandSLocatorsElux;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class DeliveryAndServicePageActionsElux {
    DandSLocatorsElux dns_Locator = new DandSLocatorsElux();

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
                : WebElementUtil.convertPriceToFloat(deliveryText);

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

        String deliveryText = WebElementUtil.getText(dns_Locator.partPrice).trim();
        float partPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(deliveryText);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.partCheckBox);

        WebElementUtil.clickElement(dns_Locator.partCheckBox);

        WebElementUtil.scrollToElementCenter(dns_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.clickElement(dns_Locator.partCheckBox);

        return afterClickTotal == startingTotal + partPrice;
    }

    public boolean clickProfessionalInstallationAndCheckTheUpdatedTotalPrice() {

        String deliveryText = WebElementUtil.getText(dns_Locator.professionalInstallationPrice).trim();
        float deliveryAndInstallationPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(deliveryText);

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

        String haulawayPrice = WebElementUtil.getText(dns_Locator.haulAwayPrice).trim();
        float finalHaulAwayPrice = haulawayPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(haulawayPrice);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.haulAwayCheckBox);

        WebElementUtil.clickElement(dns_Locator.haulAwayCheckBox);

        WebElementUtil.scrollToElementCenter(dns_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.haulAwayCheckBox);

        WebElementUtil.clickElement(dns_Locator.haulAwayCheckBox);

        return afterClickTotal == startingTotal + finalHaulAwayPrice;
    }

    public boolean clickMoveOldUnitCheckBoxAndCheckTheUpdatedTotalPrice() {

        String moveOldUnitPrice = WebElementUtil.getText(dns_Locator.moveOldUnitPrice).trim();
        float finalmoveOldUnitPricePrice = moveOldUnitPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(moveOldUnitPrice);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.moveOldUnitCheckBox);

        WebElementUtil.clickElement(dns_Locator.moveOldUnitCheckBox);

        WebElementUtil.scrollToElementCenter(dns_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.moveOldUnitCheckBox);

        WebElementUtil.clickElement(dns_Locator.moveOldUnitCheckBox);

        return afterClickTotal == startingTotal + finalmoveOldUnitPricePrice;
    }

    public boolean clickDoorSwingCheckBoxAndCheckTheUpdatedTotalPrice() {

        String moveOldUnitPrice = WebElementUtil.getText(dns_Locator.doorSwingPrice).trim();
        float finalmoveOldUnitPricePrice = moveOldUnitPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(moveOldUnitPrice);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.doorSwingCheckBox);

        WebElementUtil.clickElement(dns_Locator.doorSwingCheckBox);

        WebElementUtil.scrollToElementCenter(dns_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.doorSwingCheckBox);

        WebElementUtil.clickElement(dns_Locator.doorSwingCheckBox);

        return afterClickTotal == startingTotal + finalmoveOldUnitPricePrice;
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

        WebElementUtil.scrollToElementCenter(dns_Locator.oneYearPlanPrice);
        String oneYearPrice = WebElementUtil.getText(dns_Locator.oneYearPlanPrice).trim();
        float finaloneYearPrice = oneYearPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(oneYearPrice);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.oneYearCheckBox);

        WebElementUtil.clickElement(dns_Locator.oneYearCheckBox);

        WebElementUtil.scrollToElementCenter(dns_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.declineProtection);
        WebElementUtil.forceClick(dns_Locator.declineProtection);

        return afterClickTotal == startingTotal + finaloneYearPrice;
    }

    public boolean clickThreeYearProtectionAndCheckTheUpdatedTotalPrice() {

        WebElementUtil.scrollToElementCenter(dns_Locator.threeYearsPlanPrice);
        String threeYearPrice = WebElementUtil.getText(dns_Locator.threeYearsPlanPrice).trim();
        float finalthreeYearPrice = threeYearPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(threeYearPrice);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.threeYearsCheckBox);

        WebElementUtil.clickElement(dns_Locator.threeYearsCheckBox);

        WebElementUtil.scrollToElementCenter(dns_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.declineProtection);
        WebElementUtil.forceClick(dns_Locator.declineProtection);

        return afterClickTotal == startingTotal + finalthreeYearPrice;
    }

    public boolean clickFiveYearProtectionAndCheckTheUpdatedTotalPrice() {
        WebElementUtil.forceClick(dns_Locator.declineProtection);

        WebElementUtil.scrollToElementCenter(dns_Locator.fiveYearsPlanPrice);
        String fiveYearPrice = WebElementUtil.getText(dns_Locator.fiveYearsPlanPrice).trim();
        float finalFiveYearPrice = fiveYearPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(fiveYearPrice);

        float startingTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dns_Locator.fiveYearsCheckBox);

        WebElementUtil.forceClick(dns_Locator.fiveYearsCheckBox);

        WebElementUtil.scrollToElementCenter(dns_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dns_Locator.totalPrice);

        return afterClickTotal == startingTotal + finalFiveYearPrice;
    }

    public CartPageActionsElux clickSaveAndViewCartButton() {
        WebElementUtil.scrollToElementCenter(dns_Locator.saveAndViewCartButton);
        WebElementUtil.clickElement(dns_Locator.saveAndViewCartButton);
        return new CartPageActionsElux();
    }



}
