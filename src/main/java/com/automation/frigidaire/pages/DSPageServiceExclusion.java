package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DSPagesService;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DSPageServiceExclusion {

    public void zipCodeChange(String zipCode) throws InterruptedException {

        WebDriver driver= DriverManager.getDriver();
        WaitUtils.sleep(2);
        WebElementUtil.waitForElementToBeVisible(DSPagesService.zipCodeField,10);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.zipCodeField, 10);
        WebElementUtil.clickElement(DSPagesService.zipCodeField);

        WebElementUtil.waitForElementToBeVisible(DSPagesService.zipCodeInput);
        WebElement element = driver.findElement(DSPagesService.zipCodeInput);
        Thread.sleep(2000);
        element.clear();
        element.sendKeys(zipCode);
        Thread.sleep(2000);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.zipCodeButton);
        WebElementUtil.clickElement(DSPagesService.zipCodeButton);
        //driver.navigate().refresh();
    }
    public void zipCodePop() throws InterruptedException {
        WebElementUtil.waitForElementToBeVisible(DSPagesService.zipPopUp);
        WebElementUtil.clickElement(DSPagesService.zipPopUp);
        //Thread.sleep(2000);

    }
    public void deliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        WebElement element= driver.findElement(DSPagesService.deliverySubTitle);
        WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliverySubTitle);

        Assert.assertTrue(driver.findElement(DSPagesService.deliverySubTitle).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliveryRadioButton, 10);
        Assert.assertTrue(driver.findElement(DSPagesService.deliveryRadioButton).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

//        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliveryPrice, 10);
//        Assert.assertTrue(driver.findElement(DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only price is not available!");

        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPagesService.requiredInstallation, 10);
        Assert.assertTrue(driver.findElement(DSPagesService.requiredInstallation).isDisplayed(),
                "Required Installation is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPagesService.checkBoxRequired, 10);
        Assert.assertTrue(driver.findElement(DSPagesService.checkBoxRequired).isDisplayed(),
                "Required checkbox is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPagesService.listOfAvailable, 10);
        Assert.assertTrue(driver.findElement(DSPagesService.listOfAvailable).isDisplayed(),
                "Required Installation list of available is NOT available!");

    }
    public void installationUnavailable(){

        WebDriver driver= DriverManager.getDriver();

        Assert.assertTrue(driver.findElement(DSPagesService.installationUnavailable).isDisplayed(),
                "Installation part is NOT available!");
    }
}
