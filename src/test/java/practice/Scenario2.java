package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {

	public static void main(String[] args) throws Throwable {
		
		//Launch Browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		//Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
		//Navigate to Organizations link 
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		
		//Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(1000);
		
		//Create Organization with Mandatory fields 
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("PentaChrome");
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
