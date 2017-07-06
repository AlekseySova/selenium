package com.kit.homework.lesson23;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.GmailAccountPage;
import com.kit.pages.GmailLoginPage;
import com.kit.pages.GmailPasswordPage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by AlekseySova on 09.06.2017.
 */
public class GmailSearchTest extends WebDriverTestBase {

    private String gmailSearch = "https://www.gmail.com";
    private String gmailTitle = "Gmail";
    private String mailPassword = "evwfevwf78";
    private String mailName = "aaabbcc439";
    private String emailAddress = "aaabbcc439@gmail.com";

    @Test(enabled = false)
    public void SearchTest(){

        GmailLoginPage gmailLoginPage = new GmailLoginPage(webDriver);

        gmailLoginPage.openPage(gmailSearch);

        gmailLoginPage.fillAndSubmitData(emailAddress);

        GmailPasswordPage gmailPasswordPage = new GmailPasswordPage(webDriver);

        gmailPasswordPage.fillAndSubmitData(mailPassword);

        GmailAccountPage gmailAccountPage = new GmailAccountPage(webDriver);

        gmailAccountPage.enterToAccountInfo();

        assertTrue(gmailAccountPage.getAccountName().contains(emailAddress));

    }



}
