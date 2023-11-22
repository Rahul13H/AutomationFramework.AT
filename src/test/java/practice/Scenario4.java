package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {

	public static void main(String[] args) throws Throwable {
		
		//Launch Browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
								
		//Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		Thread.sleep(1000);
						
		//Navigate to Organizations link 
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		Thread.sleep(1000);
						
		//Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(1000);
						
		//Create Organization with Mandatory fields 
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("PentaChrome");
		Thread.sleep(1000);
		
		//Select "Energy"  in the industry drop down
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select ind = new Select(industry);
		ind.selectByIndex(10);
		Thread.sleep(1000);
		
		//Select "Customer" in the Type Drop down
		WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select tpe = new Select(type);
		tpe.selectByIndex(3);
		Thread.sleep(1000);
		
		//Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		
		//Verify
		String OrganizationHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if (OrganizationHeader.contains("PentaChrome")) 
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
