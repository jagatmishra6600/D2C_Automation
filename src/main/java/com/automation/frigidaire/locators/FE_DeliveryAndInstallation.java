package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

import static java.awt.SystemColor.text;


public class FE_DeliveryAndInstallation {



    public static By getRadioButton(String deliveryOption) {
        return By.xpath("//div[normalize-space(text())='" + deliveryOption + "']/parent::div/parent::div//div[@id=\"deliveryServiceDiv\" or  \"Laundry_Washers_FrontLoad_Electric_Install\"]//input");
    }



    public static By radioButton = By.xpath("//div[text()=\" Delivery only (No Install) \"]/parent::div/parent::div//div[@id=\"deliveryServiceDiv\"]//input");
    public static By plpProductOpen = By.xpath("//div[@class=\"container-fluid px-2 plp\"]//div[@id=\"PlpItem0\"]//div[@class=\"col- Product-Image-Placeholder\"]//app-elux-image\n");
    public static By addToCart = By.xpath("//app-elux-action-button[@class=\"luxuryProductDetails productDetails ng-star-inserted\"]");
    public static By deliveryAndInStoreBox = By.xpath("//div[text()='" + text + "']");
    public static By deliveryAndInstallationHeading = By.xpath("//h3[text()='" + text + "']");
    public static By viewIncludedPartsLink = By.xpath("//a[text()='View included parts and additional details']");
    public static By DeliveryAndAppliancePopUp = By.xpath("//span[@class='H3H3_Desktop']");
    public static By TotalApplianceProtectionHeading=By.xpath("//p[@class='tap-heading']");
    public static By DeliveryAndAppliancePopUpSubText = By.xpath("//div[text()=\" 6' Long Stainless Steel Braided Refrigerator Water Supply Line (912001026) \"]\n");
    public static By DAndAppIncludedProductTxt= By.xpath("//span[@class='H3H3_Desktop']/ancestor::div//p[@class='mt-4 f-20']");
    public static By TotalApplianceProtectionPopUpText=By.xpath("//cx-page-slot[@class='tapLogo tapProtectionDescSlot has-components']//p[@class='ng-star-inserted']");
    public static By selectProtectionHeading = By.xpath("//h3[text()=\" Select a protection plan\" or text()=' Available protection plan.']");
    public static By protectionPlanSubText = By.xpath("//cx-page-slot[contains(@class,'tapDescSlot') or contains(@class,'Body-MediumBody_Medium tapSelectProtectionSlot')]");
    public static By protectionPlanViewDetailsLink = By.xpath("//u[text()=\"View Details\"]");
    public static By protectionPlanPopUpHeading = By.xpath("//button/following-sibling::p");
    public static By declineprotectionBy = By.xpath("//div[@class=\"Decline Body-SmallBody_Small_Centered\" or contains(@class,'declineProtectionDiv decline bord-right hideDeclineProtection')]");
    public static By differentProtectionPlan = By.xpath("//div[@class=\"vertical-separator-sep\"]//span[text()=\"1 year\"]");
    public static By protectProtectionPlan = By.xpath("//p[text()=\"Protect your investment with our appliance protection plan.\"]");
    public static By totalProtectionPlan = By.xpath("//p[@class=\"tap-heading\"]");
    public static By totalProtectionPlanSubTxt = By.xpath("//p[text()=\"Protect your investment with our appliance protection plan\"]");
    public static By protectionPlanPopUp = By.xpath("//div[@id=\"tap-modal\"]");
    public static By viewIncludePartsClosePopUpButton=By.xpath("//button[@aria-label='Close']/img");
    //div[@class='Body_Large-Title Utility-TextPrice-Sm col-md-4 p-0 text-right total-price']
    public static By optionByText(String text) {
        return By.xpath("//p[normalize-space()='" + text + "']");
    }

    public static By includeWithService(String text){
        return By.xpath("//span[text()='" + text +"']");
    }
    public static By subTotalPrice = By.xpath("//div[@class='Utility-TextPrice-Sm col-md-4 p-0 subtotal-price text-right' or contains(@class,'Body_Large-Title col-md-4 p-0 text-right')]//b");
    public static By protectionPlanPrice = By.xpath("//div[@class='col-md-4 p-0 text-right']");
    public static By totalPrice = By.xpath("//div[contains(@class, 'Body_Large-Title') and contains(@class, 'Utility-TextPrice-Sm') and contains(@class, 'total-price')]");
    public static By totalPriceForElectrolux = By.xpath("//div[contains(@class,'Body_Large-Title col-md-4 p-0 text-right ng-star-inserted')]");
    public static By protectionPlanPriceForElectrolux = By.xpath("//div[text()=' Protection Plan ']/following-sibling::div[@class='col-md-4 p-0 text-right']");
    public static By installationServices = By.xpath("//div[text()=' Installation Services']/following-sibling::div[@class=\"col-md-4 p-0 text-right\"]");
    public static By yearPlan(String Text){
        return By.xpath("//span[text()='" + text +"']/ancestor::div[@class=\"elxtapselection\"]//div[@class='mt-0 SmallBody_Small_Centered']");
    }
    public static By getPlanYearLocator(String dynamicText) {
        return By.xpath("//div[contains(@class,'-years Body-MediumBody_Medium_Centered font-weight-bold')]//span[contains(text(),'" + dynamicText + "')]");
    }


    public static By getPriceLocator(String year) {
        return By.xpath("//span[text()='"+year+"']/ancestor::div[@class='elxtapselection']//div[@class='mt-0 SmallBody_Small_Centered']");
    }

    public static By getYearLocatorForElectrolux(String year) {
        return By.xpath("//div[@class='-years ng-star-inserted']//div[text()='"+year+"']");
    }

    //div[text()='3 years']/parent::div[contains(@class,'-years ng-star-inserted')]/parent::label/following-sibling::div

    public static By getPriceLocatorForElectrolux(String year) {
        return By.xpath("//div[text()='"+year+"']/parent::div[contains(@class,'-years ng-star-inserted')]/parent::label/following-sibling::div");
    }

}
