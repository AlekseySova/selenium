package com.thomascook.search_uk;

import com.thomascook.core.WebDriverTestBase;
import com.thomascook.pages.ThomasCookLoginPage;
import com.thomascook.pages.ThomasCookMainPage;
import com.thomascook.pages.ThomasCookMyAccountPage;
import com.thomascook.pages.ThomasCookSearchPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertTrue;

/**
 * Created by Alex Owl on 12.06.2017.
 */
public class DefaultSearch extends WebDriverTestBase {

    String webSite = "https://www.thomascook.com/";

    @Features("Thomascook")
    @Stories("Search_UK")
    @Title("DefaultSearch")
    @Test
    public void searchAccordingTo(){

        ThomasCookMainPage mainPage = new ThomasCookMainPage(webDriver);

        ThomasCookSearchPage searchPage = new ThomasCookSearchPage(webDriver);

        mainPage.openPage(webSite);

        mainPage.closePopUp();

        mainPage.closeCoockiesMsg();

        mainPage.clickSearch();

        Boolean isCondTrue = searchPage.existOfPaginationAndFacets();

        assertTrue(isCondTrue);

    }

}
