package com.automation.electrolux.pages;

import com.automation.electrolux.locators.PLPLocatorsElux;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;

import static com.automation.utils.WaitUtils.untilClickable;

public class PlpPageActionsElux {

    PLPLocatorsElux plpPage_Locator = new PLPLocatorsElux();

    private static String selectedProductId;
    private static String selectedProductTitle;
    private static String selectedProductPrice;

    public PlpPageActionsElux closePopupModel() {

        try {
            WaitUtils.untilVisible(plpPage_Locator.closePopupButton, 20);
            WebElement closeBtn = untilClickable(plpPage_Locator.closePopupButton, 20);
            if (closeBtn != null) {
                closeBtn.click();
            }
        } catch (Exception ignored) {

        }
        return this;
    }

    public PlpPageActionsElux storeSelectedProductId() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductId);
        selectedProductId = WebElementUtil.getText(plpPage_Locator.plpProductId);
        return this;
    }

    public PlpPageActionsElux storeSelectedProductTitle() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductTitle);
        selectedProductTitle = WebElementUtil.getText(plpPage_Locator.plpProductTitle);
        return this;
    }

    public PlpPageActionsElux storeSelectedProductPrice() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductPrice);
        selectedProductPrice = WebElementUtil.getText(plpPage_Locator.plpProductPrice);
        return this;
    }

    public PdpPageActionsElux clickFirstProduct() {
        WebElementUtil.scrollToElementCenter(plpPage_Locator.plpProductReview);
        WebElementUtil.clickElement(plpPage_Locator.plpProductReview);
        return new PdpPageActionsElux();
    }

    public static String getSelectedProductId() {
        return selectedProductId;
    }

    public static String getSelectedProductTitle() {
        return selectedProductTitle;
    }

    public static String getSelectedProductPrice() {
        return selectedProductPrice;
    }

}