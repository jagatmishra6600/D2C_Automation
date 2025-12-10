package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ELUX_MailDropPage {
	
	public static final By headerEmailAddressField = By.cssSelector("div.top-16 input[placeholder='view-this-mailbox']");
	public static final By headerViewMailBoxButton = By.xpath("//div[contains(@class,'top-16')]//button[contains(.,'View Mailbox')]");
	public static final By inboxRefreshButton = By.xpath("//button[contains(.,'Refresh')]");
	public static final By firstMail = By.xpath("(//div[contains(@class,'message')])[1]");
	public static final By mailTitle = By.xpath("(//div[contains(@class,'md:rounded-t-lg')]//div)[3]");
	public static final By mailResetPasswordLink = By.cssSelector("a[href*='resetPassword']");
//	public static final By passwordResetMailBodyText = By.xpath("//div[@class='header-text']");
	public static final By mailBodyText = By.cssSelector("table#bodyTable");
	public static final By mailFrame = By.cssSelector("iframe.w-full");
	public static final By mailElectroluxLogo = By.cssSelector("img[alt='Electrolux']");
	public static final By passwordChangeSuccessMailBodyText = By.cssSelector("div.verification-text");
	public static final By mailContactUsLink = By.xpath("//p[contains(text(),'reset your password')]//a[normalize-space()='contact us']");
	public static final By mailConnectSocialMediaLinks = By.xpath("//a//img[contains(@src,'SocialIcons')]");
	public static final By mailFooterLinks = By.xpath("//div[@class='footer-links']//a");
	public static final By firstMailSubject = By.xpath("(//div[contains(@class,'message')])[1]//div[@class='truncate']");
	public static final By mailClickToActivateAccountLink = By.xpath("//a[contains(.,'activate your account')]");
	public static final By mailGreetingMessage = By.xpath("//p[contains(.,'Hi') or contains(.,'Dear')]");
	public static final By mailThanksForCreatingAccountMessage = By.xpath("//p[contains(.,'Thanks for creating an account')]");
	public static final By mailLinkExpiresText = By.xpath("//p[contains(.,'expires')]");
	public static final By mailNotIntendedRecipientText = By.xpath("//p[contains(text(),'If you are not the intended recipient')]");
	public static final By mailCreateAccountFooterFacebookLink = By.cssSelector("img[alt='facebook']");
	public static final By mailCreateAccountFooterTwitterLink = By.cssSelector("img[alt='twitter']");
	public static final By mailCreateAccountFooterYoutubeLink = By.cssSelector("img[alt='youtube']");
	public static final By mailCreateAccountFooterPintrestLink = By.cssSelector("img[alt='pintrest']");
	public static final By mailCreateAccountFooterInstagramLink = By.cssSelector("img[alt='instagram']");
	
}
