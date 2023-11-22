package contactTests;

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
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest {
	
	@Test
	public void createContactTest() throws IOException, InterruptedException{
		
		// step 1: Create all the required object
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver = null;
		
		//Step 2: Read the Required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		
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
         else if (BROWSER.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+"launched");
		}
         else
         {
        	 System.out.println("invalid browser");
         }
		
		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//Step 4: Load the Url
		driver.get(URL);
		
		//Step 5: Login To Application
//		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPassWordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		//Step 6: click on contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		//Step 7: click on create contact lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImage();
		
		//Step 8: create contact with mandatory fields and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
		
		//Step 9: validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if (contactHeader.contains(LASTNAME)) 
		{
			System.out.println(contactHeader);
			System.out.println("PASS");
		} 
		else 
		{
			System.out.println("FAIL");
		}
		
		//Step 14: Logout
		hp.logOutOfApplication(driver);
				
		//Step 15: Close the Browser
		driver.close();
		
	}
	@Test
	public void demo()
	{
		System.out.println("demo");
	}

}
