package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic method related to web driver actions
 * @author RahulH
 */
public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for a particular element to be visible in the DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown by Visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform Right click
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
	}
	
	/**
	 * This Method will perform right click
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * 
	 * This method will right click on particular web element
	 * @param driver
	 * @param element
	 */

	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
		
	}
	
	/**
	 * This method will perform double click anywhere on page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * 
	 * This method will double click on a web element
	 * @param driver
	 * @param element
	 */

	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();	
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement dstEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, dstEle).perform();
	}
	
	/**
	 * 
	 * This method will drag and drop from src element to target element offsets.
	 * @param driver
	 * @param src
	 * @param x
	 * @param y
	 */
	public void dragAndDropAction(WebDriver driver,WebElement src, int x, int y )
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x, y).perform();
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by NameOrID
	 * @param driver
	 * @param NameOrID
	 */
	public void switchToFrame(WebDriver driver, String NameOrID)
	{
		driver.switchTo().frame(NameOrID);
	}
	
	/**
	 * This method will handle frame by WebElement
	 * @param driver
	 * @param NameOrID
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch control from child to immediate parent
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();	
	}

	/**
	 * This method will switch control from child to default Frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();	
	}
	
	/**
	 * This Method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0,500);", "");
	}
	
	
	/**
	 * This Method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0,-500);", "");
	}
	
	/**
	 * This Method will accept the alert PopUp
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This Method will cancle the alert PopUp
	 * @param driver
	 */
	public void cancleAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will fetch the alert text and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshoot\\"+screenshotName+".png");  //....Screenshot1.png
		Files.copy(src, dst);
		return dst.getAbsolutePath();  //used for extent reports
	}
	
	/**
	 * This method will switch the window based on window title.
	 * @param driver
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//step1: get all the window IDs
		 Set<String> allWinIds = driver.getWindowHandles();
		 
		//step2: Navigate to each window
		for (String winID:allWinIds)	 
		 {
			//STEP3: switch to each window and Capture The title
			 String actTitle = driver.switchTo().window(winID).getTitle();
			 
			//Step4: compare act title with expected partial Title
			 if(actTitle.contains(partialWindowTitle))
			 {
				 break;
			 }
				 		 
		 }
		 	 	
	}
	
	
	


}
