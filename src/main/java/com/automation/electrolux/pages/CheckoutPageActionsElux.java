package com.automation.electrolux.pages;

import com.automation.electrolux.locators.CheckoutLocatorsElux;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CheckoutPageActionsElux {
    private final CheckoutLocatorsElux locators = new CheckoutLocatorsElux();

    public void selectDeliveryAndSaveAndViewCart() {
        // Select delivery & installation radio
        WebElementUtil.waitForElementToBeVisible(locators.deliveryInstallationRadio, 10);
        WebElementUtil.scrollToElementStable(locators.deliveryInstallationRadio);
        WebElementUtil.waitForElementToBeClickable(locators.deliveryInstallationRadio);
        WebElementUtil.clickElement(locators.deliveryInstallationRadio);

        selectAddOns();
        selectProtectionPlan();

        // Click Save and view cart
        WebElementUtil.scrollToElementStable(locators.saveAndViewCartButton);
        WebElementUtil.waitForElementToBeClickable(locators.saveAndViewCartButton, 20);
        WebElementUtil.clickElement(locators.saveAndViewCartButton);
    }

    public void selectAddOns() {
        List<WebElement> elements = WebElementUtil.findElements(locators.addOnServices);
        for(WebElement element: elements) {
            WebElementUtil.waitForElementToBeVisible(element);
            WebElementUtil.scrollToElementStable(element);
            element.click();
        }
    }

    public void selectProtectionPlan() {
        WebElementUtil.waitForElementToBeVisible(locators.selectProtectionPlan, 10);
        WebElementUtil.scrollToElementStable(locators.selectProtectionPlan);
        WebElementUtil.clickElement(locators.selectProtectionPlan);
    }

    public boolean isDeliveryTypeBannerVisible() {
        WaitUtils.untilVisible(locators.deliveryTypeBanner, 10);
        try {
            return WebElementUtil.isDisplayed(locators.deliveryTypeBanner);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean orderItemNameIsVisible() {
        WaitUtils.untilVisible(locators.orderTitle, 10);
        try {
            return WebElementUtil.isDisplayed(locators.orderTitle);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSKUVisible() {
        WaitUtils.untilVisible(locators.orderSKU, 10);
        try {
            return WebElementUtil.isDisplayed(locators.orderSKU);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isQtyVisible() {
        WaitUtils.untilVisible(locators.orderQty, 10);
        try {
            return WebElementUtil.isDisplayed(locators.orderQty);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOrderPriceVisible() {
        WaitUtils.untilVisible(locators.orderPrice, 10);
        try {
            return WebElementUtil.isDisplayed(locators.orderPrice);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDiscountPricePriceVisible() {
        WaitUtils.untilVisible(locators.discountPrice, 10);
        try {
            return WebElementUtil.isDisplayed(locators.discountPrice);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProtectionPlanVisible() {
        WebElementUtil.scrollToElementStable(locators.protectionPlan);
        WaitUtils.untilVisible(locators.protectionPlan, 10);
        try {
            return WebElementUtil.isDisplayed(locators.protectionPlan);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAddOnServiceVisible() {
        WebElementUtil.scrollToElementStable(locators.addOnService);
        WaitUtils.untilVisible(locators.addOnService, 10);
        try {
            return WebElementUtil.isDisplayed(locators.addOnService);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isIncludedSectionVisible() {
        WaitUtils.untilVisible(locators.includedSection, 10);
        try {
            return WebElementUtil.isDisplayed(locators.includedSection);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isIncludedItemTitleVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.includedItemTitles);

        List<WebElement> elements = WebElementUtil.findElements(locators.includedItemTitles);

        for (WebElement element : elements) {
            WebElementUtil.scrollToElementStable(element);
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isIncludedItemSKUVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.includedItemSKUs);

        List<WebElement> elements = WebElementUtil.findElements(locators.includedItemSKUs);

        for (WebElement element : elements) {
            WebElementUtil.scrollToElementStable(element);
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isIncludedItemColorVisible() {
        WaitUtils.untilVisible(locators.includedItemColor, 10);
        try {
            return WebElementUtil.isDisplayed(locators.includedItemColor);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateEditOrder() {
        boolean isCartPage;

        WebElementUtil.waitForElementToBeVisible(locators.EditOrder, 20);
        WebElementUtil.scrollToElementStable(locators.EditOrder);
        WebElementUtil.clickElement(locators.EditOrder);

        WebElementUtil.waitForElementToBeVisible(locators.cartPage, 20);
        isCartPage = WebElementUtil.isDisplayed(locators.cartPage);
        return isCartPage;
    }

}
