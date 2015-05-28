/**
 * 
 */
package com.nativeapps.homeowner.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

/**
 * @author shabana.khanam
 *
 */
public class PostJobSelendroidTest {
	
	private  WebDriver driver;
	
//	 @BeforeMethod
//	  public void setup() throws MalformedURLException 
//	  {
//			  File appDir = new File("C:\\WorkspaceNativeApps\\android\\");
//			  File app = new File(appDir, "Tokyo_RatedPeople_HomeOwner.apk");
//			  DesiredCapabilities capabilities = new DesiredCapabilities();
//			  capabilities.setCapability("platformVersion", "4.3");
//			  capabilities.setCapability("deviceName", "GT-19300");
//			  capabilities.setCapability("platformName","Android");
//			  capabilities.setCapability("app-package","com.ratedPeople.homeOwner");
//			  capabilities.setCapability("app-activity","PostJobActivity");
//			  capabilities.setCapability("app", app.getAbsolutePath());
//	     	  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//			  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);  
//			  Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
//			  for (String contextName : contextNames) {
//			      System.out.println(contextNames); //prints out something like NATIVE_APP \n WEBVIEW_1
//			  }
//			 
//	   }
	
	 
	 @Test
	 @SuppressWarnings("unused")
	 public void postaJobTest() throws Exception
	 {
		    	  
//			WebDriverWait wait = new WebDriverWait(driver,80);
		 	@SuppressWarnings("static-access")
			DesiredCapabilities caps = new SelendroidCapabilities().android();
			driver = new SelendroidDriver(caps);
			driver.findElement(By.name("Post a Job")).click();
			System.out.println("This is the id click");
			driver.findElement(By.name("Aerial / Network Specialist")).click();
			driver.findElement(By.name("CCTV")).click();
			driver.switchTo().window("WEBVIEW");
//			driver.context(contextNames.toArray()[1]);
			driver.findElement(By.xpath(".//*[@id='statusREADY_TO_HIRE']")).click();
			driver.findElement(By.xpath(".//*[@id='ownerOWN_AND_LIVE']")).click();
			Select something = new Select(driver.findElement(By.xpath(".//*[@id='timing']")));
			something.selectByValue("URGENTLY");
			driver.findElement(By.xpath(".//*[@id='postcode']")).sendKeys("RP99RP");
			driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']")).sendKeys("Posting a Job through Native App Android Hybrid");
			driver.findElement(By.xpath(".//*[@id='next']")).click();
			driver.wait();
	 }
	 
	
	

}
