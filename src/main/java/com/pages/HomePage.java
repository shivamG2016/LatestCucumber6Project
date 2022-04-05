package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    private By homePageSections =By.cssSelector("ul.menusubnav a");

    // Creation of the custructor

    public HomePage(WebDriver driver){

        this.driver=driver;
    }

    // We have to create page actions here

    public int getDifferentTabCount(){

      return  driver.findElements(homePageSections).size();
    }

    // Getting list of the elements

    public List<String> getLeftPannelList(){

        List<String> pannelList = new ArrayList<String>();
           List<WebElement> pannelList1=    driver.findElements(homePageSections);

           for(WebElement e : pannelList1 ){

                   String text =e.getText();
               System.out.println(text);
               pannelList.add(text);
           }

           return pannelList;

    }

    // Getting the title of the home page


    public String getHomePagetitle(){

      return   driver.getTitle();
    }

}
