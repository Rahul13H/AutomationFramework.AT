package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage { //Step 1
	
	//Step 2 : Deceleration
		@FindBy (xpath = "//img[@alt ='Create Contact...']")
		private WebElement CreateContactLookUpImg;
		
		//Step 3 : Initialization
		public ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Step 4 : Utilization
		public WebElement getCreateContactLookUpImg() {
			return CreateContactLookUpImg;
		}
		
		//Step 5 : Business Library
		/**
		 * This method will click on create contact lookup image
		 */
		public void clickOnCreateContactImage()
		{
			CreateContactLookUpImg.click();
		}


}
