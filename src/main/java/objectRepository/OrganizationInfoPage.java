package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {  //Step 1
	
	//Step 2 : Deceleration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderTxt;
	
	//Declaration
	public  OrganizationInfoPage(WebDriver Driver) 
	{
		PageFactory.initElements(Driver, this);		
	}

	
	//utilization
	
	public WebElement getOrgHeaderTxt() {
		return OrgHeaderTxt;
	}


	//Business Library
	/**
	 * This method will capture the text from Org Header and return it to caller
	 * @return
	 */
	public String getOrgHeader()
	{
		return OrgHeaderTxt.getText();
	}
	
	

}
