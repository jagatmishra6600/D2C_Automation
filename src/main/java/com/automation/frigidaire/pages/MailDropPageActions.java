package com.automation.frigidaire.pages;

import java.time.Duration;
import java.util.stream.Stream;

import org.openqa.selenium.By;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;

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
	
	public MailDropPageActions enterEmailAddress(String emailAddress) {
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
	
	public MailDropPageActions login(String emailAddress) {
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
	
	public MailDropPageActions openFirstMailInInbox(String emailAddress) {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		WaitUtils.sleep(2000);
		return this;
	}
	
	public MailDropPageActions openFirstMailInInbox(String emailAddress, String expectedMailTitle) {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		for(int i=0;i<5;i++) {
			if(getMailTitle().equalsIgnoreCase(expectedMailTitle)) {
				return this;
			}
			clickInboxRefresh();
		}
		WaitUtils.sleep(1000);
		return this;
	}

	public String getMailTitle() {
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
	
	public FrigidaireResetPasswordPageActions clickMailResetYourPasswordLink() {
		WaitUtils.sleep(2000);
		WebElementUtil.switchToFrame(mailFrame);
		WebElementUtil.ctrlClick(mailResetPasswordLink);
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
		var environment = ConfigReader.getProperty("app.url");	
		if(environment.contains("frigidaire")) {
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
	
	public boolean isResponseMailCorrect() {
	    var storeName = getStoreName();
	    var mailSubject = getFirstMailSubject();

	    switch (storeName) {
	        case "FRIGIDAIRE":
	            return isFrigidaireMailCorrect(mailSubject);
	        case "ELECTROLUX":
	            return false;
	        default:
	            return false;
	    }
	}
	
	public String getStoreName() {
		var environment = ConfigReader.getProperty("app.url");
		if (environment.contains("frigidaire")) return "FRIGIDAIRE";
	    if (environment.contains("electrolux")) return "ELECTROLUX";
	    return "";
	}
	
	private boolean isFrigidaireMailCorrect(String mailSubject) {
	    if (mailSubject.equalsIgnoreCase("Password Reset")) {
	        return isFrigidairePasswordResetMailCorrect();
	    } else if (mailSubject.equalsIgnoreCase("Frigidaire password changed")) {
	        return isFrigidairePasswordResetSuccessMailCorrect();
	    }
	    return false;
	}
	
//	public boolean isFrigidairePasswordResetMailCorrect() {	
//		return getMailTitle().equals("Password Reset") &&
//		           isMailResetYourPasswordLinkDisplayed() &&
//		           getMailText().contains("If you did not make this request, please ignore this email. If you don't use this link within 24 hours, it will expire.") &&
//		           isBrandLogoDisplayed();
//	}
	
//	public boolean isFrigidairePasswordResetSuccessMailCorrect() {
//	    return getMailTitle().equalsIgnoreCase("Frigidaire password changed") &&
//	    			isMailContactUsLinkDisplayed() &&
//    				getMailText().contains("Your password was successfully reset.") &&
//    				getMailText().contains("Frigidaire team") &&
//    				isMailConnectSocialMediaLinksDisplayed() &&
//    				isMailFooterLinksDisplayed();
//	}
	
	public boolean isFrigidairePasswordResetMailCorrect() {	
		var mailTitle =getMailTitle().equalsIgnoreCase("Password Reset");
		var resetYourPasswordLink =isMailResetYourPasswordLinkDisplayed();
		var linkExpiresIn24HoursMessage = getMailText().contains("If you did not make this request, please ignore this email. If you don't use this link within 24 hours, it will expire.");
		var frigidaireBrandLogo = isBrandLogoDisplayed();  
		
		 System.out.printf(
			        "Password Reset Mail results — mailTitle:%b resetYourPasswordLink:%b linkExpiresIn24HoursMessage:%b frigidaireBrandLogo:%b%n",
			        mailTitle, resetYourPasswordLink, linkExpiresIn24HoursMessage, frigidaireBrandLogo
			    );
		 return mailTitle && resetYourPasswordLink && linkExpiresIn24HoursMessage && frigidaireBrandLogo;

	}
	
	public boolean isFrigidairePasswordResetSuccessMailCorrect() {
	    var mailTitle = getMailTitle().equalsIgnoreCase("Frigidaire password changed");
	    var frigidaireBrandLogo = isBrandLogoDisplayed();
	    var contactUsLink = isMailContactUsLinkDisplayed();
	    var resetSuccessMessage = getMailText().contains("Your password was successfully reset.");
	    var frigidaireTeamText = getMailText().contains("Frigidaire team");
	    var socialMediaLinks = isMailConnectSocialMediaLinksDisplayed();
	    var footerLinks = isMailFooterLinksDisplayed();

	    System.out.printf(
	        "Password Reset Success Mail results — mailTitle:%b frigidaireBrandLogo:%b contactUsLink:%b resetSuccessMessage:%b FrigidareTeamText:%b socialMediaLinks:%b footerLinks:%b%n",
	        mailTitle,frigidaireBrandLogo, contactUsLink, resetSuccessMessage, frigidaireTeamText, socialMediaLinks, footerLinks
	    );
	    return mailTitle && contactUsLink && resetSuccessMessage && frigidaireTeamText && socialMediaLinks && footerLinks;

	}
}
