package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class ProductListingPageActions {

    SoftAssert softAssert=new SoftAssert();
    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        WebElementUtil.clickElement(emailPopUp);
    }

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

    public void verifyAndClickElements(int i) {
        WebDriver driver = DriverManager.getDriver();
        WebElementUtil.zoomInOrOut(40);
            String image = "//div[@id=\"PlpItem"+i+"\"]//div[@class=\"col- Product-Image-Placeholder\"]/a";
            String nameXpath = "//div[@id=\"PlpItem"+i+"\"]//div[@class='col- Product-Name my-2 min-height-v10']/a";
            String ratingXpath = "//div[@id=\"PlpItem"+i+"\"]//div[@id='ReviewsPLPItemComponent']";

            verifyAndClickIfNeeded(driver, image, "Product Image");
            verifyAndClickIfNeeded(driver, nameXpath, "Product Name");
            verifyAndClickIfNeeded(driver, ratingXpath, "Product Rating");
    }
    private void verifyAndClickIfNeeded(WebDriver driver, String xpath, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            if (element.isDisplayed()) {
                    element.click();
                    System.out.println("Clicked on " + elementName + " — navigating to PDP page.");

                    Thread.sleep(2000);
                    driver.navigate().back();
                    System.out.println("Navigated back to PLP page.");

                    Thread.sleep(4000);
                }
        } catch (Exception e) {
            System.out.println(elementName + " NOT found or not displayed. Xpath: " + xpath);
        }
    }

    public void checkPlpItem(String ProductName) throws InterruptedException {
        WebElementUtil.zoomInOrOut(60);
        Thread.sleep(5000);
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> items = driver.findElements(By.xpath("//div[starts-with(@id, 'PlpItem')]"));
        for (int i = 0; i <=2; i++) {
            if(ProductName.equalsIgnoreCase("Kitchen")){
                checkProductDetail(i);
                verifyKitchenDetails(i);
                verifyAndClickElements(i);
            } else if (ProductName.equalsIgnoreCase("Air Care")) {
                checkProductDetail(i);
                verifyAirCareDetails(i);
                verifyAndClickElements(i);
            }
        }
    }
        public void checkProductDetail(int i){
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[contains(@class, 'Utility-TextProduct-SKU-Sm')]/div[1]", "SKU Number");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- highlight-wapper d-flex f-gap-10']/span", "Left Corner Tag");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- Product-Name my-2 min-height-v10']/a", "Product Name");

            //verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='position-relative imgContainerWithPromotion']/img", "Product Image");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class=\"col- Product-Image-Placeholder\"]/a//img[1]", "Product Image");
           // verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//img[@alt='Frigidaire Gallery' or @alt='Frigidaire Professional']", "Tag Image");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//img[@alt='Frigidaire Gallery' or @alt='Frigidaire Professional']", "Tag Image");

            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@id='ReviewsPLPItemComponent']", "Product Rating");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div//span[@class='col-']//span[contains(text(),'D')]", "Dimension Label");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- product-card my-3 plpPriceAlign featureContainer']/div/div", "Feature Section");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div/span[@class='H3H3_Desktop color-promo-green']", "Discount Price");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div/span[@class='MSRP ml-3']//span", "Original Price");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div/span[@class='MSRP ml-3']//div[@class='tooltip-wrapper']", "MSRP Tooltip Icon");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//input[@type='checkbox']", "Compare Checkbox");

        }

    public void verifyKitchenDetails(int i){
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='min-height-v3 promotionalContainer']//span", "Kit and Accessory");
            verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div[@class='col- Product-Color-Swatch-wrapper d-flex hidden-class-rac']/a", "Color Option");
    }

    public void verifyAirCareDetails(int i){
        verifyElementDisplayed("//div[@id=\"PlpItem"+i+"\"]//div//div//button","Add to cart");

    }

    public void verifyElementDisplayed(String xpath, String elementName) {
        try {
            WebDriver driver = DriverManager.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            boolean isDisplayed = element.isDisplayed();
            System.out.println(elementName + " is displayed: " + isDisplayed + " "+ element.getText());
            softAssert.assertTrue(isDisplayed, elementName + " should be displayed.");
        } catch (Exception e) {
            System.out.println(elementName + " not found or not displayed.");
            softAssert.fail(elementName + " not found or not displayed. Exception: " + e.getMessage());
        }
    }

}
