package com.automation.electrolux.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import static com.automation.utils.WaitUtils.untilClickable;

public class ElectroluxHomePageActions {

    // Locators remain the same
    //************************** Main Menu Bar Locators **************************
    private final By mainMenu_Login_OrderStatus = By.xpath("(//div[contains(.,'Log in / Order status')])[1]");
    private final By mainMenu_Login_OrderStatus_Login = By.xpath("//*[@class='dropdown-login-cta']//button[contains(.,'Log in')]");
    private final By mainMenu_Login_OrderStatus_CreateAccount = By.xpath("//*[@class='dropdown-login-cta']//button[contains(.,'Create an account')]");
    
    private final By mainMenu_CartCount = By.xpath("//span[@class='count']");
    private final By mainMenu_Login = By.cssSelector("a[role='link']");
    private final By mainMenu_searchInput = By.cssSelector("input[placeholder='Search...']");
    private final By mainMenu_searchButton = By.cssSelector("button[aria-label='Search']");
    private final By mainMenu_searchSuggestions = By.xpath("//*[@class='suggestions font-weight-bold']");
    private final By mainMenu_searchSuggestions_FirstElement = By.xpath("//*[@class='suggestions font-weight-bold']/a[1]");
    private final By mainMenu_searchSuggestions_Landing = By.cssSelector("div[class='title mb-1'] h1 p");
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

    //************************** Body Locators ************************************
    private By body_shopOurCategoriesHeading = By.xpath("//h2[contains(text(), 'Shop Our Categories')]");
    private By body_category_item = By.xpath("//*[@class=\"row six_items standard-category-list\"]/div/div[2]/cx-generic-link/a");
    private By body_ShopOurTopRatedAppliancesSection = By.xpath("//h2[contains(text(), 'Shop our Best-Selling Appliances')]");
    private By body_ShopOurTopRatedAppliancesCard = By.xpath("//*[@class=\"carousel-tracks\"]");
    private By body_firstProductCard = By.xpath("//*[@class=\"carousel-tracks\"]/div[1]");
    private By body_firstProductSku = By.xpath("(//*[@class=\"prodSku\"]/span)[1]");
    private By body_PDPfirstProductSku = By.xpath("//h2[@class='prod_id Utility-TextProduct-SKU-Sm ng-star-inserted']");
    private By body_MoretoExpHeading = By.xpath("//h2[contains(text(), 'More to Explore from Frigidaire')]");

    //************************** Footer Generic **************************
    private final By footerRoot = By.xpath("//footer");
    private final By footer_ElectroluxLogo = By.xpath("//footer//img[contains(@alt,'Electrolux')]");

    // CONTACT & SUPPORT (Customer Service + Owner Support mapping)
    private final By footer_ContactUs = By.xpath("//footer//a[normalize-space()='Contact Us']");
    private final By footer_ServiceAndRepair = By.xpath("//footer//a[contains(normalize-space(.),'Service') and contains(normalize-space(.),'Repair')]");
    private final By footer_ProductRegistration = By.xpath("//footer//a[normalize-space()='Product Registration' or normalize-space()='Register Your Product']");
    private final By footer_FAQs = By.xpath("//footer//a[contains(normalize-space(.),'FAQ') or contains(normalize-space(.),'FAQs') or contains(normalize-space(.),'Troubleshooting')]");
    private final By footer_ReturnAndExchangePolicy = By.xpath("//footer//a[contains(normalize-space(.),'Return') and contains(normalize-space(.),'Policy')]");
    private final By footer_ShippingDeliveryInstallPolicy = By.xpath("//footer//a[contains(normalize-space(.),'Shipping') and (contains(normalize-space(.),'Delivery') or contains(normalize-space(.),'Install'))]");
    private final By footer_Financing = By.xpath("//footer//a[contains(normalize-space(.),'Financing')]");
    private final By footer_IcemakerRecall = By.xpath("//footer//a[contains(normalize-space(.),'Recall')]");

    // ABOUT ELECTROLUX
    private final By footer_About_ElectroluxGroup = By.xpath("//footer//a[normalize-space()='Electrolux Group']");
    private final By footer_About_PressNews = By.xpath("//footer//a[contains(normalize-space(.),'Press') or contains(normalize-space(.),'News')]");
    private final By footer_About_FinancialInformation = By.xpath("//footer//a[contains(normalize-space(.),'Financial')]");
    private final By footer_About_CareerOpportunities = By.xpath("//footer//a[contains(normalize-space(.),'Career')]");
    private final By footer_About_ElectroluxProfessional = By.xpath("//footer//a[contains(normalize-space(.),'Electrolux Professional')]");

    // TERMS & CONDITIONS (Others)
    private final By footer_Terms_PrivacyPolicy = By.xpath("//footer//a[contains(normalize-space(.),'Privacy Policy')]");
    private final By footer_Terms_DoNotSell = By.xpath("//footer//a[contains(normalize-space(.),'Do not sell my information') or contains(normalize-space(.),'Do Not Sell')]");
    private final By footer_Terms_TermsAndConditions = By.xpath("//footer//a[contains(normalize-space(.),'Terms') and contains(normalize-space(.),'Conditions')]");
    private final By footer_Terms_TransparencySupplyChains = By.xpath("//footer//a[contains(normalize-space(.),'Transparency') and contains(normalize-space(.),'Supply')]");

    // CONNECT WITH US (social)
    private final By footer_Connect_Facebook_Anchor = By.xpath("//footer//a[contains(@href,'facebook.com')]");
    private final By footer_Connect_Youtube_Anchor = By.xpath("//footer//a[contains(@href,'youtube.com') or contains(@href,'youtu.be')]");
    private final By footer_Connect_Instagram_Anchor = By.xpath("//footer//a[contains(@href,'instagram.com')]");

    // Not in USA? and Live Chat
    private final By footer_NotInUSA = By.xpath("//footer//a[normalize-space()='Not in USA?']");
    private final By footer_LiveChatIcon = By.xpath("//footer//*[contains(translate(@alt,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'chat') or contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'chat') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'chat') or contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'chat')]");
    private final By liveChat_Interface = By.xpath("//*[contains(@class,'chat') or contains(@id,'chat') or contains(@title,'Chat')]");
    private final By chatIcon_Global = By.xpath("//*[contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'chat') or contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'chat') or contains(translate(@class,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'chat')][not(self::script)]");

    // Deduplicated wrappers handled above with scroll and overlay suppression
    // Other footer locators and visibility helpers for the sections listed in the TC_03 comments.
    // Connect with us
    private final By footer_Connect_Facebook = By.cssSelector("//li[@role='presentation']//cx-banner[@class='frigfacebook socialIconsClass']//a");
    private final By footer_Connect_Twitter = By.cssSelector("//li[contains(@role,'presentation')]//cx-banner[contains(@class,'frigtwitter socialIconsClass')]//a");
    private final By footer_Connect_Youtube = By.cssSelector("//li[contains(@role,'presentation')]//cx-banner[contains(@class,'frigYoutube socialIconsClass')]//a");
    private final By footer_Connect_Instagram = By.cssSelector("//li[contains(@role,'presentation')]//cx-banner[contains(@class,'frigInstagram socialIconsClass')]//a");
    private final By footer_Connect_Pinterest = By.cssSelector("//li[contains(@role,'presentation')]//cx-banner[contains(@class,'frigPinterest socialIconsClass')]//a");
    // Others
    private final By footer_Other_Privacy = By.cssSelector("a[aria-label='Privacy policy.  of ']");
    private final By footer_Other_TermAndCondition = By.cssSelector("a[aria-label='Terms & Conditions Node.  of ']");
    private final By footer_Other_DoNotSell = By.cssSelector("a[aria-label='Do not sell my information.  of ']");

    //==================== TC_03 Comprehensive Footer & Newsletter Locators ====================
    // Footer root
    private final By footer_Root = By.xpath("//footer");

    // Footer section headings
    private final By footer_Heading_ContactSupport = By.xpath("//footer//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'contact & support') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'support') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'contact us')]");
    private final By footer_Heading_AboutElectrolux = By.xpath("//footer//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'about electrolux')]");
    private final By footer_Heading_TermsConditions = By.xpath("//footer//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'terms & conditions')]");
    private final By footer_Heading_ConnectWithUs = By.xpath("//footer//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'connect with us')]");

    // CONTACT & SUPPORT links
    private final By footer_Link_ContactUs = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'contact us')]");
    private final By footer_Link_ServiceRepair = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'service & repair')]");
    private final By footer_Link_ProductRegistration = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'product registration')]");
    private final By footer_Link_FAQs = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')," +
            "concat('faq'," +
            "'s'))]");
    private final By footer_Link_ReturnExchange = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'return and exchange policy')]");
    private final By footer_Link_ShippingDeliveryInstall = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'shipping, delivery and install policy')]");
    private final By footer_Link_Financing = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'financing')]");
    private final By footer_Link_IcemakerRecall = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'icemaker recall')]");

    // ABOUT ELECTROLUX links
    private final By footer_Link_ElectroluxGroup = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'electrolux group')]");
    private final By footer_Link_PressNews = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'press & news')]");
    private final By footer_Link_FinancialInfo = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'financial information')]");
    private final By footer_Link_CareerOpportunities = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'career opportunities')]");
    private final By footer_Link_ElectroluxProfessional = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'electrolux professional')]");

    // TERMS & CONDITIONS links
    private final By footer_Link_PrivacyPolicy = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'privacy policy')]");
    private final By footer_Link_DoNotSellInfo = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'do not sell my information')]");
    private final By footer_Link_TermsConditions = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'terms & conditions')]");
    private final By footer_Link_TransparencySupplyChains = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'transparency in supply chains')]");

    // Not in USA?
    private final By footer_Link_NotInUSA = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'not in usa')]");

    // Newsletter - Left
    private final By newsletterLeft_EmailInput = By.xpath("//footer//input[@type='email']");
    private final By newsletterLeft_SignUpButton = By.xpath("//footer//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'sign up')]");
    private final By newsletterLeft_TermsText = By.xpath("//footer//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'by submitting this form')]");
    private final By newsletterLeft_Heading = By.xpath("//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'first to know') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'stay in the know') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'sign up for emails')]");
    private final By newsletterLeft_Description = By.xpath("//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'get the latest deals') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'exclusive offers') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'promotions')]");

    // Newsletter - Right
    private final By newsletterRight_Heading = By.xpath("//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'get more from frigidaire')]");
    private final By newsletterRight_SpecialOffers = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'special offers') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'promotions')]");
    private final By newsletterRight_Support = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'support')]");
    private final By newsletterRight_ProductRegistration = By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'product registration')]");

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


    private final By productsLink = By.linkText("Products");
    private final By electroluxLogo = By.cssSelector("img[alt='Electrolux']");
    private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private final By navigationBarAirConditioners = By.xpath("//h5[@aria-label='Air Conditioners']");
    private final By windowMounted = By.xpath("//h5[contains(text(), 'Window Mounted')]");
    private final By navigationBarKitchen = By.xpath("//h5[@aria-label='Kitchen']");
    private final By frenchDoor = By.xpath("//h5[contains(text(), 'French Door')]");
    private final By homePageTemplate = By.xpath("//cx-page-layout[contains(@class,'ElxSecondaryPageTemplate')]");
    private final By userGreetingDropdownButton = By.xpath("(//a[@role='link' and contains(.,'Hello')])[1]");
    private final By cookie_AcceptButton = By.id("onetrust-accept-btn-handler");
    
    
    private void acceptCookiesIfPresent() {
        try {
            try { WaitUtils.untilPresent(cookie_AcceptButton, 5); } catch (Exception ignored) {}
            if (WebElementUtil.isDisplayed(cookie_AcceptButton)) {
                WebElementUtil.clickElement(cookie_AcceptButton);
                WaitUtils.sleep(500);
            }
        } catch (Exception ignored) {}
    }

    public ElectroluxHomePageActions navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        try {
            WebElement acceptBtn = untilClickable(acceptButtonLocator, 25);
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
        return WebElementUtil.isDisplayed(electroluxLogo)
        		&& WebElementUtil.isDisplayed(homePageTemplate);
    }

    public boolean isLoginDisplayed() {
        return WebElementUtil.isDisplayed(mainMenu_Login_OrderStatus);
    }

    public ElectroluxHomePageActions clickLoginOrderStatusLink() {
    	WebElementUtil.clickElement(mainMenu_Login_OrderStatus);
    	if(!WebElementUtil.isDisplayed(mainMenu_Login_OrderStatus_CreateAccount)) {
    		WebElementUtil.clickElement(mainMenu_Login_OrderStatus);
    	}
    	return this;
    }

    public ElectroluxLoginPageActions navigateToLoginPage() {
    	navigateToHomePage();
    	WebElementUtil.hoverElement(mainMenu_Login_OrderStatus);
    	WebElementUtil.clickElement(mainMenu_Login_OrderStatus_Login);
    	return new ElectroluxLoginPageActions();
    }


	public boolean isUserGreetingDropdownDisplayed() {
		return WebElementUtil.isDisplayed(userGreetingDropdownButton);
	}
}