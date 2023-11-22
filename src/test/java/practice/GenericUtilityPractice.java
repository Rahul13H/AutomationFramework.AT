package practice;

import java.io.IOException;

import org.apache.logging.log4j.util.PropertyFilePropertySource;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility pUtill = new PropertyFileUtility();
		String URL = pUtill.readDataFromPropertyFile("url");  // url or username or password
		System.out.println(URL);
		
		String Browser = pUtill.readDataFromPropertyFile("browser");
		System.out.println(Browser);
		
		ExcelFileUtility eUtill = new ExcelFileUtility();
		String data = eUtill.readDataFromExcel("Contacts", 1, 2);
		System.out.println(data);
		
		JavaUtility jUtill = new JavaUtility();
		int r = jUtill.getRandomNumber();
		System.out.println(r);
		
		String date = jUtill.getSystemDate();
		System.out.println(date);
	}

}
