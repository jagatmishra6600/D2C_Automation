package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.COPS_OrderSummaryLocatorsFrig;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class COPS_OrderSummaryPageActionsFrig {

    COPS_OrderSummaryLocatorsFrig orderSummary = new COPS_OrderSummaryLocatorsFrig();

    public void clickProductKitchen() {

        WebElementUtil.zoomInOrOut(80);

        waitScrollAndClick(orderSummary.addToCartButtons);

        WebElementUtil.scrollToElementCenter(orderSummary.addOnServiceText);
        WebElementUtil.waitForElementToBeVisible(orderSummary.addOnServiceText, 10);

        waitScrollAndClick(orderSummary.selectAddOnServices);

        WebElementUtil.scrollToElementCenter(orderSummary.protectionPlanText);
        WebElementUtil.waitForElementToBeVisible(orderSummary.protectionPlanText, 10);

        waitScrollAndClick(orderSummary.selectProtectionPlan);
        waitScrollAndClick(orderSummary.saveAndViewCartButton);
        WaitUtils.sleep(3000);
    }
    private void waitScrollAndClick(By element) {
        WebElementUtil.scrollToElementStable(element);
        WebElementUtil.waitForElementToBeVisible(element, 10);
        WebElementUtil.waitForElementToBeClickable(element, 10);
        WebElementUtil.clickElement(element);
    }


    public boolean verifySubtotal(String text) {
        WebElementUtil.waitForElementToBeVisible(orderSummary.subtotalText(text), 10);
        return WebElementUtil.isDisplayed(orderSummary.subtotalText(text));
    }

}
