package com.thomascook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by AlekseySova on 12.06.2017.
 */


public class ThomasCookMyAccountPage extends ThomasCookBasePage{


    private WebDriver webDriver;

    private By welcomTextLocator = By.cssSelector(".my-account-title");
    private By brandLogoLocator = By.cssSelector(".brandLogo");

    public ThomasCookMyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Confirm login in")
    public String confirmLogIn(){

        WebElement welcomField = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(welcomTextLocator));

        String welcom = welcomField.getText();

        System.out.println(welcom);

        return welcom;
    }

    @Step("Go to main page")
    public void goToMainPage(){

        Actions actions = new Actions(webDriver);

        WebElement brandLogo = webDriver.findElement(brandLogoLocator);

        actions.moveToElement(brandLogo).click().perform();

    }
}
