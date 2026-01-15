package com.automation.familystoreus.pages;

import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class KlarnaPageActionFsus {

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

    public final By enterPhoneNumber = By.xpath("//input[@id=\"phone\"]\n");


    public void waitAndClick(By locator) {
        WaitUtils.untilPageLoadComplete(5);
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.waitForElementToBeVisible(locator, 20);
        WebElementUtil.waitForElementToBeClickable(locator, 20);
        WebElementUtil.clickElement(locator);
        WaitUtils.sleep(5000);
    }

    public void checkoutPage(String phoneNo){
        WaitUtils.untilPageLoadComplete(5);
        waitAndClick(selectDate);
        enterNumber(phoneNo);
        waitAndClick(continueToBillingButton);
        waitAndClick(klarnaPaymentOption);
    }

    public void enterNumber(String phoneNo){
        WebElementUtil.scrollToElementStable(enterPhoneNumber);
        WebElementUtil.waitForElementToBeVisible(enterPhoneNumber,10);
        WebElementUtil.waitForElementToBeClickable(enterPhoneNumber,10);
        WebElementUtil.sendKeys(enterPhoneNumber, phoneNo);
    }

    public void openKlarnaWindow() {
        WebElementUtil.findElement(continueWithKlarnaButton).click();
        WaitUtils.sleep(5000);
        WebElementUtil.switchToLatestTab();
    }

    public boolean isTitleVisible(){
        WaitUtils.untilPageLoadComplete(10);
        try {
            WebElementUtil.waitForElementToBeVisible(klarnaTitle,10);
            return WebElementUtil.isDisplayed(klarnaTitle);
        } catch (Exception e) {
            return false;
        }
    }

}
