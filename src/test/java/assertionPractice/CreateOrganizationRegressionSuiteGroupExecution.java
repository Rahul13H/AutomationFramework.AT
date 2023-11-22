package assertionPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

public class CreateOrganizationRegressionSuiteGroupExecution extends BaseClass{
	
	@Test(groups="RegressionSuite")
	public void CreateOrganizationassert() throws EncryptedDocumentException, IOException {
		
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImage();
		
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
	}

}
