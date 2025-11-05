package com.automation.electrolux.pages;

import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.testng.Assert;

public class ElectroluxFAQ {

    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    private final By faqQuestion = By.xpath("//div[@id=\"faqs\"]//div[@class=\"pdp_faq_accordion accordion\"]/div[1]");
    private final By helpFullTab=By.xpath("//div[span[text()=\"Helpful?\"]]//span[@role=\"button\"]");
    private final By collapsedButton=By.xpath("//div[@id=\"faqs\"]//div[@class=\"pdp_faq_accordion accordion\"]//span[@class=\"icon-plus\"]");
    private final By viewMore = By.xpath("//button[contains(normalize-space(text()), 'View all FAQs')]\n");
    private final By viewLess = By.xpath("//button[contains(normalize-space(text()), 'View less FAQs')]\n");

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        WebElementUtil.clickElement(emailPopUp);
    }

    public void productNameClick(String productName) {
        WebElementUtil.zoomInOrOut(40);
        By productXpath = By.xpath("//a[div[contains(text(), '" + productName + "')]]");
        WebElementUtil.clickElement(productXpath);
        System.out.println("Clicked on product: ");
    }

    public void productFAQsSection() {
        try {
            By faqTab=By.xpath("//div[span[text()=\"FAQs\"]]");
            WebElementUtil.waitForElementToBeClickable(faqTab);
            WebElementUtil.clickElement(faqTab);
            Thread.sleep(1000);

            WebElementUtil.zoomInOrOut(40);
            By faqText = By.xpath("//div[@id=\"faqs\"]/h2");
            WebElementUtil.waitForElementToBeVisible(faqText);

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
            WebElementUtil.waitForElementToBeVisible(viewMore);
            WebElementUtil.clickElement(viewMore);
            WebElement viewLessText= driver.findElement(viewLess);
            String viewLessTexts= viewLessText.getText();
            Assert.assertTrue(viewLessTexts.contains("View less FAQs"));
            Thread.sleep(5000);

            WebElementUtil.waitForElementToBeClickable(viewLess);
            WebElementUtil.clickElement(viewLess);
            WebElement viewMoreText= driver.findElement(viewLess);
            String viewMoreTexts= viewMoreText.getText();
            Assert.assertTrue(viewMoreTexts.contains("View all FAQs"));
        } catch (Exception e) {
            System.out.println(" View more FAQs button not present — fewer FAQs available.");
        }
    }
}
