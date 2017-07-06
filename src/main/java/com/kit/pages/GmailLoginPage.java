package com.kit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by AlekseySova on 09.06.2017.
 */
public class GmailLoginPage {

    private WebDriver webDriver;
    private WebElement searchField;

    public GmailLoginPage(WebDriver webDriver) {

        this.webDriver = webDriver;

    }
    private WebElement nextButton;

    //Locators
    private By searchMailField = By.xpath(".//*[@id=\"identifierId\"][@class=\"whsOnd zHQkBf\"]");
    private By searchMailButton = By.xpath(".//*[@class=\"ZFr60d CeoRYc\"]");




    public void openPage(String url){

        webDriver.get(url);

    }

    public void fillAndSubmitData(String searchText){

        Actions actions = new Actions(webDriver);
        searchField = webDriver.findElement(searchMailField);
        searchField.sendKeys(searchText);

        nextButton = webDriver.findElement(searchMailButton);
        actions.moveToElement(nextButton).click().perform();

    }


}
