package com.kit.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by AlekseySova on 09.06.2017.
 */
public class WebDriverTestBase {

    protected WebDriver webDriver;

    @BeforeSuite

    public void setUp(){

        ChromeDriverManager.getInstance().setup();

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void testDown(){
        // Closes a browser
        webDriver.close();
        //Closes a browser's tab
        //webDriver.quit();

    }

}
