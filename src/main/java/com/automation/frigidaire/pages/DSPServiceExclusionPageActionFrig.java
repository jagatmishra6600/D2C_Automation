package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DSPServiceLocatorsFrig;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DSPServiceExclusionPageActionFrig {

    public void zipCodeChange(String zipCode) throws InterruptedException {

        WebDriver driver= DriverManager.getDriver();
        WaitUtils.sleep(2);
        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.zipCodeField,10);
        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.zipCodeField, 10);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.zipCodeField);

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.zipCodeInput);
        WebElement element = driver.findElement(DSPServiceLocatorsFrig.zipCodeInput);
        Thread.sleep(2000);
        element.clear();
        element.sendKeys(zipCode);
        Thread.sleep(2000);
        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.zipCodeButton);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.zipCodeButton);
    }
    public void zipCodePop(){
        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.zipPopUp);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.zipPopUp);
    }
    public void deliveryOnlyIsAvailable() {

        WebElementUtil.scrollToElementStable(DSPServiceLocatorsFrig.deliverySubTitle);

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliverySubTitle,10);
        WebElementUtil.isDisplayed(DSPServiceLocatorsFrig.deliverySubTitle);

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.isDisplayed(DSPServiceLocatorsFrig.deliveryRadioButton);

//        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliveryPrice, 10);
//        Assert.assertTrue(driver.findElement(DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only price is not available!");

        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.requiredInstallation, 10);
        WebElementUtil.isDisplayed(DSPServiceLocatorsFrig.requiredInstallation);

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.checkBoxRequired, 10);
        WebElementUtil.isDisplayed(DSPServiceLocatorsFrig.checkBoxRequired);

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.listOfAvailable, 10);
        WebElementUtil.isDisplayed(DSPServiceLocatorsFrig.listOfAvailable);

    }
    public void installationUnavailable(){
        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.installationUnavailable,10);
        WebElementUtil.isDisplayed(DSPServiceLocatorsFrig.installationUnavailable);
    }
}
