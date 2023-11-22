package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all Basic Configuration Annotation of testNG
 * @author RahulH
 *
 */
public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	
	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("---DB Connection Sucessful---");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException {
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + " launched");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
		
		driver.get(URL);
	}

	
	@BeforeMethod
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		System.out.println("---Login Succesful---");
	}

	
	@AfterMethod
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		System.out.println("---Logout Succesful---");
	}

	
	@AfterClass
	public void acConfig() {
		driver.quit();
		System.out.println("---Browser Closed---");
	}

	
	@AfterSuite
	public void asConfig() {
		System.out.println("---DB Connection Closed---");
	}


}
