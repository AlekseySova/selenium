package com.thomascook.pages;

import com.thomascook.utils.WebDriverUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by AlekseySova on 20.06.2017.
 */
public class ThomasCookBasePage {

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;

    public ThomasCookBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);
    }

    @Step("Open Page")
    public void openPage(String url){

        webDriver.get(url);
    }

    @Step("Close PopUp")
    public void closePopUp(){

        Actions actions = new Actions(webDriver);

        By popUpCloseButtonLocator = By.cssSelector(".deliver-component-CloseButton-times");

        try {
            WebElement popUpCloseButton = webDriver.findElement(popUpCloseButtonLocator);
            actions.moveToElement(popUpCloseButton).click().perform();
        } // try
        catch (Exception e) {
            System.out.println("");
        } // catch

    }
    @Step("Close masssega about coockies")
    public void closeCoockiesMsg(){

        Actions actions = new Actions(webDriver);

        By coockiesCloseButtonLocator = By.cssSelector("#accept-cookies");

        try {
            WebElement coockiesCloseButton = webDriver.findElement(coockiesCloseButtonLocator);
            actions.moveToElement(coockiesCloseButton).click().perform();
        } // try
        catch (Exception e) {
            System.out.println("");
        } // catch

    }

}
