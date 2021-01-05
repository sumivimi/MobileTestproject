package com.ibm.Assignment;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
public class Magento_Contact_Test {
	AndroidDriver driver;
  @BeforeMethod
	  public void beforeMethod() throws InterruptedException, MalformedURLException {
	  DesiredCapabilities capability= new DesiredCapabilities();
	  capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Vimala");
	  capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	  driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability); 
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      
	  }
  
  @Test
  public void function() throws InterruptedException {
	  driver.get("https://magento.com/");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//button[@class='nav-menu-button js-menu-button visible-xs visible-sm']")).click();
      driver.findElement(By.xpath("//*[@id='block-header']/ul/li[8]/a")).click();
      driver.findElement(By.xpath("//ul[@class='menu menu-level-1']/li/div/div[2]/p[2]/a")).click();
      JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("window.scrollBy(0,2500)");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("*&:)");
	  driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("*&:)123A");
	  driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("sumivimi@"); 
	  driver.findElement(By.xpath("//*[@id='Phone']")).sendKeys("ABCFF"); 
	  WebElement element = driver.findElement(By.xpath("//*[@id='Country']")); 
	  Select select = new Select(element); 
	  select.selectByVisibleText("India");
	  WebElement element1 = driver.findElement(By.xpath("//*[@id='Job_Role__c']"));
	  Select select1 = new Select(element1);
	  select1.selectByValue("Developers");
	  driver.findElement(By.xpath("//*[@id='Company']")).sendKeys("IBM");
	  WebElement element2 = driver.findElement(By.xpath("//*[@id='Organizational_Role__c']"));
	  Select select2 = new Select(element2);
	  select2.selectByIndex(2);
	  WebElement element3 = driver.findElement(By.xpath("//*[@id='MktoPersonNotes']"));
	  Select select3 = new Select(element3);
	  select3.selectByIndex(3);
	  driver.hideKeyboard();
	  js.executeScript("window.scrollBy(0,1000)");
	  driver.findElement(By.xpath("//*[@id='top-target']/div[1]/div/div[1]/form/div[48]/span/button")).click();
	  
  }
  
  @AfterMethod
  public void afterMethod() throws IOException {
	  try {
		  
		  String errorMessage=driver.findElement(By.xpath("//*[@id='ValidMsgEmail']")).getText();
          System.out.println("Invalid Email :"+errorMessage);
          File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(file, new File("C:\\Users\\VimalaSubbaraj\\Desktop\\Selenium_udemy\\SS\\Screen2.jpg"));
		 
         
          }
      
      catch(NoSuchElementException e) {
      	
      	  String actualMessage=driver.findElement(By.xpath("//div[@class='js-step-thank-you step-thank-you']")).getText();
          System.out.println("Enquiry is submitted :"+actualMessage);
          File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(file, new File("C:\\Users\\VimalaSubbaraj\\Desktop\\Selenium_udemy\\SS\\Screen3.jpg"));
          }
	  driver.close();
  }

}
