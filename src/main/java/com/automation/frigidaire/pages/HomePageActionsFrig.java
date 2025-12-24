package com.automation.frigidaire.pages;

import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.PdpPageActionsElux;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import static com.automation.utils.WaitUtils.untilClickable;

import com.automation.electrolux.locators.HomepageLocatorsElux;
import com.automation.frigidaire.locators.HomepageLocatorsFrig;

public class HomePageActionsFrig {

    HomepageLocatorsFrig homePage_Locator = new HomepageLocatorsFrig();

    // Locators remain the same
    //************************** Main Menu Bar Locators **************************
    private final By mainMenu_FrigidaireSite = By.cssSelector("img[alt='Frigidaire Brand Site']");
    private final By mainMenu_ElectroluxSite = By.cssSelector("img[alt='Electrolux Brand Site']");
    private final By mainMenu_Login_OrderStatus = By.xpath("(//div[contains(.,'Log in / Order status')])[1]");
    private final By mainMenu_Contact = By.xpath("//a[contains(text(),'Contact us')]");
    private final By mainMenu_DeliverTo = By.xpath("//div[@class='pdp-hide-header-visible']//span[@class='Set-delivery-area']");
    private final By mainMenu_Cart = By.xpath("//img[@alt='Your Shopping Cart']");
    private final By mainMenu_Login_OrderStatus_Login = By.xpath("//*[@id='dropdown']//button[contains(.,'Log in')]");
    private final By mainMenu_Login_OrderStatus_CreateAccount = By.xpath("//*[@id='dropdown']//button[contains(.,'Create an account')]");

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
    // Footer helpers
    public void scrollToFooter() throws InterruptedException {
        WaitUtils.waitForPageLoad();
        acceptCookiesIfPresent();
        int attempts = 0;
        while (attempts < 3) {
            try {
                ((JavascriptExecutor) DriverManager.getDriver())
                        .executeScript("window.scrollTo({top: Math.max(document.body.scrollHeight, document.documentElement.scrollHeight), behavior: 'instant'});");
                suppressObstructingOverlays();
                // Ensure footer is present and visible
                WaitUtils.untilPresent(homePage_Locator.footer_Root, 10);
                WaitUtils.untilVisible(homePage_Locator.footer_Root, 10);
                return;
            } catch (StaleElementReferenceException sere) {
                attempts++;
                WaitUtils.sleep(300);
            } catch (Exception e) {
                attempts++;
                WaitUtils.sleep(300);
            }
        }
        // Final attempt using visibility check
        try {
            WaitUtils.untilVisible(homePage_Locator.footer_Root, 10);
        } catch (Exception ignored) {}
    }

    private void suppressObstructingOverlays() {
        try {
            String script = "const sels=[" +
                    "'[aria-label=\\'chat\\' i]', '[id*=\\'chat\\' i]', '[class*=\\'chat\\' i]'," +
                    "'[aria-label=\\'feedback\\' i]', '[class*=\\'feedback\\' i]'," +
                    "'iframe[src*=\\'chat\\']', 'iframe[src*=\\'livechat\\']'," +
                    "'#onetrust-banner-sdk', '#onetrust-pc-sdk', '[id*=\\'onetrust\\' i]', '.ot-sdk-container'" +
                    "];" +
                    "document.querySelectorAll('#onetrust-banner-sdk,#onetrust-pc-sdk,[id*=onetrust],.ot-sdk-container').forEach(el=>{try{el.style.pointerEvents='none'; el.style.display='none'; el.style.visibility='hidden'; el.style.zIndex='-1';}catch(e){}});" +
                    "sels.forEach(sel=>{document.querySelectorAll(sel).forEach(el=>{try{el.style.pointerEvents='none'; el.style.zIndex='0';}catch(e){}})});";
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript(script);
        } catch (Exception ignored) {}
    }

    private void acceptCookiesIfPresent() {
        try {
            try { WaitUtils.untilPresent(homePage_Locator.cookie_AcceptButton, 5); } catch (Exception ignored) {}
            if (WebElementUtil.isDisplayed(homePage_Locator.cookie_AcceptButton)) {
                WebElementUtil.clickElement(homePage_Locator.cookie_AcceptButton);
                WaitUtils.sleep(500);
            }
        } catch (Exception ignored) {}
    }

    public void clickFooter_ContactUs() throws InterruptedException {
        scrollToFooter();
        acceptCookiesIfPresent();
        WebElementUtil.scrollIntoView(footer_Link_ContactUs, 150);
        suppressObstructingOverlays();
        WebElementUtil.clickElement(footer_Link_ContactUs);
    }

    public boolean isFooterVisible() {
        return WebElementUtil.isDisplayed(footerRoot);
    }

    public boolean isFooterElectroluxLogoDisplayed() {
        return WebElementUtil.isDisplayed(footer_ElectroluxLogo);
    }

    // CONTACT & SUPPORT visibility
    public boolean isFooterContactUsDisplayed() { return WebElementUtil.isDisplayed(footer_ContactUs); }
    public boolean isFooterServiceAndRepairDisplayed() { return WebElementUtil.isDisplayed(footer_ServiceAndRepair); }
    public boolean isFooterProductRegistrationDisplayed() { return WebElementUtil.isDisplayed(footer_ProductRegistration); }
    public boolean isFooterFAQsDisplayed() { return WebElementUtil.isDisplayed(footer_FAQs); }
    public boolean isFooterReturnAndExchangePolicyDisplayed() { return WebElementUtil.isDisplayed(footer_ReturnAndExchangePolicy); }
    public boolean isFooterShippingDeliveryInstallPolicyDisplayed() { return WebElementUtil.isDisplayed(footer_ShippingDeliveryInstallPolicy); }
    public boolean isFooterFinancingDisplayed() { return WebElementUtil.isDisplayed(footer_Financing); }
    public boolean isFooterIcemakerRecallDisplayed() { return WebElementUtil.isDisplayed(footer_IcemakerRecall); }

    // ABOUT ELECTROLUX visibility
    public boolean isFooterAboutElectroluxGroupDisplayed() { return WebElementUtil.isDisplayed(footer_About_ElectroluxGroup); }
    public boolean isFooterAboutPressNewsDisplayed() { return WebElementUtil.isDisplayed(footer_About_PressNews); }
    public boolean isFooterAboutFinancialInformationDisplayed() { return WebElementUtil.isDisplayed(footer_About_FinancialInformation); }
    public boolean isFooterAboutCareerOpportunitiesDisplayed() { return WebElementUtil.isDisplayed(footer_About_CareerOpportunities); }
    public boolean isFooterAboutElectroluxProfessionalDisplayed() { return WebElementUtil.isDisplayed(footer_About_ElectroluxProfessional); }

    // TERMS & CONDITIONS visibility
    public boolean isFooterPrivacyPolicyDisplayed() { return WebElementUtil.isDisplayed(footer_Terms_PrivacyPolicy); }
    public boolean isFooterDoNotSellDisplayed() { return WebElementUtil.isDisplayed(footer_Terms_DoNotSell); }

    // CONNECT WITH US visibility
    public boolean isFooterFacebookIconDisplayed() { return WebElementUtil.isDisplayed(footer_Connect_Facebook_Anchor); }
    public boolean isFooterYoutubeIconDisplayed() { return WebElementUtil.isDisplayed(footer_Connect_Youtube_Anchor); }
    public boolean isFooterInstagramIconDisplayed() { return WebElementUtil.isDisplayed(footer_Connect_Instagram_Anchor); }

    // Not in USA? and Live Chat
    public boolean isFooterNotInUSADisplayed() { return WebElementUtil.isDisplayed(footer_NotInUSA); }
    public boolean isLiveChatIconDisplayed() throws InterruptedException {
        scrollToFooter();
        try { WaitUtils.untilPresent(footer_LiveChatIcon, 10); } catch (Exception ignored) {}
        try { WaitUtils.untilPresent(chatIcon_Global, 10); } catch (Exception ignored) {}
        return WebElementUtil.isDisplayed(footer_LiveChatIcon) || WebElementUtil.isDisplayed(chatIcon_Global);
    }
    public void clickLiveChatIcon() throws InterruptedException {
        scrollToFooter();
        suppressObstructingOverlays();
        if (WebElementUtil.isDisplayed(footer_LiveChatIcon)) {
            WebElementUtil.scrollIntoView(footer_LiveChatIcon, 150);
            WebElementUtil.clickElement(footer_LiveChatIcon);
        } else if (WebElementUtil.isDisplayed(chatIcon_Global)) {
            WebElementUtil.scrollIntoView(chatIcon_Global, 150);
            WebElementUtil.clickElement(chatIcon_Global);
        }
    }
    public boolean isLiveChatInterfaceDisplayed() { return WebElementUtil.isDisplayed(liveChat_Interface); }


    public HomePageActionsFrig navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        try {
            WebElement acceptBtn = untilClickable(homePage_Locator.acceptButtonLocator, 15);
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
        return WebElementUtil.isDisplayed(homePage_Locator.frigidaireLogo)
        		&& WebElementUtil.isDisplayed(homePage_Locator.homePageTemplate);
    }

    public boolean isBrancdLogoLoaded() {
        return WebElementUtil.isDisplayed(homePage_Locator.frigidaireLogo);
    }

//    public void navigateToLoginPage() {
//        WebElementUtil.hoverOverElement(mainMenu_Login_OrderStatus);
//        WebElementUtil.clickElement(mainMenu_Login);
//    }

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


    public ProductCategoryPageActionsFrig clickProductsLink() {
        WebElementUtil.clickElement(productsLink);
        return new ProductCategoryPageActionsFrig();
    }
    public boolean isLoginDisplayed() {
        return WebElementUtil.isDisplayed(mainMenu_Login_OrderStatus);
    }

    //Methods for Header
    public boolean validateInvalidZIPWhenBlank() {
        WebElementUtil.clickElement(mainMenu_DeliverTo);
        WebElement zipInput = WebElementUtil.waitForElementToBeVisible(By.xpath("//*[@id=\"ngb-popover-1\"]/div[2]/div/form/div/div/input"));
        zipInput.clear();
        WebElement errorMessage = WebElementUtil.waitForElementToBeVisible(By.xpath("//*[@id=\"ngb-popover-1\"]/div[2]/div/form/div[2]"));
        return errorMessage.getText().contains("Invalid Zip Code");
    }

    public boolean validateInvalidZIPWhenLessThan5Digits() {
        WebElementUtil.clickElement(mainMenu_DeliverTo);
        WebElement zipInput = WebElementUtil.waitForElementToBeVisible(By.xpath("//*[@id=\"ngb-popover-1\"]/div[2]/div/form/div/div/input"));
        zipInput.clear();
        zipInput.sendKeys("123");
        WebElement errorMessage = WebElementUtil.waitForElementToBeVisible(By.xpath("//*[@id=\"ngb-popover-1\"]/div[2]/div/form/div[2]"));
        return errorMessage.getText().contains("Invalid Zip Code");
    }

    public void enterZipCode(String zip) {
        WebElementUtil.clickElement(mainMenu_DeliverTo);
        WebElement zipInput = WebElementUtil.waitForElementToBeVisible(By.xpath("//*[@id=\"ngb-popover-1\"]/div[2]/div/form/div/div/input"));
        zipInput.clear();
        zipInput.sendKeys(zip);
        WebElementUtil.clickElement(By.cssSelector("#deliverToRibbonZipCodeButton"));
    }

    public boolean isMiniCartCountUpdated() {
        WebElement cartIcon = WebElementUtil.waitForElementToBeVisible(mainMenu_Cart);
        String ariaLabel = WebElementUtil.getText(mainMenu_CartCount);
        return ariaLabel != null && ariaLabel.contains("1");
    }

    public void addIteamToCart(String itemName) {
        WebElementUtil.sendKeys(mainMenu_searchInput, itemName);
        WebElementUtil.clickElement(mainMenu_searchButton);
        WebElementUtil.clickElement(mainMenu_Logo);
    }

    public HomePageActionsFrig clickLoginOrderStatusLink() {
    	WebElementUtil.clickElement(mainMenu_Login_OrderStatus);
    	if(!WebElementUtil.isDisplayed(mainMenu_Login_OrderStatus_CreateAccount)) {
    		WebElementUtil.clickElement(mainMenu_Login_OrderStatus);
    	}
    	return this;
    }

    public CreateAccountPageActionsFrig navigateToCreateAccountPage() {
    	clickLoginOrderStatusLink();
    	WebElementUtil.clickElement(mainMenu_Login_OrderStatus_CreateAccount);
    	return new CreateAccountPageActionsFrig();
    }

    public LoginPageActionsFrig navigateToLoginPage() {
    	navigateToHomePage();
    	WebElementUtil.hoverElement(mainMenu_Login_OrderStatus);
    	WebElementUtil.clickElement(mainMenu_Login_OrderStatus_Login);
    	return new LoginPageActionsFrig();
    }

    public PlpPageActionsFrig clickWindowMounted() {
        WebElementUtil.clickElement(homePage_Locator.navigationBarAirConditioners);
        WebElementUtil.clickElement(homePage_Locator.windowMounted);
        return new PlpPageActionsFrig();
    }

    public PlpPageActionsFrig clickFrenchDoor() {
        WebElementUtil.clickElement(homePage_Locator.navigationBarKitchen);
        WebElementUtil.clickElement(homePage_Locator.frenchDoor);
        return new PlpPageActionsFrig();
    }

    public HomePageActionsFrig  clickSearchAndEnterProductId(String productId) {
        WebElementUtil.clickElement(homePage_Locator.searchBox);
        WebElementUtil.sendKeys(homePage_Locator.searchBox, productId);
        return this;
    }

    public HomePageActionsFrig clickSearchIconAndWaitForAccessProduct() {
        WebElementUtil.clickElement(homePage_Locator.searchIcon);
        WebElementUtil.waitForElementToBeVisible(homePage_Locator.accesProductLink);
        return this;
    }

    public PdpPageActionsFrig clickAccesProduct() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.accesProductLink);
        WebElementUtil.clickElement(homePage_Locator.accesProductLink);
        return new PdpPageActionsFrig();
    }


    public ForgotPasswordPageActionsFrig navigateToResetPasswordPage() {
    	return navigateToLoginPage().clickForgotPasswordLink();
    }

    public boolean isSearchIconDisplayed() {
        return WebElementUtil.isDisplayed(mainMenu_searchInput);
    }

    public void clickSearchInputAndEnterText(String searchText) throws InterruptedException {
        WebElementUtil.clickElement(mainMenu_searchInput);
        WebElement searchInputElement = WebElementUtil.waitForElementToBeVisible(mainMenu_searchInput);
        searchInputElement.clear();
        for (char c : searchText.toCharArray()) {
            searchInputElement.sendKeys(String.valueOf(c));
            WaitUtils.sleep(100);
        }
        if (searchText.length() >= 4) {
            WebElementUtil.waitForElementToBeVisible(mainMenu_searchSuggestions);
        }
    }

    public List<WebElement> getSearchSuggestionsList() {
        WaitUtils.untilPresent(mainMenu_searchSuggestions);
        return WebElementUtil.findElements(mainMenu_searchSuggestions);
    }


    public boolean areSearchSuggestionsDisplayed() {
        try {
            WebElement suggestionsElement = WebElementUtil.waitForElementToBeVisible(mainMenu_searchSuggestions);
            return suggestionsElement.isDisplayed() && !getSearchSuggestionsList().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSearchInputFieldDisplayed() {
        try {
            WebElement searchInputElement = WebElementUtil.waitForElementToBeVisible(mainMenu_searchInput);
            return searchInputElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectFirstSuggestion() {
        WebElementUtil.clickElement(mainMenu_searchSuggestions_FirstElement);
    }

    public boolean isUserOnSearchResultsPage() {
        try {
            WebElement resultsElement = WebElementUtil.waitForElementToBeVisible(mainMenu_searchSuggestions_Landing);
            return resultsElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isShopOurCategoriesSectionDisplayed() {
        return WebElementUtil.waitForElementToBeVisible(body_shopOurCategoriesHeading).isDisplayed() ;
    }

    public List<String> getShopOurCategories() {
        List<String> categories = new ArrayList<>();
        try {
            // Try primary locator first
            List<WebElement> categoryElements = WebElementUtil.findElements(body_category_item);

            for (WebElement categoryElement : categoryElements) {
                String categoryName = categoryElement.getText().trim();
                if (!categoryName.isEmpty() && !categories.contains(categoryName)) {
                    categories.add(categoryName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving categories: " + e.getMessage());
        }
        return categories;
    }

    public boolean isShopOurTopRatedAppliancesSectionDisplayed() {
        return WebElementUtil.waitForElementToBeVisible(body_ShopOurTopRatedAppliancesSection).isDisplayed() ;
    }

    public boolean areProductCardsElementsDisplayed() {
        return WebElementUtil.waitForElementToBeVisible(body_ShopOurTopRatedAppliancesCard).isDisplayed() ;
    }

    public void clickFirstProductCard() throws InterruptedException {
        try {
            WaitUtils.sleep(1000);
            WebElementUtil.scrollIntoView(body_firstProductCard);
            WebElement firstProductCard = WebElementUtil.waitForElementToBeVisible(body_firstProductCard);
            firstProductCard.click();
        } catch (Exception e) {
            System.out.println("Error clicking first product card: " + e.getMessage());
            throw e;
        }
    }

    public boolean isUserOnPDP() {
        String skuProductTitle = WebElementUtil.getText(body_firstProductSku);
        WebElementUtil.clickElement(body_firstProductCard);
        String getSKu = WebElementUtil.getText(body_PDPfirstProductSku);
        return skuProductTitle.equals(getSKu);
    }

    public boolean isMoreToExploreSectionDisplayed(){
        return WebElementUtil.waitForElementToBeVisible(body_MoretoExpHeading).isDisplayed() ;
    }

    public List<String> getMoreToExp() {
        List<String> categories = new ArrayList<>();
        try {
            // Try primary locator first
            WebElementUtil.scrollIntoView(body_category_item);
            List<WebElement> categoryElements = WebElementUtil.findElements(body_category_item);

            for (WebElement categoryElement : categoryElements) {
                String categoryName = categoryElement.getText().trim();
                if (!categoryName.isEmpty() && !categories.contains(categoryName)) {
                    categories.add(categoryName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving categories: " + e.getMessage());
        }
        return categories;
    }


// Right Footer Newsletter: visibility checks
public boolean isRightNewsletter_ProductRegistrationDisplayed() {
    return WebElementUtil.isDisplayed(pre_Footer_GetMoreFromFrigidaire_ProductRegistration);
}

public boolean isRightNewsletter_PromotionsDisplayed() {
    return WebElementUtil.isDisplayed(pre_Footer_GetMoreFromFrigidaire_Promotions);
}

public boolean isRightNewsletter_ExtendedServiceWarrantiesDisplayed() {
    return WebElementUtil.isDisplayed(pre_Footer_GetMoreFromFrigidaire_ExtendedServiceWarranties);
}

public boolean isRightNewsletter_BlogInspirationDisplayed() {
    return WebElementUtil.isDisplayed(pre_Footer_GetMoreFromFrigidaire_BlogInspiration);
}

// Right Footer Newsletter: click actions
public void clickRightNewsletter_ProductRegistration() {
    WebElementUtil.scrollIntoView(pre_Footer_GetMoreFromFrigidaire_ProductRegistration);
    WebElementUtil.clickElement(pre_Footer_GetMoreFromFrigidaire_ProductRegistration);
}

public void clickRightNewsletter_Promotions() {
    WebElementUtil.scrollIntoView(pre_Footer_GetMoreFromFrigidaire_Promotions);
    WebElementUtil.clickElement(pre_Footer_GetMoreFromFrigidaire_Promotions);
}

public void clickRightNewsletter_ExtendedServiceWarranties() {
    WebElementUtil.scrollIntoView(pre_Footer_GetMoreFromFrigidaire_ExtendedServiceWarranties);
    WebElementUtil.clickElement(pre_Footer_GetMoreFromFrigidaire_ExtendedServiceWarranties);
}

public void clickRightNewsletter_BlogInspiration() {
    WebElementUtil.scrollIntoView(pre_Footer_GetMoreFromFrigidaire_BlogInspiration);
    WebElementUtil.clickElement(pre_Footer_GetMoreFromFrigidaire_BlogInspiration);
}

// Right Footer Newsletter: simple page verifications by heading text
public boolean isProductRegistrationPageLoaded() {
    return WebElementUtil.isDisplayed(By.xpath("//h1[contains(text(),'Product Registration')]"));
}

public boolean isPromotionsPageLoaded() {
    return WebElementUtil.isDisplayed(By.xpath("//h1[contains(text(),'Promotions')]|//h2[contains(text(),'Promotions')]"));
}

public boolean isExtendedServiceWarrantiesPageLoaded() {
    return WebElementUtil.isDisplayed(By.xpath("//h1[contains(text(),'Extended Service Warranties')]|//h2[contains(text(),'Extended Service Warranties')]"));
}

public boolean isBlogInspirationPageLoaded() {
    return WebElementUtil.isDisplayed(By.xpath("//h1[contains(text(),'Blog Inspiration')]|//h2[contains(text(),'Blog Inspiration')]"));
}

//==================== TC_03 Footer & Newsletter Helpers ====================
public boolean isFooterDisplayed() { return WebElementUtil.isDisplayed(homePage_Locator.footer_Root); }

// Footer section headings visibility
public boolean isContactSupportSectionVisible(){
    return WebElementUtil.isDisplayed(footer_Heading_ContactSupport)
            || WebElementUtil.isDisplayed(footer_ContactUs)
            || WebElementUtil.isDisplayed(footer_ServiceAndRepair)
            || WebElementUtil.isDisplayed(footer_FAQs);
}
public boolean isAboutElectroluxSectionVisible() throws InterruptedException {
    scrollToFooter();
    try { WaitUtils.untilPresent(footer_Heading_AboutElectrolux, 10); } catch (Exception ignored) {}
    return WebElementUtil.isDisplayed(footer_Heading_AboutElectrolux)
            || WebElementUtil.isDisplayed(footer_About_ElectroluxGroup)
            || WebElementUtil.isDisplayed(footer_About_PressNews)
            || WebElementUtil.isDisplayed(footer_About_FinancialInformation)
            || WebElementUtil.isDisplayed(footer_About_CareerOpportunities)
            || WebElementUtil.isDisplayed(footer_About_ElectroluxProfessional)
            || WebElementUtil.isDisplayed(By.xpath("//footer//a[contains(@href,'electroluxgroup')]"))
            || WebElementUtil.isDisplayed(By.xpath("//footer//a[contains(@href,'careers.electroluxgroup')]"))
            || WebElementUtil.isDisplayed(By.xpath("//footer//a[contains(@href,'electroluxprofessional')]"));
}
public boolean isTermsConditionsSectionVisible(){
    return WebElementUtil.isDisplayed(footer_Heading_TermsConditions)
            || WebElementUtil.isDisplayed(footer_Terms_PrivacyPolicy)
            || WebElementUtil.isDisplayed(footer_Terms_DoNotSell)
            || WebElementUtil.isDisplayed(footer_Terms_TermsAndConditions)
            || WebElementUtil.isDisplayed(footer_Terms_TransparencySupplyChains);
}
public boolean isConnectWithUsSectionVisible(){
    return WebElementUtil.isDisplayed(footer_Heading_ConnectWithUs)
            || WebElementUtil.isDisplayed(footer_Connect_Facebook_Anchor)
            || WebElementUtil.isDisplayed(footer_Connect_Youtube_Anchor)
            || WebElementUtil.isDisplayed(footer_Connect_Instagram_Anchor);
}

// CONTACT & SUPPORT visibility
public boolean isFooter_ContactUsDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_ContactUs); }
public boolean isFooter_ServiceRepairDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_ServiceRepair); }
public boolean isFooter_ProductRegistrationDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_ProductRegistration); }
public boolean isFooter_FAQsDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_FAQs); }
public boolean isFooter_ReturnExchangeDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_ReturnExchange); }
public boolean isFooter_ShippingDeliveryInstallDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_ShippingDeliveryInstall); }
public boolean isFooter_FinancingDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_Financing); }
public boolean isFooter_IcemakerRecallDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_IcemakerRecall); }

public void clickFooter_IcemakerRecall() throws InterruptedException {
    scrollToFooter();
    suppressObstructingOverlays();
    WebElementUtil.scrollIntoView(footer_Link_IcemakerRecall, 150);
    WebElementUtil.clickElement(footer_Link_IcemakerRecall);
}

// ABOUT ELECTROLUX visibility
public boolean isFooter_ElectroluxGroupDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_ElectroluxGroup); }
public boolean isFooter_PressNewsDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_PressNews); }
public boolean isFooter_FinancialInfoDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_FinancialInfo); }
public boolean isFooter_CareerOpportunitiesDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_CareerOpportunities); }
public boolean isFooter_ElectroluxProfessionalDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_ElectroluxProfessional); }
public boolean isFooter_PrivacyPolicyDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_PrivacyPolicy); }
public boolean isFooter_DoNotSellInfoDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_DoNotSellInfo); }
public boolean isFooter_TermsConditionsDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_TermsConditions); }
public boolean isFooter_TransparencySupplyChainsDisplayed(){ return WebElementUtil.isDisplayed(footer_Link_TransparencySupplyChains); }
public boolean isFooter_NotInUSADisplayed(){ return WebElementUtil.isDisplayed(footer_Link_NotInUSA); }

// Duplicate method removed; using earlier version with overlay suppression

// Dynamic header helpers for L0/L1 checks
public boolean isHeaderCategoryDisplayed(String categoryLabel) {
    By category = By.cssSelector("h5[aria-label='" + categoryLabel + "']");
    return WebElementUtil.isDisplayed(category);
}

public void openHeaderCategory(String categoryLabel) {
    By category = By.cssSelector("h5[aria-label='" + categoryLabel + "']");
    WebElementUtil.clickElement(category);
}

public boolean isHeaderSubcategoryDisplayed(String subLabel) {
    By sub = By.xpath("//h5[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')," +
            "'" + subLabel.toLowerCase() + "')]");
    return WebElementUtil.isDisplayed(sub);
}

// More to Explore CTA click by link text
public void clickMoreToExploreLink(String linkText) {
    By link = By.xpath("//h2[contains(.,'More to Explore')]/following::a[normalize-space()='%s']".replace("%s", linkText));
    WebElementUtil.scrollIntoView(link);
    WebElementUtil.clickElement(link);
}

// Newsletter left visibility and actions
public boolean isNewsletterLeft_HeadingDisplayed(){
    return WebElementUtil.isDisplayed(newsletterLeft_Heading)
            || WebElementUtil.isDisplayed(pre_Footer_FirstToKnow_EmailInput)
            || WebElementUtil.isDisplayed(pre_Footer_FirstToKnow_SubmitButton);
}
public boolean isNewsletterLeft_DescriptionDisplayed(){
    return WebElementUtil.isDisplayed(newsletterLeft_Description)
            || WebElementUtil.isDisplayed(pre_Footer_FirstToKnow_TermsAndConditions)
            || WebElementUtil.isDisplayed(pre_Footer_FirstToKnow_PrivacyPolicy);
}
public boolean isNewsletterLeft_EmailInputDisplayed(){
    if (WebElementUtil.isDisplayed(By.xpath("//input[@id='newsletterEmailControl']"))) {
        return true;
    }
    return WebElementUtil.isDisplayed(newsletterLeft_EmailInput);
}
public boolean isNewsletterLeft_SignUpDisplayed(){
    if (WebElementUtil.isDisplayed(By.xpath("//input[@id='submitBtn']"))) {
        return true;
    }
    return WebElementUtil.isDisplayed(newsletterLeft_SignUpButton);
}
public boolean isNewsletterLeft_TermsTextDisplayed(){
    if (WebElementUtil.isDisplayed(By.xpath("//u[normalize-space()='Terms and Conditions']"))
            || WebElementUtil.isDisplayed(By.xpath("//u[normalize-space()='Privacy Policy']"))){
        return true;
    }
    return WebElementUtil.isDisplayed(newsletterLeft_TermsText);
}
public void newsletterLeft_EnterEmail(String email){
    if (WebElementUtil.isDisplayed(By.xpath("//input[@id='newsletterEmailControl']"))) {
        WebElementUtil.sendKeys(By.xpath("//input[@id='newsletterEmailControl']"), email);
        return;
    }
    WebElementUtil.sendKeys(newsletterLeft_EmailInput, email);
}
public void newsletterLeft_ClickSignUp(){
    if (WebElementUtil.isDisplayed(By.xpath("//input[@id='submitBtn']"))) {
        WebElementUtil.clickElement(By.xpath("//input[@id='submitBtn']"));
        return;
    }
    WebElementUtil.clickElement(newsletterLeft_SignUpButton);
}

// Newsletter Right visibility
public boolean isNewsletterRight_HeadingDisplayed(){
    return WebElementUtil.isDisplayed(newsletterRight_Heading);
}
public boolean isNewsletterRight_SpecialOffersDisplayed(){
    return WebElementUtil.isDisplayed(newsletterRight_SpecialOffers);
}
public boolean isNewsletterRight_SupportDisplayed(){
    return WebElementUtil.isDisplayed(newsletterRight_Support);
}
public boolean isNewsletterRight_ProductRegistrationDisplayed(){
    return WebElementUtil.isDisplayed(newsletterRight_ProductRegistration);
}

public boolean isUserGreetingDropdownDisplayed() {
    return WebElementUtil.isDisplayed(homePage_Locator.userGreetingDropdownButton);
}

public HomePageActionsFrig acceptCookies() {
	try {
        WebElement acceptBtn = untilClickable(homePage_Locator.acceptButtonLocator, 20);
        if (acceptBtn != null) {
            acceptBtn.click();
        }
    } catch (Exception ignored) {
        // Cookie banner not present or not interactable; continue
    }
    return this;
}
}