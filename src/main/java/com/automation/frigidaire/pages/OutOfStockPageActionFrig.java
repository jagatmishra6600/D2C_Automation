package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.OutOfStockLocatorsFrig;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OutOfStockPageActionFrig {

    // Do not initialize WebDriver at class instantiation time.
    // Access DriverManager.getDriver() inside methods after BaseTest @BeforeMethod runs.

    OutOfStockLocatorsFrig plpAction = new OutOfStockLocatorsFrig();


    public void verifyProductItemPage(String str, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void closeEmailPopUp() {
        try {
            WaitUtils.untilVisible(plpAction.emailPopUp, 60);
            WebElementUtil.clickElement(plpAction.emailPopUp);
        } catch (Exception e) {
            System.out.println("Email popup is not visible");
        }
    }

    public void clickOnProductName(String sku) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(5000);
        By productNameX = By.xpath("//div[normalize-space(text())='" + sku + "']/parent::div/parent::div//div[@class='col- Product-Name my-2 min-height-v10']//a");
        WebElement element = driver.findElement(productNameX);
        WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.scrollToElementStable(productNameX);
        WebElementUtil.waitForElementToBeVisible(productNameX);
        WebElementUtil.waitForElementToBeClickable(productNameX);
        WebElementUtil.clickElement(productNameX);
    }

    public void checkStock() throws InterruptedException {
        Thread.sleep(5000);
        if (WebElementUtil.isDisplayed(plpAction.addToCart)) {
            WebElementUtil.waitForElementToBeClickable(plpAction.addToCart);
            verifyStockForAirCareProduct();
        } else {
            checkOutOfStock();
        }

    }

    public void verifyStockForAirCareProduct() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElementUtil.zoomInOrOut(60);

        WebElementUtil.isDisplayed(plpAction.earliestDelivery);
        WebElement deliveryElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(plpAction.earliestDelivery)

        );
        String actualText = deliveryElement.getText().trim();
        Assert.assertTrue(
                actualText.contains("Earliest delivery") || actualText.contains("In stock"),
                " Text does not contain 'Earliest delivery' or 'In stock'. Found: " + actualText);

    }

    public void checkOutOfStock() {
        WebElementUtil.zoomInOrOut(75);
        WebDriver driver = DriverManager.getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement outOfStockText = wait.until(ExpectedConditions.visibilityOfElementLocated(plpAction.outOfStock));
        WebElementUtil.scrollToElement(driver, outOfStockText);
        Assert.assertTrue(outOfStockText.getText().contains("Temporarily out of stock in your area."));

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(plpAction.emailField));
        emailInput.clear();
        emailInput.sendKeys("rajatverma11@gmail.com");

        WebElement notifyBtn = wait.until(ExpectedConditions.elementToBeClickable(plpAction.notifyButton));
        notifyBtn.click();

        WebElement verifyText = wait.until(ExpectedConditions.visibilityOfElementLocated(plpAction.notifyVerify));
        Assert.assertTrue(verifyText.getText().contains("You’re signed up"));

    }


}
