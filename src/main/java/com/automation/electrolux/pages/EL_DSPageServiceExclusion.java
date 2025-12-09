package com.automation.electrolux.pages;

import com.automation.electrolux.locators.EL_DSPagesService;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EL_DSPageServiceExclusion {

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
        WebElement addButton = driver.findElement(EL_DSPagesService.addToCartButton);
        WebElementUtil.scrollToElement(driver, addButton);
        WebElementUtil.scrollToElementStable(EL_DSPagesService.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.addToCartButton, 10);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.addToCartButton, 10);
        WebElementUtil.clickElement(EL_DSPagesService.addToCartButton);

    }


    public void zipCodeChange(String zipCode) throws InterruptedException {

        WebDriver driver= DriverManager.getDriver();
        WaitUtils.sleep(2);
        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.zipCodeField,10);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.zipCodeField, 10);
        WebElementUtil.clickElement(EL_DSPagesService.zipCodeField);

        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.zipCodeInput);
        WebElement element = driver.findElement(EL_DSPagesService.zipCodeInput);
        Thread.sleep(2000);
        element.clear();
        element.sendKeys(zipCode);
        Thread.sleep(2000);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.zipCodeButton);
        WebElementUtil.clickElement(EL_DSPagesService.zipCodeButton);
    }
    public void zipCodePop(){
        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.zipPopUp);
        WebElementUtil.clickElement(EL_DSPagesService.zipPopUp);
    }
    public void deliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        WebElement element= driver.findElement(EL_DSPagesService.deliverySubTitle);
        WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliverySubTitle);

        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliverySubTitle).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliveryRadioButton, 10);
        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliveryRadioButton).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

//        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliveryPrice, 10);
//        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only price is not available!");

        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton, 10);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.requiredInstallation, 10);
        Assert.assertTrue(driver.findElement(EL_DSPagesService.requiredInstallation).isDisplayed(),
                "Required Installation is NOT available!");

        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.checkBoxRequired, 10);
        Assert.assertTrue(driver.findElement(EL_DSPagesService.checkBoxRequired).isDisplayed(),
                "Required checkbox is NOT available!");

        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.listOfAvailable, 10);
        Assert.assertTrue(driver.findElement(EL_DSPagesService.listOfAvailable).isDisplayed(),
                "Required Installation list of available is NOT available!");

    }
    public void installationUnavailable(){

        WebDriver driver= DriverManager.getDriver();

        Assert.assertTrue(driver.findElement(EL_DSPagesService.installationUnavailable).isDisplayed(),
                "Installation part is NOT available!");
    }
}
