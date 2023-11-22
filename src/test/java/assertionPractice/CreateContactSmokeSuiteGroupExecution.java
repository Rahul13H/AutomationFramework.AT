package assertionPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateContactSmokeSuiteGroupExecution extends BaseClass{
	
	@Test(groups="SmokeSuite")
	public void CreateContactassert() throws EncryptedDocumentException, IOException {
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImage();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
		
		ContactInfoPage cip= new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
	}

}
