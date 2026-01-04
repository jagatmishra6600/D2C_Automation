package com.automation.electrolux.pages;

import com.automation.electrolux.locators.COPS_OrderSummaryLocatorsElux;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class COPS_OrderSummaryPageActionsElux {
    public By subtotalTextVerify(String text) {
        return By.xpath("//div[contains(normalize-space(), '" + text + "')]");
    }

    COPS_OrderSummaryLocatorsElux orderSummaryLocators = new COPS_OrderSummaryLocatorsElux();


    public void searchSku(String skuNumber){
        WaitUtils.untilPageLoadComplete();
        WebElementUtil.scrollToElementStable(orderSummaryLocators.searchBoxs);
        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.searchBoxs,10);
        WebElementUtil.sendKeys(orderSummaryLocators.searchBoxs, skuNumber);

        WebElementUtil.waitForElementToBeClickable(orderSummaryLocators.searchButton,10);
        WebElementUtil.clickElement(orderSummaryLocators.searchButton);
    }

    private void waitScrollAndClick(By element) {
        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementStable(element);
        WebElementUtil.waitForElementToBeVisible(element, 10);
        WebElementUtil.waitForElementToBeClickable(element, 10);
        WebElementUtil.clickElement(element);
        WaitUtils.sleep(2000);
    }

    public void clickOnProductSelectPlan(){
        waitScrollAndClick(orderSummaryLocators.productNames);
        waitScrollAndClick(orderSummaryLocators.addToCartButtons);
        waitScrollAndClick(orderSummaryLocators.haulAwayServiceCheckbox);
        waitScrollAndClick(orderSummaryLocators.declineProtectionPlan);
    }
    public void selectProduct(){
        WaitUtils.untilPageLoadComplete();
        waitScrollAndClick(orderSummaryLocators.productNames);
        waitScrollAndClick(orderSummaryLocators.addToCartButtons);
        waitScrollAndClick(orderSummaryLocators.viewCartLink);
    }
    public void clickOnProceed(){
        waitScrollAndClick(orderSummaryLocators.proceedtoCheckoutButton);
    }

    public void shippingAddress(String email, String firstName, String lastname, String address, String phoneNumber){

        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.emailInput,10);
        WebElementUtil.sendKeys(orderSummaryLocators.emailInput,email);

        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.firstNameInput,10);
        WebElementUtil.sendKeys(orderSummaryLocators.firstNameInput,firstName);

        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.lastNameInput,10);
        WebElementUtil.sendKeys(orderSummaryLocators.lastNameInput,lastname);

        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.addressInput,10);
        WebElementUtil.sendKeys(orderSummaryLocators.addressInput,address);

        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.addressSuggest,20);
        WebElementUtil.clickElement(orderSummaryLocators.addressSuggest);

        WebElementUtil.scrollToElementStable(orderSummaryLocators.manuallyEnterAddress);
        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.manuallyEnterAddress,20);
        WebElementUtil.clickElement(orderSummaryLocators.manuallyEnterAddress);

        WaitUtils.sleep(2000);
        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.zipCode,10);
        WebElementUtil.sendKeys(orderSummaryLocators.zipCode, address);

        WebElementUtil.waitForElementToBeVisible(orderSummaryLocators.phoneInput,10);
        WebElementUtil.sendKeys(orderSummaryLocators.phoneInput,phoneNumber);

        waitScrollAndClick(orderSummaryLocators.continuetoDeliveryButton);
        waitScrollAndClick(orderSummaryLocators.continueAndSave);
    }

    public boolean verifySubtotal(String text) {
        return WebElementUtil.isDisplayed(subtotalTextVerify(text));
    }
}
