package listenersPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClassExecution;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateContactLowLevelReport extends BaseClassExecution{
	
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createContact() throws IOException, InterruptedException{
		
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		Reporter.log("Clicked on contacts Link");
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImage();
		Reporter.log("Clicked Create Contact Look Up Img");
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
		Reporter.log("Contact Create Successfully");
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		Reporter.log("Header Captured");
		//Assert.fail();  //for checking Execution & Screenshot :- failed script
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		Reporter.log("Header validated");
		System.out.println(contactHeader);	
	}
	
}
