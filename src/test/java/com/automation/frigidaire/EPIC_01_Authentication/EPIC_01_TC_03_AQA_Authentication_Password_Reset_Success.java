package com.automation.frigidaire.EPIC_01_Authentication;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireForgotPasswordPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidaireResetPasswordPageActions;
import com.automation.frigidaire.pages.MailDropPageActions;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;

@Test(singleThreaded = true)
public class EPIC_01_TC_03_AQA_Authentication_Password_Reset_Success extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    FrigidaireForgotPasswordPageActions forgotPasswordPage = new FrigidaireForgotPasswordPageActions();
    MailDropPageActions mailDropPage = new MailDropPageActions();
    FrigidaireResetPasswordPageActions resetPasswordPage = new FrigidaireResetPasswordPageActions();
    String emailAddress = ConfigReader.getProperty("user.email");
    String newPassword = ConfigReader.getProperty("user.password");
    
    @Test(groups = {"smoke", "regression"}, description = "Verify that a user can successfully reset their password through the Frigidaire website and that the corresponding password reset and confirmation emails are received and validated.")
    public void EPIC_01_Authentication_TC_03_VerifyPasswordResetFlowAndEmailNotifications() throws InterruptedException {
 
        homePage.navigateToResetPasswordPage().resetPassword(emailAddress);
        Assert.assertTrue(forgotPasswordPage.isCheckYourEmailMessageDisplayed(), "Check your Email Label and Message is not displayed");
        mailDropPage.openFirstMailInInbox(emailAddress, "Password Reset");
        mailDropPage.verifyFrigidaireResponseMailIsCorrect();
        mailDropPage.clickMailResetYourPasswordLink();
        resetPasswordPage.verifyResetPasswordPage();
        resetPasswordPage.resetPassword(newPassword);
        mailDropPage.openFirstMailInInbox(emailAddress, "Frigidaire password changed");
        mailDropPage.verifyFrigidaireResponseMailIsCorrect();
        ExtentReportManager.getTest().pass("Password reset flow completed successfully. Verified reset email, reset confirmation email, and all related UI elements.");
    }
}
