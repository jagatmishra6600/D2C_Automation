package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

public class FrigidaireHomePageActions {

    // Locators remain the same
    //************************** Main Menu Bar Locators **************************
    private final By mainMenu_FrigidaireSite = By.cssSelector("img[alt='Frigidaire Brand Site']");
    private final By mainMenu_ElectroluxSite = By.cssSelector("img[alt='Electrolux Brand Site']");
    private final By mainMenu_Login_OrderStatus = By.xpath("//a[@class='header-navigation-icon mr-4']");
    private final By mainMenu_Contact = By.xpath("//a[contains(text(),'Contact us')]");
    private final By mainMenu_DeliverTo = By.xpath("//div[@class='pdp-hide-header-visible']//span[@class='Set-delivery-area']");
    private final By mainMenu_Cart = By.xpath("//img[@alt='Your Shopping Cart']");
    private final By mainMenu_CartCount = By.xpath("//span[@class='count']");
    private final By mainMenu_Login = By.cssSelector("a[role='link']");
    //************************** Header Menu Bar Locators **************************
    private final By mainMenu_Logo = By.xpath("//img[@alt='Frigidaire Company Logo']");
    private final By headerMenu_Kitchen = By.cssSelector("h5[aria-label='Kitchen']");
    private final By headerMenu_AirConditioners = By.cssSelector("h5[aria-label='Air Conditioners']");
    private final By headerMenu_AirCare = By.cssSelector("h5[aria-label='Air Care']");
    private final By headerMenu_Laundry = By.cssSelector("h5[aria-label='Laundry']");
    private final By headerMenu_Filters = By.cssSelector("h5[aria-label='Filters']");
    private final By headerMenu_Accessories = By.cssSelector("h5[aria-label='Accessories']");
    private final By headerMenu_OwnerSupport = By.cssSelector("h5[aria-label='Owner Support']");
    private final By headerMenu_Blog = By.cssSelector("h5[aria-label='Blog']");
    private final By headerMenu_Sale = By.cssSelector("h5[aria-label='Sale']");
    //************************** Message and Feedback *******************************
    private final By message_CTA = By.xpath("//u[normalize-space()='Privacy Policy']");
    private final By Feedback_CTA = By.xpath("//img[contains(@alt,'Feedback Button')]");

    //************************** Footer Locators ************************************
    //Featured
    private final By footer_Featured_ExplorePizza = By.cssSelector("a[aria-label='Explore Pizza. 1 of 7']");
    private final By footer_Featured_ProfessionalSeries = By.cssSelector("a[aria-label='Frigidaire Professional Series. 2 of 7']");
    private final By footer_Featured_GallerySeries = By.cssSelector("a[aria-label='Frigidaire Gallery Series. 3 of 7']");
    private final By footer_Featured_ConvectionCollection = By.cssSelector("a[aria-label='Total Convection Collection. 4 of 7']");
    private final By footer_Featured_AppliancesCollection = By.cssSelector("a[aria-label='Induction Appliances Collection. 5 of 7']");
    private final By footer_Featured_AirFry = By.cssSelector("a[aria-label='Air Fry Appliances Collection. 6 of 7']");
    private final By footer_Featured_Sustainability = By.cssSelector("a[aria-label='Sustainability. 7 of 7']");
    // Owner Support
    private final By footer_OwnerSupport_CreateAccount = By.cssSelector("a[aria-label='Create an Account. 1 of 7']");
    private final By footer_OwnerSupport_RegisterProduct = By.cssSelector("a[aria-label='Register Your Product. 2 of 7']");
    private final By footer_OwnerSupport_FAQsTroubleshooting = By.cssSelector("a[aria-label='FAQs & Troubleshooting. 3 of 7']");
    private final By footer_OwnerSupport_AlexaSmartHome = By.cssSelector("a[aria-label='Alexa Smart Home. 4 of 7']");
    private final By footer_OwnerSupport_GoogleSmartHome = By.cssSelector("a[aria-label='Google Smart Home. 5 of 7']");
    private final By footer_OwnerSupport_FrigidaireFitPromise = By.cssSelector("a[aria-label='Frigidaire Fit Promise. 6 of 7']");
    private final By footer_OwnerSupport_PrepareForDelivery = By.cssSelector("a[aria-label='Prepare for Your Delivery. 7 of 7']");
    // Customer Service
    private final By footer_CustomerService_ContactUs = By.cssSelector("a[aria-label='Contact Us. 1 of 8']");
    private final By footer_CustomerService_WarrantyInformation = By.cssSelector("a[aria-label='Warranty Information. 2 of 8']");
    private final By footer_CustomerService_ServiceAndRepair = By.cssSelector("a[aria-label='Service And Repair. 3 of 8']");
    private final By footer_CustomerService_ShippingAndReturnPolicy = By.cssSelector("a[aria-label='Shipping And Return Policy. 4 of 8']");
    private final By footer_CustomerService_RecallInformation = By.cssSelector("a[aria-label='Recall Information. 5 of 8']");
    private final By footer_CustomerService_TransparencySupplyChains = By.cssSelector("a[aria-label='Transparency in Supply Chains. 6 of 8']");
    private final By footer_CustomerService_AB1200Disclosure = By.cssSelector("a[aria-label='AB1200 Disclosure. 7 of 8']");
    private final By footer_CustomerService_AB1305Disclosure = By.cssSelector("a[aria-label='AB1305 Disclosure. 8 of 8']");
    // Sales and Discounts
    private final By footer_SalesDiscount_Promotions = By.cssSelector("a[aria-label='Promotions. 1 of 6']");
    private final By footer_SalesDiscount_ApplianceRebates = By.cssSelector("a[aria-label='Appliance Rebates. 2 of 6']");
    private final By footer_SalesDiscount_TeachersDiscount = By.cssSelector("a[aria-label='Teachers Discount. 3 of 6']");
    private final By footer_SalesDiscount_MilitaryDiscount = By.cssSelector("a[aria-label='Military Discount. 4 of 6']");
    private final By footer_SalesDiscount_HealthcareProfessionalsDiscount = By.cssSelector("a[aria-label='Healthcare Professionals Discount. 5 of 6']");
    private final By footer_SalesDiscount_FirstRespondersDiscount = By.cssSelector("a[aria-label='First Responders Discount. 6 of 6']");
    //Connect
    private final By footer_Connect_Facebook = By.cssSelector("//li[@role='presentation']//cx-banner[@class='frigfacebook socialIconsClass']//a");
    private final By footer_Connect_Twitter = By.cssSelector("//li[contains(@role,'presentation')]//cx-banner[contains(@class,'frigtwitter socialIconsClass')]//a");
    private final By footer_Connect_Youtube = By.cssSelector("//li[contains(@role,'presentation')]//cx-banner[contains(@class,'frigYoutube socialIconsClass')]//a");
    private final By footer_Connect_Instagram = By.cssSelector("//li[contains(@role,'presentation')]//cx-banner[contains(@class,'frigInstagram socialIconsClass')]//a");
    private final By footer_Connect_Pinterest = By.cssSelector("//li[contains(@role,'presentation')]//cx-banner[contains(@class,'frigPinterest socialIconsClass')]//a");
    //Others
    private final By footer_Other_Privacy = By.cssSelector("a[aria-label='Privacy policy.  of ']");
    private final By footer_Other_TermAndCondition = By.cssSelector("a[aria-label='Terms & Conditions Node.  of ']");
    private final By footer_Other_DoNotSell = By.cssSelector("a[aria-label='Do not sell my information.  of ']");
    //************************** Pre-Footer Locators **************************
    // Get More From Frigidaire
    private final By pre_Footer_GetMoreFromFrigidaire_ProductRegistration = By.xpath("//a[normalize-space()='Product Registration']");
    private final By pre_Footer_GetMoreFromFrigidaire_Promotions = By.xpath("//cx-page-slot[@class='rightFooternewsletterColumnB has-components']//a[contains(text(),'Promotions')]");
    private final By pre_Footer_GetMoreFromFrigidaire_ExtendedServiceWarranties = By.xpath("//a[normalize-space()='Extended Service Warranties']");
    private final By pre_Footer_GetMoreFromFrigidaire_BlogInspiration = By.xpath("//a[normalize-space()='Blog Inspiration']");
    // First To Know
    private final By pre_Footer_FirstToKnow_EmailInput = By.xpath("//input[@id='newsletterEmailControl']");
    private final By pre_Footer_FirstToKnow_SubmitButton = By.xpath("//input[@id='submitBtn']");
    private final By pre_Footer_FirstToKnow_TermsAndConditions = By.xpath("//u[normalize-space()='Terms and Conditions']");
    private final By pre_Footer_FirstToKnow_PrivacyPolicy = By.xpath("//u[normalize-space()='Privacy Policy']");


    private final By searchInput = By.cssSelector("input[placeholder='Search...']");
    private final By searchButton = By.cssSelector("img[aria-label='search']");
    private final By productAddToCart = By.cssSelector("button[aria-label='Add to cart']");
    private final By frigidaireLogo = By.cssSelector("img[alt='Frigidaire Company Logo']");
    private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private final By closeButtonLocator = By.cssSelector("img[alt='Close'][src='/assets/icons/frg-icons-close-d-7-CartModal.webp']");


    public FrigidaireHomePageActions navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getProperty("app.url"));
        try {
            WebElement acceptBtn = untilClickable(acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
    }

    public boolean isHomePageLoaded() {
        // isDisplayed now handles the wait internally
        return WebElementUtil.isDisplayed(frigidaireLogo);
    }

    public boolean isBrancdLogoLoaded() {
        return WebElementUtil.isDisplayed(frigidaireLogo);
    }

    public void navigateToLoginPage() {
        WebElementUtil.hoverOverElement(mainMenu_Login_OrderStatus);
        WebElementUtil.clickElement(mainMenu_Login);
    }

    public boolean validateUserNavigateBackToHomepage() {
        WebElementUtil.clickElement(mainMenu_Contact);
        WebElementUtil.clickElement(mainMenu_Logo);
        return WebElementUtil.isDisplayed(mainMenu_Logo);
    }

    public void navigateToProductsPage() {
        WebElementUtil.clickElement(mainMenu_Contact);
    }

    public boolean isContactUsLinkDisplayed() {
        return WebElementUtil.isDisplayed(mainMenu_Contact);
    }

    public void clickContactUsLink() {
        WebElementUtil.clickElement(mainMenu_Contact);
    }

    public boolean isZipCodeDisplayed() {
        return WebElementUtil.isDisplayed(mainMenu_DeliverTo);
    }

    public String getDefaultZipCode() {
        return WebElementUtil.getText(mainMenu_DeliverTo);
    }

    public void clickZipCodeArea() {
        WebElementUtil.clickElement(mainMenu_DeliverTo);
    }

    public boolean isMiniCartDisplayed() {
        return WebElementUtil.isDisplayed(mainMenu_Cart);
    }

    public void clickMiniCart() {
        WebElementUtil.clickElement(mainMenu_Cart);
    }

    public boolean isLoginDisplayed() {
        return WebElementUtil.isDisplayed(mainMenu_Login_OrderStatus);
    }

    //Methods for Header
    public boolean validateInvalidZIPWhenBlank() {
        WebElementUtil.clickElement(mainMenu_DeliverTo);
        WebElement zipInput = WebElementUtil.waitForElementToBeVisible(By.id("zipCodeInput"));
        zipInput.clear();
        WebElement errorMessage = WebElementUtil.waitForElementToBeVisible(By.id("zipCodeError"));
        return errorMessage.getText().contains("Invalid Zip Code");
    }

    public boolean validateInvalidZIPWhenLessThan5Digits() {
        WebElementUtil.clickElement(mainMenu_DeliverTo);
        WebElement zipInput = WebElementUtil.waitForElementToBeVisible(By.id("zipCodeInput"));
        zipInput.clear();
        zipInput.sendKeys("123");
        WebElement errorMessage = WebElementUtil.waitForElementToBeVisible(By.id("zipCodeError"));
        return errorMessage.getText().contains("Invalid Zip Code");
    }

    public void enterZipCode(String zip) {
        WebElementUtil.clickElement(mainMenu_DeliverTo);
        WebElement zipInput = WebElementUtil.waitForElementToBeVisible(By.id("zipCodeInput"));
        zipInput.clear();
        zipInput.sendKeys(zip);
        WebElementUtil.clickElement(By.id("setZipCodeButton"));
    }
    public boolean isMiniCartCountUpdated() {
        WebElement cartIcon = WebElementUtil.waitForElementToBeVisible(mainMenu_Cart);
        String ariaLabel = WebElementUtil.getText(mainMenu_CartCount);
        return ariaLabel != null && ariaLabel.contains("1");
    }

    public void addIteamToCart(String itemName) {
        WebElementUtil.sendKeys(searchInput, itemName);
        WebElementUtil.clickElement(searchButton);
        WebElementUtil.clickElement(productAddToCart);
        WebElementUtil.clickElement(closeButtonLocator);
        WebElementUtil.clickElement(mainMenu_Logo);
    }
}