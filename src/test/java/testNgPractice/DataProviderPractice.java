package testNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider="getData")
	public void addProductToCart(String Name, int Price, int qty, String model)
	{
		System.out.println("Phone name is:"+Name+" Price: "+Price+" Qty:"+qty+" Model:"+model);
	}
	
	@DataProvider
	public Object[][] getData()
	{                           //Row //Cell
		Object[][]data = new Object[3][4]; // 3 get of data with 4 details in each set
		
		data[0][0]="Samsung";
		data[0][1]=10000;
		data[0][2]=20;
		data[0][3]="A80";
		
		data[1][0]="Nokia";
		data[1][1]=12000;
		data[1][2]=10;
		data[1][3]="A12";
		
		data[2][0]="Iphone";
		data[2][1]=15000;
		data[2][2]=15;
		data[2][3]="S14";
		
		return data;
	}

}
