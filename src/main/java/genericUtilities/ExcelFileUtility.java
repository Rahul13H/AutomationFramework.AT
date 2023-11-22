package genericUtilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is consists of generic methods related to excel file
 * @author RahulH
 * 
 */
public class ExcelFileUtility 
{
    /**
     * This method will read data from excel file and return the value to caller
     * @param sheetName
     * @param rowNo
     * @param cellNo
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
	
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	
	/**
	 * This method will write data from excel file and return the value to caller
	 * @param SheetName
	 * @param rowNo
	 * @param celNo
	 * @param Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String SheetName, int rowNo, int celNo, String Value) throws EncryptedDocumentException, IOException
	{
	   FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	   Workbook wb = WorkbookFactory.create(fis);
	   wb.createSheet(SheetName).createRow(rowNo).createCell(celNo).setCellValue(Value);
		
	   FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	   wb.write(fos);
	   wb.close();
	}
	
	/**
	 * This method will read multiple data from excel sheet at time used for Data Provider
	 * @param Sheetname
	 * @return
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String Sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream (".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet(Sheetname);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		  
		Object [][] data = new Object [lastRow][lastCel];
		  
		for (int i=0;i<lastRow;i++)
		{
		  for (int j=0;j<lastCel;j++)
		  {
	    	 data [i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		  }
		}

		return data;
	}
		
	
}
