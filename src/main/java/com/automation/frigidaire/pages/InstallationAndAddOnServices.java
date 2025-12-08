package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DSPageInstallation;
import com.automation.frigidaire.locators.DSPagesService;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InstallationAndAddOnServices {

    public void clickProductBySKU(String sku, String Website) throws InterruptedException {

        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(7000);
        By productClick = null;

        if(Website.equalsIgnoreCase("Frigidaire")){
            productClick=By.xpath("//div[text()='" + sku + "']//parent::div//parent::div//div[@class='col- Product-Name my-2 min-height-v10']//a");

        } else if (Website.equalsIgnoreCase("Electrolux")) {
            productClick=By.xpath("//div[text()='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");
        }
        else {
        }
        WebDriver driver= DriverManager.getDriver();
        WebElement productSKUNumber= driver.findElement(productClick);
        WebElementUtil.scrollToElementStable(productClick);
        WebElementUtil.waitForElementToBeVisible(productClick, 10);
        WebElementUtil.waitForElementToBeClickable(productClick, 10);
        WebElementUtil.clickElement(productClick);

        Thread.sleep(3000);
        WebElement addButton = driver.findElement(DSPagesService.addToCartButton);
        WebElementUtil.scrollToElement(driver, addButton);
        WebElementUtil.scrollToElementStable(DSPagesService.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(DSPagesService.addToCartButton, 10);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.addToCartButton, 10);
        WebElementUtil.clickElement(DSPagesService.addToCartButton);

    }

    public void validateDeliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliverySubTitle);
        Assert.assertTrue(driver.findElement(DSPagesService.deliverySubTitle).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliveryRadioButton);
        Assert.assertTrue(driver.findElement(DSPagesService.deliveryRadioButton).isDisplayed(),
                "'Delivery only' radio button is NOT available!");


//        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliveryPrice);
//        Assert.assertTrue(driver.findElement(DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only' price is NOT available!");
    }
    public void selectedDeliveryOnly() throws InterruptedException {

        WaitUtils.implicitWait(5);
        WebElementUtil.waitForElementToBeVisible(DSPagesService.deliveryRadioButton);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        validateElement(DSPageInstallation.requiredInstallation,
                "Required Installation is not available");

        validateElement(DSPageInstallation.checkBoxRequired,
                "Required check box is not available");

        validateElement(DSPageInstallation.listOfAvailable,
                "Required Installation list of available is not available");

        validateElement(DSPageInstallation.priceRequired,
                "Required Installation price is not available");

    }
    public void selectCheckBoxRequired(){

        WebElementUtil.waitForElementToBeVisible(DSPageInstallation.checkBoxRequired);
        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.checkBoxRequired, 10);
        WebElementUtil.clickElement(DSPageInstallation.checkBoxRequired);

        String actualPriceRequired = WebElementUtil.getText(DSPageInstallation.priceRequired);
        String priceRequiredText = actualPriceRequired.replace("$", "").replace(",", "");

        double price = Double.parseDouble(priceRequiredText);


        WebDriver driver = DriverManager.getDriver();
        WebElement element = driver.findElement(DSPageInstallation.subTotal);
        WebElementUtil.scrollToElement(driver, element);

        String subTotalPrice = WebElementUtil.getText(DSPageInstallation.subTotal);

        String subTotalPriceText = subTotalPrice.replace("$", "").replace(",", "");
        double subTotalNumeric = Double.parseDouble(subTotalPriceText);


        double expected = price + subTotalNumeric;

        WebElementUtil.waitForElementToBeVisible(DSPageInstallation.totalPrice);
        String totalPriceText = WebElementUtil.getText(DSPageInstallation.totalPrice);

        String totalPriceNumeric = totalPriceText.replace("$", "").replace(",", "");
        double totalPriceProduct = Double.parseDouble(totalPriceNumeric);

        Assert.assertEquals(totalPriceProduct, expected," Delivery only error ");
    }
    public void deliveryInstallation(){

        validateElement(DSPageInstallation.deliveryInstallation,
                "Delivery & installation option is NOT displayed!");

        validateElement(DSPageInstallation.deliveryInstallationRadioButton,
                "Delivery & installation radio button is NOT displayed!");

        validateElement(DSPageInstallation.deliveryInstallationTag,
                "Recommended tag is NOT displayed!");

        validateElement(DSPageInstallation.deliveryInstallationDescription,
                "Description for Delivery & installation is NOT displayed!");

        validateElement(DSPageInstallation.deliveryInstallationPrice,
                "Price for Delivery & installation is NOT displayed!");

        validateElement(DSPageInstallation.deliveryInstallationViewLink,
                "'View included parts and additional details' link is NOT displayed!");

    }

    public void professionalInstallation (){

        validateElement(DSPageInstallation.professionalInstallation,
                "Delivery & installation option is NOT displayed!");

        validateElement(DSPageInstallation.professionalInstallationRadioButton,
                "Delivery & installation radio button is NOT displayed!");

//        validateElement(DSPageInstallation.professionalInstallationTag,
//                "Recommended tag is NOT displayed!");

        validateElement(DSPageInstallation.professionalInstallationDescription,
                "Description for Delivery & installation is NOT displayed!");

        validateElement(DSPageInstallation.professionalInstallationPrice,
                "Price for Delivery & installation is NOT displayed!");

        validateElement(DSPageInstallation.professionalInstallationViewLink,
                "'View included parts and additional details' link is NOT displayed!");
    }

    public void validateElement(By locator, String errorMessage) {
        WebDriver driver = DriverManager.getDriver();
        WebElementUtil.waitForElementToBeVisible(locator, 15);
        WebElement element = driver.findElement(locator);

        WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.waitForElementToBeVisible(locator);

        Assert.assertTrue(element.isDisplayed(), errorMessage);
    }

    public void validateAddOnServicesAreAvailable() {

        validateElement(DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

//        validateElement(DSPageInstallation.addOnMessage,
//                "Add-on services message is NOT available!");

        validateElement(DSPageInstallation.haulCheckBox,
                "'Haul away / dispose old appliance' checkbox is NOT available!");

        validateElement(DSPageInstallation.haulText,
                "Haul away text is Not available!");

        validateElement(DSPageInstallation.haulDescription,
                "'Haul away / dispose old appliance' description is NOT available!");

        validateElement(DSPageInstallation.haulPrice,
                "'Haul away / dispose old appliance' price is NOT available!");

        validateElement(DSPageInstallation.moveOldCheckBox,
                "'Move old unit to another room' checkbox is NOT available!");

        validateElement(DSPageInstallation.moveOld,
                "Move old text is Not available!");

        validateElement(DSPageInstallation.moveOldDescription,
                "'Move old unit to another room' description is NOT available!");

        validateElement(DSPageInstallation.moveOldPrice,
                "'Move old unit to another room' price is NOT available!");


    }
    public void validateDoorSwing(){
        validateElement(DSPageInstallation.doorSwing,
                "Door swing option is Not available!");

        validateElement(DSPageInstallation.doorSwingRadioButton,
                "Door swing Radio button is Not available!");

        validateElement(DSPageInstallation.doorSwingPrice,
                "Door swing price is Not available!");
    }

    public void selectHaul() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        validateElement(DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.haulCheckBox);
        WebElementUtil.clickElement(DSPageInstallation.haulCheckBox);
        String price = WebElementUtil.getText(DSPageInstallation.haulPrice);

        calculatePriceAndAssert(price);
    }

    public void moveOld() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        validateElement(DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.moveOldCheckBox);
        WebElementUtil.clickElement(DSPageInstallation.moveOldCheckBox);

        String price = WebElementUtil.getText(DSPageInstallation.moveOldPrice);
        calculatePriceAndAssert(price);
    }

    public void doorSwing() throws InterruptedException {
        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        validateElement(DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.doorSwingRadioButton);
        WebElementUtil.clickElement(DSPageInstallation.doorSwingRadioButton);

        String price = WebElementUtil.getText(DSPageInstallation.doorSwingPrice);
        calculatePriceAndAssert(price);
    }
    public void calculatePriceAndAssert( String price){
        WebDriver driver = DriverManager.getDriver();
        double priceAdd = 0;
        if(price.equalsIgnoreCase("Free")){
            priceAdd =0;
        }else {
            String num = price.replace("$", "").replace(",", "");
            priceAdd = Double.parseDouble(num);
        }
        WebElementUtil.waitForElementToBeVisible(DSPageInstallation.subTotal);
        WebElement element = driver.findElement(DSPageInstallation.subTotal);
        WebElementUtil.scrollToElement(driver,element);
        String subTotalText = WebElementUtil.getText(DSPageInstallation.subTotal);
        String totalPriceNumeric = subTotalText.replace("$", "").replace(",", "");
        double subTotalprice = Double.parseDouble(totalPriceNumeric);
        double expected = priceAdd + subTotalprice;
        WebElementUtil.waitForElementToBeVisible(DSPageInstallation.totalPrice);
        String totalprice = WebElementUtil.getText(DSPageInstallation.totalPrice);
        String totalPriceActual = totalprice.replace("$", "").replace(",", "");
        double totalA = Double.parseDouble(totalPriceActual);
        Assert.assertEquals(totalA, expected, "Error" );
    }

    public void haulAndMove() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        validateElement(DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.haulCheckBox);
        WebElementUtil.clickElement(DSPageInstallation.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.moveOldCheckBox);
        WebElementUtil.clickElement(DSPageInstallation.moveOldCheckBox);

        WebElementUtil.waitForElementToBeVisible(DSPageInstallation.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPageInstallation.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }

    public void haulAndDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        validateElement(DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.haulCheckBox);
        WebElementUtil.clickElement(DSPageInstallation.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.doorSwingRadioButton);
        WebElementUtil.clickElement(DSPageInstallation.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPageInstallation.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPageInstallation.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }
    public void moveAndDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        validateElement(DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.moveOldCheckBox);
        WebElementUtil.clickElement(DSPageInstallation.moveOldCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.doorSwingRadioButton);
        WebElementUtil.clickElement(DSPageInstallation.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPageInstallation.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPageInstallation.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }
    public void haulMoveDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(DSPagesService.deliveryRadioButton);

        validateElement(DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.haulCheckBox);
        WebElementUtil.clickElement(DSPageInstallation.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.moveOldCheckBox);
        WebElementUtil.clickElement(DSPageInstallation.moveOldCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallation.doorSwingRadioButton);
        WebElementUtil.clickElement(DSPageInstallation.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPageInstallation.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPageInstallation.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }

}
