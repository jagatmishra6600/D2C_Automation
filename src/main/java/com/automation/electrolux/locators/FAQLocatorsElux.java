package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class FAQLocatorsElux {

    public static final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    public static final By faqQuestion = By.xpath("//div[@id=\"faqs\"]//div[@class=\"pdp_faq_accordion accordion\"]/div[1]");
    public static final By helpFullTab=By.xpath("//div[span[text()=\"Helpful?\"]]//span[@role=\"button\"]");
    public static final By collapsedButton=By.xpath("//div[@id=\"faqs\"]//div[@class=\"pdp_faq_accordion accordion\"]//span[@class=\"icon-plus\"]");
    public static final By viewMore = By.xpath("//button[contains(normalize-space(text()), 'View all FAQs')]\n");
    public static final By viewLess = By.xpath("//button[contains(normalize-space(text()), 'View less FAQs')]\n");
    public static final By faqTab = By.xpath("//div[span[text()=\"FAQs\"]]");
    public static final By faqText = By.xpath("//div[@id=\"faqs\"]/h2");
}
