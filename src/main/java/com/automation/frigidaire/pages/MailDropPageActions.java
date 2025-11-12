package com.automation.frigidaire.pages;

import java.time.Duration;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class MailDropPageActions {

	private final By headerEmailAddressField = By.cssSelector("div.top-16 input[placeholder='view-this-mailbox']");
	private final By headerViewMailBoxButton = By.xpath("//div[contains(@class,'top-16')]//button[contains(.,'View Mailbox')]");
	private final By inboxRefreshButton = By.xpath("//button[contains(.,'Refresh')]");
	private final By firstMail = By.xpath("(//div[contains(@class,'message')])[1]");
	private final By mailTitle = By.xpath("(//div[contains(@class,'md:rounded-t-lg')]//div)[3]");
	private final By mailResetPasswordLink = By.cssSelector("a[href*='resetPassword']");
	private final By passwordResetMailBodyText = By.xpath("//div[@class='header-text']");
	private final By mailFrame = By.cssSelector("iframe.w-full");
	private final By mailFridgidaireLogo = By.xpath("//img[contains(@src,'frigidaire-logo') or contains(@src,'Logo-Frigidaire')]");
	private final By passwordChangeSuccessMailBodyText = By.cssSelector("div.verification-text");
	private final By mailContactUsLink = By.xpath("//a[.='contact us']");
	private final By mailConnectSocialMediaLinks = By.xpath("//div[@class='socialIcons']//a");
	private final By mailFooterLinks = By.xpath("//div[@class='footer-links']//a");
	private final By firstMailSubject = By.xpath("(//div[contains(@class,'message')])[1]//div[@class='truncate']");
	
	public MailDropPageActions navigateToMailDropPage() {
		WebElementUtil.navigateTo("https://maildrop.cc/");
		return this;
	}
	
	public MailDropPageActions enterEmailAddress(String emailAddress) throws InterruptedException {
		WaitUtils.sleep(2000);
		WebElementUtil.sendKeys(headerEmailAddressField, emailAddress);
		return this;
	}
	
	public MailDropPageActions clickViewMailBoxButton() {
		WebElementUtil.clickElement(headerViewMailBoxButton);
		return this;
	}
	
	public boolean isInboxLoaded() {
		return WebElementUtil.isDisplayed(inboxRefreshButton);
	}
	
	public MailDropPageActions login(String emailAddress) throws InterruptedException {
		return navigateToMailDropPage()
					.enterEmailAddress(emailAddress)
					.clickViewMailBoxButton();
	}

	public MailDropPageActions clickInboxRefresh() {
		WebElementUtil.clickElement(inboxRefreshButton);
		return this;
	}
	
	public MailDropPageActions clickFirstMailInInbox() {	
		WebElementUtil.clickElement(firstMail);
		return this;
	}
	
	public MailDropPageActions openFirstMailInInbox(String emailAddress) throws InterruptedException {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		WaitUtils.sleep(2000);
		return this;
	}
	
	public MailDropPageActions openFirstMailInInbox(String emailAddress, String expectedMailTitle) throws InterruptedException {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		for(int i=0;i<5;i++) {
			WaitUtils.sleep(2000);
			if(getMailTitle().equalsIgnoreCase(expectedMailTitle)) {
				return this;
			}
			clickInboxRefresh();
		}
		WaitUtils.sleep(1000);
		return this;
	}

	public String getMailTitle() throws InterruptedException {
		var mailTitleValue = WebElementUtil.getText(mailTitle);
	    if(mailTitleValue.equals(null) || mailTitleValue.isEmpty() || mailTitleValue.equals("")) {
	    	WaitUtils.sleep(2000);
	    	mailTitleValue = WebElementUtil.getText(mailTitle);
	    }
	    return mailTitleValue;
	}
	

	public boolean isMailResetYourPasswordLinkDisplayed() {
	    return WebElementUtil.performInFrame(mailFrame, () -> 
	        WebElementUtil.isDisplayed(mailResetPasswordLink)
	    );
	}
	
	public FrigidaireResetPasswordPageActions clickMailResetYourPasswordLink() throws InterruptedException {
		WaitUtils.sleep(2000);
		WebElementUtil.switchToFrame(mailFrame);
//		WebElementUtil.ctrlClick(mailResetPasswordLink);
//		WebElementUtil.ctrlClickWithJS(mailResetPasswordLink);
		WebElementUtil.openLinkInNewTab(mailResetPasswordLink);
		WebElementUtil.switchToDefaultContent();
		WebElementUtil.switchToLatestTabAndClosePrevious();
		return new FrigidaireResetPasswordPageActions();
	}
	
	public String getPasswordResetMailMessage() {
	    return WebElementUtil.performInFrame(mailFrame, () -> 
	        WebElementUtil.getText(passwordResetMailBodyText)
	    );
	}
	
	
	public Boolean isMailFrigidaireLogoDisplayed() {
		return WebElementUtil.performInFrame(mailFrame, () -> 
			WebElementUtil.isDisplayed(mailFridgidaireLogo)
        );
	}
	
	public String getPasswordChangeSuccessMailMessage() {
	    return WebElementUtil.performInFrame(mailFrame, () -> 
	        WebElementUtil.getText(passwordChangeSuccessMailBodyText)
	    );
	}
	
	public Boolean isMailContactUsLinkDisplayed() {
		return WebElementUtil.performInFrame(mailFrame, () -> 
			WebElementUtil.isDisplayed(mailContactUsLink)
		);
	}
	
	public boolean isMailConnectSocialMediaLinksDisplayed() {
		WebElementUtil.switchToFrame(mailFrame);
	    var isDisplayed =  DriverManager.getDriver()
	        .findElements(mailConnectSocialMediaLinks)
	        .size() > 1;
	    WebElementUtil.switchToDefaultContent();
	    return isDisplayed;
	}
	
	public boolean isMailFooterLinksDisplayed() {
        WebElementUtil.switchToFrame(mailFrame);
	    var isDisplayed =  DriverManager.getDriver()
	        .findElements(mailFooterLinks)
	        .size() > 1;
	    WebElementUtil.switchToDefaultContent();
	    return isDisplayed;
	}	
	
	public Boolean isBrandLogoDisplayed() {
		var environment = ConfigReader.getBrand();	
		if(environment.equalsIgnoreCase("frigidaire")) {
			return isMailFrigidaireLogoDisplayed();
		}
		else {
			return false;
		}
	}
	
	public String getMailText() {
	    var brand = getStoreName();
	    var mailSubject = getFirstMailSubject();

	    switch (brand) {
	        case "FRIGIDAIRE":
	            return getFrigidaireMailText(mailSubject);
	        case "ELECTROLUX":
	            return null;
	        default:
	            return null;
	    }
	}
	
	private String getFrigidaireMailText(String mailSubject) {
	    if (mailSubject.equalsIgnoreCase("Password Reset")) {
	        return getPasswordResetMailMessage();
	    } else if (mailSubject.equalsIgnoreCase("Frigidaire password changed")) {
	        return getPasswordChangeSuccessMailMessage();
	    }
	    return null;
	}
	
	public String getFirstMailSubject() {	
		return WebElementUtil.getText(firstMailSubject);
	}
	
	
	public String getStoreName() {
		var brand = ConfigReader.getBrand();
		if (brand.equalsIgnoreCase("frigidaire")) return "FRIGIDAIRE";
	    if (brand.equalsIgnoreCase("electrolux")) return "ELECTROLUX";
	    return "";
	}
	
	public void verifyFrigidaireResponseMailIsCorrect() throws InterruptedException {
	    var mailSubject = getFirstMailSubject();
	    verifyFrigidaireMailCorrect(mailSubject);
	}
	
	private void verifyFrigidaireMailCorrect(String mailSubject) throws InterruptedException {
	    if (mailSubject.equalsIgnoreCase("Password Reset")) {
	         verifyFrigidairePasswordResetMail();
	    } else if (mailSubject.equalsIgnoreCase("Frigidaire password changed")) {
	         verifyFrigidairePasswordResetSuccessMail();
	    }
	    else {
	    	throw new IllegalStateException("Invalid Mail : "+mailSubject);
	    }
	}
	    
	
	public void verifyFrigidairePasswordResetMail() throws InterruptedException {	
		Assert.assertEquals(getMailTitle(), "Password Reset", "'Password Reset' title is not present in password reset mail");
        Assert.assertTrue(isMailResetYourPasswordLinkDisplayed(), "'Click here to reset your password' link is not displayed in the in password reset mail");
        Assert.assertTrue(getMailText().contains("If you did not make this request, please ignore this email. If you don't use this link within 24 hours, it will expire."), "Email Body does not contain Message stating 'Link will expire in 24 hours' in password reset mail");
        Assert.assertTrue(isBrandLogoDisplayed(), "Frigidaire Logo is not displayed in password reset mail");
	}
	
	public void verifyFrigidairePasswordResetSuccessMail() throws InterruptedException {
		Assert.assertEquals(getMailTitle(), "Frigidaire password changed", "'Frigidaire password changed' title is not present in reset success mail");
        Assert.assertTrue(isBrandLogoDisplayed(), "Brand logo is not present in reset success mail");
        Assert.assertTrue(getMailText().contains("Your password was successfully reset."), "Reset Successful Text is not present in reset success mail");
        Assert.assertTrue(isMailContactUsLinkDisplayed(), "Contact Us Link is not present in reset success mail");
        Assert.assertTrue(getMailText().contains("Frigidaire team"), "Frigidaire team Text is not present in reset success mail");
        Assert.assertTrue(isMailConnectSocialMediaLinksDisplayed(), "Connect Social Media Links Section is not present in reset success mail");
        Assert.assertTrue(isMailFooterLinksDisplayed(), "Footer Links Section is not present in reset success mail");  
	}
}
