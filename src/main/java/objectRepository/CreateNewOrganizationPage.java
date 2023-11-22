package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {  //Step 1
	
	//Step 2 : Deceleration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy (name= "industry")
	private WebElement IndustryDropDown;
	
	@FindBy (name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Step 3 : Initialization
	public CreateNewOrganizationPage(WebDriver driver)
    {
	   PageFactory.initElements(driver, this);
    }

	//Step 4 : Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	
	//Step 5 : Business Library
	/**
	 * This method will create organization with orgname 
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create Organization name With  industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOrganization(String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown, INDUSTRY);
		SaveBtn.click();
		
	}
	
	/**
	 * This method will create Organization name With  industry and type dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createOrganization(String ORGNAME, String INDUSTRY, String TYPE)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown, INDUSTRY);
		handleDropDown(typeDropDown, TYPE);
		SaveBtn.click();
		
	}
	



}
