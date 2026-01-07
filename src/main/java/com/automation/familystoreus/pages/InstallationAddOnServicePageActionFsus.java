package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.InstallationAddOnServiceLocatorsFsus;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class InstallationAddOnServicePageActionFsus {

    InstallationAddOnServiceLocatorsFsus installationAddOnService = new InstallationAddOnServiceLocatorsFsus();

    public void verifyDeliveryOnlyElements() {

//        WebElementUtil.scrollToElementStable(installationAddOnService.pageTitle);
//        assertElementDisplayed(installationAddOnService.pageTitle, "Page Title is not displayed");
        assertElementDisplayed(installationAddOnService.freeDeliveryMessage, "Free Delivery Message is not displayed");
        assertElementDisplayed(installationAddOnService.sectionTitle, "Section Title is not displayed");
    }

    public void verifyAddOnService() {
        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);

        assertElementDisplayed(installationAddOnService.addOnServiceTitle, "Add-On Service Title is not displayed");
        assertElementDisplayed(installationAddOnService.addOnServiceMessage, "Add-On Service Message is not displayed");
        assertElementDisplayed(installationAddOnService.haulAwayLabel, "Haul Away Label is not displayed");
        assertElementDisplayed(installationAddOnService.haulAwayDescription, "Haul Away Description is not displayed");
        assertElementDisplayed(installationAddOnService.haulAwayCheckbox, "Haul Away Checkbox is not displayed");
        assertElementDisplayed(installationAddOnService.haulAwayPrice, "Haul Away Price is not displayed");
        assertElementDisplayed(installationAddOnService.moveUnitLabel, "Move Unit Label is not displayed");
        assertElementDisplayed(installationAddOnService.moveUnitDescription, "Move Unit Description is not displayed");
        assertElementDisplayed(installationAddOnService.moveUnitCheckbox, "Move Unit Checkbox is not displayed");
        assertElementDisplayed(installationAddOnService.moveUnitPrice, "Move Unit Price is not displayed");
    }

    public void assertElementDisplayed(By element, String errorMessage) {
        Assert.assertTrue(WebElementUtil.isDisplayed(element), errorMessage);
    }

    public void selectHaul() {

        WaitUtils.sleep(1000);
        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
        WebElementUtil.waitForElementToBeClickable(installationAddOnService.haulAwayCheckbox, 10);
        WebElementUtil.clickElement(installationAddOnService.haulAwayCheckbox);

        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel, 10);

        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice).trim();
        subTotal = subTotal.replace("$", "").replace(",", "");
        calculatePriceAndAssert(subTotal);

        WebElementUtil.scrollToElementStable(installationAddOnService.unSelectHaul);
        WebElementUtil.waitForElementToBeClickable(installationAddOnService.unSelectHaul, 10);
        WebElementUtil.clickElement(installationAddOnService.unSelectHaul);
    }

    public void selectMove() {

        WaitUtils.sleep(1000);
        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
        WebElementUtil.waitForElementToBeClickable(installationAddOnService.moveUnitCheckbox, 10);
        WebElementUtil.clickElement(installationAddOnService.moveUnitCheckbox);

        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel, 10);

        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice).trim();
        subTotal = subTotal.replace("$", "").replace(",", "");
        calculatePriceAndAssert(subTotal);

        WebElementUtil.scrollToElementStable(installationAddOnService.unSelectMove);
        WebElementUtil.waitForElementToBeClickable(installationAddOnService.unSelectMove, 10);
        WebElementUtil.clickElement(installationAddOnService.unSelectMove);
    }

    private void calculatePriceAndAssert(String price) {
        double priceAdd = 0;
        if (price.equalsIgnoreCase("Free")) {
            priceAdd = 0;
        } else {
            String num = price.replace("$", "").replace(",", "");
            priceAdd = Double.parseDouble(num);
        }
        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalPrice);
        WebElementUtil.scrollToElementStable(installationAddOnService.subTotalPrice);
        String subTotalText = WebElementUtil.getText(installationAddOnService.subTotalPrice);

        String totalPriceNumeric = subTotalText.replace("$", "").replace(",", "");
        double subTotalPrice = Double.parseDouble(totalPriceNumeric);
        double expectedTotal = priceAdd + subTotalPrice;


        WebElementUtil.waitForElementToBeVisible(installationAddOnService.totalLabel);
        String totalPrice = WebElementUtil.getText(installationAddOnService.totalLabel);
        String totalPriceActual = totalPrice.replace("$", "").replace(",", "");
        double actualTotal = Double.parseDouble(totalPriceActual);

        Assert.assertEquals(actualTotal, expectedTotal, "Error");
    }

}
