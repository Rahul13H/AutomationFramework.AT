package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		
		//Launch Browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
		//Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Create contact look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Create Contact with Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Pawar");
		Thread.sleep(1000);
		//Save
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		
		//Verify
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactHeader.contains("Pawar")) 
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
