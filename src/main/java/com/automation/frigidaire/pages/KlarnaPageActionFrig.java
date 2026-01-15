package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.COPS_OrderSummaryLocatorsFrig;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class KlarnaPageActionFrig {

    COPS_OrderSummaryLocatorsFrig orderSummary = new COPS_OrderSummaryLocatorsFrig();

    public final By selectDate =
            By.xpath("(//label[@class=\"cx-delivery-label avaliableDates\"])[1]");

    public final By continueToBillingButton =
            By.xpath("//button[normalize-space(text())='Continue to billing']");

    public final By klarnaPaymentOption =
            By.xpath("//img[@alt=\"Klarna\"]/parent::label//input[@name=\"paymentOption\"]\n");

    public final By continueWithKlarnaButton =
            By.xpath("//button[normalize-space(text())='Continue with Klarna']");

    public final By klarnaTitle =
            By.xpath("//h1[@id=\"title\"]");


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
        waitAndClick(selectDate);
        waitAndClick(continueToBillingButton);
        waitAndClick(klarnaPaymentOption);
    }

    public void openKlarnaWindow() {
        WebElementUtil.findElement(continueWithKlarnaButton).click();
        WaitUtils.sleep(5000);
        WebElementUtil.switchToLatestTab();
    }

    public boolean isTitleVisible(){
        WaitUtils.untilPageLoadComplete();
            try {
                WebElementUtil.waitForElementToBeVisible(klarnaTitle,10);
                return WebElementUtil.isDisplayed(klarnaTitle);
            } catch (Exception e) {
                return false;
            }
    }
}
