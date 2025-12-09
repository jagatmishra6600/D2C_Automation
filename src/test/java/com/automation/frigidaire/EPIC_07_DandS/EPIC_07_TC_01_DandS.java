package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.locators.FE_DeliveryAndInstallation;
import com.automation.frigidaire.pages.DeliveryInstallationPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.automation.utils.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

public class EPIC_07_TC_01_DandS extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions = new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions = new PLPProductItemsPageActions();
    DeliveryInstallationPageActions DeliveryInstallationPageActions = new DeliveryInstallationPageActions();
    WebDriver driver=getDriver();

    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_01_test_Included_Parts_Section_Within_Delivery_Installation_Section() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        DeliveryInstallationPageActions.selectProductAndAddToCart(0);
        //Assert.assertTrue(DeliveryInstallationPageActions.isSectionVisible("Delivery & installation options"));
     //   Assert.assertTrue(DeliveryInstallationPageActions.isSectionVisible(FE_DeliveryAndInstallation.getRadioButton("Delivery & installation")));
      //  DeliveryInstallationPageActions.verifySubLinksinDAndSPage();
          DeliveryInstallationPageActions.verifyHeadingAndSubLinksinDAndSPage("Delivery & installation");
       // Assert.assertTrue(DeliveryInstallationPageActions.isSectionVisible(FE_DeliveryAndInstallation.getRadioButton("Delivery & installation")));
        ExtentReportManager.getTest().pass("Successfully hide/show filters functionality for FrenchDoor");
    }

    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_01_test_Included_Parts_Section_Within_Delivery_Installation_Sections() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        DeliveryInstallationPageActions.selectProductAndAddToCart(0);
        DeliveryInstallationPageActions.verifyHeadingAndSubLinksinDAndSPage("Delivery & installation");
        DeliveryInstallationPageActions.verifyPopupTextIsVisible();
        ExtentReportManager.getTest().pass("Successfully hide/show filters functionality for FrenchDoor");
    }


    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_02_test_ESA_Protection_Plan_Section() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        DeliveryInstallationPageActions.selectProductAndAddToCart(0);
//        DeliveryInstallationPageActions.verifyHeadingAndSubLinksinDAndSPage("Delivery & installation");
        DeliveryInstallationPageActions.verifyProtectionPlanSection(" Select a protection plan");
        ExtentReportManager.getTest().pass("Successfully hide/show filters functionality for FrenchDoor");
    }



}
