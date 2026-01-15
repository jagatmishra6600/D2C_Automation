package com.automation.electrolux.pages;

import com.automation.electrolux.locators.COPS_OrderSummaryLocatorsElux;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class KlarnaPageActionElux {

    COPS_OrderSummaryLocatorsElux orderSummaryLocators = new COPS_OrderSummaryLocatorsElux();

    public final By selectDate =
            By.xpath("(//label[@class='cx-delivery-label'])[1]");

    public final By continueToBillingButton =
            By.xpath("//button[normalize-space(text())='Continue to billing']");

    public final By klarnaPaymentOption =
            By.xpath("//img[@alt=\"Klarna\"]/parent::label//input[@name=\"paymentOption\"]\n");

    public final By continueWithKlarnaButton =
            By.xpath("//button[normalize-space(text())='Continue with Klarna']");

    public final By klarnaTitle =
            By.xpath("//h1[@id=\"title\"]");

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
        scrollAndClick(selectDate);
        scrollAndClick(continueToBillingButton);
        scrollAndClick(klarnaPaymentOption);
    }

    public void navigateToKlarnaWindow() {
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
