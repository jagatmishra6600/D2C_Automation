package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

import static java.awt.SystemColor.text;


public class DeliveryAndInstallationLocatorsFrig {



    public static By getRadioButton(String deliveryOption) {
        return By.xpath("//div[normalize-space(text())='" + deliveryOption + "']/parent::div/parent::div//div[@id=\"deliveryServiceDiv\" or  \"Laundry_Washers_FrontLoad_Electric_Install\"]//input");
    }



    public static By radioButton = By.xpath("//div[text()=\" Delivery only (No Install) \"]/parent::div/parent::div//div[@id=\"deliveryServiceDiv\"]//input");
    public static By plpProductOpen = By.xpath("//div[@class=\"container-fluid px-2 plp\"]//div[@id=\"PlpItem0\"]//div[@class=\"col- Product-Image-Placeholder\"]//app-elux-image\n");
    public static By addToCart = By.xpath("//app-elux-action-button[@class=\"luxuryProductDetails productDektails ng-star-inserted\"]");
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
    public final By addToCartButton = By.xpath("//app-elux-action-button[contains(@class,'luxuryProductDetails')]//cx-add-to-cart//span[normalize-space(text()) = 'Add to cart']");
    public final By saveAndViewCartButton = By.xpath("//button[normalize-space(text())='Save and view cart']");
    public final By saveSideAndViewCartButton = By.xpath("//a[normalize-space(text())='Save and view cart']");
    public final By itemAddedToCartText = By.xpath("//span[text()='Item added to cart']");
    public final By productTitleText = By.xpath("//p[contains(@class, 'product-title')]");
    public final By productIdText = By.xpath("//p[contains(@class, 'product-title')]//..//following-sibling::p");
    public final By productPriceText = By.xpath("//span[contains(@class, 'TextPrice')]");
    public final By optionToReceiveOrderText = By.xpath("//h3[contains(@class,'card-title')]");
    public final By deliveryOptionBox = By.xpath("//div[text()='Delivery']/parent::div");
    public final By deliveryAndServiceSectionHeading = By.xpath("//h3[text()='Delivery & installation services']");
    public static final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div");
    public final By deliveryOnlyOption = By.xpath("//div[normalize-space(text())='Delivery only (No Install)']/parent::div/preceding-sibling::div//input");
    public final By deliveryOnlyOptionPrice = By.xpath("//div[normalize-space(text())='Delivery only (No Install)']/../following-sibling::div//div[contains(@class, 'priceFree')]//span");
    public final By requireInstallationPartsText = By.xpath("//p[text()='Required installation parts']");
    public final By partCheckBox = By.xpath("//input[@id='912001026']");
    public final By InstallationsPartPrice = By.xpath("//div[text()='Installation parts']/following-sibling::div");
    public final By AddOnServicesPartPrice = By.xpath("//div[normalize-space()='Add-on services']/following-sibling::div");
    public final By  TapProtectionPlanPrice = By.xpath("//div[normalize-space()='Tap protection plan']/following-sibling::div");
    public By addOnServiceText = By.xpath("//p[normalize-space()='Add-on services']");
    public By selectAddOnServices = By.xpath("//div[normalize-space()='Haul away / dispose old appliance']//parent::div/parent::div//input");
    public By protectionPlanText = By.xpath("//h3[text()=\" Select a protection plan\"]");
    public By selectProtectionPlan = By.xpath("//span[text()=\"3 years\"]");




    public static By optionByText(String text) {
        return By.xpath("//p[normalize-space()='" + text + "']");
    }

    public static By includeWithService(String text){
        return By.xpath("//span[text()='" + text +"']");
    }
    public static By subTotalPrice = By.xpath("//div[@class='Utility-TextPrice-Sm col-md-4 p-0 subtotal-price text-right' or contains(@class,'Body_Large-Title col-md-4 p-0 text-right')]//b");
    public static By protectionPlanPrice = By.xpath("//div[@class='col-md-4 p-0 text-right']");
    //public static By totalPrice = By.xpath("//div[contains(@class, 'Body_Large-Title') and contains(@class, 'Utility-TextPrice-Sm') and contains(@class, 'total-price')]");
    public static By totalPriceForElectrolux = By.xpath("//div[contains(@class,'Body_Large-Title col-md-4 p-0 text-right ng-star-inserted')]");
    public static By protectionPlanPriceForElectrolux = By.xpath("//div[text()=' Protection Plan ']/following-sibling::div[@class='col-md-4 p-0 text-right']");
    public static By installationServices = By.xpath("//div[text()='Installation parts']/following-sibling::div[@class=\"col-md-4 p-0 text-right\"]");
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
