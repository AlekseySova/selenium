package com.thomascook.utils;

import com.thomascook.core.Browser;
import com.thomascook.core.LocatorTypes;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;


import java.io.File;
import java.util.List;

import static com.google.common.io.Files.toByteArray;

/**
 * Created by Alex Owl on 20.06.2017.
 */
public class WebDriverUtil {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    long explicitWait = Long.parseLong(PropertiesCache.getProperty("wait.explicit"));
    private JavascriptExecutor executor;
    private String locatorTypes;

    public WebDriverUtil(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, explicitWait);
    }

    public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition) {
        return  (WebElement)webDriverWait.until(expectedCondition);
    }

    public List<WebElement> waitForExpectedConList(ExpectedCondition expectedCondition) {
        return  (List<WebElement>)webDriverWait.until(expectedCondition);
    }

    public void jsSendKeys(String locator, String type) {
        executor = (JavascriptExecutor) webDriver;


        LocatorTypes locatorType = EnumUtils.isValidEnum(LocatorTypes.class,type) ?
                LocatorTypes.valueOf(type.toUpperCase()) : LocatorTypes.ID;

        switch(locatorType) {
            case ID:
                executor.executeScript("document.getElementById(\"" + locator + "\").setAttribute(\"value\", \"London\" )");
                break;
            case NAME:
                executor.executeScript("document.getElementsByName(\"" + locator + "\")[0].click()");
                break;
            case XPATH:
                executor.executeScript("document.getElementsByName(\"" + locator + "\")[0].click()");
                break;
        }
    }

    @Attachment(value = "{0}")
    public byte[] saveScreenshot(String attachName) {
        try {
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            return toByteArray(scrFile);
        } catch (Exception e) {
            System.out.println("Is not saved screenshot" + e);
        }
        return new byte[0];
    }
}
