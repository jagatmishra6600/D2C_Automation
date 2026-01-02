package com.automation.electrolux.pages;

import com.automation.electrolux.locators.FEDEX_AITLocatorsElux;
import com.automation.utils.WebElementUtil;
import org.testng.Assert;

public class FEDEX_AITPageActionsElux {

    FEDEX_AITLocatorsElux fedexLocators = new FEDEX_AITLocatorsElux();

    public boolean isDeliveryOnlyItemsTitleDisplayed() {
        return WebElementUtil.isDisplayed(fedexLocators.deliveryOnlyItems);
    }

    public boolean isDeliverToZipCodeDisplayed() {
        return WebElementUtil.isDisplayed(fedexLocators.deliverToZipcode);
    }

    public boolean isDeliveryMessageDisplayed() {
        return WebElementUtil.isDisplayed(fedexLocators.messages);
    }

    public boolean isEstimatedDeliveryDateDisplayed() {
        return WebElementUtil.isDisplayed(fedexLocators.estimatedDelivery);
    }

    public boolean isDeliveryCommentsTextBoxDisplayed() {
        return WebElementUtil.isDisplayed(fedexLocators.deliveryCommentsTextbox);
    }

    public void checkoutPagesFedex() {
        Assert.assertTrue(isDeliveryOnlyItemsTitleDisplayed(),
                "Delivery Only Items title is not displayed on Checkout Page.");

        Assert.assertTrue(isDeliverToZipCodeDisplayed(),
                "Deliver To Zip Code field is not displayed on Checkout Page.");

        Assert.assertTrue(isDeliveryMessageDisplayed(),
                "Delivery message is not displayed on Checkout Page.");

        Assert.assertTrue(isEstimatedDeliveryDateDisplayed(),
                "Estimated delivery date is not displayed on Checkout Page.");

        Assert.assertTrue(isDeliveryCommentsTextBoxDisplayed(),
                "Delivery comments text box is not displayed on Checkout Page.");
    }


}


