package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.FedexServicelocatorsFsus;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class FedexServiceExclusionPageActionFsus {

    FedexServicelocatorsFsus fedexService = new FedexServicelocatorsFsus();

    public void enterZipCode(){
        WebElementUtil.waitForElementToBeVisible(fedexService.zipCode,10);
        WebElementUtil.waitForElementToBeClickable(fedexService.zipCode,10);
        WebElementUtil.clickElement(fedexService.zipCode);

        WebElement inputBox = WebElementUtil.waitForElementToBeVisible(fedexService.zipInputBox,10);
        inputBox.clear();
        inputBox.sendKeys("85062");

        WebElementUtil.waitForElementToBeVisible(fedexService.zipButton,10);
        WebElementUtil.waitForElementToBeClickable(fedexService.zipCode,10);
        WebElementUtil.clickElement(fedexService.zipCode);
    }
    public void searchProduct(String keyword) {
        WebElement search = WebElementUtil.waitForElementToBeVisible(fedexService.searchBox,10);
        search.clear();
        search.sendKeys(keyword);
        search.sendKeys(Keys.ENTER);
    }

    public void clickProduct(){
        WebElementUtil.scrollToElementStable(fedexService.productName);
        WebElementUtil.waitForElementToBeVisible(fedexService.productName,10);
        WebElementUtil.waitForElementToBeClickable(fedexService.productName,10);
        WebElementUtil.clickElement(fedexService.productName);

        WebElementUtil.scrollToElementStable(fedexService.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(fedexService.addToCartButton,10);
        WebElementUtil.waitForElementToBeClickable(fedexService.addToCartButton,10);
        WebElementUtil.clickElement(fedexService.addToCartButton);
    }
    public void checkDeliveryOptions() {

        WebElementUtil.scrollToElementStable(fedexService.deliveryOption);
        WebElementUtil.waitForElementToBeVisible(fedexService.deliveryOption, 10);

        WebElementUtil.waitForElementToBeVisible(fedexService.radioButton, 10);
        WebElementUtil.isDisplayed(fedexService.radioButton);

        WebElementUtil.waitForElementToBeVisible(fedexService.deliveryOnlyText, 10);
        WebElementUtil.isDisplayed(fedexService.deliveryOnlyText);

        WebElementUtil.waitForElementToBeVisible(fedexService.descriptionText, 10);
        WebElementUtil.isDisplayed(fedexService.descriptionText);

        WebElementUtil.waitForElementToBeVisible(fedexService.deliveryPrice, 10);
        WebElementUtil.isDisplayed(fedexService.deliveryPrice);

        WebElementUtil.waitForElementToBeVisible(fedexService.requiredInstallationParts,10);
        WebElementUtil.isDisplayed(fedexService.requiredInstallationParts);

        WebElementUtil.waitForElementToBeVisible(fedexService.installationList,10);
        WebElementUtil.isDisplayed(fedexService.installationList);

        WebElementUtil.waitForElementToBeVisible(fedexService.installationCheckbox,10);
        WebElementUtil.isDisplayed(fedexService.installationCheckbox);

        WebElementUtil.waitForElementToBeVisible(fedexService.installationPrice,10);
        WebElementUtil.isDisplayed(fedexService.installationPrice);
    }
}
