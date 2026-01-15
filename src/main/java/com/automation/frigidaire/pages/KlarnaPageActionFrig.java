package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.COPS_OrderSummaryLocatorsFrig;
import com.automation.frigidaire.locators.KlarnaLocatorsFrig;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class KlarnaPageActionFrig {

    COPS_OrderSummaryLocatorsFrig orderSummary = new COPS_OrderSummaryLocatorsFrig();
    KlarnaLocatorsFrig klarnaLocatorsFrig = new KlarnaLocatorsFrig();


    public void clickProduct() {
        WebElementUtil.zoomInOrOut(80);
        waitAndClick(orderSummary.addToCartButtons);
        WaitUtils.sleep(3000);
        waitAndClick(orderSummary.saveAndViewCartButton);
    }

    public void waitAndClick(By locator) {
        WaitUtils.untilPageLoadComplete(5);
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.waitForElementToBeVisible(locator, 10);
        WebElementUtil.waitForElementToBeClickable(locator, 10);
        WebElementUtil.clickElement(locator);
        WaitUtils.sleep(5000);
    }

    public void checkoutPage(){
        WaitUtils.untilPageLoadComplete(5);
        waitAndClick(klarnaLocatorsFrig.selectDate);
        waitAndClick(klarnaLocatorsFrig.continueToBillingButton);
        waitAndClick(klarnaLocatorsFrig.klarnaPaymentOption);
    }

    public void openKlarnaWindow() {
        WebElementUtil.findElement(klarnaLocatorsFrig.continueWithKlarnaButton).click();
        WaitUtils.sleep(5000);
        WebElementUtil.switchToLatestTab();
    }

    public boolean isTitleVisible(){
        WaitUtils.untilPageLoadComplete();
            try {
                WebElementUtil.waitForElementToBeVisible(klarnaLocatorsFrig.klarnaTitle,10);
                return WebElementUtil.isDisplayed(klarnaLocatorsFrig.klarnaTitle);
            } catch (Exception e) {
                return false;
            }
    }
}
