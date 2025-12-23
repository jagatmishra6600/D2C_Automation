package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class OrderSummaryForCheckOutPage1Frig {


    public static final By ORDER_SUMMARY_HEADING = By.xpath("//h4[normalize-space()='Order summary']");
    public static final By SUBTOTALPRICE= By.xpath("//div[contains(@class, 'Utility-TextPrice-Sm mb-4')]");
    public static final By INSTALLATION_PARTS_PRICE =By.xpath("");
    public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div");

    public final By subTotalPrice = By.xpath("//div[contains(@class,'Utility-TextPrice-Sm mb-4')]");

}
