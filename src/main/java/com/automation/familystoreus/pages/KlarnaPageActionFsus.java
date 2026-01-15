package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.KlarnaLocatorsFsus;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class KlarnaPageActionFsus {

    KlarnaLocatorsFsus klarnaLocatorsFsus = new KlarnaLocatorsFsus();

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
        waitAndClick(klarnaLocatorsFsus.selectDate);
        enterNumber(phoneNo);
        waitAndClick(klarnaLocatorsFsus.continueToBilling);
        waitAndClick(klarnaLocatorsFsus.klarnaPaymentOption);
    }

    public void enterNumber(String phoneNo){
        WebElementUtil.scrollToElementStable(klarnaLocatorsFsus.enterPhoneNumber);
        WebElementUtil.waitForElementToBeVisible(klarnaLocatorsFsus.enterPhoneNumber,10);
        WebElementUtil.waitForElementToBeClickable(klarnaLocatorsFsus.enterPhoneNumber,10);
        WebElementUtil.sendKeys(klarnaLocatorsFsus.enterPhoneNumber, phoneNo);
    }

    public void openKlarnaWindow() {
        WebElementUtil.findElement(klarnaLocatorsFsus.continueWithKlarnaButton).click();
        WaitUtils.sleep(5000);
        WebElementUtil.switchToLatestTab();
    }

    public boolean isTitleVisible(){
        WaitUtils.untilPageLoadComplete(10);
        try {
            WebElementUtil.waitForElementToBeVisible(klarnaLocatorsFsus.klarnaTitle,10);
            return WebElementUtil.isDisplayed(klarnaLocatorsFsus.klarnaTitle);
        } catch (Exception e) {
            return false;
        }
    }

}
