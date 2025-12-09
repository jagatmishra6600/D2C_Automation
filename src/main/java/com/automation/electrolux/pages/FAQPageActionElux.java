package com.automation.electrolux.pages;

import com.automation.electrolux.locators.FAQLocatorsElux;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.testng.Assert;

public class FAQPageActionElux {


    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(FAQLocatorsElux.emailPopUp, 60);
        WebElementUtil.clickElement(FAQLocatorsElux.emailPopUp);
    }

    public void productNameClick(String sku) {
        WebDriver driver = DriverManager.getDriver();
        WebElementUtil.zoomInOrOut(75);
        WaitUtils.implicitWait(5);

        By productXpath = By.xpath(
                "//div[text()='" + sku + "']/parent::div/parent::div/parent::div/parent::div//div[@class='col- product-card-inner-row kit']//a"
        );

        WebElement element = driver.findElement(productXpath);
        WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.scrollToElementStable(productXpath);
        WebElementUtil.clickElement(productXpath);
        System.out.println("Clicked on product: ");
    }

    public void productFAQsSection() {
        WebDriver driver = DriverManager.getDriver();
        WaitUtils.implicitWait(5);

        try {
            WebElement faqTabElement = driver.findElement(FAQLocatorsElux.faqTab);
            WebElementUtil.scrollToElement(driver, faqTabElement);
            WebElementUtil.scrollToElementStable(FAQLocatorsElux.faqTab);
            WebElementUtil.waitForElementToBeClickable(FAQLocatorsElux.faqTab);
            WebElementUtil.clickElement(FAQLocatorsElux.faqTab);


            Thread.sleep(5000);
            WebElementUtil.zoomInOrOut(70);
            WebElement faqTextElement = driver.findElement(FAQLocatorsElux.faqText);
            WebElementUtil.scrollToElement(driver,faqTextElement);
            WebElementUtil.waitForElementToBeVisible(FAQLocatorsElux.faqText);

            WebElement element = driver.findElement(FAQLocatorsElux.faqQuestion);
            WebElementUtil.scrollToElement(driver,element);
            WebElementUtil.waitForElementToBeVisible(FAQLocatorsElux.faqQuestion);
            WebElementUtil.waitForElementToBeClickable(FAQLocatorsElux.faqQuestion);
            WebElementUtil.clickElement(FAQLocatorsElux.faqQuestion);

            WebElementUtil.waitForElementToBeVisible(FAQLocatorsElux.helpFullTab);
            WebElement helpTab= DriverManager.getDriver().findElement(FAQLocatorsElux.helpFullTab);
            Assert.assertTrue(helpTab.isDisplayed());

            WebElementUtil.waitForElementToBeClickable(FAQLocatorsElux.collapsedButton);
            WebElementUtil.clickElement(FAQLocatorsElux.collapsedButton);

            checkViewMore();

            System.out.println(" FAQ section verification completed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" FAQ verification failed due to: " + e.getMessage());
        }
    }
    public void checkViewMore() {
        try {
            WebDriver driver=DriverManager.getDriver();
            WebElement viewMoreElement = driver.findElement(FAQLocatorsElux.viewMore);
            WebElementUtil.scrollToElement(driver, viewMoreElement);
            WebElementUtil.waitForElementToBeVisible(FAQLocatorsElux.viewMore);
            WebElementUtil.clickElement(FAQLocatorsElux.viewMore);
            WebElement viewLessText= driver.findElement(FAQLocatorsElux.viewLess);
            String viewLessTexts= viewLessText.getText();
            System.out.println("View less");
            Assert.assertTrue(viewLessTexts.contains("View less FAQs"));

            Thread.sleep(5000);
            WebElementUtil.waitForElementToBeClickable(FAQLocatorsElux.viewLess);
            WebElementUtil.clickElement(FAQLocatorsElux.viewLess);
            WebElement viewMoreText= driver.findElement(FAQLocatorsElux.viewMore);
            String viewMoreTexts= viewMoreText.getText();
            System.out.println("View more");
            Assert.assertTrue(viewMoreTexts.contains("View all FAQs"));

        } catch (Exception e) {
            System.out.println(" View more FAQs button not present — fewer FAQs available.");
        }
    }
}
