package com.kit.homework.lesson23;

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
 * Created by AlekseySova on 07.06.2017.
 */
public class GmailSearchOldTest {

    private String gmailSearch;
    private WebDriver webDriver;

    @BeforeClass

    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Alex Owl\\IdeaProjects\\selenium\\src\\main\\resources\\chromedriver.exe");

        String gmailSearch = "https://www.gmail.com";
        webDriver = new ChromeDriver();
        //Lunch GoogleChrome on gmail.com
        webDriver.get(gmailSearch);

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test(enabled = false)
    public void gmailSearchTest(){

        Actions actions = new Actions(webDriver);

        //Data for test
        String gmailTitle = "Gmail";
        String mailPassword = "evwfevwf78";
        String mailName = "aaabbcc439";
        String emailAddress = "aaabbcc439@gmail.com";
        By searchMailField1 = By.xpath(".//*[@id=\"identifierId\"][@class=\"whsOnd zHQkBf\"]");
        By searchMailButton = By.xpath(".//*[@class=\"ZFr60d CeoRYc\"]");
        By searchMailField2 = By.xpath(".//*[@class=\"whsOnd zHQkBf\"][@type=\"password\"]");
        By accountMailLocator = By.xpath(".//*[@class=\"gb_8a gbii\"]");
        By verifyMailLocator = By.xpath(".//*[@class=\"gb_wb\"]");

        //Verify that it is gmail.com page
        assertTrue(webDriver.getTitle().contains(gmailTitle));

        WebElement mailField = webDriver.findElement(searchMailField1);
        WebElement mailButton = webDriver.findElement(searchMailButton);

        //Enter email name in field
        mailField.sendKeys(mailName);

        //Push button "next"
        actions.moveToElement(mailButton).click().perform();

        WebElement passField = webDriver.findElement(searchMailField2);

        //Enter email password
        passField.sendKeys(mailPassword);

        WebElement mailButton2 = webDriver.findElement(searchMailButton);

        //Push button "next"
        actions.moveToElement(mailButton2).click().perform();


        WebElement mailAccount = webDriver.findElement(accountMailLocator);

        actions.moveToElement(mailAccount).click().perform();

        WebElement verifyField = webDriver.findElement(verifyMailLocator);

        //Verify that entering in right email account
        assertEquals(emailAddress, verifyField.getText());

    }

    @AfterClass
    public void closeUp(){

        webDriver.close();

    }
}
