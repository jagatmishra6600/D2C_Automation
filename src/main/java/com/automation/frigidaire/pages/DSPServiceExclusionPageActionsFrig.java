package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DSPServiceLocatorsFrig;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;

public class DSPServiceExclusionPageActionsFrig {

    public void zipCodeChange(String zipCode) throws InterruptedException {

        WebDriver driver= DriverManager.getDriver();
        sleep(2);
        waitForElementToBeVisible(DSPServiceLocatorsFrig.zipCodeField);
        waitForElementToBeClickable(DSPServiceLocatorsFrig.zipCodeField);
        clickElement(DSPServiceLocatorsFrig.zipCodeField);

        waitForElementToBeVisible(DSPServiceLocatorsFrig.zipCodeInput);
        WebElement element = driver.findElement(DSPServiceLocatorsFrig.zipCodeInput);
        Thread.sleep(2000);
        element.clear();
        element.sendKeys(zipCode);
        Thread.sleep(2000);
        waitForElementToBeClickable(DSPServiceLocatorsFrig.zipCodeButton);
        clickElement(DSPServiceLocatorsFrig.zipCodeButton);
    }
    public void zipCodePop(){
        waitForElementToBeVisible(DSPServiceLocatorsFrig.zipPopUp);
        clickElement(DSPServiceLocatorsFrig.zipPopUp);
    }
    public void deliveryOnlyIsAvailable() {

        scrollToElementStable(DSPServiceLocatorsFrig.deliverySubTitle);

        waitForElementToBeVisible(DSPServiceLocatorsFrig.deliverySubTitle);
        isDisplayed(DSPServiceLocatorsFrig.deliverySubTitle);

        waitForElementToBeVisible(DSPServiceLocatorsFrig.deliveryRadioButton);
        isDisplayed(DSPServiceLocatorsFrig.deliveryRadioButton);

//       waitForElementToBeVisible(DSPagesService.deliveryPrice, 10);
//        Assert.assertTrue(driver.findElement(DSPagesService.deliveryPrice).isDisplayed(),
//                "'Delivery only price is not available!");

        waitForElementToBeClickable(DSPServiceLocatorsFrig.deliveryRadioButton);
        clickElement(DSPServiceLocatorsFrig.deliveryRadioButton);

        waitForElementToBeVisible(DSPServiceLocatorsFrig.requiredInstallation);
        isDisplayed(DSPServiceLocatorsFrig.requiredInstallation);

        waitForElementToBeVisible(DSPServiceLocatorsFrig.checkBoxRequired);
        isDisplayed(DSPServiceLocatorsFrig.checkBoxRequired);

        waitForElementToBeVisible(DSPServiceLocatorsFrig.listOfAvailable);
        isDisplayed(DSPServiceLocatorsFrig.listOfAvailable);

    }
    public void installationUnavailable(){
        waitForElementToBeVisible(DSPServiceLocatorsFrig.installationUnavailable);
        isDisplayed(DSPServiceLocatorsFrig.installationUnavailable);
    }
}
