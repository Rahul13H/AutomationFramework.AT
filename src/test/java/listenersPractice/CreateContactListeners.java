package listenersPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
public class CreateContactListeners extends BaseClassExecution{
	
	@Test
	public void createContact() throws IOException, InterruptedException{
		
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImage();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		Assert.fail();  //for checking Execution & Screenshot :- failed script
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);	
	}
	
	@Test
	public void demo()
	{
		System.out.println("demo");
	}
	
}
