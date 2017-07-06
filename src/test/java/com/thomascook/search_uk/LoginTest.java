package com.thomascook.search_uk;

import com.thomascook.core.WebDriverTestBase;
import com.thomascook.pages.ThomasCookLoginPage;
import com.thomascook.pages.ThomasCookMainPage;
import com.thomascook.pages.ThomasCookMyAccountPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by AlekseySova on 12.06.2017.
 */

@Listeners({com.thomascook.core.TestListener.class})
public class LoginTest extends WebDriverTestBase{

    String webSite = "https://www.thomascook.com/";
    String email = "citigacy@gmail.com";
    String password = "evwfevwf78A";
    String expectedText = "Welcome to My Account!";


    @Features("Thomascook")
    @Stories("Login")
    @Title("LoginTest")
    @Test
    public void logInTest() throws InterruptedException {

        ThomasCookMainPage mainPage = new ThomasCookMainPage(webDriver);
        ThomasCookLoginPage loginPage = new ThomasCookLoginPage(webDriver);
        ThomasCookMyAccountPage myAccountPage = new ThomasCookMyAccountPage(webDriver);

        mainPage.openPage(webSite);

        mainPage.closePopUp();

        mainPage.closeCoockiesMsg();

        mainPage.enterToLogPage();

        mainPage.closePopUp();

        loginPage.enterMailAndPassword(email, password);

        String welcomText = myAccountPage.confirmLogIn();



        assertEquals(expectedText,welcomText);

    }
}
