package com.kit.homework.lesson22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by AlekseySova on 06.06.2017.
 */
public class StylusSearchText {

    private String stylusSearch;
    private WebDriver webDriver;

    @BeforeClass

    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Alex Owl\\IdeaProjects\\selenium\\src\\main\\resources\\chromedriver.exe");

        webDriver = new ChromeDriver();
        stylusSearch = "https://www.stylus.com.ua/";
        webDriver.get(stylusSearch);
        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void searchTest() {

        Actions actions = new Actions(webDriver);

        //data for test
        String searchText = "Sony Xperia Z2";
        String searchTitle = "Sony Xperia Z2 White";
        By searchLocator1 = By.name("q");
        By searchLocator2 = By.xpath(".//*[@name=\"q\"][@type=\"text\"]");
        By linkLocator = By.xpath("//*[.='Смартфон Sony Xperia Z2 White'][@class=\"title\"]");

        //Enter "Sony Xperia Z2" to searching field of stylus.com.ua
        WebElement searchField = webDriver.findElement(searchLocator1);
        searchField.sendKeys(searchText);

        WebElement searchButton = webDriver.findElement(searchLocator2);
        searchButton.submit();

        //Verify link that maches searching text
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchText));


        actions.moveToElement(link).click().perform();

        //Verify that this is right page
        assertTrue(webDriver.getTitle().contains(searchTitle));

    }

    @AfterClass

    public void afterClass(){

        //Close chrome;
        webDriver.close();

    }

}
