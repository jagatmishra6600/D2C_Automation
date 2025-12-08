package com.automation.electrolux.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.automation.utils.WaitUtils.untilClickable;

public class ElectroluxProductCards {

    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    private final By skuNumber = By.xpath("//div[@id='PlpItem1']//div[@class='Product-Card-Sku']");
    private final By leftCornerTag = By.xpath("//div[@id='PlpItem1']//div[@class='mb-4 highlight-wapper']/div");
    private final By productImage = By.xpath("//div[@id='PlpItem1']//div[@class='col- Product-Image-Placeholder px-0']//img");
    private final By productName = By.xpath("//div[@id='PlpItem1']//div[@class='col- product-card-inner-row kit']//div");
    private final By colorOption = By.xpath("//div[@id='PlpItem1']//div[@class='col- Product-Color-Swatch-wrapper my-2 d-flex']/a");
    private final By rating = By.xpath("//div[@id='PlpItem1']//div[@id='BvProductRating']");
    private final By feature = By.xpath("//div[@id='PlpItem1']//div[@id='badge']/div");
    private final By discountPrice = By.xpath("//div[@id='PlpItem1']//div[@class='col- ElementsPricingMSRP-Sale ff']//div//span[@class='H3H3_Desktop saleprice']");
    private final By originalPrice = By.xpath("//div[@id='PlpItem1']//div[@class='col- ElementsPricingMSRP-Sale ff']/div/span[@class='CTA-Text-ELE-Blue-Mid']/s");
    private final By priceIcon = By.xpath("//div[@id='PlpItem1']//div[@class='col- ElementsPricingMSRP-Sale ff']//div//app-elux-tooltip//div//img");
    private final By compareBox = By.xpath("//div[@id='PlpItem1']//div//input[@type='checkbox']");


    SoftAssert softAssert = new SoftAssert();

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        WebElementUtil.clickElement(emailPopUp);
    }

    public ElectroluxProductCards navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        try {
            WebElement acceptBtn = untilClickable(acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
    }

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void verifyProductItemPage(String str, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void verifyElementDisplayed(By xpath, String elementName) {
        try {
            WebDriver driver = DriverManager.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

            boolean isDisplayed = element.isDisplayed();
            softAssert.assertTrue(isDisplayed, elementName + " should be displayed.");
        } catch (Exception e) {
            softAssert.fail(elementName + " not found or not displayed.");
        }
    }

    public void verifyProductDetails() {

        verifyElementDisplayed(skuNumber, "SKU Number");
        verifyElementDisplayed(leftCornerTag, "Left Corner Tag");
        verifyElementDisplayed(productImage, "Image");
        verifyElementDisplayed(productName, "Name");
        verifyElementDisplayed(colorOption, "Color");
        verifyElementDisplayed(rating, "Rating");
        verifyElementDisplayed(feature, "Feature");
        verifyElementDisplayed(discountPrice, "Discount Price");
        verifyElementDisplayed(originalPrice, "Original Price");
        verifyElementDisplayed(priceIcon, "Price Icon");
        verifyElementDisplayed(compareBox, "Compare Box");
    }


    public void verifyAndClickElements(){
        WebDriver driver = DriverManager.getDriver();
        WebElementUtil.zoomInOrOut(80);

        verifyAndClickIfNeeded(driver, productImage, "Product Image");
        verifyAndClickIfNeeded(driver, productName, "Product Name");
        verifyAndClickIfNeeded(driver, rating, "Product Rating");
    }
    private void verifyAndClickIfNeeded(WebDriver driver, By xpath, String elementName){
        By skuPLP = By.xpath("//div[@id=\"PlpItem1\"]//div[@class=\"Product-Card-Sku\"]");
        WebElementUtil.waitForElementToBeVisible(skuPLP);
        WebElement skuNumber = driver.findElement(skuPLP);
        String textValuePLP = skuNumber.getText();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));


            if (element.isDisplayed()) {
                element.click();

                By skuPDP = By.xpath("//div[@id=\"EluxBreadcrumb\"]//span[@class=\"ng-star-inserted\"]//span");
                WebElementUtil.waitForElementToBeVisible(skuPDP);
                WebElement skuNumberPDP = driver.findElement(skuPDP);
                String textPDP = skuNumberPDP.getText();

                Assert.assertEquals(textPDP,textValuePLP);

                DriverManager.getDriver().navigate().back();
            }
        } catch (Exception e) {
            System.out.println(elementName + " NOT found or not displayed. Xpath: " + xpath);
        }
    }

    public void checkPlpItem(String ProductName) throws InterruptedException {
        WebElementUtil.zoomInOrOut(80);
        WaitUtils.implicitWait(5);
        WebDriver driver = DriverManager.getDriver();

        if(ProductName.equalsIgnoreCase("Vacuums")){
            WebElement nameProduct= driver.findElement(productName);
            WebElementUtil.scrollToElement(driver, nameProduct);
            verifyProductDetails();
            verifyAndClickElements();
        } else if (ProductName.equalsIgnoreCase("Laundry")) {
            WebElement nameProduct= driver.findElement(productName);
            WebElementUtil.scrollToElement(driver, nameProduct);
            verifyProductDetails();
            verifyAndClickElements();
        }

    }

}