package com.thomascook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by AlekseySova on 14.06.2017.
 */
public class ThomasCookSearchPage extends ThomasCookBasePage{

    private WebDriver webDriver;

    private By paginationFieldLocator = By.id("paginationSearchResultsPanel");
    private By filterFieldLocator = By.cssSelector(".basicFiltersContainer");

    private By hotelHeaderLocator = By.cssSelector(".PackageHeader-hotelName");
    private By flyingFromLocator = By.id("SearchbarReadonly-origin");
    private By whereToLocator = By.id("SearchbarReadonly-goingTo");


    public ThomasCookSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Confirm Pagination and Facets")
    public Boolean existOfPaginationAndFacets(){

        WebElement paginationField = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(paginationFieldLocator));

        WebElement filterField = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(filterFieldLocator));

        boolean isTrue = paginationField.isEnabled() && filterField.isEnabled();

        return  isTrue;
    }

    @Step("Confirm criteria of search")
    public Boolean searchForArraivelPlace() {

        Boolean rightHotelLocation = true;
        Boolean rightArrivalAirport = true;
        Boolean rightDuration = true;

        List<WebElement> hotelLocationList = (List<WebElement>) webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".PackageHeader-hotelName")));
        if (!hotelLocationList.isEmpty()) {
            int countOfHotel = hotelLocationList.size();
            for(int i = 0; i <= (countOfHotel - 1); i++) {
                if(rightHotelLocation == true ){
                    if (hotelLocationList.get(i).getAttribute("ng-href").contains("Mexico")) {
                        rightHotelLocation = true;
                    } else {
                        rightHotelLocation = false;
                    }

                }
            }



        }else {
            assertFalse("Elements not found", true);
        }

        List<WebElement> arrivalAirportList = webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".PackageCard-details-list-item-content")));
        if(!arrivalAirportList.isEmpty() ){

            int countOfField = arrivalAirportList.size();
            int countOfSearchField = 0;
            for(int i = 0; i <= (countOfField - 1); i++){

                if(arrivalAirportList.get(i).getText().contains("London")){

                    countOfSearchField += 1;

                }

            }
            if(countOfSearchField == (countOfField/5)){

                rightArrivalAirport = true;

            }else{

                rightArrivalAirport = false;
            }
        }else{

            assertFalse("Elements not found", true);

        }


        List<WebElement> durationList = webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".AT-duration")));

        if(!durationList.isEmpty()){

            int countOfField = durationList.size();
            int countOfSearchField = 0;
            for(int i= 0; i>= countOfField; i++){

                if(durationList.get(i).getText().contains("7 Nights")){

                    countOfSearchField += 1;

                }
                if(countOfSearchField == (countOfField/5)){

                    rightDuration = true;
                }

            }
        }


        return rightArrivalAirport && rightHotelLocation && rightDuration;
    }


}
