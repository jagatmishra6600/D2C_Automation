package com.automation.electrolux.pages;

import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.testng.Assert;

public class ElectroluxFAQ {

    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    private final By faqQuestion = By.xpath("//div[@id=\"faqs\"]//div[@class=\"pdp_faq_accordion accordion\"]/div[1]");
    private final By helpFullTab=By.xpath("//div[span[text()=\"Helpful?\"]]//span[@role=\"button\"]");
    private final By collapsedButton=By.xpath("//div[@id=\"faqs\"]//div[@class=\"pdp_faq_accordion accordion\"]//span[@class=\"icon-plus\"]");
    private final By viewMore = By.xpath("//button[contains(normalize-space(text()), 'View all FAQs')]\n");
    private final By viewLess = By.xpath("//button[contains(normalize-space(text()), 'View less FAQs')]\n");
    private final By faqTab = By.xpath("//div[span[text()=\"FAQs\"]]");
    private final By faqText = By.xpath("//div[@id=\"faqs\"]/h2");



    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        WebElementUtil.clickElement(emailPopUp);
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
            WebElement faqTabElement = driver.findElement(faqTab);
            WebElementUtil.scrollToElement(driver, faqTabElement);
            WebElementUtil.scrollToElementStable(faqTab);
            WebElementUtil.waitForElementToBeClickable(faqTab);
            WebElementUtil.clickElement(faqTab);


            Thread.sleep(5000);
            WebElementUtil.zoomInOrOut(70);
            WebElement faqTextElement = driver.findElement(faqText);
            WebElementUtil.scrollToElement(driver,faqTextElement);
            WebElementUtil.waitForElementToBeVisible(faqText);

            WebElement element = driver.findElement(faqQuestion);
            WebElementUtil.scrollToElement(driver,element);
            WebElementUtil.waitForElementToBeVisible(faqQuestion);
            WebElementUtil.waitForElementToBeClickable(faqQuestion);
            WebElementUtil.clickElement(faqQuestion);

            WebElementUtil.waitForElementToBeVisible(helpFullTab);
            WebElement helpTab= DriverManager.getDriver().findElement(helpFullTab);
            Assert.assertTrue(helpTab.isDisplayed());

            WebElementUtil.waitForElementToBeClickable(collapsedButton);
            WebElementUtil.clickElement(collapsedButton);

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
            WebElement viewMoreElement = driver.findElement(viewMore);
            WebElementUtil.scrollToElement(driver, viewMoreElement);
            WebElementUtil.waitForElementToBeVisible(viewMore);
            WebElementUtil.clickElement(viewMore);
            WebElement viewLessText= driver.findElement(viewLess);
            String viewLessTexts= viewLessText.getText();
            System.out.println("View less");
            Assert.assertTrue(viewLessTexts.contains("View less FAQs"));

            Thread.sleep(5000);
            WebElementUtil.waitForElementToBeClickable(viewLess);
            WebElementUtil.clickElement(viewLess);
            WebElement viewMoreText= driver.findElement(viewMore);
            String viewMoreTexts= viewMoreText.getText();
            System.out.println("View more");
            Assert.assertTrue(viewMoreTexts.contains("View all FAQs"));

        } catch (Exception e) {
            System.out.println(" View more FAQs button not present — fewer FAQs available.");
        }
    }
}
