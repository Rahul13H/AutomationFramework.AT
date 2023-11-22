package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{ //Step 1
	
	//Step 2 : Deceleration
	@FindBy (name = "lastname")
	private WebElement LastnameEdt;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement OrgLookUpImg;
	
	@FindBy (xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	@FindBy (name = "search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy (name= "search")
	private WebElement SearchBtn;
	
	//Step 3 : Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 4 : Utilization
	public WebElement getLastnameEdt() {
		return LastnameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
		
	//Step 5 : Business library
	/**
	 * This method will create contact with mandatory field and save
	 * @param LASTNAME
	 */
	public void CreateNewContact(String LASTNAME)
	{
		LastnameEdt.sendKeys (LASTNAME);
		SaveBtn.click();
	}
	
    /**
     * This method will create new contact with organization with window handling
     * @param Driver
     * @param LASTNAME
     * @param ORGNAME
     */
	public void CreateNewContact(WebDriver driver, String LASTNAME, String ORGNAME)
	{
		LastnameEdt.sendKeys (LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']"));
		switchToWindow(driver, "Contacts");	
		SaveBtn.click();
	}


}
