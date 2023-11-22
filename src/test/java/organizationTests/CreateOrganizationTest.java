package organizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

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

public class CreateOrganizationTest {

	@Test
	public void createOrganization() throws IOException, InterruptedException{
		
		// step 1: Create all the required object
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver = null;
		
		//Step 2: Read the Required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Step 3: Launch the Browser
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+"launched");
		} 
		else if(BROWSER.equalsIgnoreCase("firefox")) 
		 {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+"launched");
		}
		 else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+"launched");
		}
		 else
		{
			System.out.println("Invalid browser");
		}
		
		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//loas url
		driver.get(URL);
		
		// Step 5: Login the application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		// step 6: click on organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//step 7: click on organization lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImage();
		
		//step 8: create organization with mandatory information and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		//step 9: validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		if (orgHeader.contains(ORGNAME)) 
		{
			System.out.println(orgHeader);
			System.out.println("Organization created");
		} 
		else 
		{
			System.out.println("FAIL");
		}
		
		//step 10:logout
		hp.logOutOfApplication(driver);
		
		//step 11: close the browser
		driver.close();
		
	}

}
