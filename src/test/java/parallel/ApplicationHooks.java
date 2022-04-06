package parallel;

import com.qa.factory.DriverFactory;

import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

 private DriverFactory driverFactory;
 private WebDriver driver;
 private ConfigReader configreader ;
 Properties prop ;

 @Before(order =0)
 public  void getProperty() throws Exception {

  configreader = new ConfigReader();
  prop= configreader.init_prop();

 }
 @Before(order =1)
 public  void LaunchBrowser() {

     String BrowserName=prop.getProperty("browser");
     driverFactory=new DriverFactory();
     driver=driverFactory.init_driver(BrowserName);
 }

 @After(order=0)

 public  void quitBrowser(){
  driver.quit();
 }

 @After(order=0)

 public  void tearDown(Scenario scenario){
  if(scenario.isFailed()){
   // Take screen shots inside this

  String sreenShotName= scenario.getName().replaceAll(" ","_");
  byte[] sourcepath= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  scenario.attach(sourcepath,"image/png",sreenShotName);
  }
 }


}
