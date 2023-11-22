package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {  //Step 1
	
	//Step 2 : Deceleration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	//Step 3 : Initialization
	public OrganizationsPage(WebDriver driver)
	{
	   PageFactory.initElements(driver, this);
	}
	
	
	//Step 4 : Utilization
	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	
	//Step 5 : Business library
	/**
	 * This method will click on organization lookup image
	 */
	public void clickOnOrganizationLookUpImage()
	{
		createOrgLookupImg.click();
	}

}
