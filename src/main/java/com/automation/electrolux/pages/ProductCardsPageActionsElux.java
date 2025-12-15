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
import java.util.List;

import static com.automation.utils.WaitUtils.untilClickable;

public class ProductCardsPageActionsElux {

    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    SoftAssert softAssert = new SoftAssert();

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        WebElementUtil.clickElement(emailPopUp);
    }

    public ProductCardsPageActionsElux navigateToHomePage() {
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

    public void verifyElementDisplayed(String xpath, String elementName) {
        try {
            WebDriver driver = DriverManager.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            boolean isDisplayed = element.isDisplayed();
            System.out.println(elementName + " is displayed: " + isDisplayed);
            softAssert.assertTrue(isDisplayed, elementName + " should be displayed.");
        } catch (Exception e) {
            System.out.println(elementName + " is not displayed: ");
            softAssert.fail(elementName + " not found or not displayed.");
        }
    }

    public void verifyProductDetails(int i) {
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class=\"Product-Card-Sku\"]","SKU Number");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='mb-4 highlight-wapper']/div", "Left Corner Tag");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- Product-Image-Placeholder px-0']//img", "Image");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- product-card-inner-row kit']//div", "Name");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- Product-Color-Swatch-wrapper my-2 d-flex']/a", "Color");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@id='BvProductRating']", "Rating");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@id='badge']/div", "Feature");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- ElementsPricingMSRP-Sale ff']//div//span[@class='H3H3_Desktop saleprice']", "Discount Price");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- ElementsPricingMSRP-Sale ff']/div/span[@class='CTA-Text-ELE-Blue-Mid']/s", "Original Price");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- ElementsPricingMSRP-Sale ff']//div//app-elux-tooltip//div//img", "Price Icon");
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div//input[@type='checkbox']", "Compare Box");
    }

    public void verifyAndClickElements(int i) {
        WebDriver driver = DriverManager.getDriver();
        WebElementUtil.zoomInOrOut(40);

            String image="//div[@id=\"PlpItem"+i+"\"]//div[@class='col- Product-Image-Placeholder px-0']//img";
            String nameXpath="//div[@id=\"PlpItem"+i+"\"]//div[@class=\"Product-title Body-XLargeBody_XLarge-Title m-auto\"]";
            String ratingXpath="//div[@id=\"PlpItem"+i+"\"]//div[@id='BvProductRating']";
            verifyAndClickIfNeeded(driver, image, "Product Image");
            verifyAndClickIfNeeded(driver, nameXpath, "Product Name");
            verifyAndClickIfNeeded(driver, ratingXpath, "Product Rating");
    }
    private void verifyAndClickIfNeeded(WebDriver driver, String xpath, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            if (element.isDisplayed()) {
                element.click();
                System.out.println("Clicked on " + elementName + " — navigating to PDP page.");

                WaitUtils.implicitWait(2);
                driver.navigate().back();
                System.out.println("Navigated back to PLP page.");

                WaitUtils.implicitWait(4);
            }
        } catch (Exception e) {
            System.out.println(elementName + " NOT found or not displayed. Xpath: " + xpath);
        }
    }

    public void checkPlpItem(String ProductName) throws InterruptedException {
        WebElementUtil.zoomInOrOut(60);
        WaitUtils.implicitWait(5);
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> items = driver.findElements(By.xpath("//div[starts-with(@id, 'PlpItem')]"));
        for (int i = 0; i < 5; i++) {
            if(ProductName.equalsIgnoreCase("Vacuums")){
                verifyProductDetails(i);
                verifyAndClickElements(i);
            } else if (ProductName.equalsIgnoreCase("Laundry")) {
                verifyProductDetails(i);
                verifyAndClickElements(i);
            }
        }
    }

}