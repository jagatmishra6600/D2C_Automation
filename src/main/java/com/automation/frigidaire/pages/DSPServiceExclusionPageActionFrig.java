package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DSPServiceLocatorsFrig;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
        //driver.navigate().refresh();
    }
    public void zipCodePop() throws InterruptedException {
        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.zipPopUp);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.zipPopUp);
        //Thread.sleep(2000);

    }
    public void deliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        WebElement element= driver.findElement(DSPServiceLocatorsFrig.deliverySubTitle);
        WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliverySubTitle);

        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.deliverySubTitle).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.deliveryRadioButton).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

//        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliveryPrice, 10);
//        Assert.assertTrue(driver.findElement(DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only price is not available!");

        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.requiredInstallation, 10);
        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.requiredInstallation).isDisplayed(),
                "Required Installation is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.checkBoxRequired, 10);
        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.checkBoxRequired).isDisplayed(),
                "Required checkbox is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.listOfAvailable, 10);
        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.listOfAvailable).isDisplayed(),
                "Required Installation list of available is NOT available!");

    }
    public void installationUnavailable(){

        WebDriver driver= DriverManager.getDriver();

        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.installationUnavailable).isDisplayed(),
                "Installation part is NOT available!");
    }
}
