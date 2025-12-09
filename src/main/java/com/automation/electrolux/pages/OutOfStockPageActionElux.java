package com.automation.electrolux.pages;

import com.automation.electrolux.locators.OutOfStockLocatorsElux;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OutOfStockPageActionElux {

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(OutOfStockLocatorsElux.emailPopUp, 60);
        WebElementUtil.clickElement(OutOfStockLocatorsElux.emailPopUp);
    }

    public void verifyStockForVacuums(String sku) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();

        WebElementUtil.zoomInOrOut(75);
        WaitUtils.implicitWait(10);
        By productName = By.xpath("//div[normalize-space(text())='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");
        WebElement element = driver.findElement(productName);
        WebElementUtil.scrollToElementStable(productName);
        WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.waitForElementToBeClickable(productName);
        WebElementUtil.clickElement(productName);

        if (WebElementUtil.isDisplayed(OutOfStockLocatorsElux.addToCart)) {
            WebElementUtil.zoomInOrOut(50);
            WebElement freeDeliveryText = driver.findElement(OutOfStockLocatorsElux.freeDelivery);
            String actual = freeDeliveryText.getText();
            String partialText = "Free delivery";
            Assert.assertTrue(actual.contains(partialText));
        } else {
            checkOutOfStock();
        }
    }
    public void verifyStockForLaundry(String sku) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(3000);
        By productName = By.xpath("//div[normalize-space(text())='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");
        WebElementUtil.scrollToElementStable(productName);
        WebElementUtil.waitForElementToBeClickable(productName);
        WebElementUtil.clickElement(productName);

        if (WebElementUtil.isDisplayed(OutOfStockLocatorsElux.addToCart)) {
            WebElementUtil.zoomInOrOut(50);
            WaitUtils.implicitWait(15);
            WebElement freeDeliveryText = wait.until(ExpectedConditions.visibilityOfElementLocated(OutOfStockLocatorsElux.earliestDelivery));
            Assert.assertTrue(freeDeliveryText.getText().contains("Earliest delivery"));
        } else {
            checkOutOfStock();
        }
    }
    public void checkOutOfStock(){
        WebElementUtil.zoomInOrOut(70);
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement outOfStockText = wait.until(ExpectedConditions.visibilityOfElementLocated(OutOfStockLocatorsElux.outOfStock));
        Assert.assertTrue(outOfStockText.getText().contains("Temporarily out of stock in your area."));

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(OutOfStockLocatorsElux.emailField));
        emailInput.clear();
        emailInput.sendKeys("rajatverma11@gmail.com");

        WebElement notifyButton = wait.until(ExpectedConditions.elementToBeClickable(OutOfStockLocatorsElux.notify));
        notifyButton.click();

        WebElement verifyText = wait.until(ExpectedConditions.visibilityOfElementLocated(OutOfStockLocatorsElux.notifyVerify));
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
