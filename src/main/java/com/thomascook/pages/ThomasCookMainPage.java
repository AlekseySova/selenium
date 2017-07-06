package com.thomascook.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by Alex Owl on 12.06.2017.
 */
public class ThomasCookMainPage extends ThomasCookBasePage{

    private By logLogoLocator = By.id("login-link");
    private By searchButtonLocator = By.id("SearchbarForm-submitBtn");
    private By depAirportLocator = (By.cssSelector(".SearchbarForm-summary.ng-binding"));
    private By arrivalAirportLocator = By.cssSelector("#SearchbarForm-goingTo");
    private By searchDurationLocator = By.id("SearchbarForm-duration");
    private By durationLocator = By.id("SearchbarForm-duration");

    public ThomasCookMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Click to loging page")
    public void enterToLogPage(){

        WebElement logInLogo = webDriver.findElement(logLogoLocator);

        Actions actions = new Actions(webDriver);

        actions.moveToElement(logInLogo).click().perform();

    }


    @Step("Click to search button")
    public void clickSearch(){

        Actions actions = new Actions(webDriver);

        WebElement searchButton = webDriver.findElement(searchButtonLocator);

        actions.moveToElement(searchButton).click().perform();

    }


    @Step("Enter search criteria")
    public void enterSearchCriteria() {

        Actions actions = new Actions(webDriver);

        List<WebElement> webElementList = webDriverUtil.waitForExpectedConList(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".SearchbarForm-summary.ng-binding")));
        if (!webElementList.isEmpty()) {
            webElementList.get(1).click();
        }else {
            assertFalse("Elements not found", true);
        }

        WebElement depAirport = webDriver.findElement(depAirportLocator);


        actions.moveToElement(depAirport).sendKeys("Any London").perform();

        actions.pause(1000);

        actions.sendKeys(Keys.DOWN,Keys.ENTER).perform();

        actions.pause(1000);

        webElementList.get(0).click();

        WebElement arrivalAirport = webDriver.findElement(arrivalAirportLocator);


        actions.moveToElement(arrivalAirport).sendKeys("Mexico, Any").perform();

        actions.pause(1000);

        actions.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER).perform();

        WebElement searchDuration = webDriver.findElement(searchDurationLocator);

        actions.moveToElement(searchDuration).click().perform();

        actions.sendKeys(Keys.DOWN, Keys.ENTER).perform();

        WebElement searchButton = webDriver.findElement(searchButtonLocator);

        actions.moveToElement(searchButton).click().perform();




    }


    public String selectDurationByVisibleText() {

        WebElement duration = webDriver.findElement(durationLocator);

        Select select = new Select(duration);

        select.selectByVisibleText("1 Night");

        WebElement duratinInfo = select.getFirstSelectedOption();

        return duratinInfo.getText();
    }
}
