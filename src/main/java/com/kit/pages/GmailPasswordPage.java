package com.kit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by AlekseySova on 09.06.2017.
 */
public class GmailPasswordPage {

    private WebDriver webDriver;
    private Actions actions;
    private WebElement searchField;
    private WebElement nextButton;

    //Locators
    private By searchMailField = By.xpath(".//*[@class=\"whsOnd zHQkBf\"][@type=\"password\"]");
    private By searchMailButton = By.xpath(".//*[@id='passwordNext']/div[2]");


    public GmailPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillAndSubmitData(String searchText){

        Actions actions = new Actions(webDriver);
        searchField = webDriver.findElement(searchMailField);
        searchField.sendKeys(searchText);

        nextButton = webDriver.findElement(searchMailButton);
        actions.moveToElement(nextButton).click().perform();

    }

}
