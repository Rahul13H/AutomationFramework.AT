package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{  //Step 1
	
	//Step 2 : Deceleration
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy (linkText="Products")
	private WebElement productLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	//Step 3 : Initialization
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	//Step 4 : Utilization
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	
	
	public WebElement getProductLnk() {
		return productLnk;
	}


	//Step 5 : Business library
	/**
	 * This Method will click on organization link
	 */
	public void clickOnOrganizationLink()
	{
		organizationLnk.click();
	}
	
	/**
	 * This Method will click on contact link
	 */
	public void clickOnContactLink()
	{
		contactLnk.click();
	}
	
	/**
	 * This method will click on product Link
	 */
	public void clickOnProductLink()
	{
		productLnk.click();
	}
	
	/**
	 * This method will logout of application
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void logOutOfApplication(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signOutLnk.click();
	}
	

}
