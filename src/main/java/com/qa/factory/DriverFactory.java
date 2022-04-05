package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();

    public WebDriver init_driver(String browser){

        System.out.println("Browser value is " +browser);

        if(browser.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());

        }

        else if (browser.equalsIgnoreCase("firefox")){


            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }

        else if (browser.equalsIgnoreCase("Safari")){

            tlDriver.set(new SafariDriver());
        }

        else {
            System.out.println("Please pass correct Browser values");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();


    }
    public static WebDriver getDriver(){

        return tlDriver.get();
    }



}
