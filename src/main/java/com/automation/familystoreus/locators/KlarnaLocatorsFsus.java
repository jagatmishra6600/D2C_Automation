package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class KlarnaLocatorsFsus {

    public final By selectDate =
            By.xpath("(//label[@class=\"cx-delivery-label avaliableDates\"])[1]");

    public final By continueToBilling =
            By.xpath("//button[normalize-space(text())='Continue to billing']");

    public final By klarnaPaymentOption =
            By.xpath("//img[@alt=\"Klarna\"]/parent::label//input[@name=\"paymentOption\"]\n");

    public final By continueWithKlarnaButton =
            By.xpath("//button[normalize-space(text())='Continue with Klarna']");

    public final By klarnaTitle =
            By.xpath("//h1[@id=\"title\"]");

    public final By enterPhoneNumber = By.xpath("//input[@id=\"phone\"]\n");
}
