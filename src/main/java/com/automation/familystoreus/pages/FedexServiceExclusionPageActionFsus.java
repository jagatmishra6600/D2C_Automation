package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.FedexServiceLocatorsFsus;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FedexServiceExclusionPageActionFsus {

    FedexServiceLocatorsFsus fedexService = new FedexServiceLocatorsFsus();

    public void enterZipCode(String zip) throws InterruptedException {

        WebElementUtil.scrollToElementStable(fedexService.zipCode);
        WebElementUtil.waitForElementToBeVisible(fedexService.zipCode,10);
        WebElementUtil.waitForElementToBeClickable(fedexService.zipCode,10);
        WebElementUtil.clickElement(fedexService.zipCode);

        WebElementUtil.waitForElementToBeVisible(fedexService.zipInputBox,10);
        Thread.sleep(3000);
        WebElementUtil.sendKeys(fedexService.zipInputBox,zip);

        WebElementUtil.waitForElementToBeVisible(fedexService.zipButton,10);
        WebElementUtil.waitForElementToBeClickable(fedexService.zipButton,10);
        WebElementUtil.clickElement(fedexService.zipButton);
    }
    public void searchProduct(String keyword) throws InterruptedException {
        WebElementUtil.scrollToElementStable(fedexService.searchBox);
        WebElement search = WebElementUtil.waitForElementToBeVisible(fedexService.searchBox,20);
        search.clear();
        search.sendKeys(keyword);
        search.sendKeys(Keys.ENTER);
        WaitUtils.sleep(3000);
    }

    public void clickProduct() throws InterruptedException {

        WebElementUtil.scrollToElementStable(fedexService.productName);
        Thread.sleep(5000);

        WebElementUtil.scrollToElementStable(fedexService.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(fedexService.addToCartButton,15);
        WebElementUtil.waitForElementToBeClickable(fedexService.addToCartButton,15);
        WebElementUtil.clickElement(fedexService.addToCartButton);
    }
//    public void checkDeliveryOptions() {
//
//        WebElementUtil.scrollToElementStable(fedexService.deliveryOption);
//        WebElementUtil.waitForElementToBeVisible(fedexService.deliveryOption, 10);
//
//        WebElementUtil.waitForElementToBeVisible(fedexService.radioButton, 10);
//        WebElementUtil.isDisplayed(fedexService.radioButton);
//
//        WebElementUtil.waitForElementToBeVisible(fedexService.deliveryOnlyText, 10);
//        WebElementUtil.isDisplayed(fedexService.deliveryOnlyText);
//
//        WebElementUtil.waitForElementToBeVisible(fedexService.descriptionText, 10);
//        WebElementUtil.isDisplayed(fedexService.descriptionText);
//
//        WebElementUtil.waitForElementToBeVisible(fedexService.deliveryPrice, 10);
//        WebElementUtil.isDisplayed(fedexService.deliveryPrice);
//
//        WebElementUtil.scrollToElementStable(fedexService.requiredInstallationParts);
//        WebElementUtil.waitForElementToBeVisible(fedexService.requiredInstallationParts,10);
//        WebElementUtil.isDisplayed(fedexService.requiredInstallationParts);
//
//        WebElementUtil.scrollToElementStable(fedexService.installationList);
//        WebElementUtil.waitForElementToBeVisible(fedexService.installationList,10);
//        WebElementUtil.isDisplayed(fedexService.installationList);
//
//        WebElementUtil.waitForElementToBeVisible(fedexService.installationCheckbox,10);
//        WebElementUtil.isDisplayed(fedexService.installationCheckbox);
//
//        WebElementUtil.waitForElementToBeVisible(fedexService.installationPrice,10);
//        WebElementUtil.isDisplayed(fedexService.installationPrice);
//
//        WebElementUtil.waitForElementToBeVisible(fedexService.installationUnavailable,10);
//        WebElementUtil.isDisplayed(fedexService.installationUnavailable);
//    }

    public void assertElementVisible(By locator, String elementName) {
        Assert.assertTrue(WebElementUtil.isDisplayed(locator), elementName + " is not visible");
        WebElementUtil.scrollToElementStable(locator);
    }

    public void checkDeliveryOptions() {
        assertElementVisible(fedexService.deliveryOption, "Delivery Option");
        assertElementVisible(fedexService.radioButton, "Delivery Radio Button");
        assertElementVisible(fedexService.deliveryOnlyText, "Delivery Only Text");
        //assertElementVisible(fedexService.descriptionText, "Delivery Description");
        //assertElementVisible(fedexService.deliveryPrice, "Delivery Price");
        assertElementVisible(fedexService.requiredInstallationParts, "Required Installation Parts");
        //assertElementVisible(fedexService.installationList, "Installation List");
        assertElementVisible(fedexService.installationCheckbox, "Installation Checkbox");
        assertElementVisible(fedexService.installationPrice, "Installation Price");
    }
    public void checkInstallationUnavailable(){
        assertElementVisible(fedexService.installationUnavailable, "Installation Unavailable Message");

    }

}
