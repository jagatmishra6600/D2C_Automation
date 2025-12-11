package com.automation.electrolux.pages;


import com.automation.electrolux.locators.DSPageInstallationLocatorsElux;
import com.automation.electrolux.locators.DSPageServiceLocatorsElux;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InstallationAddOnServicePageActionElux {


    public void clickProductBySKU(String sku) throws InterruptedException {

        WebElementUtil.zoomInOrOut(75);
        Thread.sleep(7000);
        By productClick =By.xpath("//div[text()='" + sku + "']//parent::div//parent::div//parent::div//parent::div//div[@class=\"col- product-card-inner-row kit\"]//a");
        WebElementUtil.scrollToElementStable(productClick);
        WebElementUtil.waitForElementToBeVisible(productClick, 10);
        WebElementUtil.waitForElementToBeClickable(productClick, 10);
        WebElementUtil.clickElement(productClick);

        Thread.sleep(3000);
        WebElementUtil.scrollToElementStable(DSPageServiceLocatorsElux.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.addToCartButton, 10);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.addToCartButton, 10);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.addToCartButton);

    }

    public void validateDeliveryOnlyIsAvailable() {
        WebDriver driver = DriverManager.getDriver();

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.deliverySubTitle);
        Assert.assertTrue(driver.findElement(DSPageServiceLocatorsElux.deliverySubTitle).isDisplayed(),
                "'Delivery only' radio button is NOT available!");

        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.deliveryRadioButton);
        Assert.assertTrue(driver.findElement(DSPageServiceLocatorsElux.deliveryRadioButton).isDisplayed(),
                "'Delivery only' radio button is NOT available!");


//        WebElementUtil.waitForElementToBeVisible(EL_DSPagesService.deliveryPrice);
//        Assert.assertTrue(driver.findElement(EL_DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only' price is NOT available!");
    }
    public void selectedDeliveryOnly() throws InterruptedException {

        WaitUtils.implicitWait(5);
        WebElementUtil.waitForElementToBeVisible(DSPageServiceLocatorsElux.deliveryRadioButton);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton, 10);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        validateElement(DSPageInstallationLocatorsElux.requiredInstallation,
                "Required Installation is not available");

        validateElement(DSPageInstallationLocatorsElux.checkBoxRequired,
                "Required check box is not available");

        validateElement(DSPageInstallationLocatorsElux.listOfAvailable,
                "Required Installation list of available is not available");

        validateElement(DSPageInstallationLocatorsElux.priceRequired,
                "Required Installation price is not available");

    }
    public void selectCheckBoxRequired(){

        WebElementUtil.waitForElementToBeVisible(DSPageInstallationLocatorsElux.checkBoxRequired);
        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.checkBoxRequired, 10);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.checkBoxRequired);

        String actualPriceRequired = WebElementUtil.getText(DSPageInstallationLocatorsElux.priceRequired);
        String priceRequiredText = actualPriceRequired.replace("$", "").replace(",", "");

        double price = Double.parseDouble(priceRequiredText);


        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.subTotal);

        String subTotalPrice = WebElementUtil.getText(DSPageInstallationLocatorsElux.subTotal);

        String subTotalPriceText = subTotalPrice.replace("$", "").replace(",", "");
        double subTotalNumeric = Double.parseDouble(subTotalPriceText);


        double expected = price + subTotalNumeric;

        WebElementUtil.waitForElementToBeVisible(DSPageInstallationLocatorsElux.totalPrice);
        String totalPriceText = WebElementUtil.getText(DSPageInstallationLocatorsElux.totalPrice);

        String totalPriceNumeric = totalPriceText.replace("$", "").replace(",", "");
        double totalPriceProduct = Double.parseDouble(totalPriceNumeric);

        Assert.assertEquals(totalPriceProduct, expected," Delivery only error ");
    }
    public void deliveryInstallation(){

        validateElement(DSPageInstallationLocatorsElux.deliveryInstallation,
                "Delivery & installation option is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.deliveryInstallationRadioButton,
                "Delivery & installation radio button is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.deliveryInstallationTag,
                "Recommended tag is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.deliveryInstallationDescription,
                "Description for Delivery & installation is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.deliveryInstallationPrice,
                "Price for Delivery & installation is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.deliveryInstallationViewLink,
                "'View included parts and additional details' link is NOT displayed!");

    }

    public void professionalInstallation (){

        validateElement(DSPageInstallationLocatorsElux.professionalInstallation,
                "Delivery & installation option is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.professionalInstallationRadioButton,
                "Delivery & installation radio button is NOT displayed!");

//        validateElement(EL_DSPageInstallation.professionalInstallationTag,
//                "Recommended tag is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.professionalInstallationDescription,
                "Description for Delivery & installation is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.professionalInstallationPrice,
                "Price for Delivery & installation is NOT displayed!");

        validateElement(DSPageInstallationLocatorsElux.professionalInstallationViewLink,
                "'View included parts and additional details' link is NOT displayed!");
    }

    public void validateElement(By locator, String errorMessage) {
      //  WebDriver driver = DriverManager.getDriver();
        WebElementUtil.waitForElementToBeVisible(locator, 15);
       // WebElement element = driver.findElement(locator);

       // WebElementUtil.scrollToElement(driver, element);
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.waitForElementToBeVisible(locator);

       // Assert.assertTrue(element.isDisplayed(), errorMessage);
        WebElementUtil.isDisplayed(locator);
    }

    public void validateAddOnServicesAreAvailable() {

        validateElement(DSPageInstallationLocatorsElux.addOnService,
                "'Add-on services' title is NOT available!");

//        validateElement(EL_DSPageInstallation.addOnMessage,
//                "Add-on services message is NOT available!");

        validateElement(DSPageInstallationLocatorsElux.haulCheckBox,
                "'Haul away / dispose old appliance' checkbox is NOT available!");

        validateElement(DSPageInstallationLocatorsElux.haulText,
                "Haul away text is Not available!");

        validateElement(DSPageInstallationLocatorsElux.haulDescription,
                "'Haul away / dispose old appliance' description is NOT available!");

        validateElement(DSPageInstallationLocatorsElux.haulPrice,
                "'Haul away / dispose old appliance' price is NOT available!");

        validateElement(DSPageInstallationLocatorsElux.moveOldCheckBox,
                "'Move old unit to another room' checkbox is NOT available!");

        validateElement(DSPageInstallationLocatorsElux.moveOld,
                "Move old text is Not available!");

        validateElement(DSPageInstallationLocatorsElux.moveOldDescription,
                "'Move old unit to another room' description is NOT available!");

        validateElement(DSPageInstallationLocatorsElux.moveOldPrice,
                "'Move old unit to another room' price is NOT available!");


    }
    public void validateDoorSwing(){
        validateElement(DSPageInstallationLocatorsElux.doorSwing,
                "Door swing option is Not available!");

        validateElement(DSPageInstallationLocatorsElux.doorSwingRadioButton,
                "Door swing Radio button is Not available!");

        validateElement(DSPageInstallationLocatorsElux.doorSwingPrice,
                "Door swing price is Not available!");
    }

    public void selectHaul() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        validateElement(DSPageInstallationLocatorsElux.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.addOnService);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.haulCheckBox);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.haulCheckBox);
        String price = WebElementUtil.getText(DSPageInstallationLocatorsElux.haulPrice);

        calculatePriceAndAssert(price);
    }

    public void moveOld() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        validateElement(DSPageInstallationLocatorsElux.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.addOnService);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.moveOldCheckBox);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.moveOldCheckBox);

        String price = WebElementUtil.getText(DSPageInstallationLocatorsElux.moveOldPrice);
        calculatePriceAndAssert(price);
    }

    public void doorSwing() throws InterruptedException {
        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        validateElement(DSPageInstallationLocatorsElux.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.addOnService);


        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.doorSwingRadioButton);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.doorSwingRadioButton);

        String price = WebElementUtil.getText(DSPageInstallationLocatorsElux.doorSwingPrice);
        calculatePriceAndAssert(price);
    }
    public void calculatePriceAndAssert( String price){
        double priceAdd = 0;
        if(price.equalsIgnoreCase("Free")){
            priceAdd =0;
        }else {
            String num = price.replace("$", "").replace(",", "");
            priceAdd = Double.parseDouble(num);
        }
        WebElementUtil.waitForElementToBeVisible(DSPageInstallationLocatorsElux.subTotal);
        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.subTotal);
        String subTotalText = WebElementUtil.getText(DSPageInstallationLocatorsElux.subTotal);
        String totalPriceNumeric = subTotalText.replace("$", "").replace(",", "");
        double subTotalprice = Double.parseDouble(totalPriceNumeric);
        double expected = priceAdd + subTotalprice;
        WebElementUtil.waitForElementToBeVisible(DSPageInstallationLocatorsElux.totalPrice);
        String totalprice = WebElementUtil.getText(DSPageInstallationLocatorsElux.totalPrice);
        String totalPriceActual = totalprice.replace("$", "").replace(",", "");
        double totalA = Double.parseDouble(totalPriceActual);
        Assert.assertEquals(totalA, expected, "Error" );
    }

    public void haulAndMove() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        validateElement(DSPageInstallationLocatorsElux.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.addOnService);


        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.haulCheckBox);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.moveOldCheckBox);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.moveOldCheckBox);

        WebElementUtil.waitForElementToBeVisible(DSPageInstallationLocatorsElux.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPageInstallationLocatorsElux.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }

    public void haulAndDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        validateElement(DSPageInstallationLocatorsElux.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.addOnService);


        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.haulCheckBox);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.doorSwingRadioButton);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPageInstallationLocatorsElux.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPageInstallationLocatorsElux.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }
    public void moveAndDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        validateElement(DSPageInstallationLocatorsElux.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.addOnService);


        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.moveOldCheckBox);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.moveOldCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.doorSwingRadioButton);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPageInstallationLocatorsElux.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPageInstallationLocatorsElux.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }
    public void haulMoveDoor() throws InterruptedException {

        //Thread.sleep(5000);
        WebElementUtil.waitForElementToBeClickable(DSPageServiceLocatorsElux.deliveryRadioButton);
        WebElementUtil.clickElement(DSPageServiceLocatorsElux.deliveryRadioButton);

        validateElement(DSPageInstallationLocatorsElux.addOnService,
                "'Add-on services' title is NOT available!");
        WebElementUtil.scrollToElementStable(DSPageInstallationLocatorsElux.addOnService);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.haulCheckBox);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.haulCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.moveOldCheckBox);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.moveOldCheckBox);

        WebElementUtil.waitForElementToBeClickable(DSPageInstallationLocatorsElux.doorSwingRadioButton);
        WebElementUtil.clickElement(DSPageInstallationLocatorsElux.doorSwingRadioButton);

        WebElementUtil.waitForElementToBeVisible(DSPageInstallationLocatorsElux.subTotalAddOnServicePrice);
        String str = WebElementUtil.getText(DSPageInstallationLocatorsElux.subTotalAddOnServicePrice);
        calculatePriceAndAssert(str);
    }


}
