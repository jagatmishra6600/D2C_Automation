package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.FedexServiceLocatorsFsus;
import com.automation.familystoreus.locators.InstallationAddOnServiceLocatorsFsus;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.testng.Assert;

public class InstallationAddOnServicePageActionFsus {

    InstallationAddOnServiceLocatorsFsus installationAddOnService = new InstallationAddOnServiceLocatorsFsus();
    FedexServiceLocatorsFsus fedexService = new FedexServiceLocatorsFsus();

    public void verifyDeliveryOnlyElements() {

//        WebElementUtil.scrollToElementStable(installationAddOnService.pageTitle);
//        WebElementUtil.waitForElementToBeVisible(installationAddOnService.pageTitle, 10);
//        WebElementUtil.isDisplayed(installationAddOnService.pageTitle);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.freeDeliveryMessage, 10);
        WebElementUtil.isDisplayed(installationAddOnService.freeDeliveryMessage);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.sectionTitle, 10);
        WebElementUtil.isDisplayed(installationAddOnService.sectionTitle);
    }

    public void verifyProfessionalInstallationSection() {

        WebElementUtil.scrollToElementStable(installationAddOnService.professionalInstallationTitle);
        WebElementUtil.waitForElementToBeVisible(installationAddOnService.professionalInstallationTitle, 10);
        WebElementUtil.isDisplayed(installationAddOnService.professionalInstallationTitle);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.professionalInstallationRadio, 10);
        WebElementUtil.isDisplayed(installationAddOnService.professionalInstallationRadio);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.professionalInstallationDescription, 10);
        WebElementUtil.isDisplayed(installationAddOnService.professionalInstallationDescription);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.professionalInstallationPrice, 10);
        WebElementUtil.isDisplayed(installationAddOnService.professionalInstallationPrice);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.professionalInstallationTag);
        WebElementUtil.isDisplayed(installationAddOnService.professionalInstallationTag);
    }

    public void selectDeliveryOnly() {

        WebElementUtil.scrollToElementStable(fedexService.deliveryOption);

        WebElementUtil.waitForElementToBeVisible(fedexService.radioButton, 10);
        WebElementUtil.waitForElementToBeClickable(fedexService.radioButton, 10);
        WebElementUtil.clickElement(fedexService.radioButton);

        WebElementUtil.waitForElementToBeVisible(fedexService.installationCheckbox, 10);
        WebElementUtil.waitForElementToBeClickable(fedexService.installationCheckbox, 10);
        WebElementUtil.clickElement(fedexService.installationCheckbox);


    }

    public void verifyAddOnService() {

        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.addOnServiceTitle, 10);
        WebElementUtil.isDisplayed(installationAddOnService.addOnServiceTitle);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.addOnServiceMessage, 10);
        WebElementUtil.isDisplayed(installationAddOnService.addOnServiceMessage);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.haulAwayLabel, 10);
        WebElementUtil.isDisplayed(installationAddOnService.haulAwayLabel);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.haulAwayDescription, 10);
        WebElementUtil.isDisplayed(installationAddOnService.haulAwayDescription);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.haulAwayCheckbox, 10);
        WebElementUtil.isDisplayed(installationAddOnService.haulAwayCheckbox);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.haulAwayPrice, 10);
        WebElementUtil.isDisplayed(installationAddOnService.haulAwayPrice);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.moveUnitLabel, 10);
        WebElementUtil.isDisplayed(installationAddOnService.moveUnitLabel);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.moveUnitDescription, 10);
        WebElementUtil.isDisplayed(installationAddOnService.moveUnitDescription);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.moveUnitCheckbox, 10);
        WebElementUtil.isDisplayed(installationAddOnService.moveUnitCheckbox);

        WebElementUtil.waitForElementToBeVisible(installationAddOnService.moveUnitPrice, 10);
        WebElementUtil.isDisplayed(installationAddOnService.moveUnitPrice);
    }

    public void selectHaul() throws InterruptedException {

        WaitUtils.sleep(3);
        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
        WebElementUtil.waitForElementToBeClickable(installationAddOnService.haulAwayCheckbox,10);
        WebElementUtil.clickElement(installationAddOnService.haulAwayCheckbox);

        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel,10);

        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice).trim();
        subTotal = subTotal.replace("$", "").replace(",", "");
        System.out.println(subTotal);
        calculatePriceAndAssert(subTotal);

        WebElementUtil.waitForElementToBeClickable(installationAddOnService.haulAwayCheckbox,10);
        WebElementUtil.clickElement(installationAddOnService.haulAwayCheckbox);
    }

    public void selectMove() throws InterruptedException {

        WaitUtils.sleep(3);
        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
        WebElementUtil.waitForElementToBeClickable(installationAddOnService.moveUnitCheckbox,10);
        WebElementUtil.clickElement(installationAddOnService.moveUnitCheckbox);

        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel,10);

        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice).trim();
        subTotal = subTotal.replace("$", "").replace(",", "");
        System.out.println(subTotal);
        calculatePriceAndAssert(subTotal);

        WebElementUtil.waitForElementToBeClickable(installationAddOnService.moveUnitCheckbox,10);
        WebElementUtil.clickElement(installationAddOnService.moveUnitPrice);
    }

    public void selectHaulAndMove() throws InterruptedException {

        WaitUtils.sleep(3);
        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
        WebElementUtil.waitForElementToBeClickable(installationAddOnService.haulAwayCheckbox,10);
        WebElementUtil.clickElement(installationAddOnService.haulAwayCheckbox);

        WebElementUtil.waitForElementToBeClickable(installationAddOnService.moveUnitCheckbox,10);
        WebElementUtil.clickElement(installationAddOnService.moveUnitCheckbox);

        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel,10);

        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice).trim();
        subTotal = subTotal.replace("$", "").replace(",", "");
        System.out.println(subTotal);
        calculatePriceAndAssert(subTotal);

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
//
//    public void selectHaul() {
//
//        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
//        clickAddon(installationAddOnService.haulAwayCheckbox);
//        //validateSubtotal();
//        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
//        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel, 10);
//
//        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice)
//                .trim()
//                .replace("$", "")
//                .replace(",", "");
//
//        System.out.println(subTotal);
//        calculatePriceAndAssert(subTotal);
//        WebElementUtil.waitForElementToBeClickable(installationAddOnService.haulAwayCheckbox, 10);
//        WebElementUtil.clickElement(installationAddOnService.haulAwayCheckbox);
//    }
//
//    public void selectMove() {
//        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
//        clickAddon(installationAddOnService.moveUnitCheckbox);
//        //validateSubtotal();
//        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
//        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel, 10);
//        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice)
//                .trim()
//                .replace("$", "")
//                .replace(",", "");
//
//        System.out.println(subTotal);
//        calculatePriceAndAssert(subTotal);
//        WebElementUtil.waitForElementToBeClickable(installationAddOnService.moveUnitCheckbox, 10);
//        WebElementUtil.clickElement(installationAddOnService.moveUnitCheckbox);
//    }
//
//    public void selectHaulAndMove() {
//
//        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
//        clickAddon(installationAddOnService.haulAwayCheckbox);
//        clickAddon(installationAddOnService.moveUnitCheckbox);
//        //validateSubtotal();
//        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
//        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel, 10);
//
//        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice)
//                .trim()
//                .replace("$", "")
//                .replace(",", "");
//
//        System.out.println(subTotal);
//        calculatePriceAndAssert(subTotal);
//    }
//
//    private void clickAddon(By checkbox) {
//        WebElementUtil.scrollToElementCenter(installationAddOnService.addOnServiceTitle);
//        WebElementUtil.waitForElementToBeClickable(checkbox, 10);
//        WebElementUtil.clickElement(checkbox);
//    }
//
//    private void validateSubtotal() {
//        WebElementUtil.scrollToElementCenter(installationAddOnService.subTotalLabel);
//        WebElementUtil.waitForElementToBeVisible(installationAddOnService.subTotalLabel, 10);
//
//        String subTotal = WebElementUtil.getText(installationAddOnService.subTotalAddOnServicePrice)
//                .trim()
//                .replace("$", "")
//                .replace(",", "");
//
//        System.out.println(subTotal);
//        calculatePriceAndAssert(subTotal);
//    }


}
