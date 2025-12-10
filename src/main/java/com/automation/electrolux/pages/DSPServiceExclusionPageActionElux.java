package com.automation.electrolux.pages;

import com.automation.electrolux.locators.DSPageServiceLocatorsElux;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DSPServiceExclusionPageActionElux {

    public void clickProductBySKU(String sku) throws InterruptedException {

        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(7000);
        By productClick =By.xpath("//div[text()='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");

        WebElementUtil.scrollToElementStable(productClick);
        WebElementUtil.waitForElementToBeVisible(productClick, 10);
        WebElementUtil.waitForElementToBeClickable(productClick, 10);
        WebElementUtil.clickElement(productClick);

        Thread.sleep(3000);
        WebElementUtil.scrollToElementStable(DSPageServiceLocatorsElux.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.addToCartButton, 10);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.addToCartButton, 10);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.addToCartButton);

    }


    public void zipCodeChange(String zipCode) throws InterruptedException {

        WebDriver driver= DriverManager.getDriver();
        WaitUtils.sleep(2);
        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.zipCodeField,10);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.zipCodeField, 10);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.zipCodeField);

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.zipCodeInput);
        WebElement element = driver.findElement(DSPageServiceLocatorsElux.zipCodeInput);
        Thread.sleep(2000);
        element.clear();
        element.sendKeys(zipCode);
        Thread.sleep(2000);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.zipCodeButton);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.zipCodeButton);
    }
    public void zipCodePop(){
        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.zipPopUp, 10);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.zipPopUp);
    }
    public void deliveryOnlyIsAvailable() {
        WebElementUtil.scrollToElementStable(DSPageServiceLocatorsElux.deliverySubTitle);
        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.deliverySubTitle);
        WebElementUtil.isDisplayed(DSPageServiceLocatorsElux.deliverySubTitle);

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.deliveryRadioButton, 10);
        WebElementUtil.isDisplayed(DSPageServiceLocatorsElux.deliveryRadioButton);


//        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliveryPrice, 10);
//        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only price is not available!");

        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.requiredInstallation, 10);
        WebElementUtil.isDisplayed(DSPageServiceLocatorsElux.requiredInstallation);

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.checkBoxRequired, 10);
        WebElementUtil.isDisplayed(DSPageServiceLocatorsElux.checkBoxRequired);

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.listOfAvailable, 10);
        WebElementUtil.isDisplayed(DSPageServiceLocatorsElux.listOfAvailable);

    }
    public void installationUnavailable(){

        WebElementUtil.isDisplayed(DSPageServiceLocatorsElux.installationUnavailable);
    }
}
