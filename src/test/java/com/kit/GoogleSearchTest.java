package com.kit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by AlekseySova on 05.06.2017.
 */
public class GoogleSearchTest {

    private String googleSearch;
    private WebDriver webDriver;

    @BeforeClass

    public void setUp(){

        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\Alex Owl\\IdeaProjects\\selenium\\src\\main\\resources\\chromedriver.exe");

        webDriver = new ChromeDriver();
        googleSearch = "https://www.google.com.ua";
        webDriver.get(googleSearch);

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @Test
    public void searchTest(){

        String searchText = "Selenium";
        By searchLocator = By.name("q");
        WebElement searchField = webDriver.findElement(searchLocator);

        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");

        WebElement link = webDriver.findElement(linkLocator);

        assertTrue(link.getText().contains(searchText));

    }


}
