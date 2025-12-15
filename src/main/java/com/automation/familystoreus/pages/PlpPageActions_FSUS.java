package com.automation.familystoreus.pages;

import com.automation.electrolux.locators.EL_PLP;
import com.automation.familystoreus.locators.ProductListingPageLocator_FSUS;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;

import static com.automation.utils.WaitUtils.untilClickable;

public class PlpPageActions_FSUS {

    ProductListingPageLocator_FSUS plpPage_Locator = new ProductListingPageLocator_FSUS();

    private static String selectedProductId;
    private static String selectedProductTitle;
    private static String selectedProductPrice;
    private static String selectedHeight;
    private static String selectedWidth;
    private static String selectedDepth;


    public PlpPageActions_FSUS closePopupModel() {

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

    public PlpPageActions_FSUS storeSelectedProductId() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductId);
        selectedProductId = WebElementUtil.getText(plpPage_Locator.plpProductId);
        return this;
    }

    public PlpPageActions_FSUS storeSelectedProductTitle() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductTitle);
        selectedProductTitle = WebElementUtil.getText(plpPage_Locator.plpProductTitle);
        return this;
    }

    public PlpPageActions_FSUS storeSelectedProductPrice() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductPrice);
        selectedProductPrice = WebElementUtil.getText(plpPage_Locator.plpProductPrice);
        return this;
    }

    public PdpPageActions_FSUS clickFirstProduct() {
        WebElementUtil.scrollToElementCenter(plpPage_Locator.plpProductReview);
        WebElementUtil.clickElement(plpPage_Locator.plpProductReview);
        return new PdpPageActions_FSUS();
    }

    public PlpPageActions_FSUS storeProductDimensions() {
        WaitUtils.untilVisible(plpPage_Locator.plpHeight);
        WaitUtils.untilVisible(plpPage_Locator.plpWidth);
        WaitUtils.untilVisible(plpPage_Locator.plpDepth);

        selectedHeight = WebElementUtil.getText(plpPage_Locator.plpHeight);
        selectedWidth =  WebElementUtil.getText(plpPage_Locator.plpWidth);
        selectedDepth = WebElementUtil.getText(plpPage_Locator.plpDepth);

        return this;
    }

    public static String getSelectedProductId() {
        return selectedProductId;
    }

    public static String getSelectedProductTitle() {return selectedProductTitle;}

    public static String getSelectedProductPrice() {
        return selectedProductPrice;
    }

    public static String getSelectedHeight() {return selectedHeight;}

    public static String getSelectedWidth() {return selectedWidth;}

    public static String getSelectedDepth() {return selectedDepth;}

}