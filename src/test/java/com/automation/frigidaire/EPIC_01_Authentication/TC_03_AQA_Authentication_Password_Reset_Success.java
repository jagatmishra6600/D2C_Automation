package com.automation.frigidaire.EPIC_01_Authentication;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireForgotPasswordPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidaireResetPasswordPageActions;
import com.automation.frigidaire.pages.MailDropPageActions;
import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.ExtentReportManager;

public class TC_03_AQA_Authentication_Password_Reset_Success extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    FrigidaireForgotPasswordPageActions forgotPasswordPage = new FrigidaireForgotPasswordPageActions();
    MailDropPageActions mailDropPage = new MailDropPageActions();
    FrigidaireResetPasswordPageActions resetPasswordPage = new FrigidaireResetPasswordPageActions();

    @Test(groups = {"smoke", "regression"}, description = "Verify that a user can successfully reset their password through the Frigidaire website and that the corresponding password reset and confirmation emails are received and validated.")
    public void TC_03_VerifyPasswordResetFlowAndEmailNotifications() {
        var emailAddress = ConfigReader.getProperty("user.email");
        var newPassword = ConfigReader.getProperty("user.password");
        var expectedMailTitle = "Password Reset";

        homePage.navigateToResetPasswordPage().resetPassword(emailAddress);
        Assert.assertTrue(forgotPasswordPage.isCheckYourEmailMessageDisplayed(), "Check your Email Label and Message is not displayed");
        mailDropPage.openFirstMailInInbox(emailAddress, expectedMailTitle);

        Assert.assertEquals(mailDropPage.getMailTitle(), expectedMailTitle, "'Password Reset' title is not present in password reset mail");
        Assert.assertTrue(mailDropPage.isMailResetYourPasswordLinkDisplayed(), "'Click here to reset your password' link is not displayed in the in password reset mail");
        Assert.assertTrue(mailDropPage.getMailText().contains("If you did not make this request, please ignore this email. If you don't use this link within 24 hours, it will expire."), "Email Body does not contain Message stating 'Link will expire in 24 hours' in password reset mail");
        Assert.assertTrue(mailDropPage.isBrandLogoDisplayed(), "Frigidaire Logo is not displayed in password reset mail");

        mailDropPage.clickMailResetYourPasswordLink();

        Assert.assertTrue(resetPasswordPage.isChangePasswordTitleDisplayed(), "'Change Password' Title is not displayed in reset password page");
        Assert.assertTrue(resetPasswordPage.isNewPasswordFieldDisplayed(), "New Password field is not displayed in reset password page");
        Assert.assertTrue(resetPasswordPage.isConfirmPasswordFieldDisplayed(), "Confirm Password field is not displayed in reset password page");
        Assert.assertTrue(resetPasswordPage.isNewPasswordShowHideIconDisplayed(), "New Password Show/Hide Eye Icon is not displayed in reset password page");
        Assert.assertTrue(resetPasswordPage.isConfirmPasswordShowHideIconDisplayed(), "Confirm Password Show/Hide Eye Icon is not displayed in reset password page");
        Assert.assertTrue(resetPasswordPage.isSubmitButtonDisplayed(), "Submit Button is not displayed in reset password page");

        resetPasswordPage.resetPassword(newPassword);

        expectedMailTitle = "Frigidaire password changed";
        mailDropPage.openFirstMailInInbox(emailAddress, expectedMailTitle);

        Assert.assertEquals(mailDropPage.getMailTitle(), expectedMailTitle, "'Frigidaire password changed' title is not present in reset success mail");
        Assert.assertTrue(mailDropPage.isBrandLogoDisplayed(), "Brand logo is not present in reset success mail");
        Assert.assertTrue(mailDropPage.getMailText().contains("Your password was successfully reset."), "Reset Successful Text is not present in reset success mail");
        Assert.assertTrue(mailDropPage.isMailContactUsLinkDisplayed(), "Contact Us Link is not present in reset success mail");
        Assert.assertTrue(mailDropPage.getMailText().contains("Frigidaire team"), "Frigidaire team Text is not present in reset success mail");
        Assert.assertTrue(mailDropPage.isMailConnectSocialMediaLinksDisplayed(), "Connect Social Media Links Section is not present in reset success mail");
        Assert.assertTrue(mailDropPage.isMailFooterLinksDisplayed(), "Footer Links Section is not present in reset success mail");

        ExtentReportManager.getTest().pass("Password reset flow completed successfully. Verified reset email, reset confirmation email, and all related UI elements.");
    }
}
