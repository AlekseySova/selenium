package com.kit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by AlekseySova on 09.06.2017.
 */
public class GmailAccountPage {

    private WebDriver webDriver;
    private Actions actions;
    private WebElement accountButton;
    private WebElement infoField;

    private By accountMailLocator = By.xpath(".//*[@class=\"gb_8a gbii\"]");
    private By verifyMailLocator = By.xpath(".//*[@class=\"gb_wb\"]");

    public GmailAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterToAccountInfo(){

        Actions actions = new Actions(webDriver);

        accountButton = webDriver.findElement(accountMailLocator);

        actions.moveToElement(accountButton).click().perform();

    }

    public String getAccountName(){

        infoField = webDriver.findElement(verifyMailLocator);

        return infoField.getText();
    }
}
