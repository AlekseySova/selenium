package com.thomascook.search_uk;

import com.thomascook.core.WebDriverTestBase;
import com.thomascook.pages.ThomasCookMainPage;
import com.thomascook.pages.ThomasCookSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

/**
 * Created by AlekseySova on 14.06.2017.
 */
public class SearchAccordingToCriteriaTest extends WebDriverTestBase{

    @Features("Thomascook")
    @Stories("Search_UK")
    @Title("Search According to Criteria")
    @Test()
    public void searchAccordingToCriteriaText() {

        ThomasCookMainPage mainPage = new ThomasCookMainPage(webDriver);

        ThomasCookSearchPage searchPage = new ThomasCookSearchPage(webDriver);

        Actions actions = new Actions(webDriver);

        mainPage.openPage("https://www.thomascook.com/");

        mainPage.closePopUp();

        mainPage.closeCoockiesMsg();

        mainPage.enterSearchCriteria();

        Boolean rightCriteria = searchPage.searchForArraivelPlace();
        assertTrue(rightCriteria);


    }


}
