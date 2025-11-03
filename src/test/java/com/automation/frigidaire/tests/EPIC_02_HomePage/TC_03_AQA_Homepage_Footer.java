package com.automation.frigidaire.tests.EPIC_02_HomePage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Set;

public class TC_03_AQA_Homepage_Footer extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();

    @Test(groups = {"regression","TC_03"})
    public void TC_03_verifyFooterSectionVisible() {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        Assert.assertTrue(homePage.isFooterDisplayed(), "Footer should be visible.");
        ExtentReportManager.getTest().pass("Footer is visible at the bottom of the page");
    }

    @Test(groups = {"regression","TC_03"})
    public void TC_03_verifyFooterLinksDisplayed() {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        // Section headings
        Assert.assertTrue(homePage.isContactSupportSectionVisible(), "CONTACT & SUPPORT section should be visible");
        //Assert.assertTrue(homePage.isAboutElectroluxSectionVisible(), "ABOUT ELECTROLUX section should be visible");
        Assert.assertTrue(homePage.isTermsConditionsSectionVisible(), "TERMS & CONDITIONS section should be visible");
        Assert.assertTrue(homePage.isConnectWithUsSectionVisible(), "CONNECT WITH US section should be visible");

        // CONTACT & SUPPORT links
        Assert.assertTrue(homePage.isFooter_ContactUsDisplayed(), "Contact Us link should be visible");
        Assert.assertTrue(homePage.isFooter_ServiceRepairDisplayed(), "Service & Repair link should be visible");
        Assert.assertTrue(homePage.isFooter_ProductRegistrationDisplayed(), "Product Registration link should be visible");
        Assert.assertTrue(homePage.isFooter_FAQsDisplayed(), "FAQ's link should be visible");
        Assert.assertTrue(homePage.isFooter_ReturnExchangeDisplayed(), "Return and exchange policy link should be visible");
        Assert.assertTrue(homePage.isFooter_ShippingDeliveryInstallDisplayed(), "Shipping, Delivery and Install Policy link should be visible");
        Assert.assertTrue(homePage.isFooter_FinancingDisplayed(), "Financing link should be visible");
        Assert.assertTrue(homePage.isFooter_IcemakerRecallDisplayed(), "Icemaker Recall link should be visible");

        // ABOUT ELECTROLUX links
        Assert.assertTrue(homePage.isFooter_ElectroluxGroupDisplayed(), "Electrolux Group link should be visible");
        Assert.assertTrue(homePage.isFooter_PressNewsDisplayed(), "Press & News link should be visible");
        Assert.assertTrue(homePage.isFooter_FinancialInfoDisplayed(), "Financial Information link should be visible");
        Assert.assertTrue(homePage.isFooter_CareerOpportunitiesDisplayed(), "Career Opportunities link should be visible");
        Assert.assertTrue(homePage.isFooter_ElectroluxProfessionalDisplayed(), "Electrolux Professional link should be visible");

        // TERMS & CONDITIONS links
        Assert.assertTrue(homePage.isFooter_PrivacyPolicyDisplayed(), "Privacy Policy link should be visible");
        Assert.assertTrue(homePage.isFooter_DoNotSellInfoDisplayed(), "Do not sell my information link should be visible");
        Assert.assertTrue(homePage.isFooter_TermsConditionsDisplayed(), "Terms & Conditions link should be visible");
        Assert.assertTrue(homePage.isFooter_TransparencySupplyChainsDisplayed(), "Transparency in Supply Chains link should be visible");

        // Not in USA?
        Assert.assertTrue(homePage.isFooter_NotInUSADisplayed(), "Not in USA? link should be visible");

        // CONNECT WITH US icons (basic presence via banners)
        Assert.assertTrue(homePage.isFooterDisplayed(), "Footer root visible for social icons context");
        Assert.assertTrue(homePage.isConnectWithUsSectionVisible(), "Connect with us section should be visible");
        ExtentReportManager.getTest().pass("All required footer sections and links are displayed");
    }

    @Test(groups = {"regression","TC_03"}, description = "Verify external vs internal link behaviors from footer")
    public void TC_03_verifyFooterLinksFunctionality() {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        ExtentReportManager.getTest().pass("Navigated to home page and scrolled to footer");

        String homeUrl = WebElementUtil.getCurrentUrl();
        Set<String> before = WebElementUtil.getWindowHandles();

        // Internal example: Contact Us should open in same tab
        Assert.assertTrue(homePage.isFooter_ContactUsDisplayed(), "Contact Us link present");
        ExtentReportManager.getTest().pass("Contact Us link present in footer");
        homePage.clickFooter_ContactUs();
        WaitUtils.waitForPageLoad();
        String contactUrl = WebElementUtil.getCurrentUrl();
        Assert.assertNotEquals(contactUrl, homeUrl, "Internal link should navigate in same tab");
        ExtentReportManager.getTest().pass("Contact Us navigated internally within same tab");

        // Navigate back and test an external example (social icon) opens new tab
        WebElementUtil.navigateTo("https://www.frigidaire.com/en/");
        homePage.scrollToFooter();
        ExtentReportManager.getTest().pass("Returned to home page for external link validation");
        before = WebElementUtil.getWindowHandles();
        WebElementUtil.clickElement(By.xpath("//li[@role='presentation']//cx-banner[contains(@class,'frigfacebook')]//a"));
        WaitUtils.sleep(2000);
        Set<String> after = WebElementUtil.getWindowHandles();
        Assert.assertTrue(after.size() > before.size(), "External link should open in new tab");
        ExtentReportManager.getTest().pass("External social link opened in a new tab");
        WebElementUtil.closeNewTabIfOpened(before);
        ExtentReportManager.getTest().pass("Closed newly opened tab and returned to original window");
    }

    @Test(groups = {"regression","TC_03"}, description = "Verify Live Chat Icon opens chat interface")
    public void TC_03_verifyLiveChatIconShowsInterface() {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        Assert.assertTrue(homePage.isLiveChatIconDisplayed(), "Live Chat icon should be visible");
        homePage.clickLiveChatIcon();
        WaitUtils.sleep(3000);
        Assert.assertTrue(homePage.isLiveChatInterfaceDisplayed(), "Live Chat interface should be displayed after click");
        ExtentReportManager.getTest().pass("Live Chat icon opens chat interface successfully");
    }

    @Test(groups = {"regression","TC_03"}, description = "Verify Left Footer Newsletter content and controls")
    public void TC_03_verifyLeftNewsletterSection() {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        Assert.assertTrue(homePage.isNewsletterLeft_HeadingDisplayed(), "Left newsletter heading visible");
        Assert.assertTrue(homePage.isNewsletterLeft_DescriptionDisplayed(), "Left newsletter description visible");
        Assert.assertTrue(homePage.isNewsletterLeft_EmailInputDisplayed(), "Email input visible");
        Assert.assertTrue(homePage.isNewsletterLeft_SignUpDisplayed(), "Sign Up button visible");
        Assert.assertTrue(homePage.isNewsletterLeft_TermsTextDisplayed(), "Terms text visible");
        ExtentReportManager.getTest().pass("Left footer newsletter content and controls are visible");
    }

    @Test(groups = {"regression","TC_03"}, description = "Verify Sign Up CTA triggers submission flow")
    public void TC_03_verifySignUpCTAFunctionality() {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        if (!homePage.isNewsletterLeft_EmailInputDisplayed() || !homePage.isNewsletterLeft_SignUpDisplayed()) {
            throw new SkipException("Newsletter controls not present in current region/environment");
        }
        homePage.newsletterLeft_EnterEmail("test+qa@frigidaire-automation.example.com");
        homePage.newsletterLeft_ClickSignUp();
        WaitUtils.sleep(2000);
        Assert.assertTrue(homePage.isNewsletterLeft_EmailInputDisplayed(), "Form should remain stable after submit");
        ExtentReportManager.getTest().pass("Sign Up CTA triggered and form remained stable after submission");
    }

    @Test(groups = {"regression","TC_03"}, description = "Verify Right Footer Newsletter section visibility")
    public void TC_03_verifyRightNewsletterSection() {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        Assert.assertTrue(homePage.isNewsletterRight_HeadingDisplayed(), "Right newsletter heading visible");
        Assert.assertTrue(homePage.isNewsletterRight_SpecialOffersDisplayed(), "Special Offers/Promotions link visible");
        Assert.assertTrue(homePage.isNewsletterRight_SupportDisplayed(), "Support link visible");
        Assert.assertTrue(homePage.isNewsletterRight_ProductRegistrationDisplayed(), "Product Registration link visible");
        ExtentReportManager.getTest().pass("Right footer newsletter section and links are visible");
    }

    @Test(groups = {"regression","TC_03"}, description = "Verify Right Footer Newsletter links navigate to pages")
    public void TC_03_verifyRightNewsletterLinksNavigation() {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        String startUrl = WebElementUtil.getCurrentUrl();

        // Special Offers/Promotions
        if (homePage.isNewsletterRight_SpecialOffersDisplayed()) {
            WebElementUtil.clickElement(By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'special offers') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'promotions')]"));
            WaitUtils.waitForPageLoad();
            Assert.assertNotEquals(WebElementUtil.getCurrentUrl(), startUrl, "Special Offers/Promotions should navigate");
            WebElementUtil.navigateTo("https://www.frigidaire.com/en/");
            homePage.scrollToFooter();
        }

        // Support
        if (homePage.isNewsletterRight_SupportDisplayed()) {
            WebElementUtil.clickElement(By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'support')]"));
            WaitUtils.waitForPageLoad();
            Assert.assertNotEquals(WebElementUtil.getCurrentUrl(), startUrl, "Support should navigate");
            WebElementUtil.navigateTo("https://www.frigidaire.com/en/");
            homePage.scrollToFooter();
        }

        // Product Registration
        if (homePage.isNewsletterRight_ProductRegistrationDisplayed()) {
            WebElementUtil.clickElement(By.xpath("//footer//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'product registration')]"));
            WaitUtils.waitForPageLoad();
            Assert.assertNotEquals(WebElementUtil.getCurrentUrl(), startUrl, "Product Registration should navigate");
        }
        ExtentReportManager.getTest().pass("Right footer newsletter links navigate to their respective pages");
    }
}
