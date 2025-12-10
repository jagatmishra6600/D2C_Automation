package com.automation.electrolux.pages;

import com.automation.electrolux.locators.OutOfStockLocatorsElux;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.testng.Assert;

public class OutOfStockPageActionElux {

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void verifyStockForVacuums(String sku) {

        WebElementUtil.zoomInOrOut(75);
        WaitUtils.implicitWait(10);
        By productName = By.xpath("//div[normalize-space(text())='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");
        WebElementUtil.scrollToElementStable(productName);
        WebElementUtil.waitForElementToBeClickable(productName);
        WebElementUtil.clickElement(productName);

        if (WebElementUtil.isDisplayed(OutOfStockLocatorsElux.addToCart)) {
            WebElementUtil.zoomInOrOut(50);
            WebElement freeDeliveryText = WebElementUtil.waitForElementToBeVisible(OutOfStockLocatorsElux.freeDelivery);
            String partialText = "Free delivery";
            Assert.assertTrue(freeDeliveryText.getText().contains(partialText));
        } else {
            checkOutOfStock();
        }
    }
    public void verifyStockForLaundry(String sku) throws InterruptedException {

        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(3000);
        By productName = By.xpath("//div[normalize-space(text())='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");
        WebElementUtil.scrollToElementStable(productName);
        WebElementUtil.waitForElementToBeClickable(productName);
        WebElementUtil.clickElement(productName);

        if (WebElementUtil.isDisplayed(OutOfStockLocatorsElux.addToCart)) {
            WebElementUtil.zoomInOrOut(50);
            WaitUtils.implicitWait(15);
            WebElement freeDeliveryText = WebElementUtil.waitForElementToBeVisible(OutOfStockLocatorsElux.earliestDelivery);
            Assert.assertTrue(freeDeliveryText.getText().contains("Earliest delivery"));
        } else {
            checkOutOfStock();
        }
    }
    public void checkOutOfStock(){
        WebElementUtil.zoomInOrOut(70);

        WebElement outOfStockText = WebElementUtil.waitForElementToBeVisible(OutOfStockLocatorsElux.outOfStock);
        Assert.assertTrue(outOfStockText.getText().contains("Temporarily out of stock in your area."));

        WebElement emailInput = WebElementUtil.waitForElementToBeVisible(OutOfStockLocatorsElux.emailField);
        emailInput.clear();
        emailInput.sendKeys("rajatverma11@gmail.com");

        WebElement notifyButton = WebElementUtil.waitForElementToBeClickable(OutOfStockLocatorsElux.notify);
        notifyButton.click();

        WebElement verifyText = WebElementUtil.waitForElementToBeVisible(OutOfStockLocatorsElux.notifyVerify);
        Assert.assertTrue(verifyText.getText().contains("You’re signed up"));

    }

    public void checkPlpItem(String ProductName, String sku) throws InterruptedException {
        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(3000);
        if(ProductName.equalsIgnoreCase("Vacuums")){
            verifyStockForVacuums(sku);
        } else if (ProductName.equalsIgnoreCase("Laundry")) {
            verifyStockForLaundry(sku);
        }
    }
}
