package testNgPractice;

import java.io.IOException;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateContactTestUsingBaseClass extends BaseClass{
	
	@Test
	public void createContactTest() throws IOException, InterruptedException{
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		//Step: click on contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		//Step: click on create contact lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImage();
		
		//Step: create contact with mandatory fields and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
		
		//Step: validate
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
	
		
	
	}
}
