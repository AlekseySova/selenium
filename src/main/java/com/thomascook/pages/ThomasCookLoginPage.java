package com.thomascook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Alex Owl on 12.06.2017.
 */
public class ThomasCookLoginPage extends ThomasCookBasePage {

    private By mailFieldLocator = By.xpath( ".//*[@id='emailMA'][@class=\"FormFieldMA-text ng-pristine ng-untouched ng-scope ng-empty ng-valid-email ng-invalid ng-invalid-required ng-valid-pattern\"]");
    private By passwordFieldLocator = By.xpath("//*[@id=\"password\"]");
    private By logInButtonLocator = By.id("LoginBtn");
    private By popUpFrameLocator = By.xpath("//*[@id=\"deliver-component-ByAdsP6Xg\"]/a/span");
    private By logInFrameLocator = By.cssSelector(".AuthLanding-actions.col-xs-24.col-md-12");


    public ThomasCookLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Enter Login and password")
    public void enterMailAndPassword(String mail, String password){

        Actions actions = new Actions(webDriver);

        WebElement logInFrame = webDriver.findElement(logInFrameLocator);

        actions.moveToElement(logInFrame).tick().perform();

        WebElement mailField = webDriver.findElement(mailFieldLocator);
        WebElement passwordField = webDriver.findElement(passwordFieldLocator);
        WebElement logInButton = webDriver.findElement(logInButtonLocator);

        mailField.sendKeys(mail);
        passwordField.sendKeys(password);

        actions.moveToElement(logInButton).click().perform();

    }

}
