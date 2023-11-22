package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {

	public static void main(String[] args) throws Throwable {
		
		//End to End - Integration
		//Launch Browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		//Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
				
		//Navigate to Contacts link
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		//driver.findElement(By.linkText("Contacts")).click();
				
		//Click on Create contact look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
		//Create Contact with Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Pawar");
		Thread.sleep(1000);
		
		//Select the Organization from organization look up image
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		String ContactId = driver.getWindowHandle(); 
		 System.out.println(ContactId);
		 Set<String> allIds = driver.getWindowHandles();
		 System.out.println(allIds);
		 
		 for(String id:allIds)
		 {
          if(!ContactId.equals(id))   
          {
       	   driver.switchTo().window(id);
       	   Thread.sleep(1000);
       	   driver.findElement(By.xpath("//a[@id='2']")).click();
          }
	     }
		 driver.switchTo().window(ContactId);
		 Thread.sleep(1000);
		
		//Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		
			
		//Verify
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if (ContactHeader.contains("Pawar")) 
		    {
			    System.out.println("Pass");
			} 
		     else 
		    {
		       System.out.println("Fail");
		    }
					
		    Thread.sleep(1000);
		  //logout of Application
	      WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	      		
	      Actions act=new Actions(driver);
	      act.moveToElement(ele).perform();
	      Thread.sleep(1000);
	      driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	      System.out.println("Singout Successful");
	      		
	      driver.close();
		

	}

}
