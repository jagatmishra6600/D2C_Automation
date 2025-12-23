package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.OrderSummaryForCheckOutPage1Frig;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class OrderSummaryCheckout1PageActionsFrig {



    public void verifyOrderSummary()
    {

        WaitUtils.untilVisible(OrderSummaryForCheckOutPage1Frig.ORDER_SUMMARY_HEADING,10000);
        WebElementUtil.isDisplayed(OrderSummaryForCheckOutPage1Frig.ORDER_SUMMARY_HEADING);

       // WaitUtils.
        WaitUtils.untilVisible(OrderSummaryForCheckOutPage1Frig.INSTALLATION_PARTS_PRICE,80000);





    }
}
