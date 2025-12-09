package com.automation.electrolux.pages;

import com.automation.electrolux.locators.DSPageServiceLocatorsElux;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DSPServiceExclusionPageActionElux {

    public void clickProductBySKU(String sku) throws InterruptedException {

        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(7000);
        By productClick =By.xpath("//div[text()='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");

        WebDriver driver= DriverManager.getDriver();
        WebElement productSKUNumber= driver.findElement(productClick);
        WebElementUtil.scrollToElementStable(productClick);
        WebElementUtil.waitForElementToBeVisible(productClick, 10);
        WebElementUtil.waitForElementToBeClickable(productClick, 10);
        WebElementUtil.clickElement(productClick);

        Thread.sleep(3000);
        WebElement addButton = driver.findElement(DSPageServiceLocatorsElux.addToCartButton);
        WebElementUtil.scrollToElement(driver, addButton);
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
        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.zipPopUp);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.zipPopUp);
    }
    public void deliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        WebElement element= driver.findElement(DSPageServiceLocatorsElux.deliverySubTitle);
        WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.deliverySubTitle);

        Assert.assertTrue(driver.findElement(DSPageServiceLocatorsElux.deliverySubTitle).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.deliveryRadioButton, 10);
        Assert.assertTrue(driver.findElement(DSPageServiceLocatorsElux.deliveryRadioButton).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

//        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliveryPrice, 10);
//        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only price is not available!");

        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.requiredInstallation, 10);
        Assert.assertTrue(driver.findElement(DSPageServiceLocatorsElux.requiredInstallation).isDisplayed(),
                "Required Installation is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.checkBoxRequired, 10);
        Assert.assertTrue(driver.findElement(DSPageServiceLocatorsElux.checkBoxRequired).isDisplayed(),
                "Required checkbox is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.listOfAvailable, 10);
        Assert.assertTrue(driver.findElement(DSPageServiceLocatorsElux.listOfAvailable).isDisplayed(),
                "Required Installation list of available is NOT available!");

    }
    public void installationUnavailable(){

        WebDriver driver= DriverManager.getDriver();

        Assert.assertTrue(driver.findElement(DSPageServiceLocatorsElux.installationUnavailable).isDisplayed(),
                "Installation part is NOT available!");
    }
}
