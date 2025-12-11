package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DSPInstallationLocatorsFrig;
import com.automation.frigidaire.locators.DSPServiceLocatorsFrig;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InstallationAddOnServicesPageActionFrig {

    public void clickProductBySKU(String sku) throws InterruptedException {

        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(7000);
        By productClick =By.xpath("//div[text()='" + sku + "']//parent::div//parent::div//div[@class='col- Product-Name my-2 min-height-v10']//a");

        //WebDriver driver= DriverManager.getDriver();
        WebElementUtil.scrollToElementStable(productClick);
        WebElementUtil.waitForElementToBeVisible(productClick, 10);
        WebElementUtil.waitForElementToBeClickable(productClick, 10);
        WebElementUtil.clickElement(productClick);

        Thread.sleep(3000);
        //WebElement addButton = driver.findElement(DSPServiceLocatorsFrig.addToCartButton);
       // WebElementUtil.scrollToElement(driver, addButton);
        WebElementUtil.scrollToElementStable(DSPServiceLocatorsFrig.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.addToCartButton, 10);
        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.addToCartButton, 10);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.addToCartButton);

    }

    public void validateDeliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliverySubTitle,10);
//        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.deliverySubTitle).isDisplayed(),
//                "'Delivery only' radio button is NOT available!");
        WebElementUtil.isDisplayed(DSPServiceLocatorsFrig.deliverySubTitle);

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton,10);
//        Assert.assertTrue(driver.findElement(DSPServiceLocatorsFrig.deliveryRadioButton).isDisplayed(),
//                "'Delivery only' radio button is NOT available!");
        WebElementUtil.isDisplayed(DSPServiceLocatorsFrig.deliveryRadioButton);


//        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliveryPrice);
//        Assert.assertTrue(driver.findElement(DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only' price is NOT available!");
    }
    public void selectedDeliveryOnly() throws InterruptedException {

        WaitUtils.implicitWait(5);
        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        validateElement(DSPInstallationLocatorsFrig.requiredInstallation);

        validateElement(DSPInstallationLocatorsFrig.checkBoxRequired);

        validateElement(DSPInstallationLocatorsFrig.listOfAvailable);

        validateElement(DSPInstallationLocatorsFrig.priceRequired);

    }
    public void selectCheckBoxRequired(){

        WebElementUtil.waitForElementToBeVisible(DSPInstallationLocatorsFrig.checkBoxRequired, 10);
        WebElementUtil.waitForElementToBeClickable(DSPInstallationLocatorsFrig.checkBoxRequired, 10);
        WebElementUtil.clickElement(DSPInstallationLocatorsFrig.checkBoxRequired);

        String actualPriceRequired = WebElementUtil.getText(DSPInstallationLocatorsFrig.priceRequired);
        String priceRequiredText = actualPriceRequired.replace("$", "").replace(",", "");

        double price = Double.parseDouble(priceRequiredText);


        //WebDriver driver = DriverManager.getDriver();
        //WebElement element = driver.findElement(DSPInstallationLocatorsFrig.subTotal);
        //WebElementUtil.scrollToElement(driver, element);

        WebElementUtil.scrollToElementStable(DSPInstallationLocatorsFrig.subTotal);

        String subTotalPrice = WebElementUtil.getText(DSPInstallationLocatorsFrig.subTotal);

        String subTotalPriceText = subTotalPrice.replace("$", "").replace(",", "");
        double subTotalNumeric = Double.parseDouble(subTotalPriceText);


        double expected = price + subTotalNumeric;

        WebElementUtil.waitForElementToBeVisible(DSPInstallationLocatorsFrig.totalPrice);
        String totalPriceText = WebElementUtil.getText(DSPInstallationLocatorsFrig.totalPrice);

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
        WebElementUtil.waitForElementToBeVisible(locator, 15);
        //WebElement element = driver.findElement(locator);

        //WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.waitForElementToBeVisible(locator);

        //Assert.assertTrue(element.isDisplayed(), errorMessage);
        WebElementUtil.isDisplayed(locator);
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

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton,10);
        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        validateElement(DSPInstallationLocatorsFrig.addOnService);
        WebElementUtil.scrollToElementStable(DSPInstallationLocatorsFrig.addOnService);

        WebElementUtil.waitForElementToBeClickable(DSPInstallationLocatorsFrig.haulCheckBox);
        WebElementUtil.clickElement(DSPInstallationLocatorsFrig.haulCheckBox);
        String price = WebElementUtil.getText(DSPInstallationLocatorsFrig.haulPrice);

        calculatePriceAndAssert(price);
    }

    public void moveOld(){

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton,10);
        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        validateElement(DSPInstallationLocatorsFrig.addOnService);
        WebElementUtil.scrollToElementStable(DSPInstallationLocatorsFrig.addOnService);

        WebElementUtil.waitForElementToBeClickable(DSPInstallationLocatorsFrig.moveOldCheckBox);
        WebElementUtil.clickElement(DSPInstallationLocatorsFrig.moveOldCheckBox);

        String price = WebElementUtil.getText(DSPInstallationLocatorsFrig.moveOldPrice);
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
        WebElementUtil.waitForElementToBeVisible(DSPInstallationLocatorsFrig.subTotal);
        //WebElement element = driver.findElement(DSPInstallationLocatorsFrig.subTotal);
        //WebElementUtil.scrollToElement(driver,element);
        WebElementUtil.scrollToElementStable(DSPInstallationLocatorsFrig.subTotal);
        String subTotalText = WebElementUtil.getText(DSPInstallationLocatorsFrig.subTotal);
        String totalPriceNumeric = subTotalText.replace("$", "").replace(",", "");
        double subTotalprice = Double.parseDouble(totalPriceNumeric);
        double expected = priceAdd + subTotalprice;
        WebElementUtil.waitForElementToBeVisible(DSPInstallationLocatorsFrig.totalPrice);
        String totalprice = WebElementUtil.getText(DSPInstallationLocatorsFrig.totalPrice);
        String totalPriceActual = totalprice.replace("$", "").replace(",", "");
        double totalA = Double.parseDouble(totalPriceActual);
        Assert.assertEquals(totalA, expected, "Error" );
    }

    public void haulAndMove(){

        WebElementUtil.waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        validateElement(DSPInstallationLocatorsFrig.addOnService);
        WebElementUtil.scrollToElementStable(DSPInstallationLocatorsFrig.addOnService);

        WebElementUtil.waitForElementToBeClickable(DSPInstallationLocatorsFrig.haulCheckBox);
        WebElementUtil.clickElement(DSPInstallationLocatorsFrig.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPInstallationLocatorsFrig.moveOldCheckBox);
        WebElementUtil.clickElement(DSPInstallationLocatorsFrig.moveOldCheckBox);

        WebElementUtil.waitForElementToBeVisible(DSPInstallationLocatorsFrig.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPInstallationLocatorsFrig.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }

}
