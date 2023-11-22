package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import objectRepository.OrganizationsPage;

public class ObjectRepositoryPractice2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Step 1: Create all the required Objects
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver = null;
		
		//Step 2: Read The Required Data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
						
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcel("Organization", 4, 3);
		String TYPE = eUtil.readDataFromExcel("Organization", 7, 4);
						
		//Step 3: Launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
						
		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
						
		//Step 4: Load the URL
		driver.get(URL);
		
		//Step 5: Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		//Step 6: Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 7: Click on Create Organization look Up Imge
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImage();
		
		//Step 8: Create Organization with mandatory information and save
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrganization(ORGNAME, INDUSTRY, TYPE);
		
		//Step 9: Validate
		OrganizationInfoPage oinfo = new OrganizationInfoPage(driver);
		oinfo.getOrgHeader();
		
		
		/*
		//Step 10: Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
						
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successful");
						
		driver.close();
		*/

		//Step 10: Logout of Application
		//hp.logOutOfApplication(driver);
	

	}

}
