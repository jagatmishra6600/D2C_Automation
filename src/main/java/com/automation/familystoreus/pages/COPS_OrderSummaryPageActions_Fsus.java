package com.automation.familystoreus.pages;

import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class COPS_OrderSummaryPageActions_Fsus {

    public By searchBox = By.xpath("//input[@class='navSearchDirty']");
    public By searchButton = By.xpath("//cx-icon[@class=\"elxIconsSearch search cx-icon fas fa-search\"]");
    public By clickOnProductLink = By.xpath("//a[@class=\"text-decoration-none\"]");

    public By addToCart = By.xpath("//span[text()=' Add to cart ']");
    //public By saveAndViewCart = By.xpath("//button[@class='btn btn-orange btn-block saveViewCart']");
    //public By viewCartButton = By.xpath("//a[@class='btn btn-block btn-orange view-cart']");
    public By viewOrSaveCartButton = By.xpath("//button[@class=\"btn btn-orange btn-block saveViewCart ng-star-inserted\"] | //a[@class='btn btn-block btn-orange view-cart']");
    public By proceedToCheckoutButton = By.xpath("//button[@class='proceedToCheckout btn btn-orange btn-block']");
    public By newAddress = By.xpath("//button[text()=\" Add New Address \"]");

    public By firstNameInput = By.xpath("//input[@id='firstName']");
    public By lastNameInput = By.xpath("//input[@id='lastName']");
    public By addressLine1Input = By.xpath("//input[@id='address-1']");
    public By addressTypeaheadOption = By.xpath("//button[@id='ngb-typeahead-0-1']");
    public By zipCodeInput = By.xpath("//input[@id='zipcode']");
    public By continueToDeliveryButton = By.xpath("//button[@name='continueToDeliveryButton']");
    public By saveAndContinueButton = By.xpath("//button[text()='Save & continue']");

    public By subtotalText(String text) {
        return By.xpath("//div[contains(normalize-space(), '" + text + "')]");
    }

    public void searchProducts(String skuNumber) {

        WaitUtils.sleep(3000);
        WaitUtils.untilPageLoadComplete();
        WebElementUtil.waitForElementToBeVisible(searchBox, 10);
        WebElementUtil.sendKeys(searchBox, skuNumber);

        WebElementUtil.waitForElementToBeClickable(searchButton, 10);
        WebElementUtil.clickElement(searchButton);

        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementStable(clickOnProductLink);
        WebElementUtil.waitForElementToBeVisible(clickOnProductLink,10);
        WebElementUtil.waitForElementToBeClickable(clickOnProductLink,10);
        WebElementUtil.clickElement(clickOnProductLink);
    }

    private void scrollWaitAndClick(By element) {
        WaitUtils.sleep(3000);
        //WebElementUtil.scrollToElementStable(element);
        WebElementUtil.scrollToElementCenter(element);
        WebElementUtil.waitForElementToBeVisible(element, 10);
        WebElementUtil.waitForElementToBeClickable(element, 10);
        WebElementUtil.clickElement(element);
    }

    public void clickOnProductBundle() {
        scrollWaitAndClick(addToCart);
        //scrollWaitAndClick(viewOrSaveCartButton);
    }

    public void clickOnProductRacks() {
        scrollWaitAndClick(addToCart);
        //scrollWaitAndClick(viewOrSaveCartButton);
    }

    public void clickOnProceedCheckout() {
        scrollWaitAndClick(viewOrSaveCartButton);
        scrollWaitAndClick(proceedToCheckoutButton);
    }

    public void enterAddressDetails(String zipCode) {

        try {
            scrollWaitAndClick(newAddress);

            WebElementUtil.waitForElementToBeVisible(firstNameInput, 10);
            WebElementUtil.sendKeys(firstNameInput, "Tester");

            WebElementUtil.waitForElementToBeVisible(lastNameInput, 10);
            WebElementUtil.sendKeys(lastNameInput, "Test");

            WebElementUtil.waitForElementToBeVisible(addressLine1Input, 10);
            WebElementUtil.sendKeys(addressLine1Input, zipCode);

            WebElementUtil.waitForElementToBeVisible(addressTypeaheadOption, 10);
            WebElementUtil.clickElement(addressTypeaheadOption);

            WaitUtils.sleep(3000);
            WebElementUtil.waitForElementToBeVisible(zipCodeInput, 10);
            WebElementUtil.sendKeys(zipCodeInput, zipCode);

            WebElementUtil.waitForElementToBeVisible(continueToDeliveryButton, 10);
            WebElementUtil.clickElement(continueToDeliveryButton);

            WebElementUtil.waitForElementToBeVisible(saveAndContinueButton, 10);
            WebElementUtil.clickElement(saveAndContinueButton);
        } catch (Exception e) {

        }
    }

    public void verifySubtotal(String text) {
        try {
            WebElementUtil.waitForElementToBeVisible(subtotalText(text), 10);
            WebElementUtil.isDisplayed(subtotalText(text));
        } catch (Exception e) {
        }
    }
}
