package framesAndPopUps;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopUpCurrentDate {

	public static void main(String[] args) throws InterruptedException {
		
		Date d = new Date();
		String dateNow = d.toString();
		System.out.println(dateNow);
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
		System.out.println(currentDate);
		
        
		// Launch the browser
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");

		Thread.sleep(1000);

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

		Thread.sleep(2000);

		// navigate to departure
		// driver.findElement(By.xpath("//label[@for='departure']")).click();

		// navigate to desired date in calender
		Thread.sleep(1000);                       //dynamic xpath
		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		                             //div[@aria-label='Sat Jul 08 2023']
		                             //div[@aria-label='Sat Jul 09 2023']
		                             //div[@aria-label='Sat Jul 18 2023']

	}

}
