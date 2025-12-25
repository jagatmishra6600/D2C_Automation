package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DSPInstallationLocatorsFrig;
import com.automation.frigidaire.locators.DSPServiceLocatorsFrig;
import com.automation.utils.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;

public class InstallationAddOnServicesPageActionsFrig {

    public void clickProductBySKU(String sku) throws InterruptedException {

        zoomInOrOut(75);
        Thread.sleep(7000);
        By productClick =By.xpath("//div[text()='" + sku + "']//parent::div//parent::div//div[@class='col- Product-Name my-2 min-height-v10']//a");

        //WebDriver driver= DriverManager.getDriver();
        scrollToElementStable(productClick);
        waitForElementToBeVisible(productClick);
        waitForElementToBeClickable(productClick);
        clickElement(productClick);

        Thread.sleep(3000);
        //WebElement addButton = driver.findElement(DSPServiceLocatorsFrig.addToCartButton);
       // scrollToElement(driver, addButton);
        scrollToElementStable(DSPServiceLocatorsFrig.addToCartButton);
        waitForElementToBeVisible(DSPServiceLocatorsFrig.addToCartButton);
        waitForElementToBeClickable(DSPServiceLocatorsFrig.addToCartButton);
        clickElement(DSPServiceLocatorsFrig.addToCartButton);

    }

    public void validateDeliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        waitForElementToBeVisible(DSPServiceLocatorsFrig.deliverySubTitle);
//        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.deliverySubTitle).isDisplayed(),
//                "'Delivery only' radio button is NOT available!");
        isDisplayed(DSPServiceLocatorsFrig.deliverySubTitle);

        waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton);
//        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.deliveryRadioButton).isDisplayed(),
//                "'Delivery only' radio button is NOT available!");
        isDisplayed(DSPServiceLocatorsFrig.deliveryRadioButton);


//        waitForElementToBeVisible(DSPagesService.deliveryPrice);
//        Assert.assertTrue(driver.findElement(DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only' price is NOT available!");
    }
    public void selectedDeliveryOnly() throws InterruptedException {

        implicitWait(5);
        waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton);
        waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton);
        clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);
        validateElement(DSPInstallationLocatorsFrig.requiredInstallation);
        validateElement(DSPInstallationLocatorsFrig.checkBoxRequired);
        validateElement(DSPInstallationLocatorsFrig.listOfAvailable);
        validateElement(DSPInstallationLocatorsFrig.priceRequired);

    }
    public void selectCheckBoxRequired(){

        waitForElementToBeVisible(DSPInstallationLocatorsFrig.checkBoxRequired);
        waitForElementToBeClickable(DSPInstallationLocatorsFrig.checkBoxRequired);
        clickElement(DSPInstallationLocatorsFrig.checkBoxRequired);

        String actualPriceRequired = getText(DSPInstallationLocatorsFrig.priceRequired);
        String priceRequiredText = actualPriceRequired.replace("$", "").replace(",", "");

        double price = Double.parseDouble(priceRequiredText);


        //WebDriver driver = DriverManager.getDriver();
        //WebElement element = driver.findElement(DSPInstallationLocatorsFrig.subTotal);
        //scrollToElement(driver, element);

        scrollToElementStable(DSPInstallationLocatorsFrig.subTotal);

        String subTotalPrice = getText(DSPInstallationLocatorsFrig.subTotal);

        String subTotalPriceText = subTotalPrice.replace("$", "").replace(",", "");
        double subTotalNumeric = Double.parseDouble(subTotalPriceText);


        double expected = price + subTotalNumeric;

        waitForElementToBeVisible(DSPInstallationLocatorsFrig.totalPrice);
        String totalPriceText = getText(DSPInstallationLocatorsFrig.totalPrice);

        String totalPriceNumeric = totalPriceText.replace("$", "").replace(",", "");
        double totalPriceProduct = Double.parseDouble(totalPriceNumeric);

        Assert.assertEquals(totalPriceProduct, expected," Delivery only error ");
    }
    public void deliveryInstallation(){

        validateElement(DSPInstallationLocatorsFrig.deliveryInstallation);

        validateElement(DSPInstallationLocatorsFrig.deliveryInstallationRadioButton);

        validateElement(DSPInstallationLocatorsFrig.deliveryInstallationTag);

        validateElement(DSPInstallationLocatorsFrig.deliveryInstallationDescription);

        validateElement(DSPInstallationLocatorsFrig.deliveryInstallationPrice);

        validateElement(DSPInstallationLocatorsFrig.deliveryInstallationViewLink);

    }

    public void validateElement(By locator) {
        //WebDriver driver = DriverManager.getDriver();
        waitForElementToBeVisible(locator);
        //WebElement element = driver.findElement(locator);

        //scrollToElement(driver, element);
        scrollToElementStable(locator);
        waitForElementToBeVisible(locator);

        //Assert.assertTrue(element.isDisplayed(), errorMessage);
        isDisplayed(locator);
    }

    public void validateAddOnServicesAreAvailable() {

        validateElement(DSPInstallationLocatorsFrig.addOnService);

//        validateElement(DSPageInstallation.addOnMessage,
//                "Add-on services message is NOT available!");

        validateElement(DSPInstallationLocatorsFrig.haulCheckBox);

        validateElement(DSPInstallationLocatorsFrig.haulText);

        validateElement(DSPInstallationLocatorsFrig.haulDescription);

        validateElement(DSPInstallationLocatorsFrig.haulPrice);

        validateElement(DSPInstallationLocatorsFrig.moveOldCheckBox);

        validateElement(DSPInstallationLocatorsFrig.moveOld);

        validateElement(DSPInstallationLocatorsFrig.moveOldDescription);

        validateElement(DSPInstallationLocatorsFrig.moveOldPrice);
    }

    public void selectHaul(){

        waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton);
        waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton);
        clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        validateElement(DSPInstallationLocatorsFrig.addOnService);
        scrollToElementStable(DSPInstallationLocatorsFrig.addOnService);

        waitForElementToBeClickable(DSPInstallationLocatorsFrig.haulCheckBox);
        clickElement(DSPInstallationLocatorsFrig.haulCheckBox);
        String price = getText(DSPInstallationLocatorsFrig.haulPrice);

        calculatePriceAndAssert(price);
    }

    public void moveOld(){

        waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton);
        waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton);
        clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        validateElement(DSPInstallationLocatorsFrig.addOnService);
        scrollToElementStable(DSPInstallationLocatorsFrig.addOnService);

        waitForElementToBeClickable(DSPInstallationLocatorsFrig.moveOldCheckBox);
        clickElement(DSPInstallationLocatorsFrig.moveOldCheckBox);

        String price = getText(DSPInstallationLocatorsFrig.moveOldPrice);
        calculatePriceAndAssert(price);
    }

    public void calculatePriceAndAssert( String price){
        //WebDriver driver = DriverManager.getDriver();
        double priceAdd = 0;
        if(price.equalsIgnoreCase("Free")){
            priceAdd =0;
        }else {
            String num = price.replace("$", "").replace(",", "");
            priceAdd = Double.parseDouble(num);
        }
        waitForElementToBeVisible(DSPInstallationLocatorsFrig.subTotal);
        //WebElement element = driver.findElement(DSPInstallationLocatorsFrig.subTotal);
        //scrollToElement(driver,element);
        scrollToElementStable(DSPInstallationLocatorsFrig.subTotal);
        String subTotalText = getText(DSPInstallationLocatorsFrig.subTotal);
        String totalPriceNumeric = subTotalText.replace("$", "").replace(",", "");
        double subTotalprice = Double.parseDouble(totalPriceNumeric);
        double expected = priceAdd + subTotalprice;
        waitForElementToBeVisible(DSPInstallationLocatorsFrig.totalPrice);
        String totalprice = getText(DSPInstallationLocatorsFrig.totalPrice);
        String totalPriceActual = totalprice.replace("$", "").replace(",", "");
        double totalA = Double.parseDouble(totalPriceActual);
        Assert.assertEquals(totalA, expected, "Error" );
    }

    public void haulAndMove(){

        waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton);
        waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton);
        clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        validateElement(DSPInstallationLocatorsFrig.addOnService);
        scrollToElementStable(DSPInstallationLocatorsFrig.addOnService);

        waitForElementToBeClickable(DSPInstallationLocatorsFrig.haulCheckBox);
        clickElement(DSPInstallationLocatorsFrig.haulCheckBox);

        waitForElementToBeClickable(DSPInstallationLocatorsFrig.moveOldCheckBox);
        clickElement(DSPInstallationLocatorsFrig.moveOldCheckBox);

        waitForElementToBeVisible(DSPInstallationLocatorsFrig.subTotalAddOnServicePrice);
        String str = getText(DSPInstallationLocatorsFrig.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }

}
