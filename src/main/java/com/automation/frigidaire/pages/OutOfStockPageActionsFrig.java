package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.OutOfStockLocatorsFrig;
import com.automation.utils.DriverManager;
import org.openqa.selenium.*;
import org.testng.Assert;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;


public class OutOfStockPageActionsFrig {

    OutOfStockLocatorsFrig plpAction = new OutOfStockLocatorsFrig();

    public void verifyProductItemPage(String str, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        waitForElementToBeVisible(locator);
        String s1 = getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        waitForElementToBeVisible(locator);
        clickElement(locator);
    }

    public void closeEmailPopUp() {
        try {
            untilVisible(plpAction.emailPopUp);
            clickElement(plpAction.emailPopUp);
        } catch (Exception e) {
            System.out.println("Email popup is not visible");
        }
    }

    public void clickOnProductName(String sku) throws InterruptedException {
        zoomInOrOut(75);
        Thread.sleep(5000);
        By productNameX = By.xpath("//div[normalize-space(text())='" + sku + "']/parent::div/parent::div//div[@class='col- Product-Name my-2 min-height-v10']//a");
        scrollToElementStable(productNameX);
        waitForElementToBeVisible(productNameX);
        waitForElementToBeClickable(productNameX);
        clickElement(productNameX);
    }

    public void checkStock() throws InterruptedException {
        Thread.sleep(5000);
        if (isDisplayed(plpAction.addToCart)) {
            waitForElementToBeClickable(plpAction.addToCart);
            verifyStockForAirCareProduct();
        } else {
            checkOutOfStock();
        }

    }

    public void verifyStockForAirCareProduct() {

        zoomInOrOut(60);

        isDisplayed(plpAction.earliestDelivery);

        WebElement deliveryElement = waitForElementToBeVisible(plpAction.earliestDelivery);
        Assert.assertTrue(deliveryElement.getText().trim().contains("Earliest delivery") || deliveryElement.getText().trim().contains("In stock"), " Text does not contain 'Earliest delivery' or 'In stock'. Found: ");

    }

    public void checkOutOfStock() {
        zoomInOrOut(75);
        WebDriver driver = DriverManager.getDriver();

        WebElement outOfStockText = waitForElementToBeVisible(plpAction.outOfStock);
        scrollToElement(outOfStockText);
        Assert.assertTrue(outOfStockText.getText().contains("Temporarily out of stock in your area."));

        WebElement emailInput = waitForElementToBeClickable(plpAction.emailField);
        emailInput.clear();
        emailInput.sendKeys("rajatverma11@gmail.com");

        WebElement notifyBtn = waitForElementToBeClickable(plpAction.notifyButton);
        notifyBtn.click();

        WebElement verifyText = waitForElementToBeVisible(plpAction.notifyVerify);
        Assert.assertTrue(verifyText.getText().contains("You’re signed up"));

    }


}
