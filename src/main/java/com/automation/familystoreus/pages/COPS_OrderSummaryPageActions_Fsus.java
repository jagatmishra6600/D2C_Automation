package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.COPS_orderSummaryLocatorsFsus;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class COPS_OrderSummaryPageActions_Fsus {

    COPS_orderSummaryLocatorsFsus orderSummaryFsus = new COPS_orderSummaryLocatorsFsus();
    public void searchProducts(String skuNumber) {

        WaitUtils.sleep(5000);
        WaitUtils.untilPageLoadComplete();
        WebElementUtil.scrollToElementStable(orderSummaryFsus.searchBox);
        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.searchBox, 10);
        WebElementUtil.sendKeys(orderSummaryFsus.searchBox, skuNumber);

        WebElementUtil.waitForElementToBeClickable(orderSummaryFsus.searchButton, 10);
        WebElementUtil.clickElement(orderSummaryFsus.searchButton);

        WaitUtils.sleep(3000);
    }

    private void scrollWaitAndClick(By element) {
        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementCenter(element);
        WebElementUtil.waitForElementToBeVisible(element, 10);
        WebElementUtil.waitForElementToBeClickable(element, 10);
        WebElementUtil.clickElement(element);
    }

    public void clickOnProductBundle() {
        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.addToCart,10);
        scrollWaitAndClick(orderSummaryFsus.addToCart);
    }
    public void selectAddOnProtectionPlan(){
        WaitUtils.sleep(5000);
        WaitUtils.untilPageLoadComplete();
        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.addOnServices,20);
        WebElementUtil.scrollToElementStable(orderSummaryFsus.addOnServices);

        WebElementUtil.scrollToElementStable(orderSummaryFsus.addOnServiceSelect);
        WebElementUtil.waitForElementToBeClickable(orderSummaryFsus.addOnServiceSelect,10);
        WebElementUtil.clickElement(orderSummaryFsus.addOnServiceSelect);

        WebElementUtil.scrollToElementStable(orderSummaryFsus.protectionPlansSelect);
        WebElementUtil.waitForElementToBeClickable(orderSummaryFsus.protectionPlansSelect,20);
        WebElementUtil.clickElement(orderSummaryFsus.protectionPlansSelect);
    }

    public void clickOnProductRacks() {
        scrollWaitAndClick(orderSummaryFsus.addToCart);
    }

    public void clickOnProceedCheckout() {
        scrollWaitAndClick(orderSummaryFsus.viewOrSaveCartButton);
        scrollWaitAndClick(orderSummaryFsus.proceedToCheckoutButton);
    }

    public void enterAddressDetails(String firstName, String lastName,String zipCode) {

        scrollWaitAndClick(orderSummaryFsus.newAddress);

        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.firstNameInput, 10);
        WebElementUtil.sendKeys(orderSummaryFsus.firstNameInput, firstName);

        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.lastNameInput, 10);
        WebElementUtil.sendKeys(orderSummaryFsus.lastNameInput, lastName);

        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.addressLine1Input, 10);
        WebElementUtil.sendKeys(orderSummaryFsus.addressLine1Input, zipCode);

        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.addressTypeaheadOption, 10);
        WebElementUtil.clickElement(orderSummaryFsus.addressTypeaheadOption);

        WaitUtils.sleep(3000);
        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.zipCodeInput, 10);
        WebElementUtil.sendKeys(orderSummaryFsus.zipCodeInput, zipCode);

        WebElementUtil.scrollToElementStable(orderSummaryFsus.continueToDeliveryButton);
        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.continueToDeliveryButton, 10);
        WebElementUtil.clickElement(orderSummaryFsus.continueToDeliveryButton);

        WebElementUtil.waitForElementToBeVisible(orderSummaryFsus.saveAndContinueButton, 10);
        WebElementUtil.clickElement(orderSummaryFsus.saveAndContinueButton);
    }

    public boolean verifySubtotal(String text) {
        return WebElementUtil.isDisplayed(orderSummaryFsus.subtotalText(text));
    }
}
