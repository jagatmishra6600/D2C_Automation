package com.automation.electrolux.pages;

import com.automation.electrolux.locators.COPS_OrderSummaryLocatorsElux;
import com.automation.electrolux.locators.KlarnaLocatorsElux;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;


public class KlarnaPageActionElux {

    COPS_OrderSummaryLocatorsElux orderSummaryLocators = new COPS_OrderSummaryLocatorsElux();
    KlarnaLocatorsElux klarnaLocatorsElux = new KlarnaLocatorsElux();

    private void scrollAndClick(By element) {
        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementStable(element);
        WebElementUtil.waitForElementToBeVisible(element, 10);
        WebElementUtil.waitForElementToBeClickable(element, 10);
        WebElementUtil.clickElement(element);
        WaitUtils.sleep(2000);
    }

    public void clickOnProduct(){
        scrollAndClick(orderSummaryLocators.productNames);
    }

    public void clickOnAddToCart(){
        scrollAndClick(orderSummaryLocators.addToCartButtons);
        scrollAndClick(orderSummaryLocators.viewCartLink);
    }

    public void checkoutPage() {
        scrollAndClick(klarnaLocatorsElux.selectDate);
        scrollAndClick(klarnaLocatorsElux.continueToBillingButton);
        scrollAndClick(klarnaLocatorsElux.klarnaPaymentOption);
    }

    public void navigateToKlarnaWindow() {
        WebElementUtil.findElement(klarnaLocatorsElux.continueWithKlarnaButton).click();
        WaitUtils.sleep(5000);
        WebElementUtil.switchToLatestTab();
    }

    public boolean isTitleVisible(){
        WaitUtils.untilPageLoadComplete();
        try {
            WebElementUtil.waitForElementToBeVisible(klarnaLocatorsElux.klarnaTitle,10);
            return WebElementUtil.isDisplayed(klarnaLocatorsElux.klarnaTitle);
        } catch (Exception e) {
            return false;
        }
    }
}
