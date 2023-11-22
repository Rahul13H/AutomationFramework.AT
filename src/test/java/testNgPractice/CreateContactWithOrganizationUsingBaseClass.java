package testNgPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

public class CreateContactWithOrganizationUsingBaseClass extends BaseClass{
	
	@Test
	public void CreateContactWithOrganizationTest() throws EncryptedDocumentException, IOException {
		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImage();
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		}
		else
		{
			System.out.println("FAIL");
		}
		
        hp.clickOnContactLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImage();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if(contactHeader.contains(LASTNAME))
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
