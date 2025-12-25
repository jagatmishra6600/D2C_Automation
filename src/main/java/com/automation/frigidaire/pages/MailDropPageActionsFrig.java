package com.automation.frigidaire.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;

import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;

public class MailDropPageActionsFrig {

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
	
	public MailDropPageActionsFrig navigateToMailDropPage() {
		navigateTo("https://maildrop.cc/");
		return this;
	}
	
	public MailDropPageActionsFrig enterEmailAddress(String emailAddress) {
		sleep(2000);
		sendKeys(headerEmailAddressField, emailAddress);
		return this;
	}
	
	public MailDropPageActionsFrig clickViewMailBoxButton() {
		clickElement(headerViewMailBoxButton);
		return this;
	}
	
	public boolean isInboxLoaded() {
		return isDisplayed(inboxRefreshButton);
	}
	
	public MailDropPageActionsFrig login(String emailAddress) {
		return navigateToMailDropPage()
					.enterEmailAddress(emailAddress)
					.clickViewMailBoxButton();
	}

	public MailDropPageActionsFrig clickInboxRefresh() {
		clickElement(inboxRefreshButton);
		return this;
	}
	
	public MailDropPageActionsFrig clickFirstMailInInbox() {
		clickElement(firstMail);
		return this;
	}
	
	public MailDropPageActionsFrig openFirstMailInInbox(String emailAddress) {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		sleep(2000);
		return this;
	}
	
	public MailDropPageActionsFrig openFirstMailInInbox(String emailAddress, String expectedMailTitle) {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		for(int i=0;i<5;i++) {
			sleep(2000);
			if(getMailTitle().equalsIgnoreCase(expectedMailTitle)) {
				return this;
			}
			clickInboxRefresh();
		}
		sleep(1000);
		return this;
	}

	public String getMailTitle() {
		var mailTitleValue = getText(mailTitle);
	    if(mailTitleValue.isEmpty() || mailTitleValue.equals("")) {
	    	sleep(2000);
	    	mailTitleValue = getText(mailTitle);
	    }
	    return mailTitleValue;
	}
	

	public boolean isMailResetYourPasswordLinkDisplayed() {
	    return performInFrame(mailFrame, () -> 
	        isDisplayed(mailResetPasswordLink)
	    );
	}
	
	public ResetPasswordPageActionsFrig clickMailResetYourPasswordLink() {
		sleep(2000);
		switchToFrame(mailFrame);
//		ctrlClick(mailResetPasswordLink);
//		ctrlClickWithJS(mailResetPasswordLink);
		openLinkInNewTab(mailResetPasswordLink);
		switchToDefaultContent();
		switchToLatestTabAndClosePrevious();
		return new ResetPasswordPageActionsFrig();
	}
	
	public String getPasswordResetMailMessage() {
	    return performInFrame(mailFrame, () -> 
	        getText(passwordResetMailBodyText)
	    );
	}
	
	
	public Boolean isMailFrigidaireLogoDisplayed() {
		return performInFrame(mailFrame, () -> 
			isDisplayed(mailFridgidaireLogo)
        );
	}
	
	public String getPasswordChangeSuccessMailMessage() {
	    return performInFrame(mailFrame, () -> 
	        getText(passwordChangeSuccessMailBodyText)
	    );
	}
	
	public Boolean isMailContactUsLinkDisplayed() {
		return performInFrame(mailFrame, () -> 
			isDisplayed(mailContactUsLink)
		);
	}
	
	public boolean isMailConnectSocialMediaLinksDisplayed() {
		switchToFrame(mailFrame);
	    var isDisplayed =  DriverManager.getDriver()
	        .findElements(mailConnectSocialMediaLinks)
	        .size() > 1;
	    switchToDefaultContent();
	    return isDisplayed;
	}
	
	public boolean isMailFooterLinksDisplayed() {
        switchToFrame(mailFrame);
	    var isDisplayed =  DriverManager.getDriver()
	        .findElements(mailFooterLinks)
	        .size() > 1;
	    switchToDefaultContent();
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
		return getText(firstMailSubject);
	}
	
	
	public String getStoreName() {
		var brand = ConfigReader.getBrand();
		if (brand.equalsIgnoreCase("frigidaire")) return "FRIGIDAIRE";
	    if (brand.equalsIgnoreCase("electrolux")) return "ELECTROLUX";
	    return "";
	}
	
	public MailDropPageActionsFrig verifyFrigidaireResponseMailIsCorrect() {
	    var mailSubject = getFirstMailSubject();
	    verifyFrigidaireMailCorrect(mailSubject);
	    return this;
	}
	
	private MailDropPageActionsFrig verifyFrigidaireMailCorrect(String mailSubject) {
	    if (mailSubject.equalsIgnoreCase("Password Reset")) {
	         verifyFrigidairePasswordResetMail();
	    } else if (mailSubject.equalsIgnoreCase("Frigidaire password changed")) {
	         verifyFrigidairePasswordResetSuccessMail();
	    }
	    else {
	    	throw new IllegalStateException("Invalid Mail : "+mailSubject);
	    }
	    return this;
	}
	    
	
	public MailDropPageActionsFrig verifyFrigidairePasswordResetMail() {	
		Assert.assertEquals(getMailTitle(), "Password Reset", "'Password Reset' title is not present in password reset mail");
        Assert.assertTrue(isMailResetYourPasswordLinkDisplayed(), "'Click here to reset your password' link is not displayed in the in password reset mail");
        Assert.assertTrue(getMailText().contains("If you did not make this request, please ignore this email. If you don't use this link within 24 hours, it will expire."), "Email Body does not contain Message stating 'Link will expire in 24 hours' in password reset mail");
        Assert.assertTrue(isBrandLogoDisplayed(), "Frigidaire Logo is not displayed in password reset mail");
        return this;
	}
	
	public MailDropPageActionsFrig verifyFrigidairePasswordResetSuccessMail() {
		Assert.assertEquals(getMailTitle(), "Frigidaire password changed", "'Frigidaire password changed' title is not present in reset success mail");
        Assert.assertTrue(isBrandLogoDisplayed(), "Brand logo is not present in reset success mail");
        Assert.assertTrue(getMailText().contains("Your password was successfully reset."), "Reset Successful Text is not present in reset success mail");
        Assert.assertTrue(isMailContactUsLinkDisplayed(), "Contact Us Link is not present in reset success mail");
        Assert.assertTrue(getMailText().contains("Frigidaire team"), "Frigidaire team Text is not present in reset success mail");
        Assert.assertTrue(isMailConnectSocialMediaLinksDisplayed(), "Connect Social Media Links Section is not present in reset success mail");
        Assert.assertTrue(isMailFooterLinksDisplayed(), "Footer Links Section is not present in reset success mail");  
        return this;
	}
}
