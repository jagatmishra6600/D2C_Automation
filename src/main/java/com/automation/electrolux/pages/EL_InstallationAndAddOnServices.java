package com.automation.electrolux.pages;


import com.automation.electrolux.locators.EL_DSPageInstallation;
import com.automation.electrolux.locators.EL_DSPagesService;
import com.automation.frigidaire.locators.DSPagesService;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EL_InstallationAndAddOnServices {


    public void clickProductBySKU(String sku) throws InterruptedException {

        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(7000);
        By productClick =By.xpath("//div[text()='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");
        WebDriver driver= DriverManager.getDriver();
        WebElementUtil.scrollToElementStable(productClick);
        WebElementUtil.waitForElementToBeVisible(productClick, 10);
        WebElementUtil.waitForElementToBeClickable(productClick, 10);
        WebElementUtil.clickElement(productClick);

        Thread.sleep(3000);
        WebElement addButton = driver.findElement(EL_DSPagesService.addToCartButton);
        WebElementUtil.scrollToElement(driver, addButton);
        WebElementUtil.scrollToElementStable(EL_DSPagesService.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.addToCartButton, 10);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.addToCartButton, 10);
        WebElementUtil.clickElement(EL_DSPagesService.addToCartButton);

    }

    public void validateDeliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliverySubTitle);
        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliverySubTitle).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliveryRadioButton);
        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliveryRadioButton).isDisplayed(),
                "'Delivery only' radio button is NOT available!");


//        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliveryPrice);
//        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only' price is NOT available!");
    }
    public void selectedDeliveryOnly() throws InterruptedException {

        WaitUtils.implicitWait(5);
        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliveryRadioButton);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton, 10);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        validateElement(EL_DSPageInstallation.requiredInstallation,
                "Required Installation is not available");

        validateElement(EL_DSPageInstallation.checkBoxRequired,
                "Required check box is not available");

        validateElement(EL_DSPageInstallation.listOfAvailable,
                "Required Installation list of available is not available");

        validateElement(EL_DSPageInstallation.priceRequired,
                "Required Installation price is not available");

    }
    public void selectCheckBoxRequired(){

        WebElementUtil.waitForElementToBeVisible(EL_DSPageInstallation.checkBoxRequired);
        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.checkBoxRequired, 10);
        WebElementUtil.clickElement(EL_DSPageInstallation.checkBoxRequired);

        String actualPriceRequired = WebElementUtil.getText(EL_DSPageInstallation.priceRequired);
        String priceRequiredText = actualPriceRequired.replace("$", "").replace(",", "");

        double price = Double.parseDouble(priceRequiredText);


        WebDriver driver = DriverManager.getDriver();
        WebElement element = driver.findElement(EL_DSPageInstallation.subTotal);
        WebElementUtil.scrollToElement(driver, element);

        String subTotalPrice = WebElementUtil.getText(EL_DSPageInstallation.subTotal);

        String subTotalPriceText = subTotalPrice.replace("$", "").replace(",", "");
        double subTotalNumeric = Double.parseDouble(subTotalPriceText);


        double expected = price + subTotalNumeric;

        WebElementUtil.waitForElementToBeVisible(EL_DSPageInstallation.totalPrice);
        String totalPriceText = WebElementUtil.getText(EL_DSPageInstallation.totalPrice);

        String totalPriceNumeric = totalPriceText.replace("$", "").replace(",", "");
        double totalPriceProduct = Double.parseDouble(totalPriceNumeric);

        Assert.assertEquals(totalPriceProduct, expected," Delivery only error ");
    }
    public void deliveryInstallation(){

        validateElement(EL_DSPageInstallation.deliveryInstallation,
                "Delivery & installation option is NOT displayed!");

        validateElement(EL_DSPageInstallation.deliveryInstallationRadioButton,
                "Delivery & installation radio button is NOT displayed!");

        validateElement(EL_DSPageInstallation.deliveryInstallationTag,
                "Recommended tag is NOT displayed!");

        validateElement(EL_DSPageInstallation.deliveryInstallationDescription,
                "Description for Delivery & installation is NOT displayed!");

        validateElement(EL_DSPageInstallation.deliveryInstallationPrice,
                "Price for Delivery & installation is NOT displayed!");

        validateElement(EL_DSPageInstallation.deliveryInstallationViewLink,
                "'View included parts and additional details' link is NOT displayed!");

    }

    public void professionalInstallation (){

        validateElement(EL_DSPageInstallation.professionalInstallation,
                "Delivery & installation option is NOT displayed!");

        validateElement(EL_DSPageInstallation.professionalInstallationRadioButton,
                "Delivery & installation radio button is NOT displayed!");

//        validateElement(EL_DSPageInstallation.professionalInstallationTag,
//                "Recommended tag is NOT displayed!");

        validateElement(EL_DSPageInstallation.professionalInstallationDescription,
                "Description for Delivery & installation is NOT displayed!");

        validateElement(EL_DSPageInstallation.professionalInstallationPrice,
                "Price for Delivery & installation is NOT displayed!");

        validateElement(EL_DSPageInstallation.professionalInstallationViewLink,
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

        validateElement(EL_DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");

//        validateElement(EL_DSPageInstallation.addOnMessage,
//                "Add-on services message is NOT available!");

        validateElement(EL_DSPageInstallation.haulCheckBox,
                "'Haul away / dispose old appliance' checkbox is NOT available!");

        validateElement(EL_DSPageInstallation.haulText,
                "Haul away text is Not available!");

        validateElement(EL_DSPageInstallation.haulDescription,
                "'Haul away / dispose old appliance' description is NOT available!");

        validateElement(EL_DSPageInstallation.haulPrice,
                "'Haul away / dispose old appliance' price is NOT available!");

        validateElement(EL_DSPageInstallation.moveOldCheckBox,
                "'Move old unit to another room' checkbox is NOT available!");

        validateElement(EL_DSPageInstallation.moveOld,
                "Move old text is Not available!");

        validateElement(EL_DSPageInstallation.moveOldDescription,
                "'Move old unit to another room' description is NOT available!");

        validateElement(EL_DSPageInstallation.moveOldPrice,
                "'Move old unit to another room' price is NOT available!");


    }
    public void validateDoorSwing(){
        validateElement(EL_DSPageInstallation.doorSwing,
                "Door swing option is Not available!");

        validateElement(EL_DSPageInstallation.doorSwingRadioButton,
                "Door swing Radio button is Not available!");

        validateElement(EL_DSPageInstallation.doorSwingPrice,
                "Door swing price is Not available!");
    }

    public void selectHaul() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        validateElement(EL_DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(EL_DSPageInstallation.addOnService);

        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.haulCheckBox);
        WebElementUtil.clickElement(EL_DSPageInstallation.haulCheckBox);
        String price = WebElementUtil.getText(EL_DSPageInstallation.haulPrice);

        calculatePriceAndAssert(price);
    }

    public void moveOld() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        validateElement(EL_DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(EL_DSPageInstallation.addOnService);

        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.moveOldCheckBox);
        WebElementUtil.clickElement(EL_DSPageInstallation.moveOldCheckBox);

        String price = WebElementUtil.getText(EL_DSPageInstallation.moveOldPrice);
        calculatePriceAndAssert(price);
    }

    public void doorSwing() throws InterruptedException {
        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        validateElement(EL_DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(EL_DSPageInstallation.addOnService);


        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.doorSwingRadioButton);
        WebElementUtil.clickElement(EL_DSPageInstallation.doorSwingRadioButton);

        String price = WebElementUtil.getText(EL_DSPageInstallation.doorSwingPrice);
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
        WebElementUtil.waitForElementToBeVisible(EL_DSPageInstallation.subTotal);
        WebElement element = driver.findElement(EL_DSPageInstallation.subTotal);
        WebElementUtil.scrollToElement(driver,element);
        String subTotalText = WebElementUtil.getText(EL_DSPageInstallation.subTotal);
        String totalPriceNumeric = subTotalText.replace("$", "").replace(",", "");
        double subTotalprice = Double.parseDouble(totalPriceNumeric);
        double expected = priceAdd + subTotalprice;
        WebElementUtil.waitForElementToBeVisible(EL_DSPageInstallation.totalPrice);
        String totalprice = WebElementUtil.getText(EL_DSPageInstallation.totalPrice);
        String totalPriceActual = totalprice.replace("$", "").replace(",", "");
        double totalA = Double.parseDouble(totalPriceActual);
        Assert.assertEquals(totalA, expected, "Error" );
    }

    public void haulAndMove() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        validateElement(EL_DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(EL_DSPageInstallation.addOnService);


        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.haulCheckBox);
        WebElementUtil.clickElement(EL_DSPageInstallation.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.moveOldCheckBox);
        WebElementUtil.clickElement(EL_DSPageInstallation.moveOldCheckBox);

        WebElementUtil.waitForElementToBeVisible(EL_DSPageInstallation.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(EL_DSPageInstallation.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }

    public void haulAndDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        validateElement(EL_DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(EL_DSPageInstallation.addOnService);


        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.haulCheckBox);
        WebElementUtil.clickElement(EL_DSPageInstallation.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.doorSwingRadioButton);
        WebElementUtil.clickElement(EL_DSPageInstallation.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(EL_DSPageInstallation.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(EL_DSPageInstallation.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }
    public void moveAndDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        validateElement(EL_DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(EL_DSPageInstallation.addOnService);


        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.moveOldCheckBox);
        WebElementUtil.clickElement(EL_DSPageInstallation.moveOldCheckBox);

        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.doorSwingRadioButton);
        WebElementUtil.clickElement(EL_DSPageInstallation.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(EL_DSPageInstallation.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(EL_DSPageInstallation.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }
    public void haulMoveDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(EL_DSPagesService.deliveryRadioButton);
        WebElementUtil.clickElement(EL_DSPagesService.deliveryRadioButton);

        validateElement(EL_DSPageInstallation.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(EL_DSPageInstallation.addOnService);

        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.haulCheckBox);
        WebElementUtil.clickElement(EL_DSPageInstallation.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.moveOldCheckBox);
        WebElementUtil.clickElement(EL_DSPageInstallation.moveOldCheckBox);

        WebElementUtil.waitForElementToBeClickable(EL_DSPageInstallation.doorSwingRadioButton);
        WebElementUtil.clickElement(EL_DSPageInstallation.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(EL_DSPageInstallation.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(EL_DSPageInstallation.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }


}
