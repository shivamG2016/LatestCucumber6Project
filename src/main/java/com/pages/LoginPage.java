package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {



private WebDriver driver;
    // Locators

  private By username1 = By.name("uid");
  private By password = By.name("password");
  private By LoginBtn = By.name("btnLogin");
  private By resetbtn = By.name("btnReset");

  // Constructor of page

    public LoginPage(WebDriver driver ){

        this.driver=driver;
    }

    // Page Actions ...

    public  String getLoginPageTitle(){

        return driver.getTitle();
    }

    public boolean isResetBtnExist(){

        return driver.findElement(resetbtn).isDisplayed();
    }

    public void enterUserName(String username){

         driver.findElement(username1).sendKeys(username);
    }
    public void enterPassword(String pwd){

        driver.findElement(password).sendKeys(pwd);
    }

    public void clickONLogin(){

        driver.findElement(LoginBtn).click();
    }


    public HomePage doLogin(String un , String pwd){
        System.out.println(" Log in with "+un +"and password" + pwd);
        driver.findElement(username1).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(LoginBtn).click();
        return new HomePage(driver);
    }


}
