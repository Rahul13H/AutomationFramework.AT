package framesAndPopUps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopUpFutureDate {
	
	public static void main(String[] args) throws InterruptedException {

		// Launch the browser
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");

		Thread.sleep(2000);

		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();

		// driver.findElement(By.xpath("//a[@class='close']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();

		// Navigate to From and To Elements
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']"));

		src.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();

		Thread.sleep(2000);

		dst.sendKeys("Del");

		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();

		//Thread.sleep(2000);

		// navigate to departure
		// driver.findElement(By.xpath("//label[@for='departure']")).click();

		// navigate to any future Date date in calendar
		Thread.sleep(1000); 
		
		for(;;)//1 2 3 4 5 while(true){}
		{
			try 
			{ //not visible - exception - visible - click()
				driver.findElement(By.xpath("//div[@aria-label='Fri Apr 05 2024']")).click(); // No such element exception
				break;
			} 
			catch (Exception e) 
			{//click on next month
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				Thread.sleep(1000);
			}
		}
		
		
	}


}
