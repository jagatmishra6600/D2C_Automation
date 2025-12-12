package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class MailDropPage_Fsus {
	
	 public static final By header_EmailAddressField = By.cssSelector("div.top-16 input[placeholder='view-this-mailbox']");
	 public static final By header_ViewMailBoxButton = By.xpath("//div[contains(@class,'top-16')]//button[contains(.,'View Mailbox')]");
	 public static final By inboxRefreshButton = By.xpath("//button[contains(.,'Refresh')]");
	 public static final By firstMail = By.xpath("(//div[contains(@class,'message')])[1]");
	 public static final By mail_Title = By.xpath("(//div[contains(@class,'md:rounded-t-lg')]//div)[3]");
	 public static final By mail_ResetPasswordLink = By.xpath("//a[contains(@href,'resetPassword') or contains(.,'RESET PASSWORD')]");
	 public static final By mailFrame = By.cssSelector("iframe.w-full");
	 public static final By firstMailSubject = By.xpath("(//div[contains(@class,'message')])[1]//div[@class='truncate']");
	 public static final By mail_FamilyStoreLogo = By.xpath("//img[contains(@src,'elx-logo-family-store')]");
	 public static final By passwordResetMailBodyText = By.xpath("//p[contains(.,\"This link will expire in 24 hours\")]//ancestor::td[@class='sapIntMktBlockColumn']");
	 public static final By refreshMailBoxButton = By.xpath("//button[.='Refresh Mailbox']");
	 public static final By mailList = By.cssSelector("div.message ");
	
}

