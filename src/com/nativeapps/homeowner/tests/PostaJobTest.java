/**
 * 
 */
package com.nativeapps.homeowner.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author shabana.khanam
 *
 */


public class PostaJobTest {


			 
				private  AppiumDriver driver;
				         
				  @BeforeMethod
				public void setup() throws MalformedURLException 
				  {
						  File appDir = new File("C:\\WorkspaceNativeApps\\android\\");
						  File app = new File(appDir, "Tokyo_RatedPeople_HomeOwner.apk");
						  DesiredCapabilities capabilities = new DesiredCapabilities();
//						  capabilities.setCapability("platformVersion", "4.3");
						  capabilities.setCapability("platformVersion", "4.4.2");
//						  capabilities.setCapability("deviceName", "GT-19300");
						  capabilities.setCapability("deviceName", "GT-i9505");
						  capabilities.setCapability("device","selendroid");
						  capabilities.setCapability("platformName","Android");
						  capabilities.setCapability("app-package","com.ratedPeople.homeOwner");
						  capabilities.setCapability("app-activity","PostJobActivity");
						  capabilities.setCapability("app", app.getAbsolutePath());
				     	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
						  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);  
//						  Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
//						  for (String contextName : contextNames) {
//						      System.out.println(contextNames); //prints out something like NATIVE_APP \n WEBVIEW_1
//						  }
						  
						TouchAction  touch = new TouchAction(driver);
				           Set<String> contextNames = driver.getContextHandles();
				           for (String contextName : contextNames) {
				               System.out.println("This is the context 1 : "+contextName);
				               if (contextName.contains("WEBVIEW")){
				                  driver.context(contextName);
				               }
				            } 
						 
				   }

				 
				 
				 @Test
				 @SuppressWarnings("unused")
				 public void postaJobTest() throws Exception
				 {
     			    	  
						WebDriverWait wait = new WebDriverWait(driver,80);
     					driver.findElement(By.name("Post a Job")).click();
     					driver.findElement(By.name("Aerial / Network Specialist")).click();
						driver.findElement(By.name("CCTV")).click();
						  Set<String> contextNames = driver.getContextHandles();
				           for (String contextName : contextNames) {
				               System.out.println("This is the context 2 : "+contextName);
				               if (contextName.contains("WEBVIEW")){
				                  driver.context(contextName);
				               }
				            } 
						driver.findElement(By.xpath(".//*[@id='statusREADY_TO_HIRE']")).click();
						driver.findElement(By.xpath(".//*[@id='ownerOWN_AND_LIVE']")).click();
						Select something = new Select(driver.findElement(By.xpath(".//*[@id='timing']")));
						something.selectByValue("URGENTLY");
						driver.findElement(By.xpath(".//*[@id='postcode']")).sendKeys("RP99RP");
						driver.findElement(By.xpath(".//*[@id='additionalDetailsContainer']/textarea")).sendKeys("Posting a Job through Native App Android Hybrid");
						driver.findElement(By.xpath(".//*[@id='next']")).click();
//						driver.wait();
						Select budget = new Select(driver.findElement(By.xpath(".//*[@id='jobBudgetCode']")));
						budget.selectByValue("RANGE_100_250");
						driver.findElement(By.xpath(".//*[@id='next']")).click();
						driver.findElement(By.xpath(".//*[@id='firstName']")).sendKeys("Test");
						driver.findElement(By.xpath(".//*[@id='lastName']")).sendKeys("Test");
						driver.findElement(By.xpath(".//*[@id='mobilePhone']")).sendKeys("01234567890");
						driver.findElement(By.xpath(".//*[@id='confirmPhone']")).sendKeys("01234567890");
						driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Testhack@ratedtrades.com");
						driver.findElement(By.xpath(".//*[@id='confirmEmail']")).sendKeys("Testhack@ratedtrades.com");
						driver.findElement(By.xpath(".//*[@id='btnPostJob']")).click();
					
						
				 }

				       @AfterMethod
				 public void tearDown()
				 {
				               driver.quit();
				  }


			
}



