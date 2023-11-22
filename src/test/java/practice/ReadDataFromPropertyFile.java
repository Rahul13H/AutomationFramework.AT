package practice;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//Step 1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create object of properties for java.util package
		Properties  p = new Properties();
		
		//Step 3: load the file input stream into properties
		p.load(fis);
		
		//Step 4: provide the key and read the value
		//String value = p.getProperty("Browser");
		String value = p.getProperty("url");
		System.out.println(value);
		
	}
}
