package com.thomascook.search_uk;

import com.thomascook.core.WebDriverTestBase;
import com.thomascook.pages.ThomasCookMainPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Alex Owl on 30.06.2017.
 */
public class SelectDurationTest extends WebDriverTestBase {

    @Test
    public void searchDuration(){



        ThomasCookMainPage mainPage = new ThomasCookMainPage(webDriver);

        mainPage.openPage("https://www.thomascook.com/");

        mainPage.closePopUp();

        mainPage.closeCoockiesMsg();

        String actualResult = mainPage.selectDurationByVisibleText();

        System.out.println("ActualResult= " + actualResult);

        assertEquals("1 Night", actualResult);

    }



}
