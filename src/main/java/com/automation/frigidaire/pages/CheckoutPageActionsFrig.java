package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.CheckoutLocatorsFrig;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;


public class CheckoutPageActionsFrig {
    private final CheckoutLocatorsFrig locators = new CheckoutLocatorsFrig();

    public void selectDeliveryAndSaveAndViewCart() {
        // Select delivery & installation radio
        waitForElementToBeVisible(locators.deliveryInstallationRadio);
        scrollToElementStable(locators.deliveryInstallationRadio);
        waitForElementToBeClickable(locators.deliveryInstallationRadio);
        clickElement(locators.deliveryInstallationRadio);

        selectAddOns();
        selectProtectionPlan();

        // Click Save and view cart
        scrollToElementStable(locators.saveAndViewCartButton);
        waitForElementToBeClickable(locators.saveAndViewCartButton);
        clickElement(locators.saveAndViewCartButton);
    }

    public void selectAddOns() {
        List<WebElement> elements = findElements(locators.addOnServices);
        for(WebElement element: elements) {
            waitForElementToBeVisible(element);
            scrollToElementStable(element);
            element.click();
        }
    }

    public void selectProtectionPlan() {
        waitForElementToBeVisible(locators.selectProtectionPlan);
        scrollToElementStable(locators.selectProtectionPlan);
        clickElement(locators.selectProtectionPlan);
    }

    public boolean isDeliveryTypeBannerVisible() {
        untilVisible(locators.deliveryTypeBanner);
        try {
            return isDisplayed(locators.deliveryTypeBanner);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean orderItemNameIsVisible() {
        untilVisible(locators.orderTitle);
        try {
            return isDisplayed(locators.orderTitle);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSKUVisible() {
        untilVisible(locators.orderSKU);
        try {
            return isDisplayed(locators.orderSKU);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isQtyVisible() {
        untilVisible(locators.orderQty);
        try {
            return isDisplayed(locators.orderQty);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOrderPriceVisible() {
        untilVisible(locators.orderPrice);
        try {
            return isDisplayed(locators.orderPrice);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDiscountPricePriceVisible() {
        untilVisible(locators.discountPrice);
        try {
            return isDisplayed(locators.discountPrice);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProtectionPlanVisible() {
        scrollToElementStable(locators.protectionPlan);
        untilVisible(locators.protectionPlan);
        try {
            return isDisplayed(locators.protectionPlan);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAddOnServiceVisible() {
        scrollToElementStable(locators.addOnService);
        untilVisible(locators.addOnService);
        try {
            return isDisplayed(locators.addOnService);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isIncludedSectionVisible() {
        untilVisible(locators.includedSection);
        try {
            return isDisplayed(locators.includedSection);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isIncludedItemTitleVisible() {
        waitForElementToBeVisible(locators.includedItemTitles);

        List<WebElement> elements = findElements(locators.includedItemTitles);

        for (WebElement element : elements) {
            scrollToElementStable(element);
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isIncludedItemSKUVisible() {
        waitForElementToBeVisible(locators.includedItemSKUs);

        List<WebElement> elements = findElements(locators.includedItemSKUs);

        for (WebElement element : elements) {
            scrollToElementStable(element);
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isIncludedItemColorVisible() {
        untilVisible(locators.includedItemColor);
        try {
            return isDisplayed(locators.includedItemColor);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateEditOrder() {
        boolean isCartPage;

        waitForElementToBeVisible(locators.EditOrder);
        scrollToElementStable(locators.EditOrder);
        clickElement(locators.EditOrder);

        waitForElementToBeVisible(locators.cartPage);
        isCartPage = isDisplayed(locators.cartPage);
        return isCartPage;
    }

}
