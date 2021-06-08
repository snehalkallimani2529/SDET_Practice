package com.crm.comcast.genericutility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Deepak
 *
 */
public class WebDriverUtility {
	/**
	 *  used to select the value from the dropDwon based on VisibleText
	 * @param element
	 * @param value
	 */
	 public void select(WebElement element , String value) {
		 Select sel = new Select(element);
		 sel.selectByVisibleText(value);
	 }
	 
		/**
		 *  used to select the value from the dropDwon based on index
		 * @param element
		 * @param value
		 */
		 public void select(WebElement element , int index) {
			 Select sel = new Select(element);
			 sel.selectByIndex(index);
		 }

    /**
     * its an webdriver implicitly wait , it always wait for page to load before finding an element
     * @param driver
     */
		 public void waitforPageToLoad(WebDriver driver) {
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 }
		 
		 /**
		  * its an webdriver explicitly  wait , it always wait for specific element to be visible in html document
		  * @param driver
		  * @param element
		  */
		 public void waitForElemnetToBeVisible(WebDriver driver , WebElement element) {
			 WebDriverWait wait = new WebDriverWait(driver, 20);
			 wait.until(ExpectedConditions.visibilityOf(element));
		 }
		 
		 /**
		    * This method will perform mouse over action
		    * @param driver
		    * @param element
		    */
		   
		   public void mouseOver(WebDriver driver,WebElement element)
		   {
			   Actions act = new Actions(driver);
			   act.moveToElement(element).perform();
			   
		   }
		   
		   /**
		    * This method performs right click operation 
		    * @param driver
		    * @param element
		    */
		   public void rightClick(WebDriver driver,WebElement element)
		   {
			   Actions act = new Actions(driver);
			   act.contextClick(element).perform();
		   }
		   
		   /**
		    * This method helps to switch from one window to another
		    * @param driver
		    * @param partialWinTitle
		    */
		   public void switchToWindow(WebDriver driver, String partialWinTitle)
		   {
			   Set<String> window = driver.getWindowHandles();
			   Iterator<String> it = window.iterator();
			   while(it.hasNext())
			   {
				   String winId=it.next();
				   String title=driver.switchTo().window(winId).getTitle();
		           if(title.contains(partialWinTitle))
		           {
		        	   break;
		           }
				   
			   }
			   
		   }
		   /**
		    * Accept alert 
		    * @param driver
		    */
		   
		   public void acceptAlert(WebDriver driver)
		   {
			   driver.switchTo().alert().accept();
		   }
		   
		   /**
		    * Cancel Alert
		    * @param driver
		    */
		   public void cancelAlert(WebDriver driver)
		   {
			   driver.switchTo().alert().dismiss();
		   }
		   /**
		    * This method used for scrolling action in a webpage
		    * @param driver
		    * @param element
		    */
		   public void scrollToWebElement(WebDriver driver, WebElement element) {
			   JavascriptExecutor js=(JavascriptExecutor)driver;
			  int y= element.getLocation().getY();
			   js.executeScript("window.scrollBy(0,"+y+")", element);
		   }
		   
		   /**
		    * Switch to frame based on index
		    * @param driver
		    * @param index
		    */
		    public void switchFrame(WebDriver driver,int index) {
		    	driver.switchTo().frame(index);
		    }   
		    
		    
			   /**
			    * Switch to frame based on element
			    * @param driver
			    * @param index
			    */
		    public void switchFrame(WebDriver driver,WebElement element) {
		    	driver.switchTo().frame(element);
		    } 
			
		    
			   /**
			    * Switch to frame based on id or name
			    * @param driver
			    * @param index
			    */
		    public void switchFrame(WebDriver driver,String idOrName) {
		    	driver.switchTo().frame(idOrName);
		    } 

		    /**
		     * used to take a screenshot
		     * @param driver
		     * @param screenshotName
		     * @throws Throwable
		     */
		    public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		    	TakesScreenshot ts=(TakesScreenshot)driver;
		    	File src=ts.getScreenshotAs(OutputType.FILE);
		    	File dest=new File("./screenshot/"+screenshotName+".PNG");
		    	Files.copy(src, dest);
		    }
		    
		    /**
		     * perform virtual key operation 
		     * @throws Throwable
		     */
		    public void pressEnterKey() throws Throwable {
		    	
		    	Robot rc=new Robot();
		    	rc.keyPress(KeyEvent.VK_ENTER);
		    	rc.keyRelease(KeyEvent.VK_ENTER);
		    }

}
