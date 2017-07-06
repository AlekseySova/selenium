package com.thomascook.core;

import com.thomascook.utils.PropertiesCache;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

/**
 * Created by AlekseySova on 09.06.2017.
 */
@Listeners({})
public class WebDriverTestBase {

    protected WebDriver webDriver;
    //How to pass System variable(to pass any) to Selenium Framework
    //maven -Dbrowser=CHROME of -Dbrowser=FF clean test - to run test on diff Browser

    private String browser = System.getProperty("browser");
    long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    long pageLoadTimeout = Long.parseLong(PropertiesCache.getProperty("wait.pageload"));
    long setScriptTimeout = Long.parseLong(PropertiesCache.getProperty("wait.setscript"));
    @BeforeClass


    public void setUp(){
        // for manual version
        //System.setProperty("webdriver.chrome.driver",
        //       "C:\\Users\\pc\\selenium\\src\\main\\resources\\chromedriver.exe");

        // using bonigarcia
        //ChromeDriverManager.getInstance().setup();

        //for manual version
        //webDriver = new ChromeDriver();

        //Multi-browsing
        setBrowser();

        serWebDriverSettings();

    }


    public void serWebDriverSettings() {

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout,TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(setScriptTimeout,TimeUnit.SECONDS);

    }

    public void setBrowser(){
        Browser runBrowser = EnumUtils.isValidEnum(Browser.class,browser) ?
                Browser.valueOf(browser.toUpperCase()) : Browser.CHROME;

        //Browser runBrowser = browser == null ? Browser.CHROME : Browser.valueOf(browser.toUpperCase());

        switch (runBrowser){

            case CHROME:

                ChromeDriverManager.getInstance().setup();
                webDriver = new ChromeDriver();

                break;

            case FF:

                FirefoxDriverManager.getInstance().setup();

                webDriver = new FirefoxDriver();

                break;


        }

    }

    @AfterClass
    public void testDown(){
        // Closes a browser
        //webDriver.close();
        //Closes a browser's tab
        webDriver.quit();

    }

}
