package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage { //Step 1
	
	//Step 2 : Deceleration
	@FindBy (xpath ="//span[@class='dvHeaderText']") //a [@class='hdrLink']
	private WebElement ContactHeaderText;
	
	//Step 3 : Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 4 : Utilization
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	

	//Step 5 : Business library
	/**
	 * This method will capture text from contact header and return it to caller 
	 * @return
	 */
	public String getContactHeader()
	{
		return ContactHeaderText.getText();
	}

}
